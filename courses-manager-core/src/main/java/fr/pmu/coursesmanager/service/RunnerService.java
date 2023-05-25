package fr.pmu.coursesmanager.service;

import fr.pmu.coursesmanager.bean.Runner;
import fr.pmu.coursesmanager.model.RunnerModel;

import java.util.Date;
import java.util.List;

public interface RunnerService {

	/**
	 * Method to get existing runners of a race
	 * @param raceDay
	 * @param raceNumber
	 * @return list of Runners
	 */
	public List<RunnerModel> getRunnersByRaceId(Date raceDay, Integer raceNumber);

	/**
	 * Methode to create a runner
	 * @param runner
	 * @return the Runner created
	 */
	public RunnerModel createRunner(Runner runner);

	/**
	 * Methode to create a list of runners
	 * @param runners
	 * @return the Runners created
	 */
	public List<RunnerModel> createAllRunners(List<Runner> runners);

}
