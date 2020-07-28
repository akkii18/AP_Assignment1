import java.io.*;
public class Company implements FileOperation{
	private String ID;
	private String name;
	private String ABN;
	private String URL;
	private String addr;
	
	private static int count = 0;
	
	public final static String FILENAME = "companies.txt";
	
	public Company(String name,String ABN,String URL,String addr) {
		this.ID = "C" + ++count;
		this.name = name;
		this.ABN = ABN;
		this.URL = URL;
		this.addr = addr;	
		
		addToFile();
	}
	
	public void printInfo() {
		System.out.println("*********** Company Details **********");
		System.out.println("ID : " + this.ID);
		System.out.println("Name : " + this.name);
		System.out.println("ABN : " + this.ABN);
		System.out.println("URL : " + this.URL);
		System.out.println("addr : " + this.addr);
	}
	
	public boolean addToFile() {
		
		try {
			FileWriter writer = new FileWriter(FILENAME, true);
			writer.write(this.ID + "," + this.name + "," + this.ABN + "," + this.URL + "," + this.addr);
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
