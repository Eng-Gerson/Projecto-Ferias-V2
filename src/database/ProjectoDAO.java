package database;
import model.Projecto;
import model.Departamento;
import database.DepartamentoDAO;

import java.sql.*;

import exception.DbException;
import java.util.ArrayList;
public class ProjectoDAO {
    //private static DepartamentoDAO dep = new DepartamentoDAO();
    public static void add(Projecto p) throws DbException{
        String sql = "INSERT INTO projecto(dataInicio,localizacao,codDepartamento) Values (?,?,?)";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setDate(1,p.getDataInicio());
            stmt.setString(2,p.getLocalizacao());
            stmt.setInt(3,p.getDepartamento().getCodDepartamento());
            stmt.executeUpdate();
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public static ArrayList<Projecto> listar(){
        ArrayList<Projecto> proj = new ArrayList<>();
        return proj;
    }
}
