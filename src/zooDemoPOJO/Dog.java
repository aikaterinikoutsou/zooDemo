package zooDemoPOJO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;



//POJO -- Plain Old Java Object
//POJO has empty constructors without parameters, only setter and getters
//Hashcode and equals
//implement the serializable interface
//Has toString method

public class Dog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5914010397396325040L;
	
	private Integer id;
	private String name;
	private Date dob;
	private String breed;
	private Owner owner;
	
	public Dog() {
		super();
	}

	

	public Dog(Integer id, String name, Date dob, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.breed = breed;
		
	}



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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) // check if the object is the same
			return true;
		if (obj == null) // check if the obj is null
			return false;
		if (getClass() != obj.getClass()) // check if the objects are from the same class
			return false;
		Dog other = (Dog) obj; // if they are cast the other obt to the class
		return Objects.equals(id, other.id) && Objects.equals(name, other.name); // compare the id ant the name if it's the same
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", dob=" + dob + ", breed=" + breed + "]";
	}
	
	
	
	
}
