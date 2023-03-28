package zooDemoPOJO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//POJO -- Plain Old Java Object
//POJO has empty constructors without parameters, only setter and getters
//Hashcode and equals
//implement the serializable interface
//Has toString method

public class Dog implements Serializable{
	

	private static final long serialVersionUID = 5459002349058385563L;
	
	
	// Has attributes
	private Integer id;
	private String name;
	private String breed;
	private String coat;
	private Date dob;
	private Boolean cured;
	private Owner owner; // Many to one relationship
	private List<Vet> vets; // Many to many relationship
	
	// Has an empty constructor
	public Dog() {
		super();
		vets = new ArrayList<Vet>();
	}
	
	
	
	public Dog( String name, String breed, String coat, Date dob, Boolean cured) {
		super();
		this.name = name;
		this.breed = breed;
		this.coat = coat;
		this.dob = dob;
		this.cured = cured;
	}



	// Has an equals (uses only id)
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(id, other.id);
	}
	
	// Avoid infinite loops!
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", coat=" + coat + ", dob=" + dob + "]";
	}

	// Has getters and setters for the attributes
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getCoat() {
		return coat;
	}


	public void setCoat(String coat) {
		this.coat = coat;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getCured() {
		return cured;
	}

	public void setCured(Boolean cured) {
		this.cured = cured;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Vet> getVets() {
		return vets;
	}

	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}
	
	
}
