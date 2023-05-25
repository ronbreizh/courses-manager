package fr.pmu.coursesmanager.mapper;

import fr.pmu.coursesmanager.bean.Race;
import fr.pmu.coursesmanager.bean.Runner;
import fr.pmu.coursesmanager.model.RunnerModel;
import fr.pmu.coursesmanager.model.RunnerPK;

import java.io.Serializable;

public class RunnerMapper implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Runner transformRunnerModelToRunner(RunnerModel runnerModel) {
		
		Runner returnedRunner = new Runner();
		returnedRunner.setRunnerName(runnerModel.getRunnerName());
		returnedRunner.setRunnerNumber(runnerModel.getRunnerPK().getRunnerNumber());

		Race returnedRace = new Race();
		returnedRace.setRaceNumber(runnerModel.getRunnerPK().getRunnerRaceNumber());
		returnedRace.setRaceDay(runnerModel.getRunnerPK().getRunnerRaceDay());

		returnedRunner.setRace(returnedRace);

		return returnedRunner;
		
	}

	public static RunnerModel transformRunnerToRunnerModel(Runner runner) {

		RunnerModel returnedRunnerModel = new RunnerModel();
		returnedRunnerModel.setRunnerName(runner.getRunnerName());

		RunnerPK runnerPK = new RunnerPK();
		runnerPK.setRunnerNumber(runner.getRunnerNumber());
		runnerPK.setRunnerRaceNumber(runner.getRace().getRaceNumber());
		runnerPK.setRunnerRaceDay(runner.getRace().getRaceDay());

		returnedRunnerModel.setRunnerPK(runnerPK);

		return returnedRunnerModel;

	}
	
}
