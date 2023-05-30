package zooDemaIfaces;

import zooDemoPOJO.Dog;
import zooDemoPOJO.Owner;

public interface OwnerManager {
	
	public void createOwner(Owner o);
	public Owner findOwnerByID(Integer id);
	
}
