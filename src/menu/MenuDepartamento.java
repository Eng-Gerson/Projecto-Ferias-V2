package menu;
import input.Input;
import database.DepartamentoDAO;
import model.Departamento;
import java.util.ArrayList;
import model.Empregado;
import model.Projecto;

import java.lang.Exception;

public class MenuDepartamento {
    private static final Input io = new Input();
    static DepartamentoDAO dep = new DepartamentoDAO();
    public static void exibir() throws Exception {
        int op;
        do {
            op = io.enterInt("------- MENU DEPARTAMENTO ------- \n1-Adicionar \n2-Remover \n3-Actualizar \n4-Listar \n5-Mostrar Funcionários \n6-Buscar por Código \n7-Mostrar Projectos \n8-Chefia \nOutro- Sair");
            switch (op) {
                case 1:
                    inserir();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    mostrarEmpregado();
                    break;
                case 6:
                    buscar();
                    break;
                case 7:
                    mostrarProjecto(); break;
                case 8:
                    SubMenuChefia.exibir(); break;
                default:
                    System.out.println("Saindo...");
                    break;
            }
        }while(op > 0 && op < 9);
    }

    private static void buscar() throws Exception {
        int choice = io.enterInt("Insira o número do Departamento");
        if(dep.searchID(choice) != null) {
            Departamento departamento = dep.searchID(choice);
            IO.println("CodDepartamento: " + departamento.getCodDepartamento() + " Nome: " + departamento.getNome());
        } else {
            IO.println("Departamento com esse código não existe");
        }

    }

    private static void mostrarEmpregado() throws Exception {
        int index = io.enterInt("Insira o código do departamento e eu te mostrarei os funcionários lá");
        ArrayList<Empregado> empregados = dep.listaEmpregado(index);
        if(empregados.isEmpty()){
            IO.println("Das duas uma, ou o departamento não existe ou não tem empregados");
        } else {
            for (Empregado e : empregados) {
                System.out.println("CodEmpregado: "+e.getCodEmpregado()+ " Nome Completo: "+e.getNome()+" "+e.getApelido());
            }
        }
    }

    private static void listar() throws Exception{
        ArrayList<Departamento> departamento =  dep.list();
        for(Departamento dpt : departamento){
            IO.println(dpt);
        }
    }

    private static void actualizar() throws Exception{
        int index = io.enterInt("Insira o número do departamento a actualizar");
        if(dep.searchID(index) != null) {
            String nomeDepartamento = io.enterString("Insira o novo nome para o departamento " + index);
            dep.update(nomeDepartamento, index);
        } else {
            IO.println("O departamento com esse código não existe");
        }
    }

    private static void inserir() throws Exception{
        String nomeDepartamento = io.enterString("Insira o nome do novo departamento");
        dep.add(nomeDepartamento);
    }
    private static void remover() throws Exception{
        int index = io.enterInt("Insira o código do departamento a ser removido");
        dep.remove(index);
    }
    private static void mostrarProjecto() throws Exception {
        int index = io.enterInt("Insira o código do departamento e eu te mostrarei os projectos associados");
        ArrayList<Projecto> projectos = dep.listaProjecto(index);
        if(projectos.isEmpty()){
            IO.println("Das duas uma, ou o departamento não existe ou não tem projectos associados");
        } else {
            for (Projecto p : projectos) {
                System.out.println("CodProjecto: "+p.getCodProjecto()+ "Localização: "+p.getLocalizacao());
            }
        }
    }

}
