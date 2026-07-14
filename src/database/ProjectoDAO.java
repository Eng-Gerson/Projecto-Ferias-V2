package database;
import model.Projecto;

import java.sql.*;

import exception.DbException;
import java.util.ArrayList;
public class ProjectoDAO {
    private static final DepartamentoDAO dep = new DepartamentoDAO();
    public void add(Projecto p) throws DbException{
        String sql = "INSERT INTO projecto(dataInicio,localizacao,codDepartamento) Values (?,?,?)";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setDate(1,p.getDataInicio());
            stmt.setString(2,p.getLocalizacao());
            stmt.setInt(3,p.getDepartamento().getCodDepartamento());
            stmt.executeUpdate();
            System.out.println("Projecto criado com sucesso!");
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public ArrayList<Projecto> list() throws DbException{
        ArrayList<Projecto> proj = new ArrayList<>();
        String sql = "SELECT * FROM projecto";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);ResultSet rs = stmt.executeQuery()){
          while(rs.next()){
              proj.add(new Projecto(rs.getInt("codProjecto"),rs.getDate("dataInicio"), rs.getString("localizacao"),dep.searchID(rs.getInt("codDepartamento"))));
          }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return proj;
    }
    public Projecto searchID(int index) throws DbException{
        String sql = "SELECT * from projecto where codProjecto = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,index);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Projecto(rs.getInt("codProjecto"), rs.getDate("dataInicio"), rs.getString("localizacao"), dep.searchID(rs.getInt("codDepartamento")));
                } else{
                    return null;
                }
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public void update(Projecto p,int index) throws DbException{
        String sql = "Update from projecto set dataInicio = ?,localizacao = ?,codDepartamento = ? where codProjecto = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(4,p.getCodProjecto());
            stmt.setDate(1,p.getDataInicio());
            stmt.setString(2,p.getLocalizacao());
            stmt.setInt(3,p.getDepartamento().getCodDepartamento());
           int linha = stmt.executeUpdate();
           if(linha > 0){
               IO.println("Projecto actualizado com sucesso!");
           } else {
               IO.println("Não foi possível actualizar");
           }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public void remove(int index) throws DbException{
        String sql = "Delete from projecto where codProjecto = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,index);
            int linha = stmt.executeUpdate();
            if(linha > 0){
                IO.println("Projecto removido com sucesso!");
            } else {
                IO.println("Não foi possível encontrar o projecto.");
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
}
