package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Location {
    private int id;
    private static int nextId = 1;
    private String value;

    public Location() {
        id = nextId;
        nextId++;
        this.value = "Data not available";
    }

    public Location(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return getId() == location.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
