package menu;
import input.Input;
import database.DepartamentoDAO;
import model.Departamento;
import java.util.ArrayList;
import model.Empregado;
import java.lang.Exception;

public class MenuDepartamento {
    private static final Input io = new Input();
    static DepartamentoDAO dep = new DepartamentoDAO();
    public static void exibir() throws java.lang.Exception {
        int op = io.enterInt("------- MENU DEPARTAMENTO ------- \n1- Adicionar \n2- Remover \n3-Actualizar \n4-Listar \n5-Mostrar Funcionários \n6- Buscar por ID \nOutro- Sair");
        switch(op){
            case 1:Inserir(); break;
            case 2:Remover(); break;
            case 3:Actualizar(); break;
            case 4:Listar(); break;
            case 5:Mostrar(); break;
            case 6:Buscar(); break;
            default: break;
        }

    }

    private static void Buscar() throws Exception {
        int choice = io.enterInt("Insira o número do Departamento");
        Departamento departamento = dep.Busca(choice);
        IO.println("CodDepartamento: "+departamento.getCodDepartamento()+" Nome: "+departamento.getNome());
    }

    private static void Mostrar() throws Exception {
        int index = io.enterInt("Insira o código do departamento e eu te mostrarei os funcionários lá");
        ArrayList<Empregado> empregados = dep.listaEmpregado(index);
        if(empregados == null){
            IO.println("Das duas uma, ou o departamento não existe ou não tem empregados");
        } else {
            for (Empregado e : empregados) {
                System.out.println("CodEmpregado: "+e.getCodEmpregado()+ "Nome: "+e.getNome());
            }
        }
    }

    private static void Listar() throws Exception{
        ArrayList<Departamento> departamento =  dep.list();
        for(Departamento dpt : departamento){
            IO.println(dpt.toString());
        }
    }

    private static void Actualizar() throws Exception{
        int index = io.enterInt("Insira o número do departamento a actualizar");
        String nomeDepartamento = io.enterString("Insira o novo nome para o departamento "+index);
        dep.update(nomeDepartamento,index);
    }

    public static void Inserir() throws Exception{
        String nomeDepartamento = io.enterString("Insira o nome do novo departamento");
        dep.add(nomeDepartamento);
    }
    public static void Remover() throws Exception{
        int index = io.enterInt("Insira o código do departamento a ser removido");
        dep.remove(index);
    }
}
