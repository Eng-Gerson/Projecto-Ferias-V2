package model;
import java.util.ArrayList;
import java.util.List;
public class Departamento {
	private int codDepartamento;
	private String nome;
	private List<Empregado> empregado;

	public Departamento(int codDepartamento, String nome) {
		this.codDepartamento = codDepartamento;
		this.nome = nome;
		empregado = new ArrayList<>();
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void adicionarEmpregado(Empregado e){
		empregado.add(e);
	}

	@Override
	public String toString() {
		return " codDepartamento: " + codDepartamento + " nome:" + nome;
	}
	
	
}
