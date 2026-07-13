package database;

import exception.DbException;
import model.Empregado;
import model.Dependente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DependenteDAO {
    private static final EmpregadoDAO emp = new EmpregadoDAO();
    public void add(Dependente dep)throws DbException{
        String sql = "INSERT INTO dependente(nome,sexo,dataNascimento,parentesco,codEmpregado) VALUES (?,?,?,?,?) ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setString(1, dep.getNome());
            stmt.setString(2, dep.getSexo());
            stmt.setDate(3, dep.getDataNascimento());
            stmt.setString(4, dep.getParentesco());
            stmt.setInt(5, dep.getEmpregado().getCodEmpregado());
            stmt.executeUpdate();
            IO.println("Dependente inserido com sucesso!");
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public ArrayList<Dependente> list()throws DbException{
        ArrayList<Dependente> lista = new ArrayList<>();
        String sql = "select * from dependente ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                lista.add(new Dependente(rs.getInt("codDependente"),rs.getString("nome"), rs.getString("sexo"),rs.getDate("dataNascimento"),rs.getString("parentesco"),emp.searchID(rs.getInt("codEmpregado")) ));
            }
        }catch(SQLException e){
            throw new DbException("Erro:"+e.getMessage());
        }
        return lista;
    }
    public Dependente searchID(int id)throws DbException{
        String sql = "select * from dependente where codDependente = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)
        ){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Dependente(rs.getInt("codDependente"),rs.getString("nome"), rs.getString("sexo"),rs.getDate("dataNascimento"),rs.getString("parentesco"),emp.searchID(rs.getInt("codEmpregado")) ));
                }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return null;
    }
    }
    public void remove(int id)throws DbException{
        String sql = "Delete from dependente where codDependente = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,id);
            int linhas = stmt.executeUpdate();
            if(linhas > 0){
                System.out.println("Dependente removido com sucesso!");
            } else {
                System.out.println("Dependente não encontrado");
            }
        } catch(SQLException s){
            throw new DbException("Erro ao remover o dependente: "+s.getMessage());
        }
    }
    public void update(int id,Dependente dep)throws DbException{
        String sql = "Update dependente set nome = ?,sexo = ?,dataNascimento = ?,parentesco = ?,codEmpregado = ? where codDependente = ? ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setString(1, dep.getNome());
            stmt.setString(2, dep.getSexo());
            stmt.setDate(3, dep.getDataNascimento());
            stmt.setString(4, dep.getParentesco());
            stmt.setInt(5,dep.getEmpregado().getCodEmpregado());
            stmt.setInt(6,id);
            int linhas = stmt.executeUpdate();
            if(linhas > 0){
                IO.println("Dependente actualizado com sucesso!");
            } else {
                IO.println("Dependente não achado");
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }

}
