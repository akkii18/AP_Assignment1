import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Project implements FileOperation{

	private String ID;
	private String title;
	private String descr;
	private String owner_ID;
	HashMap<String, Integer> skillsRanking = new HashMap<String, Integer>();
	
	public static final String FILENAME = "projects.txt";
	private static int count = 0;
	
	public Project(String title, String descr, String owner_ID) {
		this.ID = "Pr" + ++count;
		this.title = title;
		this.descr = descr;
		this.owner_ID = owner_ID;
		
		addToFile();
	}
	
	public boolean addToFile() {
		
		try {
			FileWriter writer = new FileWriter(FILENAME, true);
			writer.write(this.title + "\n" + this.ID + "\n" + this.descr + "\n" + this.owner_ID + "\n");
			
			for (Map.Entry<String, Integer> skill : skillsRanking.entrySet()) {
				writer.write(skill.getKey() + " " + skill.getValue() + "\t");
			}
			
			writer.write("-----\n");
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
