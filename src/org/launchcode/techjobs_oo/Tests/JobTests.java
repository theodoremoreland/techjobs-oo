package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;


public class JobTests {
    private Job invalidJob;
    private Job invalidJob2;
    private Job validJob;
    private Job validJob2;
    private final String jobName = "A job name";
    private final String employerName = "An employer";
    private final String locationName = "A location";
    private final String positionName = "A position";
    private final String coreCompetencyName = "A skill";

    @Before
    public void instantiateJobs() {
        this.invalidJob = new Job();
        this.invalidJob2 = new Job();
        this.validJob = new Job(this.jobName,
                new Employer(this.employerName),
                new Location(this.locationName),
                new PositionType(this.positionName),
                new CoreCompetency(this.coreCompetencyName)
        );
        this.validJob2 = new Job(this.jobName,
                new Employer(),
                new Location(),
                new PositionType(),
                new CoreCompetency());
    }

    @Test
    public void testSettingJobId() {
        assertEquals(invalidJob2.getId(), invalidJob.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(validJob.getName(), this.jobName);
        assertEquals(validJob.getEmployer().getValue(), this.employerName);
        assertEquals(validJob.getLocation().getValue(), this.locationName);
        assertEquals(validJob.getPositionType().getValue(), this.positionName);
        assertEquals(validJob.getCoreCompetency().getValue(), this.coreCompetencyName);

        assertTrue(validJob.getEmployer() instanceof Employer);
        assertTrue(validJob.getLocation() instanceof Location);
        assertTrue(validJob.getPositionType() instanceof PositionType);
        assertTrue(validJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(invalidJob, invalidJob2);
    }

    @Test
    public void testValidJobWithAllDataToString() {
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
                validJob.getId(),
                validJob.getName(),
                validJob.getEmployer(),
                validJob.getLocation(),
                validJob.getPositionType(),
                validJob.getCoreCompetency());

        assertEquals('\n', validJob.toString().charAt(0));
        assertEquals('\n', validJob.toString().charAt(validJob.toString().length() - 1));
        assertEquals(formattedString, validJob.toString());
    }

    @Test
    public void testValidJobWithMissingDataToString() {
        String defaultMessage = "Data not available";
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
                validJob2.getId(),
                validJob2.getName(),
                defaultMessage,
                defaultMessage,
                defaultMessage,
                defaultMessage);

        assertEquals('\n', validJob.toString().charAt(0));
        assertEquals('\n', validJob.toString().charAt(validJob.toString().length() - 1));
        assertEquals(formattedString, validJob2.toString());
    }

    @Test
    public void testInValidJobToString() {
        assertEquals(invalidJob.toString(), "OOPS! This job does not seem to exist.");
    }
}
