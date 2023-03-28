package zooDemoPOJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vet implements Serializable {

	
	private static final long serialVersionUID = 453443696806832086L;
	private Integer id;
	private String name;
	private String speciality;
	private List<Dog> dogs; // Many to many relationship
	
	public Vet() {
		super();
		dogs = new ArrayList<Dog>();
	}

	public Vet(Integer id, String name, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.speciality = speciality;
		dogs = new ArrayList<Dog>();
	}

	public Vet(String name, String speciality) {
		super();
		this.name = name;
		this.speciality = speciality;
		dogs = new ArrayList<Dog>();
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

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
		Vet other = (Vet) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vet [id=" + id + ", name=" + name + ", speciality=" + speciality + ", dogs=" + dogs + "]";
	}
	
}
