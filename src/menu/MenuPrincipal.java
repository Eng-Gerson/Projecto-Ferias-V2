package menu;
import input.Input;
public class MenuPrincipal {
	private static int op;
	private static final Input io = new Input();
	public static void exibir()throws Exception{
		op = io.enterInt("Opções \n1-Empregado \n2-Departamento");
		switch(op){
			case 1: MenuEmpregado.exibir();break;
			case 2: MenuDepartamento.exibir();break;
			default: IO.println("Bye");break;
		}
	}
}
