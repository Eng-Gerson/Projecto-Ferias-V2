package model;
import java.sql.Date;
import model.Departamento;
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

    public int getCodProjecto() {
        return codProjecto;
    }

    public void setCodProjecto(int codProjecto) {
        this.codProjecto = codProjecto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
