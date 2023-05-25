package fr.pmu.coursesmanager.service;

import fr.pmu.coursesmanager.bean.Race;
import fr.pmu.coursesmanager.model.RaceModel;

import java.util.Date;

public interface RaceService {

	/**
	 * Method to get existing race
	 * @param raceDay
	 * @param raceNumber
	 * @return Race
	 */
	public RaceModel getRaceById(Date raceDay, Integer raceNumber);

	/**
	 * Method to ckeck if race exists
	 * @param raceDay
	 * @param raceNumber
	 * @return true if Race exists, else false
	 */
	public boolean checkRace(Date raceDay, Integer raceNumber);

	/**
	 * Methode to create a race
	 * @param race
	 * @return the Race created
	 */
	public RaceModel createRace(Race race);

}
