package zooDemoPOJO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Dog dog = new Dog(1,"Indi",null, "Golden");
		Owner owner = new Owner(1,"Maria", 456956, "maria@email.com");
		
		dog.setOwner(owner);
		owner.addDog(dog);
		
		System.out.println(owner);
		
		
//		
//		Dog dog= new Dog();
//		Dog dog2 = new Dog();
//		
//		dog.setId(1);
//		dog.setName("Nico");
//		
//		dog2.setId(1);
//		dog2.setName("Nico");
//		
//		
//		System.out.println(dog==dog2);
//		System.out.println(dog.equals(dog2));
		
//		Integer a =5;
//		Integer b= 5;
//		
//		System.out.println(a==5);
//		System.out.println(a.equals(b));
//		
//		String test="Katerina";
//		String test2 = "Katerina";
//		
//		System.out.println(test==test2);
//		System.out.println(test.equals(test2));
	}

}
