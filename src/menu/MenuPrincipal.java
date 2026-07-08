package menu;
import input.Input;
//TODO refactorar os menus, observando os principios SOLID
public class MenuPrincipal {
	private static int op;
	private static final Input io = new Input();
	public static void exibir()throws Exception{
		do {
			op = io.enterInt("========== MENU PRINCIPAL ========= \n1-Empregado \n2-Departamento");
			switch (op) {
				case 1:
					MenuEmpregado.exibir();
					break;
				case 2:
					MenuDepartamento.exibir();
					break;
				default:
					IO.println("Bye");
					break;
			}
		} while(op > 0 && op < 3);
	}
}
