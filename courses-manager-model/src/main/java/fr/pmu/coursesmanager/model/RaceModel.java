package fr.pmu.coursesmanager.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "RACE")
public class RaceModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RacePK racePK;
    @Column(name="RACE_NAME")
    private String raceName;

    public RacePK getRacePK() {
        return racePK;
    }

    public void setRacePK(RacePK racePK) {
        this.racePK = racePK;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public String toString() {
        return "RaceModel{" +
                "racePK=" + racePK +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceModel raceModel = (RaceModel) o;
        return Objects.equals(racePK, raceModel.racePK) && Objects.equals(raceName, raceModel.raceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racePK, raceName);
    }
}
