import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface FileOperation {

	public boolean addToFile();
	public static void readFromFile() {};
	
	public static boolean searchInFile(String ID, String FILENAME) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(FILENAME)));
			String line = reader.readLine();
			while(line != null) {
				if(line.contains(ID)) {
					reader.close();
					return true;
				}
				line = reader.readLine();
			}
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
