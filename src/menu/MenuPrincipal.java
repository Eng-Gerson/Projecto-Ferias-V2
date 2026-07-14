package menu;
import database.DataBase;
import input.Input;
//TODO refactorar os menus, observando os principios SOLID
public class MenuPrincipal {
	private static final Input io = new Input();
	public static void exibir()throws Exception{
		int op;
		do {
			DataBase.getConnection();
			op = io.enterInt("========== MENU PRINCIPAL ========= \n1-Empregado \n2-Departamento \n3-Projecto \nOutro-Sair");
			switch (op) {
				case 1:
					MenuEmpregado.exibir();
					break;
				case 2:
					MenuDepartamento.exibir();
					break;
				case 3:
					MenuProjecto.exibir();
					break;
				default:
					DataBase.closeConnection();
					IO.println("Encerrando o programa...");
					break;
			}
		} while(op > 0 && op <= 3);
	}
}
