package hw07;
/* Angel Serrano
 * CS 2012
 * Section 05
 * Description: This assignment in my opinion one of the hardest homeworks to date and really
 * set up what i might have to face later on if this is a "introduction class" but one of the most
 * relieveing to complete. Here Creates the Facility Database class and calls on CSV file and make's sure the
 * date is written properlly
 */

public class Main {
    public static void main (String[] args) {    
    	FacilityDatabase facilityDatabase;
    	String fileName = "src/hw07/la_facility_ratings.csv";
    	facilityDatabase = CSVReaderWriter.readData(fileName);
    	CSVReaderWriter.writeData(facilityDatabase, "src/hw07/la_facility_ratings_new.csv");
    	System.out.println("-----------------------------------------------------------------");
    	System.out.println("displayFacilitiesWithGrade('C',10):\n");
        facilityDatabase.displayFacilitiesWithGrade('C', 10);
        System.out.println("displayFacilitiesWithScoreGreater(90,10):\n");
        facilityDatabase.displayFacilitiesWithScoreGreater(90, 10);
        System.out.println("displayFacilitiesWithScoreLess(79,10):\n");
        facilityDatabase.displayFacilitiesWithScoreLess(79, 10);
        System.out.println("displayFacilitiesByZipcode(90032,10):\n");
        facilityDatabase.displayFacilitiesByZipCode(90032, 10);
        System.out.println("displayFacilitiesByMonth(5,10):\n");
        facilityDatabase.displayFacilitiesByMonth(5, 10);
        System.out.println("displayCountsByGrade():\n");
        facilityDatabase.displayCountsByGrade();
    }
}
