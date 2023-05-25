package fr.pmu.coursesmanager.bean;

import java.util.List;

public class RaceRunners {

    private Race race;
    private List<Runner> runners;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }
}
