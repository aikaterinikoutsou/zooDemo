package zooDemaIfaces;

import java.io.File;

import zooDemoPOJO.Dog;
import zooDemoPOJO.Owner;

public interface XMLManager {
	
	public void owner2xml(Integer id);
	public void dog2xml(Dog d);
	public Dog xml2Dog(File xml);
	public Owner xml2Owner(File xml);
	

}
