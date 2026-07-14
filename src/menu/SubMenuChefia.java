package menu;
import database.ChefiaDAO;
import database.DepartamentoDAO;
import database.EmpregadoDAO;
import exception.DbException;
import input.Input;
import model.Departamento;
import model.Empregado;
import model.Chefia;

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
            op = io.enterInt("----- Chefia ----- \n1-Adicionar \n2-Remover \n3-Listar \n4-Buscar Chefe por Departamento \n5-Buscar Chefe por Empregado \n6-Actualizar \nOutro - Sair");
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
                    BuscarDepartamento();
                    break;
                case 5:
                    BuscarEmpregado();
                    break;
                case 6:
                    Actualizar();
                    break;
                default:
                    IO.println("Saindo...");
                    break;
            }
        }while(op > 0 && op < 7);
    }

    private static void Remover()throws Exception{
        int id = io.enterInt("Insira o código do departamento ao qual o chefe será despromovido");
        chefe.removeByDepartamento(id);
    }
    private static void Inserir()throws Exception{
        Empregado empregado = emp.searchID(io.enterInt("Insira o código do empregado"));
        if(empregado == null){
            System.out.println("Não existe empregado com esse código");
            return;
        }
        Departamento departamento = dep.searchID(io.enterInt("Insira o código do departamento"));
        if(departamento == null){
            System.out.println("Não existe departamento com esse código");
            return;
        }
        String dt = io.enterString("Insira a data de inicio  \"aaaa-mm-dd\"");
        Date data =  Date.valueOf(dt);
        String design = io.enterString("Insira a designação");
        chefe.add(new Chefia(empregado,departamento,data,design));
    }
    private static void Listar()throws DbException {
        ArrayList<Chefia> listagem = chefe.list();
        for(Chefia c : listagem){
            IO.println(c);
        }
    }
    public static void BuscarDepartamento()throws Exception{
        int id = io.enterInt("Insira o código do departamento");
        Chefia chef = chefe.searchByDepartamento(id);
        if(chef == null){
            System.out.println("O departamento não tem chefe!");
        } else {
            IO.println(chef.toString());
        }
    }
    public static void BuscarEmpregado()throws Exception{
        int id = io.enterInt("Insira o código do empregado");
        Chefia empregado = chefe.searchByEmpregado(id);
        if(empregado == null){
            System.out.println("O empregado não é chefe de nenhum departamento!");
        } else {
            IO.println(empregado.toString());
        }
    }
    private static void Actualizar()throws Exception{
        int id = io.enterInt("Insira o código do departamento ao qual deseja trocar o chefe");
        if(chefe.searchByDepartamento(id) != null) {
            Empregado empregado = emp.searchID(io.enterInt("Insira o código do empregado"));
            if(empregado == null){
                System.out.println("Não existe empregado com esse código");
                return;
            }
            String dt = io.enterString("Insira a data de inicio  \"aaaa-mm-dd\"");
            Date data =  Date.valueOf(dt);
            String design = io.enterString("Insira a designação");
            chefe.update(id,new Chefia(empregado,dep.searchID(id),data,design));
        } else {
            IO.println("O departamento não tem chefe ou não existe");
        }
    }
}
