package fr.pmu.coursesmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class RunnerPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="RUNNER_NUMBER")
    private Integer runnerNumber;
    @Column(name="RUNNER_RACE_DAY")
    private Date runnerRaceDay;
    @Column(name="RUNNER_RACE_NUMBER")
    private Integer runnerRaceNumber;

    public Integer getRunnerNumber() {
        return runnerNumber;
    }

    public void setRunnerNumber(Integer runnerNumber) {
        this.runnerNumber = runnerNumber;
    }

    public Date getRunnerRaceDay() {
        return runnerRaceDay;
    }

    public void setRunnerRaceDay(Date runnerRaceDay) {
        this.runnerRaceDay = runnerRaceDay;
    }

    public Integer getRunnerRaceNumber() {
        return runnerRaceNumber;
    }

    public void setRunnerRaceNumber(Integer runnerRaceNumber) {
        this.runnerRaceNumber = runnerRaceNumber;
    }

    @Override
    public String toString() {
        return "RunnerPK{" +
                "runnerNumber=" + runnerNumber +
                ", runnerRaceDay=" + runnerRaceDay +
                ", runnerRaceNumber=" + runnerRaceNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunnerPK runnerPK = (RunnerPK) o;
        return Objects.equals(runnerNumber, runnerPK.runnerNumber) && Objects.equals(runnerRaceDay, runnerPK.runnerRaceDay) && Objects.equals(runnerRaceNumber, runnerPK.runnerRaceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runnerNumber, runnerRaceDay, runnerRaceNumber);
    }
}
