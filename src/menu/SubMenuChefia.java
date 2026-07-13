package menu;
import database.ChefiaDAO;
import database.DepartamentoDAO;
import database.EmpregadoDAO;
import exception.DbException;
import input.Input;
import model.Departamento;
import model.Empregado;

import java.sql.Date;
import java.util.ArrayList;

public class SubMenuChefia {
    private static final ChefiaDAO chefe = new ChefiaDAO();
    private static final EmpregadoDAO emp = new EmpregadoDAO();
    private static final DepartamentoDAO dep = new DepartamentoDAO();
    private static final Input io = new Input();
    public static void exibir()throws Exception {
        int op;
        do {
            op = io.enterInt("----- Chefia ----- \n1-Adicionar \n2-Remover \n3-Listar \n4-Buscar Chefe de Departamento \n5-Actualizar \nOutro - Sair");
            switch (op) {
                case 1:
                    Inserir();
                    break;
                case 2:
                    Remover();
                    break;
                case 3:
                    Listar();
                    break;
                case 4:
                    Buscar();
                    break;
                case 5:
                    Actualizar();
                    break;
                default:
                    IO.println("Está Nice");
                    break;
            }
        }while(op > 0 && op < 6);
    }

    private static void Remover()throws Exception{
        int id = io.enterInt("Insira o código do empregado a ser removido");
        emp.remove(id);
    }

    private static void Inserir()throws Exception{
        String nome = io.enterString("Insira o 1º nome");
        String apelido = io.enterString("Insira o apelido");
        double salario = io.enterDouble("Insira o salário");
        String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
        Date data =  Date.valueOf(dt);
        Departamento dpt = dep.searchID(io.enterInt("Insira o código do departamento"));
        emp.add(new Empregado(nome,apelido,salario,data,dpt));

    }

    private static void Listar()throws DbException {
        ArrayList<Empregado> listagem = emp.list();
        for(Empregado e : listagem){
            IO.println(e);
        }
    }
    public static void Buscar()throws Exception{
        int id = io.enterInt("Insira o código do empregado");
        Empregado empregado = emp.searchID(id);
        if(empregado == null){
            System.out.println("O empregado não existe!");
        } else {
            IO.println(empregado.toString());
        }
    }

    private static void Actualizar()throws Exception{
        int id = io.enterInt("Insira o código do empregado a ser actualizado");
        if(emp.searchID(id) != null) {
            String nome = io.enterString("Insira o 1º nome");
            String apelido = io.enterString("Insira o apelido");
            double salario = io.enterDouble("Insira o salário");
            String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
            Date data = Date.valueOf(dt);
            Departamento dpt = dep.searchID(io.enterInt("Insira o código do departamento"));
            emp.update(id, new Empregado(nome, apelido, salario, data, dpt));
        } else {
            IO.println("Não existe empregado com esse código");
        }
    }
}
