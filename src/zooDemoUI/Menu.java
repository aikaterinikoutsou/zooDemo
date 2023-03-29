package zooDemoUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import zooDemaIfaces.DogManager;
import zooDemoJDBC.JDBCDogManager;
import zooDemoJDBC.JDBCManager;
import zooDemoPOJO.Dog;

public class Menu {

	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	private static DogManager dogManager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	JDBCManager jdbcManager = new JDBCManager();
	dogManager = new JDBCDogManager(jdbcManager);
	
	System.out.println("Add a new dog.");
	//create new dog method
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. Create new dog");
			System.out.println("2. Create new Vet");
			System.out.println("3. Assign a dog to a vet");
			System.out.println("4. Update Vet speciality");
			System.out.println("5. Delete Dog");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				createDog();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0: 
				jdbcManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public static void createDog() throws Exception
	{
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the breed:");
		String breed = reader.readLine();
		System.out.println("Type the coat:");
		String coat = reader.readLine();
		System.out.println("Type the dob:");
		String dob_str = reader.readLine();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dob = (Date) df.parse(dob_str);
		System.out.println("Type the cured:");
		Boolean cured = Boolean.valueOf(reader.readLine());

	
		Dog d = new Dog(name, breed, coat,dob, cured);
		dogManager.addDog(d);
	}

}
