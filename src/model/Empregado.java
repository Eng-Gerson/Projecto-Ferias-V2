package model;
import java.sql.Date;
public class Empregado {
	private int codEmpregado;
	private  String nome;
	private  String apelido;
	private double salario;
	private Date dataNascimento;
	private Departamento departamento;

	public Empregado(int codEmpregado, String nome, String apelido, double salario, Date dataNascimento, Departamento departamento) {
		this.codEmpregado = codEmpregado;
		this.nome = nome;
		this.apelido = apelido;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.departamento = departamento;
	}
	public Empregado( String nome, String apelido, double salario, Date dataNascimento, Departamento departamento) {
		this.nome = nome;
		this.apelido = apelido;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.departamento = departamento;
	}

	public int getCodEmpregado() {
		return codEmpregado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public double getSalario() {
		return salario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return  "Código do Empregado: " + codEmpregado + " Nome Completo:" + nome +" "+ apelido + " Salário:" + salario + " DataNascimento:" + dataNascimento + " Departamento: "+ departamento.getNome();
	}

}
