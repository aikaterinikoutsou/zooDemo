package zooDemoJDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import zooDemaIfaces.DogManager;
import zooDemoPOJO.Dog;
import zooDemoPOJO.Vet;

public class JDBCDogManager implements DogManager {

	private JDBCManager manager;
	
	public JDBCDogManager(JDBCManager m)
	{
		this.manager = m;
	}
	
	@Override
	public void addDog(Dog d) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO dogs (name, breed, coat, cured, ownerId) VALUES (?,?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, d.getName());
			prep.setString(2, d.getBreed());
			prep.setString(3, d.getCoat());
			prep.setDate(4, d.getDob());
			prep.setBoolean(4, d.getCured());
			prep.setInt(5, d.getOwner());
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Dog> getListOfDogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assign(int vetID, int dogID) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO examines (dogID,vetId) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, dogID);
			prep.setInt(2, vetID);		
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Dog> getListOfDogs(Integer ownerId) {
		List<Dog> dogs = new ArrayList<Dog>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM dogs WHERE ownerId=" + ownerId;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String breed = rs.getString("breed");
				String coat = rs.getString("coat");
				Date dob = rs.getDate("dob");
				Boolean cured = rs.getBoolean("cured");
							
				Dog d = new Dog(id, name,  breed, coat,  dob,  cured,  ownerId);
				dogs.add(d);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return dogs;
	}

	
}
