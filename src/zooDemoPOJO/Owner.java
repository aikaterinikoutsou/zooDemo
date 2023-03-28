package zooDemoPOJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Owner implements Serializable{
	
	

	private static final long serialVersionUID = 8227038095703196079L;
	private Integer id;
	private String name;
	private Integer phone;
	private String email;
	private Integer cardNumber;
	private List<Dog> dogs; // One to many relationship

	public Owner() {
		super();
		dogs = new ArrayList<Dog>();
	}

	public Owner(Integer id, String name, Integer phone, String email, Integer cardNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cardNumber = cardNumber;
		this.dogs = new ArrayList<Dog>();
	}

	public Owner(String name, Integer phone, String email, Integer cardNumber) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cardNumber = cardNumber;
		this.dogs = new ArrayList<Dog>();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
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
		Owner other = (Owner) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", phone=" + phone + ", email=" + email + ", cardNumber=" + cardNumber + ", dogs="
				+ dogs + "]";
	}

}
