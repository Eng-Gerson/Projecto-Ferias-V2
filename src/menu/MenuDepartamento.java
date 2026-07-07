package menu;
import input.Input;
import database.DepartamentoDAO;
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

	private static void Listar() {
	}

	private static void Actualizar() {
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
