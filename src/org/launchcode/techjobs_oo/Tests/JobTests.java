package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;

public class JobTests {
    private Job testJob1;
    private Job testJob2;
    private Job testJob3;

    @Before
    public void instantiateJobs() {
        this.testJob1 = new Job();
        this.testJob2 = new Job();
        this.testJob3 = new Job();
    }
}
