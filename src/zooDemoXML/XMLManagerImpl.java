package zooDemoXML;

import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import zooDemaIfaces.DogManager;
import zooDemaIfaces.XMLManager;
import zooDemoJDBC.JDBCDogManager;
import zooDemoJDBC.JDBCManager;
import zooDemoPOJO.Dog;
import zooDemoPOJO.Owner;
import zooDemoPOJO.Vet;

public class XMLManagerImpl implements XMLManager {

	JDBCManager manager;
	@Override
	public void owner2xml(Integer id) {
		
		Owner o = null;
		List<Dog> dogs = new ArrayList<Dog>();
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
		
		Statement stmt2 = manager.getConnection().createStatement();
		String sql2 = "Select * from dogs where ownerId="+id;
		ResultSet rs2 = stmt.executeQuery(sql2);
		
		while(rs.next())
		{
			Integer id_d= rs.getInt("id");
			String name_d = rs.getString("name");
			String breed = rs.getString("breed");
			String coat = rs.getString("coat");
			Date dob = rs.getDate("dob");
			Boolean cured = rs.getBoolean("cured");
			
			Dog d = new Dog(id_d, name_d, breed, coat, dob, cured);
			dogs.add(d);
		}
		
		
		o = new Owner(id,name,phone, email,cardnumber);
		o.setDogs(dogs);
		
		
		// export the owner to the xml file	
		JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);	
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		File file = new File("./xmls/Owner.xml");
		
		marshaller.marshal(o,file);
		
		
		rs.close();
		stmt.close();
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
		JDBCManager jdbcManager = new JDBCManager();
		DogManager dogMan = new JDBCDogManager(jdbcManager);
		
		Dog d = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Dog.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			d = (Dog) unmarshaller.unmarshal(xml);
						
			//JDBC code to insert dog to table dogs
			dogMan.addDog(d);
			
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
			JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			o = (Owner) unmarshaller.unmarshal(xml);
			
			//JDBC code to insert dog to table dogs
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return o;
	}
	
	
	public void simpleTransform(String sourcePath, String xsltPath,String resultDir) {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)),new StreamResult(new File(resultDir)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
