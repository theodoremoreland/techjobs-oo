package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class JobTests {

    Job job1;
    Job job2;

    @Before
    public void createJobObject() {
        // job1 = new Job();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job2.getName() instanceof String);
        assertTrue(job2.getEmployer() instanceof Employer);
        assertTrue(job2.getLocation() instanceof Location);
        assertTrue(job2.getPositionType() instanceof PositionType);
        assertTrue(job2.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringFormat() {
        String str;
        String oops = "OOPS! This job does not seem to exist.";

        String blank = "\n";
        String id = "ID: " + Integer.toString(job1.getId()) + "\n";

        try {
            // Initial declarations
            String name = job1.getName();
            String employer = job1.getEmployer().getValue();
            String location = job1.getLocation().getValue();
            String position = job1.getPositionType().getValue();
            String skills = job1.getCoreCompetency().getValue();

            // Reassignments based on condition
            name = name.equals("") ? "Data not available" : name;
            employer = employer.equals("") ? "Data not available" : employer;
            location = location.equals("") ? "Data not available" : location;
            position = position.equals("") ? "Data not available" : position;
            skills = skills.equals("") ? "Data not available" : skills;

            // Adding labels and newlines
            name = "Name: " + name + "\n";
            employer = "Employer: " + employer + "\n";
            location = "Location: " + location + "\n";
            position = "Position Type: " + position + "\n";
            skills = "Core Competency: " + skills;

            // Constructs string
            str = blank + id + name + employer + location + position + skills + blank;

            // Constructs test
            boolean test = job1.toString().equals(str);

            // Actual test
            assertTrue(test);
        }

        catch (Exception err) {
            assertTrue(job1.toString().equals(oops));
        } // end try-catch

    } // end method

} // end class
