package menu;
import database.EmpregadoDAO;
import exception.DbException;
import input.Input;
import java.sql.Date;
import java.util.ArrayList;
import model.*;
public class MenuEmpregado {
	private static final EmpregadoDAO emp = new EmpregadoDAO();
	private static Input io = new Input();
	private static int op;
	public static void exibir()throws Exception {
		op = io.enterInt("----- Empregado ----- \n1-Adicionar \n2-Remover \n3-Listar \n4-Buscar Empregado \n5-Actualizar \nOutro - Sair");
		switch(op){
			case 1: Inserir();break;
			case 2: Remover();break;
			case 3: Listar();break;
			case 4: Buscar();break;
			case 5: Actualizar();break;
			default: IO.print("Está Nice");break;
		}
	}

	private static void Remover()throws Exception{
		int id = io.enterInt("Insira o id do empregado a ser removido");
		emp.remover(id);
	}

	private static void Inserir()throws Exception{
		String nome = io.enterString("Insira o 1º nome");
		String apelido = io.enterString("Insira o apelido");
		Double salario = io.enterDouble("Insira o salário");
		String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
		Date data =  Date.valueOf(dt);
		Departamento dep = new Departamento(1,"TI"); //TODO usar DepartamentoDAO
		emp.add(new Empregado(nome,apelido,salario,data,dep));
		
	}

	private static void Listar()throws DbException{
		ArrayList<Empregado> listagem = emp.listar();
		for(Empregado e : listagem){
			IO.println(e.toString());
		}
	}
	public static void Buscar()throws Exception{
		int id = io.enterInt("Insira o id do empregado");
		Empregado empregado = emp.BuscarId(id);
		if(empregado == null){
			System.out.println("O empregado não existe!");
		} else {
			IO.println(empregado.toString());
		}
	}

	private static void Actualizar()throws Exception{
		int id = io.enterInt("Insira o id do funcionário  a ser actualizado");
		String nome = io.enterString("Insira o 1º nome");
		String apelido = io.enterString("Insira o apelido");
		Double salario = io.enterDouble("Insira o salário");
		String dt = io.enterString("Insira a data de Nascimento  \"aaaa-mm-dd\"");
		Date data =  Date.valueOf(dt);
		Departamento dep = new Departamento(1,"TI"); //TODO usar DepartamentoDAO
		emp.update(id, new Empregado(nome,apelido,salario,data,dep));
	}
}
