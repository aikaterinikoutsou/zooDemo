package zooDemoJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import zooDemaIfaces.VetManager;
import zooDemoPOJO.Vet;

public class JDBCVetManager implements VetManager {
	
	 private JDBCManager manager;
	 
	 public JDBCVetManager (JDBCManager m)
	 {
		  this.manager = m;
	 }

	@Override
	public List<Vet> getListAllVets() {
		// TODO Auto-generated method stub
		List<Vet> vets = new ArrayList<Vet>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM vets";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String speciality = rs.getString("speciality");
				
				Vet v = new Vet(id,name, speciality);
				vets.add(v);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return vets;
	}

	@Override
	public void createVet(Vet v) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO vets (name, speciality) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, v.getName());
			prep.setString(2, v.getSpeciality());			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSpeciality(int vet_id, String n_speciality) {
		// TODO Auto-generated method stub
		
		try {
			
			String sql = "UPDATE vets SET speciality=? WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, n_speciality);
			prep.setInt(2, vet_id);
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVetbyID(int vet_id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM vets WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,vet_id);
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public Vet getVetbyId(int id) {
		// TODO Auto-generated method stub
		
		Vet v = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM vets WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String speciality = rs.getString("speciality");
				v = new Vet(id, name, speciality);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return v;
	}
	
	
	 

}
