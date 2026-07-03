/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import exception.DbException;
import input.Input;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AddData {
	public static void AddDepartamento(Connection conn)throws Exception{
		Input io = new Input();
		String sql = "INSERT INTO departamento (nome) VALUES (?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1,io.enterString("Insira o nome do Departamento"));
				stmt.executeUpdate();
			}
		catch(SQLException e){
			    throw new DbException(e.getMessage());
			}
	}
}
