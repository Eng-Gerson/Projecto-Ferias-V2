package menu;
import input.Input;
import model.Projecto;
import database.ProjectoDAO;
import model.Departamento;
import database.DepartamentoDAO;
public class MenuProjecto {
    private static final Input io = new Input();
    private static final DepartamentoDAO dep = new DepartamentoDAO();
    private static final ProjectoDAO proj = new ProjectoDAO();
    public static void exibir() throws Exception{
        int op;
        //TODO implementar as classes
        do {
        op = io.enterInt("-------- MENU PROJECTO -------- \n1- Criar Projecto \n2-Remover \n3-Listar Projectos \n4-Actualizar Projecto \n5-Buscar pelo ID");
        switch(op){
            case 1: Inserir();break;
            case 2: Remover();break;
            case 3: Listar();break;
            case 4: Actualizar();break;
            case 5: Buscar();break;
        }
        } while(op > 1 && op < 6);
    }

    private static void Actualizar() {
    }

    private static void Buscar() {
    }

    private static void Remover() {
    }

    private static void Listar() {
    }

    private static void Inserir() {
    }
}
