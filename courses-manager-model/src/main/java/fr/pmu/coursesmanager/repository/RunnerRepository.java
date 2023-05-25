package fr.pmu.coursesmanager.repository;

import fr.pmu.coursesmanager.model.RunnerModel;
import fr.pmu.coursesmanager.model.RunnerPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RunnerRepository extends CrudRepository<RunnerModel, RunnerPK>{

    public Iterable<RunnerModel> findByRunnerPKRunnerRaceDayAndRunnerPKRunnerRaceNumber(Date raceDay, Integer raceNumber);

}
