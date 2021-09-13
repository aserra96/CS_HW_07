package hw07;
/* Angel Serrano
 * CS 2012
 * Section 05
 * Description: I cannont come up with an idea or concept to be able to grab the data or even 
 * read the data from the cvs file or database created 
 */
import java.util.ArrayList;

public class FacilityDatabase extends ArrayList<Facility> {

	public void displayFacilitiesWithGrade(char grade, int limit) {
		//check if the the char grade is the same as in the data and breaks out of the loop
		//if it reaches to 10 
        int n = 0;
        if (limit == -1) n = this.size();
        for (Facility facility : this) {
            if (facility.getGrade() == grade) {
                n++;
                System.out.println(facility);
            }
            if (n == limit) {
                break;
            }
        }
    }
	
	public void displayFacilitiesWithScoreGreater(int score, int limit) {
		//check if the the int Score is greater than the score in the data and breaks out of the loop
		//if it reaches to 10 
		int n = 0;
		if (limit == -1) limit = this.size();
		for (Facility facility : this) {
			if (facility.getScore() >= score) {
				n++;
				System.out.println(facility);
			}
			if (n == limit) {
				break;
			}
		}
	}
	
	public void displayFacilitiesWithScoreLess(int score, int limit) {
		//check if the the int Score is less than the score in the data and breaks out of the loop
				//if it reaches to 10 
        int n = 0;
        if (limit == -1) limit = this.size();
        for (Facility facility : this) {

            if (facility.getScore() <= score) {
                n++;
                System.out.println(facility);
            }
            if (n == limit) {
                break;
            }
        }
	}
	
	public void displayFacilitiesByZipCode(int zipcode, int limit) {
		//check if the the int zipcode the same compared to the data and breaks out of the loop
		//if it reaches to 10 
        int n = 0;
        if (limit == -1) limit = this.size();
        for (Facility facility : this) {
            if (facility.getZipcode() == zipcode) {
                n++;
                System.out.println(facility);
            }
            if (n == limit) {
                break;
            }
        }
	}
	
    public void displayFacilitiesByMonth(int month, int limit) {
    	//check if the the int month the same compared to the data and breaks out of the loop
    	//if it reaches to 10
        int n = 0;
        if (limit == -1) limit = this.size();
        for (Facility facility : this) {
            if (facility.getMonth() == month) {
                n++;
                System.out.println(facility);
            }
            if (n == limit) {
                break;
            }
        }
    }
    
    public void displayCountsByGrade() {
    	//graps the total amount of facilities that have the same grade and totals them
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for (Facility facility : this) {
            if (facility.getGrade() == 'A') {
                countA++;
            } else if (facility.getGrade() == 'B') {
                countB++;
            } else {
                countC++;
            }
        }
        System.out.printf("A-Grade Facilities: %s\n" +
                "B-Grade Facilities: %s\n" +
                "C-Grade Facilities: %s\n", countA, countB, countC);
    }
}

 