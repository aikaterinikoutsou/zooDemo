package zooDemaIfaces;

import java.util.List;

import zooDemoPOJO.Dog;

public interface DogManager {
	
	//Adding a new dog
	public void addDog(Dog d);
	
	//get the list of the dogs
	public List<Dog> getListOfDogs();
	
	//Assign a dog to a vet
	public void assign(int vetID, int dogID);

}
