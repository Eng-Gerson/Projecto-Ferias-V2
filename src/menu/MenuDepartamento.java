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
        int op = io.enterInt("------- MENU DEPARTAMENTO ------- \n1- Adicionar \n2- Remover \n3-Actualizar \n4-Listar \n5-Mostrar Funcionários ");
        switch(op){
            case 1:Inserir(); break;
            case 2:Remover(); break;
            case 3:Actualizar(); break;
            case 4:Listar(); break;
            case 5:Mostrar(); break;
            default: break;
        }

    }

    private static void Mostrar() {
    }

    private static void Listar() throws Exception{
        ArrayList<Departamento> departamento =  dep.list();
        for(Departamento dpt : departamento){
            IO.println(dpt.toString());
        }
    }

    private static void Actualizar() throws Exception{

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
