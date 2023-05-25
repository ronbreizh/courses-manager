package fr.pmu.coursesmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "RUNNER")
public class RunnerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RunnerPK runnerPK;

    @Column(name="RUNNER_NAME")
    private String runnerName;

    public RunnerPK getRunnerPK() {
        return runnerPK;
    }

    public void setRunnerPK(RunnerPK runnerPK) {
        this.runnerPK = runnerPK;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    @Override
    public String toString() {
        return "RunnerModel{" +
                "runnerPK=" + runnerPK +
                ", runnerName='" + runnerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunnerModel that = (RunnerModel) o;
        return Objects.equals(runnerPK, that.runnerPK) && Objects.equals(runnerName, that.runnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runnerPK, runnerName);
    }

}
