package fr.pmu.coursesmanager.repository;

import fr.pmu.coursesmanager.model.RaceModel;
import fr.pmu.coursesmanager.model.RacePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends CrudRepository<RaceModel, RacePK>{

}
