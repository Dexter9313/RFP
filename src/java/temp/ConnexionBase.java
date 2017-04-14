package ontotest;


	import java.sql.*;

import org.apache.log4j.BasicConfigurator;

	public class ConnexionBase {

	    // Chemin de la base
	    private String path;

	    // Nom d'utilisateur
	    private String user;

	    // Mot de passe
	    private String password;

	    // Connection vers la base
	    private Connection connection;


	    /* Constructeur */
	    public ConnexionBase(String path, String user, String password) {
	        this.path = path;
	        this.user = user;
	        this.password = password;
	    }


	    /*
	    *Connection � la base
	    *@return : true si la connexion est r�ussie, false si �chou�e
	    */
	    public boolean connect() {
	        try {
	            // Chargement du driver ODBC
	           // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	            
	            // Connexion � la base
	            //String connectionString = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=" + path;
	            connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/ajmi.CL-G1GYL12/workspace/ontotest/src/Etudiant.accdb");
	        }
	       /* catch (ClassNotFoundException e) {
	            System.out.println("Probl�me avec le driver ODBC");
	            return false;
	        }*/
	        catch (SQLException e) {
	            System.out.println("Impossible de se connecter � la base");
	            e.printStackTrace(System.err);
	            return false;
	        }
	        System.out.println("connecter � la base");
	        return true;
	    }


	    /*
	    *D�connexion de la base
	    *@return : true si la d�connexion est r�ussie, false sinon
	    */
	    public boolean disconnect() {
	        try {
	            connection.close();
	            return true;
	        }
	        catch (SQLException e) {
	            return false;
	        }
	    }

	    /*
	    *Envoi d'une requ�te de s�lection
	    *@param : sql
	    *@return : result
	    */
	    public ResultSet SQLSelect(String sql) throws SQLException {
	        Statement statement = null;
	        ResultSet result = null;
	        try {
	            statement = connection.createStatement();
	            result = statement.executeQuery(sql);
	            return result;
	        }
	        catch (SQLException e) {
	            result.close();
	            statement.close();
	            return null;
	        }
	    }

	    /*
	    *Envoi d'une requ�te de mise � jour (insert, update, delete)
	    *@param : sql
	    */
	    public void SQLUpdate(String sql) throws SQLException {
	        Statement statement = null;
	        try {
	            statement = connection.createStatement();
	            statement.executeUpdate(sql);
	        }
	        catch (SQLException e) {
	            
	        }
	        
	    }
	    
	    public static void main (String[] args) {
	    	BasicConfigurator.configure();
	    	ConnexionBase CB=new ConnexionBase("Etudiants.accdt","","");
	    	boolean A =CB.connect();
	    	System.out.println(A);
	    }
	}


