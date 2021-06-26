package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobFieldTests {
    String employerValue = "An employer";
    String locationValue = "A location";
    String positionTypeValue = "A position";
    String coreCompetencyValue = "A skill";

    Employer employerNoData = new Employer();
    Location locationNoData = new Location();
    PositionType positionTypeNoData = new PositionType();
    CoreCompetency coreCompetencyNoData = new CoreCompetency();

    Employer employerWithData = new Employer(employerValue);
    Location locationWithData = new Location(locationValue);
    PositionType positionTypeWithData = new PositionType(positionTypeValue);
    CoreCompetency coreCompetencyWithData = new CoreCompetency(coreCompetencyValue);

    @Test
    public void testAssignsDefaultValue() {
        String defaultValue = "Data not available";

        assertEquals(employerNoData.getValue(), defaultValue);
        assertEquals(locationNoData.getValue(), defaultValue);
        assertEquals(positionTypeNoData.getValue(), defaultValue);
        assertEquals(coreCompetencyNoData.getValue(), defaultValue);
    }

    @Test
    public void testSetsArgumentFromConstructor() {
        assertEquals(employerWithData.getValue(), employerValue);
        assertEquals(locationWithData.getValue(), locationValue);
        assertEquals(positionTypeWithData.getValue(), positionTypeValue);
        assertEquals(coreCompetencyWithData.getValue(), coreCompetencyValue);
    }

    @Test
    public void testToStringReturnsValue() {
        assertEquals(employerWithData.toString(), employerWithData.getValue());
        assertEquals(locationWithData.toString(), locationWithData.getValue());
        assertEquals(positionTypeWithData.toString(), positionTypeWithData.getValue());
        assertEquals(coreCompetencyWithData.toString(), coreCompetencyWithData.getValue());
    }

    @Test
    public void testAutoIncrementsIDs() {
        assertEquals(employerNoData.getId(), employerWithData.getId() - 1);
        assertEquals(locationNoData.getId(), locationWithData.getId() - 1);
        assertEquals(positionTypeNoData.getId(), positionTypeWithData.getId() - 1);
        assertEquals(coreCompetencyNoData.getId(), coreCompetencyWithData.getId() - 1);
    }

    @Test
    public void testEquality() {
        assertNotEquals(employerNoData, employerWithData);
    }
}
