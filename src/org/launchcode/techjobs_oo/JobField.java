package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    private final int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        this.value = "Data not available";
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value.equals("") ? "Data not available" : value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField jobField)) return false;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
