package zooDemoXML;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import zooDemaIfaces.XMLManager;
import zooDemoJDBC.JDBCManager;
import zooDemoPOJO.Dog;
import zooDemoPOJO.Owner;

public class XMLManagerImpl implements XMLManager {

	JDBCManager manager;
	@Override
	public void owner2xml(Integer id) {
		
		Owner o = null;
		manager = new JDBCManager();
		
		try {
		
		// Do a sql query to get the owner by the id
		Statement stmt = manager.getConnection().createStatement();
		String sql = "Select * from owners where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		
		String name = rs.getString("name");
		Integer phone = rs.getInt("phone");
		String email = rs.getString("email");
		Integer cardnumber = rs.getInt("cardnumber");
		o = new Owner(id,name,phone, email,cardnumber);
		
		rs.close();
		stmt.close();
		
		// export the owner to the xml file	
		JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);	
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		File file = new File("./xmls/Owner.xml");
		
		marshaller.marshal(o,file);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void dog2xml(Dog d) {
		try {
		// export the owner to the xml file	
				JAXBContext jaxbContext = JAXBContext.newInstance(Dog.class);	
				Marshaller marshaller = jaxbContext.createMarshaller();
				
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				File file = new File("./xmls/Dog.xml");
				
				marshaller.marshal(d,file);
				
				}catch(Exception e)
				{
					e.printStackTrace();
				}
	}

	@Override
	public Dog xml2Dog(File xml) {
		Dog d = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Dog.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			d = (Dog) unmarshaller.unmarshal(xml);
			
			
			
			//JDBC code to insert dog to table dogs
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public Owner xml2Owner(File xml) {
		Owner o = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Dog.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			o = (Owner) unmarshaller.unmarshal(xml);
			
			
			
			//JDBC code to insert dog to table dogs
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return o;
	}

}
