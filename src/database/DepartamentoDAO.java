package database;
import exception.DbException;
import model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DepartamentoDAO {
	public void add(String dep) throws DbException {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try(Connection conn = DataBase.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,dep);
            stmt.executeUpdate();
        } catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }
    public void remove(int index)throws DbException{
        String sql = "DELETE from departamento where codDepartamento = ? ";
        try(Connection conn = DataBase.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,index);
            int linha = stmt.executeUpdate();
            if(linha > 0){
                System.out.println("Departamento removido com sucesso!");
            } else {
                System.out.println("Departamento não existe");
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }
    public void update(String nome,int index)throws DbException{
        String sql = "Update from departamento set nome = ? where codDepartamento = ?";
        try(Connection conn = DataBase.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,nome);
            stmt.setInt(2,index);
            int i = stmt.executeUpdate();
            if(i > 0){
                IO.println("Departamento actualizado com sucesso!");
            } else {
                IO.println("Não foi possível actualizar");
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
}
