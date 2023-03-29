package zooDemaIfaces;

import java.util.List;

import zooDemoPOJO.Vet;

public interface VetManager {

	//Get all the vets
	public List<Vet> getListAllVets();
	
	//add a new vet
	public void createVet(Vet v);
	
	//update vet's speciality
	public void updateSpeciality(int vet_id, String n_speciality);
	
	//delete vet by ID
	public void deleteVetbyID(int vet_id);
	
}
