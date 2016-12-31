package org.upec.lissi;

public class Patient {
	
	private String NoPatient;
	private String nom;
    private String prenom;
    private String noTelephone;
    private String dateNaissance;
    private String NoAssSociale;
    

    /** 
     * Reponse pour une requête GET par rapport à la liste
     * des patients d'un medecin donné.
     * @param id			id de medecin récuperé de la requete GET
     * @return Response		Reponse sous forme d'une liste des objets JSON de type Patient
     * 
     * */
	public String getNoAssSociale() {
		return NoAssSociale;
	}

	public void setNoAssSociale(String noAssSociale) {
		NoAssSociale = noAssSociale;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	public Patient(String NoPatient,String NoAssSociale,String nom,String prenom,String noTelephone,String dateNaissance){
		// TODO Auto-generated constructor stub
		this.NoPatient=NoPatient;
		this.NoAssSociale=NoAssSociale;
		this.nom=nom;
		this.prenom=prenom;
		this.noTelephone=noTelephone;
		this.dateNaissance=dateNaissance;
	}
	
	public String getNoPatient() {
		return NoPatient;
	}

	public void setNoPatient(String noPatient) {
		NoPatient = noPatient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) {
		this.noTelephone = noTelephone;
	}

	    @Override
	
	    public String toString() {
	
	        return new StringBuffer(" Nom : ").append(this.nom)
	
	                .append(" Prenom : ").append(this.prenom)
	
	                .append(" Date de Naissance : ").append(this.dateNaissance).append(" Telephone : ").append(this.noTelephone).append(" NoPatient : ")
	
	                .append(this.NoPatient).append(" NoAssSociale : ").append(this.NoAssSociale).toString();
	
	    }


}
