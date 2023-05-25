package fr.pmu.coursesmanager.bean;

import java.util.Objects;

public class Runner {

    private Integer runnerNumber;
    private String runnerName;
    private Race race;

    public Integer getRunnerNumber() {
        return runnerNumber;
    }

    public void setRunnerNumber(Integer runnerNumber) {
        this.runnerNumber = runnerNumber;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "runnerNumber=" + runnerNumber +
                ", runnerName='" + runnerName + '\'' +
                ", race=" + race +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return Objects.equals(runnerNumber, runner.runnerNumber) && Objects.equals(runnerName, runner.runnerName) && Objects.equals(race, runner.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runnerNumber, runnerName, race);
    }

}
