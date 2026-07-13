package database;
import exception.DbException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class EmpregadoDAO{
	private static final DepartamentoDAO dep = new DepartamentoDAO();
	public void add(Empregado emp)throws Exception{
		String sql = "INSERT INTO empregado(nome,apelido,salario,dataNascimento,codDepartamento) VALUES (?,?,?,?,?) ";
		try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
			stmt.setString(1, emp.getNome());
			stmt.setString(2, emp.getApelido());
			stmt.setDouble(3, emp.getSalario());
			stmt.setDate(4, emp.getDataNascimento());
			stmt.setInt(5, emp.getDepartamento().getCodDepartamento());
			stmt.executeUpdate();
			IO.println("Empregado inserido com sucesso!");
		}catch(SQLException s){
			throw new DbException(s.getMessage());
		}catch(Exception e){
			throw new DbException("Erro: "+e.getMessage());
		}
		
	}
	public ArrayList<Empregado> list()throws DbException{
		ArrayList<Empregado> lista = new ArrayList<>();
		String sql = "select * from empregado ";
		try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);ResultSet rs = stmt.executeQuery()){
			while(rs.next()){
				lista.add(new Empregado(rs.getInt("codEmpregado"),rs.getString("nome"),rs.getString("apelido"),rs.getDouble("salario"),rs.getDate("dataNascimento"),dep.searchID(rs.getInt("codDepartamento"))));
		}
	}catch(SQLException e){
			throw new DbException("Erro:"+e.getMessage());
		}
		return lista;
	}
	public Empregado searchID(int id)throws DbException{
		String sql = "select * from empregado where codEmpregado = ?";
		try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)
){
			stmt.setInt(1,id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()){
				return new Empregado(rs.getInt("codEmpregado"),rs.getString("nome"),rs.getString("apelido"),rs.getDouble("salario"),rs.getDate("dataNascimento"),dep.searchID(rs.getInt("codDepartamento")));
			}
		}
		}catch(SQLException s){
			throw new DbException(s.getMessage());
		}
	return null;
	}
	public void remove(int id)throws DbException{
		String sql = "Delete from empregado where codEmpregado = ?";
		try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
			stmt.setInt(1,id);
			int linhas = stmt.executeUpdate();
			if(linhas > 0){
				System.out.println("Empregado removido com sucesso!");
			} else {
				System.out.println("Empregado não encontrado");
			}
		} catch(SQLException s){
			throw new DbException("Erro ao remover o empregado: "+s.getMessage());
		}
	}
	public void update(int id,Empregado emp)throws DbException{
		String sql = "Update empregado set nome = ?,apelido = ?,salario = ?,dataNascimento = ?,codDepartamento = ? where codEmpregado = ? ";
		try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
			stmt.setString(1, emp.getNome());
			stmt.setString(2, emp.getApelido());
			stmt.setDouble(3, emp.getSalario());
			stmt.setDate(4, emp.getDataNascimento());
			stmt.setInt(5, emp.getDepartamento().getCodDepartamento());
			stmt.setInt(6,id);
			int linhas = stmt.executeUpdate();
			if(linhas > 0){
				IO.println("Empregado actualizado com sucesso!");
			} else {
				IO.println("Empregado não achado");
			}
		}catch(SQLException s){
			throw new DbException(s.getMessage());
		}catch(Exception e){
			throw new DbException("Erro: "+e.getMessage());
		}	
	}
	
}
