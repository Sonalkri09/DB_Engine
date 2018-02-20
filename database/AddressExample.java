package database;
import com.opencsv.CSVReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AddressExample {
    private static final String ADDRESS_FILE = "C:\\Users\\User\\Downloads\\ipl.csv";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(ADDRESS_FILE));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        String[] nextLine;
	        try {
				while ((nextLine = reader.readNext()) != null) {
				    System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	}

}
