package zooDemoJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import zooDemaIfaces.OwnerManager;
import zooDemoPOJO.Dog;
import zooDemoPOJO.Owner;
import zooDemoPOJO.Vet;

public class JDBCOwnerManager implements OwnerManager {
	
	private JDBCManager manager;
	
	public JDBCOwnerManager (JDBCManager m)
	{
		  this.manager = m;
	}


	@Override
	public void createOwner(Owner o) {
				try{
					String sql = "INSERT INTO owners (name, phone, email, cardnumber,) VALUES (?,?,?,?)";
					PreparedStatement prep = manager.getConnection().prepareStatement(sql);
					prep.setString(1, o.getName());
					prep.setInt(2, o.getPhone());
					prep.setString(3, o.getEmail());	
					prep.setInt(4, o.getPhone());	
					prep.executeUpdate();			
							
				}catch(Exception e) {
					e.printStackTrace();
				}
	}


	@Override
	public Owner findOwnerByID(Integer id) {
		
		Owner o = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM owners WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
			String name = rs.getString("name");
			Integer phone = rs.getInt("phone");
			String email = rs.getString("email");
			Integer cardnumber = rs.getInt("cardNumber");
			
			o = new Owner(id, name,phone, email, cardnumber);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return o;
	}

	

}
