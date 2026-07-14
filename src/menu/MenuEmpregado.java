package menu;
import database.EmpregadoDAO;
import database.DepartamentoDAO;
import exception.DbException;
import input.Input;
import java.sql.Date;
import java.util.ArrayList;
import model.*;
public class MenuEmpregado {
	private static final EmpregadoDAO emp = new EmpregadoDAO();
    private static final DepartamentoDAO dep = new DepartamentoDAO();
	private static final Input io = new Input();
    public static void exibir()throws Exception {
		int op;
		do {
			op = io.enterInt("----- Empregado ----- \n1-Adicionar \n2-Remover \n3-Listar \n4-Buscar por Código \n5-Actualizar \n6-Dependentes \nOutro - Sair");
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
					Buscar();
					break;
				case 5:
					Actualizar();
					break;
				case 6:
					SubMenuDependente.exibir(); break;
				default:
					IO.println("Saindo...");
					break;
			}
		}while(op > 0 && op < 7);
	}

	private static void Remover()throws Exception{
		int id = io.enterInt("Insira o código do empregado a ser removido");
		emp.remove(id);
	}

	private static void Inserir()throws Exception{
		String nome = io.enterString("Insira o 1º nome");
		String apelido = io.enterString("Insira o apelido");
		double salario = io.enterDouble("Insira o salário");
		String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
		Date data =  Date.valueOf(dt);
		Departamento dpt = dep.searchID(io.enterInt("Insira o código do departamento"));
		emp.add(new Empregado(nome,apelido,salario,data,dpt));
		
	}

	private static void Listar()throws DbException{
		ArrayList<Empregado> listagem = emp.list();
		for(Empregado e : listagem){
			IO.println(e);
		}
	}
	public static void Buscar()throws Exception{
		int id = io.enterInt("Insira o código do empregado");
		Empregado empregado = emp.searchID(id);
		if(empregado == null){
			System.out.println("O empregado não existe!");
		} else {
			IO.println(empregado.toString());
		}
	}

	private static void Actualizar()throws Exception{
		int id = io.enterInt("Insira o código do empregado a ser actualizado");
		if(emp.searchID(id) != null) {
			String nome = io.enterString("Insira o 1º nome");
			String apelido = io.enterString("Insira o apelido");
			double salario = io.enterDouble("Insira o salário");
			String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
			Date data = Date.valueOf(dt);
			Departamento dpt = dep.searchID(io.enterInt("Insira o código do departamento"));
			emp.update(id, new Empregado(nome, apelido, salario, data, dpt));
		} else {
			IO.println("Não existe empregado com esse código");
		}
	}
}
