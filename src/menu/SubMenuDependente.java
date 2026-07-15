package menu;

import database.DependenteDAO;
import database.EmpregadoDAO;
import exception.DbException;
import input.Input;
import model.Dependente;
import model.Empregado;

import java.sql.Date;
import java.util.ArrayList;

public class SubMenuDependente {
    private static final EmpregadoDAO emp = new EmpregadoDAO();
    private static final DependenteDAO dep = new DependenteDAO();
    private static final Input io = new Input();
    public static void exibir()throws Exception {
        int op;
        do {
            op = io.enterInt("----- Dependente ----- \n1-Adicionar \n2-Remover \n3-Listar \n4-Buscar Dependente \n5-Buscar Dependente por Empregado \n6-Actualizar \nOutro - Sair");
            try{
            switch (op) {
                case 1:
                    inserir();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    listarEmpregado();
                    break;
                case 6:
                    actualizar();
                    break;
                default:
                    IO.println("Saindo...");
                    break;
            }
            }catch(DbException e){
                IO.println("Ocorreu um erro "+ "\n"+ e.getMessage()+"\nTente reiniciar o programa.");
            }
        }while(op > 0 && op < 7);
    }

    private static void remover()throws Exception{
        int id = io.enterInt("Insira o código do dependente a ser removido");
        dep.remove(id);
    }
    private static void inserir()throws Exception{
        String nome = io.enterString("Insira o 1º nome");
        String sexo = String.valueOf(io.enterChar("Insira o sexo"));
        Date data = io.enterDate("Insira a data de Nascimento  \"dd/MM/aaaa\"");
        String parente = io.enterString("Insira o parentesco");
        Empregado empreg = emp.searchID(io.enterInt("Insira o código do empregado"));
        if(empreg == null){
            IO.println("Esse empregado não existe");
            return;
        }
        dep.add(new Dependente(nome,sexo,data,parente,empreg));
    }
    private static void listar()throws DbException {
        ArrayList<Dependente> listagem = dep.list();
        for(Dependente d : listagem){
            IO.println(d);
        }
    }
    private static void listarEmpregado()throws Exception {
        int id = io.enterInt("Insira o código do Empregado e eu listarei os dependentes");
        ArrayList<Dependente> listagem = dep.listByEmpregado(id);
        for(Dependente d : listagem){
            IO.println(d);
        }
    }
    public static void buscar()throws Exception{
        int id = io.enterInt("Insira o código do dependente");
        Dependente dependente = dep.searchID(id);
        if(dependente == null){
            System.out.println("O dependente não existe!");
        } else {
            IO.println(dependente.toString());
        }
    }
    private static void actualizar()throws Exception{
        int id = io.enterInt("Insira o código do dependente a ser actualizado");
        if(dep.searchID(id) != null) {
            String nome = io.enterString("Insira o 1º nome");
            String sexo = String.valueOf(io.enterChar("Insira o sexo"));
            Date data = io.enterDate("Insira a data de Nascimento  \"dd/MM/aaaa\"");
            String parente = io.enterString("Insira o parentesco");
            Empregado empreg = emp.searchID(io.enterInt("Insira o código do empregado"));
            if(empreg == null){
                IO.println("Esse empregado não existe");
                return;
            }
            dep.update(id,new Dependente(nome,sexo,data,parente,empreg));
        } else {
            IO.println("Não existe dependente com esse código");
        }
    }
}
