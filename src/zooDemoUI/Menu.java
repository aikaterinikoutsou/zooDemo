package zooDemoUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import zooDemaIfaces.DogManager;
import zooDemaIfaces.UserManager;
import zooDemaIfaces.VetManager;
import zooDemaIfaces.XMLManager;
import zooDemoJDBC.JDBCDogManager;
import zooDemoJDBC.JDBCManager;
import zooDemoJDBC.JDBCVetManager;
import zooDemoJPA.JPAUserManager;
import zooDemoPOJO.Dog;
import zooDemoPOJO.User;
import zooDemoPOJO.Vet;
import zooDemoXML.XMLManagerImpl;

public class Menu {

	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	private static DogManager dogManager;
	private static VetManager vetManager;
	private static UserManager userManager;
	private static JDBCManager jdbcManager;
	private static XMLManager xmlmanager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	jdbcManager = new JDBCManager();
	dogManager = new JDBCDogManager(jdbcManager);
	vetManager = new JDBCVetManager(jdbcManager);
	userManager = new JPAUserManager();
	xmlmanager = new XMLManagerImpl();
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. Login Owner");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				loginOwner();
				break;
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
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
	
	
	private static void ownerMenu(Integer id) throws Exception{
		
		try {
			do {
				System.out.println("Choose an option");
				System.out.println("1. Create new dog");
				System.out.println("2. Get the List of All vets");
				System.out.println("3. Print my Data");
				System.out.println("4. Load new dogs");
				System.out.println("0. exit");

				int choice = Integer.parseInt(reader.readLine());
				switch(choice)
				{
				case 1:
					createDog();
					break;
				case 2:
					getListVets();
					break;
				case 3:
					printMe(id);
					break;
				case 4: 
					loadDogs();
				case 0: 
					jdbcManager.disconnect();
					userManager.disconnect();
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
	
	private static void loadDogs() {
	    Dog d= null;
		File file = new File("./xmls/External-Dog.xml");
		d = xmlmanager.xml2Dog(file);
		
		System.out.println(d);
	}


	private static void printMe(Integer id) {
		xmlmanager.owner2xml(id);
	}


	private static void loginOwner() throws Exception{
		
		System.out.println("Email:");
		String email = reader.readLine();
		
		System.out.println("Password: ");
		String passwd = reader.readLine();
		User u = userManager.checkPassword(email, passwd);
		
		if(u!=null & u.getRole().getName().equals("owner"))
		{	
			System.out.println("Login Successful!");
			ownerMenu(u.getId());
		}
		
	}
	
	private static void chooseVet() throws Exception{
		// TODO Auto-generated method stub
		Vet v = new Vet();
		System.out.println("Please choose a vet, type its ID:");
		System.out.println(vetManager.getListAllVets());
		Integer vetID = Integer.parseInt(reader.readLine());
		//show vet data
		v = vetManager.getVetbyId(vetID);
		System.out.println(v.toString());
	}

	private static void assignDog() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Please enter the dog ID to assign:");
		Integer dogid = Integer.parseInt(reader.readLine());
		System.out.println("Please enter the vet ID to assign:");
		Integer vetid = Integer.parseInt(reader.readLine());
		
		dogManager.assign(vetid, dogid);
		
	}

	private static void getListVets() throws Exception {
		// TODO Auto-generated method stub
		List<Vet> vets = new ArrayList<Vet>();
		
		try {
			vets = vetManager.getListAllVets();
			int i;
			for(i=0; i< vets.size(); i++)
			{
				System.out.println(vets.get(i).toString());
			}
		
		}catch (Exception e) {
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
		//System.out.println("Type the dob:");
		//String dob_str = reader.readLine();
		//DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		//Date dob = (Date) df.parse(dob_str);
		System.out.println("Type the cured:");
		Boolean cured = Boolean.valueOf(reader.readLine());
		System.out.println("Type the owner ID:");
		Integer owner_id = Integer.parseInt(reader.readLine());

	
		Dog d = new Dog(name, breed, coat, cured,owner_id);
		dogManager.addDog(d);
	}

	public static void createVet() throws Exception
	{
		System.out.println("Type the name of the vet:");
		String name =  reader.readLine();
		System.out.println("Type the speciality name");
		String speciality =  reader.readLine();
		
		Vet v = new Vet(name, speciality);
		
		vetManager.createVet(v);		
	}
	
	public static void updateVetSpeciality() throws Exception
	{
		System.out.println("Please enter the id of the vet to update:");
		int vet_id =  Integer.parseInt(reader.readLine());
		System.out.println("Please enter the new speciality:");
		String speciality = reader.readLine();
		
		vetManager.updateSpeciality(vet_id, speciality);
	}
	
	public static void deleteVet() throws Exception
	{
		System.out.println("Please ente the id of the vet to delete:");
		int vet_id =  Integer.parseInt(reader.readLine());
		vetManager.deleteVetbyID(vet_id);
	}
}
