package fr.pmu.coursesmanager.service;

import fr.pmu.coursesmanager.bean.Runner;
import fr.pmu.coursesmanager.mapper.RunnerMapper;
import fr.pmu.coursesmanager.model.RunnerModel;
import fr.pmu.coursesmanager.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RunnerServiceImpl implements RunnerService {

	private RunnerRepository runnerRepository;

	@Autowired
	public RunnerServiceImpl(RunnerRepository runnerRepository) {
		this.runnerRepository = runnerRepository;
	}

	//-----------------

	@Override
	public List<RunnerModel> getRunnersByRaceId(Date raceDay, Integer raceNumber){
		List<RunnerModel> runners = new ArrayList<>();
		runnerRepository.findByRunnerPKRunnerRaceDayAndRunnerPKRunnerRaceNumber(raceDay, raceNumber).forEach(runners::add);
		return runners;
	}

	@Override
	public RunnerModel createRunner(Runner runner) {
		RunnerModel runnerModel = RunnerMapper.transformRunnerToRunnerModel(runner);
		return runnerRepository.save(runnerModel);
	}

	@Override
	public List<RunnerModel> createAllRunners(List<Runner> runners) {

		List<RunnerModel> runnersModelToSave = new ArrayList<>(0);
		List<RunnerModel> runnersModelToReturn = new ArrayList<>(0);
		for(Runner runner : runners){
			runnersModelToSave.add(RunnerMapper.transformRunnerToRunnerModel(runner));
		}
		runnerRepository.saveAll(runnersModelToSave).forEach(runnersModelToReturn::add);
		return runnersModelToReturn;
	}

}
