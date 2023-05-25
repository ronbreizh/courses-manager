package fr.pmu.coursesmanager.service;

import fr.pmu.coursesmanager.bean.Race;
import fr.pmu.coursesmanager.model.RaceModel;
import fr.pmu.coursesmanager.model.RacePK;
import fr.pmu.coursesmanager.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RaceServiceImpl implements RaceService {

	private RaceRepository raceRepository;

	@Autowired
	public RaceServiceImpl(RaceRepository raceRepository) {
		this.raceRepository = raceRepository;
	}

	//-----------------

	@Override
	public RaceModel getRaceById(Date raceDay, Integer raceNumber){
		RacePK racePK = new RacePK();
		racePK.setRaceDay(raceDay);
		racePK.setRaceNumber(raceNumber);
		return raceRepository.findById(racePK).get();
	}

	@Override
	public boolean checkRace(Date raceDay, Integer raceNumber) {
		RacePK racePK = new RacePK();
		racePK.setRaceDay(raceDay);
		racePK.setRaceNumber(raceNumber);
		return raceRepository.existsById(racePK);
	}

	@Override
	public RaceModel createRace(Race race) {
		RaceModel raceModel = new RaceModel();

		RacePK racePK = new RacePK();
		racePK.setRaceDay(race.getRaceDay());
		racePK.setRaceNumber(race.getRaceNumber());

		raceModel.setRacePK(racePK);
		raceModel.setRaceName(race.getRaceName());

		return raceRepository.save(raceModel);
	}

}
