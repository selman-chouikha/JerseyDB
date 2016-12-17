package org.upec.lissi;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/v1")
public class ServiceSCTIC {
public ServiceSCTIC() {
// TODO Auto-generated constructor stub
}
@GET
@Path("/welcome")
@Produces(MediaType.TEXT_PLAIN)
public String getValue(){
return "Welcome to DBA";
}
@GET
@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
public Response getValuePatients(){
	List<Patient> listePatient=new ArrayList<Patient>();
	
	try {
	    // ouverture de connexion 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection cx = DriverManager.getConnection("jdbc:mysql://localhost/clinique", "root",null );
		// exécution d'une requête 
		Statement st = cx.createStatement();
		ResultSet rs = st.executeQuery( "SELECT * FROM patient" );
		while(rs.next())
		{
			Patient pat=new Patient();
			pat.setNoPatient(rs.getString("NoPatient"));
			pat.setDateNaissance(rs.getString("DateNaissance"));
			pat.setNoAssSociale(rs.getString("NoAssSociale"));
			pat.setNom(rs.getString("Nom"));
			pat.setPrenom(rs.getString("Prenom"));
			pat.setNoTelephone(rs.getString("NoTelephone"));
			listePatient.add(pat);
			//System.out.println(pat.toString());
		}
        
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return Response.ok(listePatient).build();
}
@GET
@Path("/patients/{id_patient}")
@Produces(MediaType.APPLICATION_JSON)
public Patient getValuePatient(@PathParam("id_patient") String id){
	Patient pat=new Patient();
	try {
	    // ouverture de connexion 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection cx = DriverManager.getConnection("jdbc:mysql://localhost/clinique", "root",null );
		// exécution d'une requête 
		PreparedStatement ps=cx.prepareStatement("SELECT * FROM patient WHERE NoPatient=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			pat.setNoPatient(rs.getString("NoPatient"));
			pat.setDateNaissance(rs.getString("DateNaissance"));
			pat.setNoAssSociale(rs.getString("NoAssSociale"));
			pat.setNom(rs.getString("Nom"));
			pat.setPrenom(rs.getString("Prenom"));
			pat.setNoTelephone(rs.getString("NoTelephone"));
			System.out.println(pat.toString());
		}
        
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return pat;
}
@GET
@Path("/medecin/{id_medecin}/patients")
@Produces(MediaType.APPLICATION_JSON)
public Response getValueMedecin(@PathParam("id_medecin") String id){
	
	
List<Patient> listePatient=new ArrayList<Patient>();
	
	try {
	    // ouverture de connexion 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection cx = DriverManager.getConnection("jdbc:mysql://localhost/clinique", "root",null );
		// exécution d'une requête 
		PreparedStatement ps=cx.prepareStatement("SELECT * FROM patient_medecin WHERE NoMedecin=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Patient pat=new Patient();
			pat.setNoPatient(rs.getString("NoPatient"));
			pat.setDateNaissance(rs.getString("DateNaissance"));
			pat.setNoAssSociale(rs.getString("NoAssSociale"));
			pat.setNom(rs.getString("Nom_Patient"));
			pat.setPrenom(rs.getString("Prenom_Patient"));
			pat.setNoTelephone(rs.getString("NoTelephone"));
			listePatient.add(pat);
			//System.out.println(pat.toString());
		}
        
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return Response.ok(listePatient).build();
	
}
}