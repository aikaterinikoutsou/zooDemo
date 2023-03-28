package zooDemoJDBC;

import java.sql.PreparedStatement;
import java.util.List;

import zooDemaIfaces.DogManager;
import zooDemoPOJO.Dog;

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
			String sql = "INSER INTO dogs (name, breed, coat, dob, cured) VALUES (?,?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, d.getName());
			prep.setString(2, d.getBreed());
			prep.setString(3, d.getCoat());
			prep.setDate(4, d.getDob());
			prep.setBoolean(5, d.getCured());
			
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
		
	}

	
}
