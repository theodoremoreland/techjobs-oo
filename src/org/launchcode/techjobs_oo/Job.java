package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {
    private final int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public boolean isValid() {
        return (this.name != null) || (this.employer != null) || (this.location != null) || (this.positionType != null) || (this.coreCompetency != null);
    }

    @Override
    public String toString() {
        if (!this.isValid()) { return "OOPS! This job does not seem to exist."; }

        String defaultMessage = "Data not available";
        String name;
        String employer;
        String location;
        String positionType;
        String coreCompetency;
        String template =
                """
                
                ID:  %s
                Name: %s
                Employer: %s
                Location: %s
                Position Type: %s
                Core Competency: %s
                
                """;

        if (this.name != null) { name = this.name; } else { name = defaultMessage; }
        if (this.employer != null) { employer = this.employer.getValue(); } else { employer = defaultMessage; }
        if (this.location != null) { location = this.location.getValue(); } else { location = defaultMessage; }
        if (this.positionType != null) { positionType = this.positionType.getValue(); } else { positionType = defaultMessage; }
        if (this.coreCompetency != null) { coreCompetency = this.coreCompetency.getValue(); } else { coreCompetency = defaultMessage; }

        String formattedString = String.format(template,
                this.id,
                name,
                employer,
                location,
                positionType,
                coreCompetency);

        return formattedString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
