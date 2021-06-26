package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;


public class JobTests {
    private Job testJob1;
    private Job testJob2;
    private Job testJob3;
    private final String jobName = "A job name";
    private final String employerName = "An employer";
    private final String locationName = "A location";
    private final String positionName = "A position";
    private final String coreCompetencyName = "A skill";

    @Before
    public void instantiateJobs() {
        this.testJob1 = new Job();
        this.testJob2 = new Job();
        this.testJob3 = new Job(this.jobName,
                new Employer(this.employerName),
                new Location(this.locationName),
                new PositionType(this.positionName),
                new CoreCompetency(this.coreCompetencyName)
        );
    }

    @Test
    public void testSettingJobId() {
        assertEquals(testJob2.getId(), testJob1.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(testJob3.getName(), this.jobName);
        assertEquals(testJob3.getEmployer().getValue(), this.employerName);
        assertEquals(testJob3.getLocation().getValue(), this.locationName);
        assertEquals(testJob3.getPositionType().getValue(), this.positionName);
        assertEquals(testJob3.getCoreCompetency().getValue(), this.coreCompetencyName);

        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void testToString() {
        String template =
                """
                
                ID:  %s
                Name: %s
                Employer: %s
                Location: %s
                Position Type: %s
                Core Competency: %s
                
                """;
        String formattedString = String.format(template,
                testJob3.getId(),
                testJob3.getName(),
                testJob3.getEmployer(),
                testJob3.getLocation(),
                testJob3.getPositionType(),
                testJob3.getCoreCompetency());

        assertEquals('\n', testJob3.toString().charAt(0));
        assertEquals('\n', testJob3.toString().charAt(testJob3.toString().length() - 1));
        assertEquals(testJob3.toString(), formattedString);
    }
}
