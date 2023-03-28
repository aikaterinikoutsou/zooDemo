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
		createDog();
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
