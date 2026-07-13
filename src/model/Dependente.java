package model;
import java.sql.Date;
public class Dependente {
    private int codDependente;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String parentesco;
    private Empregado empregado;

    public Dependente(int codDependente, String nome, String sexo, Date dataNascimento, String parentesco, Empregado empregado) {
        this.codDependente = codDependente;
        this.nome = nome;
        this.sexo = String.valueOf(sexo.charAt(0));
        this.dataNascimento = dataNascimento;
        this.parentesco = parentesco;
        this.empregado = empregado;
    }

    public int getCodDependente() {
        return codDependente;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "codDependente=" + codDependente +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento=" + dataNascimento +
                ", parentesco='" + parentesco + '\'' +
                ", empregado=" + empregado +
                '}';
    }
}
