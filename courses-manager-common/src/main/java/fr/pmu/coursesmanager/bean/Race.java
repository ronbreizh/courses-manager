package fr.pmu.coursesmanager.bean;

import java.util.Date;
import java.util.Objects;

public class Race {

    private Date raceDay;
    private Integer raceNumber;
    private String raceName;

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

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceDay=" + raceDay +
                ", raceNumber=" + raceNumber +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(raceDay, race.raceDay) && Objects.equals(raceNumber, race.raceNumber) && Objects.equals(raceName, race.raceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceDay, raceNumber, raceName);
    }

}
