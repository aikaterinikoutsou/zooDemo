package zooDemoPOJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Owner implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9108688598346524449L;
	private Integer id;
	private String name;
	private Integer phone;
	private String mail;
	private ArrayList<Dog> listDogs;
	
	public Owner() {
		super();
		listDogs = new ArrayList<Dog>();
		
	}

	
	
	public Owner(Integer id, String name, Integer phone, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		
		listDogs = new ArrayList<Dog>();

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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
		Owner other = (Owner) obj;
		return Objects.equals(id, other.id);
	}

	public ArrayList<Dog> getListDogs() {
		return listDogs;
	}

	public void setListDogs(ArrayList<Dog> listDogs) {
		this.listDogs = listDogs;
	}

	
	public void addDog(Dog dog) {
		if(!listDogs.contains(dog))
			listDogs.add(dog);
	}
	
	public void removeDog(Dog dog) {
		if(listDogs.contains(dog))
			listDogs.remove(dog);
		
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", listDogs=" + listDogs
				+ "]";
	}
	

	
}
