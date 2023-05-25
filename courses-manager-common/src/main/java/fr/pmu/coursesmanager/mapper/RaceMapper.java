package fr.pmu.coursesmanager.mapper;

import fr.pmu.coursesmanager.bean.Race;
import fr.pmu.coursesmanager.model.RaceModel;
import fr.pmu.coursesmanager.model.RacePK;

import java.io.Serializable;

public class RaceMapper implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Race transformRaceModelToRace(RaceModel raceModel) {
		
		Race returnedRace = new Race();
		returnedRace.setRaceDay(raceModel.getRacePK().getRaceDay());
		returnedRace.setRaceNumber(raceModel.getRacePK().getRaceNumber());
		returnedRace.setRaceName(raceModel.getRaceName());

		return returnedRace;
		
	}

	public static RaceModel transformRaceToRaceModel(Race race) {

		RaceModel returnedRaceModel = new RaceModel();
		returnedRaceModel.setRaceName(race.getRaceName());

		RacePK racePK = new RacePK();
		racePK.setRaceDay(race.getRaceDay());
		racePK.setRaceNumber(race.getRaceNumber());

		returnedRaceModel.setRacePK(racePK);

		return returnedRaceModel;

	}
	
}
