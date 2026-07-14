package model;
import java.sql.Date;
public class Projecto {
    private int codProjecto;
    private Date dataInicio;
    private String localizacao;
    private Departamento departamento;

    public Projecto(int codProjecto, Date dataInicio, String localizacao, Departamento departamento) {
        this.codProjecto = codProjecto;
        this.dataInicio = dataInicio;
        this.localizacao = localizacao;
        this.departamento = departamento;
    }
    public Projecto(Date dataInicio, String localizacao, Departamento departamento) {
        this.dataInicio = dataInicio;
        this.localizacao = localizacao;
        this.departamento = departamento;
    }


    public int getCodProjecto() {
        return codProjecto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Código do Projecto: " + codProjecto +
                " Data de Inicio:" + dataInicio +
                " Localização: " + localizacao +
                " Departamento: " + departamento.getNome();
    }
}
