package fr.pmu.coursesmanager.controller;

import fr.pmu.coursesmanager.bean.Race;
import fr.pmu.coursesmanager.bean.RaceRunners;
import fr.pmu.coursesmanager.bean.Runner;
//import fr.pmu.coursesmanager.kafka.Producer;
import fr.pmu.coursesmanager.mapper.RaceMapper;
import fr.pmu.coursesmanager.mapper.RunnerMapper;
import fr.pmu.coursesmanager.model.RunnerModel;
import fr.pmu.coursesmanager.service.RaceService;
import fr.pmu.coursesmanager.service.RunnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CoursesManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursesManagerController.class);

    private RaceService raceService;
    private RunnerService runnerService;
    //private Producer producer;

    @Autowired
    public CoursesManagerController(
            RaceService raceService,
            RunnerService runnerService
//            ,Producer producer
    ) {
        this.raceService = raceService;
        this.runnerService = runnerService;
//        this.producer = producer;
    }

    //----------
    // TODO : extract all logs and errors in an util class

    /**
     * Create a race and runners in database and send a message in kafka bus if ok
     * @param raceRunners
     * @return the entities created if ok or a bad request with errors if ko
     */
    @RequestMapping(method = RequestMethod.POST, path = "/race/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRaceAndRunners(@RequestBody RaceRunners raceRunners) {

        Date now = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<String> errors = new ArrayList<>(0);

        boolean isRaceExist = false;

        Race race = raceRunners.getRace();
        List<Runner> runners = raceRunners.getRunners();

        // Check race
        if(null != race){

            if(race.getRaceDay() != null){
                if(race.getRaceDay().before(now)){
                    errors.add("Race day can't be before today.");
                }
            }else{
                errors.add("Race day is est mandatory.");
            }

            if(race.getRaceNumber() == null){
                errors.add("Race number is mandatory.");
            }

            if(race.getRaceName() == null){
                errors.add("Race name is mandatory.");
            }

        }else{
            errors.add("Race object is 'null'.");
        }

        List<Runner> uniqueRunners = new ArrayList<>(0);

        if(null != runners && !runners.isEmpty()){
            // Call Race from database
            isRaceExist = raceService.checkRace(race.getRaceDay(), race.getRaceNumber());

            if(isRaceExist){
                //TODO : stop or continue with runners?
                LOGGER.info("Race already exists on unicity constraint (day and number).");
                LOGGER.info("We'll update runners with new ones.");

                // Call Runners from database
                List<RunnerModel> runnersDb = runnerService.getRunnersByRaceId(race.getRaceDay(), race.getRaceNumber());
                for (RunnerModel runnerModel : runnersDb){
                    runners.add(RunnerMapper.transformRunnerModelToRunner(runnerModel));
                }
            }

            uniqueRunners = runners.stream().sorted(Comparator.comparingInt(Runner::getRunnerNumber)).distinct().collect(Collectors.toList());

            if(runners.size() != uniqueRunners.size()){
                errors.add("Unicity Problem with runners.");
            }

            if(runners.size() < 3){
                errors.add("A race must have 3 runners at least");
            }

            int count = 1;
            for(Runner runner : uniqueRunners){
                if(runner.getRunnerNumber() == null){
                    errors.add("Runner must have a number.");
                }

                if(runner.getRunnerName() == null){
                    errors.add("Runner must have a name.");
                }

                if(count == 1 && runner.getRunnerNumber() != count){
                    errors.add("First runner is undefined.");
                }else if(count != 1 && runner.getRunnerNumber() != count){
                    errors.add("There's a break in runners numbers.");
                }
                count ++;
            }
        }

        if(!errors.isEmpty()){
            errors.forEach(System.out::println);
            return ResponseEntity.badRequest().body(errors);
        }else{

            try {

                Race raceOutput = new Race();

                // 0 Errors, we can save in Db
                if (!isRaceExist) {
                    raceOutput = RaceMapper.transformRaceModelToRace(raceService.createRace(race));
                }else{
                    raceOutput = RaceMapper.transformRaceModelToRace(raceService.getRaceById(race.getRaceDay(), race.getRaceNumber()));
                }
                List<Runner> runnersOutput = new ArrayList<>(0);

                List<RunnerModel> runnersModelOutput = runnerService.createAllRunners(uniqueRunners);
                for (RunnerModel runnerModel : runnersModelOutput) {
                    runnersOutput.add(RunnerMapper.transformRunnerModelToRunner(runnerModel));
                }

            }catch(Exception e){
                errors.add("An error occured during race and runners creation.");
                e.printStackTrace();
                return ResponseEntity.badRequest().body(errors);
            }

            // If Ok, message to kafka platform
            //producer.sendMessage("A new couple of race and runners are availables.");
            LOGGER.info("A new couple of race and runners are availables.");

        }


        return ResponseEntity.ok().body("A new couple of race and runners are availables.");
    }

}
