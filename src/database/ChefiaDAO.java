package database;

import exception.DbException;
import model.Chefia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChefiaDAO {
    private static final DepartamentoDAO dep = new DepartamentoDAO();
    private static final EmpregadoDAO emp = new EmpregadoDAO();
    public void add(Chefia chefe)throws DbException{
        String sql = "INSERT INTO chefia(codEmpregado,codDepartamento,dataInicio,designacao) VALUES (?,?,?,?) ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1, chefe.getEmpregado().getCodEmpregado());
            stmt.setInt(2, chefe.getDepartamento().getCodDepartamento());
            stmt.setDate(3, chefe.getDataInicio());
            stmt.setString(4, chefe.getDesignacao());
            stmt.executeUpdate();
            IO.println("Empregado promovido a chefe com sucesso!");
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }
    public ArrayList<Chefia> list()throws DbException{
        ArrayList<Chefia> lista = new ArrayList<>();
        String sql = "select * from chefia ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                lista.add(new Chefia(emp.searchID(rs.getInt("codEmpregado")),dep.searchID(rs.getInt("codDepartamento")),rs.getDate("dataInicio"), rs.getString("designacao")));
            }
        }catch(SQLException e){
            throw new DbException("Erro:"+e.getMessage());
        }
        return lista;
    }
    public Chefia searchByDepartamento(int id)throws DbException{
        String sql = "select * from chefia where codDepartamento = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)
        ){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Chefia(emp.searchID(rs.getInt("codEmpregado")),dep.searchID(rs.getInt("codDepartamento")),rs.getDate("dataInicio"), rs.getString("designacao"));
                }
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return null;
    }
    public Chefia searchByEmpregado(int id)throws DbException{
        String sql = "select * from chefia where codEmpregado = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)
        ){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Chefia(emp.searchID(rs.getInt("codEmpregado")),dep.searchID(rs.getInt("codDepartamento")),rs.getDate("dataInicio"), rs.getString("designacao"));
                }
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
        return null;
    }
    public void removeByDepartamento(int codDepartamento)throws DbException{
        String sql = "Delete from chefia where codDepartamento = ?";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1,codDepartamento);
            int linhas = stmt.executeUpdate();
            if(linhas > 0){
                System.out.println("Chefe despromovido com sucesso!");
            } else {
                System.out.println("O empregado não é chefe");
            }
        } catch(SQLException s){
            throw new DbException("Erro ao despromover o empregado: "+s.getMessage());
        }
    }
    public void update(int id,Chefia chefe)throws DbException{
        String sql = "Update chefia set codEmpregado = ?,dataInicio = ?,designacao = ? where codDepartamento = ? ";
        try(PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql)){
            stmt.setInt(1, chefe.getEmpregado().getCodEmpregado());
            stmt.setDate(2, chefe.getDataInicio());
            stmt.setString(3, chefe.getDesignacao());
            stmt.setInt(4,id);
            int linhas = stmt.executeUpdate();
            if(linhas > 0){
                IO.println("Chefe actualizado com sucesso!");
            } else {
                IO.println("O departamento não tem chefe");
            }
        }catch(SQLException s){
            throw new DbException(s.getMessage());
        }
    }

}
