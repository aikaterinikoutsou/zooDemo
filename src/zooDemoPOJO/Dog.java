package zooDemoPOJO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import zooDemoXMLutils.SQLDateAdapter;


//POJO -- Plain Old Java Object
//POJO has empty constructors without parameters, only setter and getters
//Hashcode and equals
//implement the serializable interface
//Has toString method
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "Dog")
@XmlType(propOrder = {"breed","coat", "dob", "cured", "owner"})

public class Dog implements Serializable{
	

	private static final long serialVersionUID = 5459002349058385563L;
	
	
	// Has attributes
	@XmlTransient
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private String breed;
	@XmlElement
	private String coat;
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date dob;
	@XmlElement
	private Boolean cured;
	@XmlElement
	private Integer owner; // Many to one relationship
	@XmlTransient
	private List<Vet> vets; // Many to many relationship
	
	
	
	public Dog() {
		super();
	}



	public Dog(Integer id, String name, String breed, String coat, Date dob, Boolean cured, Integer owner) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.coat = coat;
		this.dob = dob;
		this.cured = cured;
		this.owner = owner;
	}



	public Dog(Integer id, String name, String breed, String coat, Date dob, Boolean cured) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.coat = coat;
		this.dob = dob;
		this.cured = cured;
		vets = new ArrayList<Vet>();
	}



	public Dog( String name, String breed, String coat, Boolean cured, Integer owner) {
		super();
		this.name = name;
		this.breed = breed;
		this.coat = coat;
		//this.dob = dob;
		this.cured = cured;
		this.owner = owner;
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

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public List<Vet> getVets() {
		return vets;
	}

	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}
	
	
}
