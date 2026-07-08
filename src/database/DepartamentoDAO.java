package database;
import exception.DbException;
import model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Empregado;
public class DepartamentoDAO {
	public void add(String dep) throws DbException {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setString(1,dep);
            stmt.executeUpdate();
        } catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }
    public void remove(int index)throws DbException{
        String sql = "DELETE from departamento where codDepartamento = ? ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
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
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
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
    public ArrayList<Departamento> list() throws DbException{
        String sql = "Select * from Departamento";
        ArrayList<Departamento> lista = new ArrayList<>();
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                lista.add(new Departamento(rs.getInt("codDepartamento"),rs.getString("nome")));
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        return lista;
    }
    public Departamento Busca(int index) throws DbException{
        String sql = "Select * from departamento where codDepartamento = ?";
        Departamento dep = null;
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,index);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    dep = new Departamento(rs.getInt("codDepartamento"), rs.getString("nome"));
                }
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return dep;
    }
    public ArrayList<Empregado> listaEmpregado(int index)throws DbException{
        ArrayList<Empregado> emp = new ArrayList<>();
        String sql = "select empregado.*, departamento.nome as nomeDepartamento from empregado inner join departamento on empregado.codDepartamento = departamento.codDepartamento where empregado.codDepartamento = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,index);
            try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                emp.add(new Empregado(rs.getInt("codEmpregado"),rs.getString("nome"),rs.getString("apelido"),rs.getDouble("salario"),rs.getDate("dataNascimento"),new Departamento(rs.getInt("codDepartamento"),rs.getString("nomeDepartamento"))));
            }
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return emp;
    }
}
