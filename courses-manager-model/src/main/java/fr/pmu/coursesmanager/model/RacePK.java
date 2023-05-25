package fr.pmu.coursesmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class RacePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="RACE_DAY")
    private Date raceDay;
    @Column(name="RACE_NUMBER")
    private Integer raceNumber;

    public Date getRaceDay() {
        return raceDay;
    }

    public void setRaceDay(Date raceDay) {
        this.raceDay = raceDay;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    @Override
    public String toString() {
        return "RacePK{" +
                "raceDay=" + raceDay +
                ", raceNumber=" + raceNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacePK racePK = (RacePK) o;
        return Objects.equals(raceDay, racePK.raceDay) && Objects.equals(raceNumber, racePK.raceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceDay, raceNumber);
    }
}
