import java.util.*;

public class Application {
	
	// the below function will clear the console
    // the function is made platform independent 
    public final static void clearConsole(){
        try {

            //extracting the type of OS and clearing the console with different commands
            if (System.getProperty("os.name").contains("Windows"))
    
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    
            else
    
                Runtime.getRuntime().exec("clear");
    
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		String[] choices = {"Add Company","Add Project Owner","Add Project",
							"Capture Student Personalities","Add Student Preferences",
							"Shortlist Projects"};
		while(true) {
			
			clearConsole();
			
			for (int i = 0; i < choices.length; i++) {
				System.out.println((i+1) + ")" + choices[i]);
			}
			System.out.println("0)Exit");
			System.out.print("Enter choice: ");
			byte choice = input.nextByte();
			
			switch(choice){
				case 1: System.out.println("Please give us the following details");
						System.out.print("Company Name: ");
						input.nextLine();
						
						String name = input.nextLine();
						System.out.print("Company ABN: ");
						
						String ABN = input.nextLine();
						System.out.print("Company URL: ");
						
						String URL = input.nextLine();
						System.out.print("Company address: ");
						
						String addr = input.nextLine();
						
						Company c1 = new Company(name, ABN, URL, addr);
						c1.printInfo();
						break;
				case 2: System.out.println("Please give us the following details");
						
						System.out.print("Owner's first name: ");
						input.nextLine();
						String firstname = input.nextLine();
						
						System.out.print("Owner's lastname: ");
						String lastname = input.nextLine();
						
						System.out.print("Owner's role: ");
						String role = input.nextLine();
					
						System.out.print("Owner's email: ");	
						String email = input.nextLine();

						System.out.print("Owner's company ID: ");	
						String company_ID = input.nextLine();
						
						if(FileOperation.searchInFile(company_ID, Company.FILENAME)) {
							ProjectOwner po = new ProjectOwner(firstname, lastname, role, email, company_ID)
						}
						else
							System.out.println("!INVALID COMPANY ID ENTERED!");
						break;
				case 3: System.out.println("Please give us the following details");
				
						System.out.print("Project title: ");
						input.nextLine();
						name = input.nextLine();
						
						System.out.print("Project descr: ");
						String descr = input.nextLine();
						
						System.out.print("Project owner ID: ");
						String owner_ID = input.nextLine();
					
										
						if(Company.searchInFile(company_ID)) {
							ProjectOwner po = new ProjectOwner(firstname, lastname, role, email, company_ID)
						}
						else
							System.out.println("!INVALID COMPANY ID ENTERED!");
						break;
			}
			
			input.nextLine();
			input.nextLine();
		}
		
	}
}
