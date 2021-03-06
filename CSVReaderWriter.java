package hw07;
/* Angel Serrano
 * CS 2012
 * Section 05
 * Description: This is the Reader and Writer class for the la_facility_ratings.csv. This class 
 * is aimed to read the data from the .csv file and split the data properlly and add it to a List
 * database. With the Writer section writing down in a new .csv file
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class CSVReaderWriter {	
	
	private CSVReaderWriter() {	
	}
	//This class will read the data from the .csv dile and return the data presented as an objecect 
	//and populate the database
	public static FacilityDatabase readData(String fileName) {
		//grabs the file name or int this case the csv file and reads it
		FacilityDatabase facilityDatabase = new FacilityDatabase();
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count = 0;
		String tuple;
		try {
			while ((tuple = reader.readLine()) != null) {
				try {
					count++;
					//creates the data and returns it to the database
					String[] token = tuple.split(",");
					String name = token[0];
					String address = token[1];
					int zipcode = Integer.parseInt(token[2]);
					String date = token[3];
					int score = Integer.parseInt(token[4]);
					char grade = token[5].charAt(0);
					Facility facility = new Facility(name, address, zipcode, date, score, grade);
					facilityDatabase.add(facility);
				} catch (DateFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return facilityDatabase;
	}
     
    public static void writeData(FacilityDatabase facilityDatabase, String fileName) {
        try{
        	//creates new CSV file from 
        	FileWriter csvWriter = new FileWriter("fileName"); 
        	//read all facilities from db
        	for (Facility f : facilityDatabase) {
        		//rebuild the splitted date
        		String date = f.getDay()+"-"+f.getMonth()+"-"+f.getYear();
        		//also redo the conversion of zipcode,marks,grade to string type from their respective type
        		csvWriter.append(String.join(",", f.getName(),f.getAddress(),f.getZipcode()+"",date,f.getScore()+"",f.getGrade()+""));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
