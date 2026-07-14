package model;
import java.sql.Date;
public class Chefia {
    private  Empregado empregado;
    private  Departamento departamento;
    private  Date dataInicio;
    private  String designacao;
    public Chefia(Empregado e,Departamento d,Date data,String design){
        this.empregado = e;
        this.departamento = d;
        this.dataInicio = data;
        this.designacao = design;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public String getDesignacao() {
        return designacao;
    }

    @Override
    public String toString(){
        return "Empregado: "+empregado.getNome()+" "+empregado.getApelido()+" Código: "+empregado.getCodEmpregado()
                +" Departamento: "+departamento.getNome()+" Código: "+departamento.getCodDepartamento()
                +" Designacao: "+designacao+" Data de Início: "+dataInicio;
    }
}
