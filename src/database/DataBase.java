package database;
import exception.DbException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DataBase {
	public static Connection conn = null;
	public static Connection getConnection()throws DbException{
		if(conn == null){
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
				System.out.println("Connection succesful!");
			}
			catch(SQLException e){
				throw new DbException("A comunicação com o banco de dados falhou \n"+e.getMessage());
			} 
		}
		return conn;
	}

	public static void closeConnection() throws DbException{
		if(conn != null){
			try{
				conn.close();  
				System.out.println("Connection closed");
			}
			catch(SQLException e){
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() throws DbException{
		try(FileInputStream fs = new FileInputStream("src/database/db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch(IOException e){
			throw new DbException(e.getMessage());
		}
	}
}
