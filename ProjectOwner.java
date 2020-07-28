import java.io.FileWriter;
import java.io.IOException;


public class ProjectOwner implements FileOperation{

	private String firstName;
	private String surname;
	private String ID;
	private String role;
	private String email;
	private String company_ID;
	
	public final static String FILENAME = "owners.txt";
	private static int count = 0;
	
	public ProjectOwner(String firstName, String surname, String role, String email, String company_ID) {
		this.ID = "Own" + ++count;
		this.firstName = firstName;
		this.surname = surname;
		this.role = role;
		this.email = email;
		this.company_ID = company_ID;
		
		addToFile();
	}
	
	public boolean addToFile() {
		
		try {
			FileWriter writer = new FileWriter(FILENAME, true);
			writer.write(this.ID + "," + this.firstName + "," + this.surname + "," + this.role+ "," + this.email + "," + this.company_ID);
			writer.write("\n");
			writer.close();
			return true;
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
}
