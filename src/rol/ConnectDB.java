package rol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	private final String HOST;
	private final String USER;
	private final String PASSWORD;
	
	public ConnectDB() {
		this.HOST = "jdc:mysql://localhost:3306/";
		this.USER = "root";
		this.PASSWORD = "";
	}
	public void connectToDB() throws SQLException {
		Connection connect = DriverManager.getConnection(HOST, USER, PASSWORD);
		Statement sentencia = connect.createStatement();
		
		String comandoSQL = "CREATE DATABASE rol;";
		sentencia.executeUpdate(comandoSQL);
		
		comandoSQL = "USE rol;";
		sentencia.executeUpdate(comandoSQL);
		
		comandoSQL = "CREATE TABLE razas (nombre VARCHAR(50) NOT NULL PRIMARY KEY, Caract_bonif VARCHAR(20), bonificador INT);";
				sentencia.executeUpdate(comandoSQL);
				
		comandoSQL = "CREATE TABLE personajesCreados (nombre VARCHAR(50) NOT NULL PRIMARY KEY, Caract_bonif VARCHAR(20), bonificador INT);";
				sentencia.executeUpdate(comandoSQL);
				
				sentencia.close();
				connect.close();

	}
}
