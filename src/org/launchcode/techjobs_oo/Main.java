package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.Scanner;

import static org.launchcode.techjobs_oo.CustomFormatter.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("\n\nHow many job postings do you want to create? ");
        int numberOfJobPostingsToCreate = in.nextInt();
        in.nextLine(); // Consumes the "enter" button pressed after int input.
        System.out.println("\nCreating " + colorWrap(String.valueOf(numberOfJobPostingsToCreate), BLUE) + " job postings...");
        System.out.println(colorWrap("Enter the values for each field of the job posting as they are prompted below, then press your 'ENTER' key.\n", GREEN_BOLD_BRIGHT));

        while (numberOfJobPostingsToCreate > 0) {
            String name;
            String employer;
            String location;
            String positionType;
            String coreCompetency;
            Job job;

            System.out.print(colorWrap("CREATE NEW JOB POSTING\n", BLUE_UNDERLINED));
            System.out.print("    Name: ");
            name = in.nextLine();

            System.out.print("    Employer: ");
            employer = in.nextLine();

            System.out.print("    Location: ");
            location = in.nextLine();

            System.out.print("    Position Type: ");
            positionType = in.nextLine();

            System.out.print("    Core competency: ");
            coreCompetency = in.nextLine();

            job = new Job(name, new Employer(employer), new Location(location), new PositionType(positionType), new CoreCompetency(coreCompetency));
            jobs.add(job);

            numberOfJobPostingsToCreate--;
        }

        System.out.println(colorWrap("\n*****JOBS CREATED*****", WHITE_BOLD_BRIGHT));

        for (Job job : jobs){
            System.out.println(colorWrap(job.toString(), BLUE_BRIGHT));
        }
    }

}
