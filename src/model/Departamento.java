package model;

public class Departamento {
	private int codDepartamento;
	private String nome;

	public Departamento(int codDepartamento, String nome) {
		this.codDepartamento = codDepartamento;
		this.nome = nome;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return " Código do Departamento: " + codDepartamento + " Nome:" + nome;
	}
	
	
}
