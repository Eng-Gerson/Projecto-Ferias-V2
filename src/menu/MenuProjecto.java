package menu;
import input.Input;
import model.Projecto;
import database.ProjectoDAO;
import java.util.ArrayList;
import database.DepartamentoDAO;

import java.sql.Date;

public class MenuProjecto {
    private static final Input io = new Input();
    private static final DepartamentoDAO dep = new DepartamentoDAO();
    private static final ProjectoDAO proj = new ProjectoDAO();
    public static void exibir() throws Exception{
        int op;
        do {
        op = io.enterInt("-------- MENU PROJECTO -------- \n1-Criar Projecto \n2-Remover \n3-Listar Projectos \n4-Actualizar Projecto \n5-Buscar pelo ID \nOutro-Sair");
            switch(op){
             case 1: Inserir();break;
             case 2: Remover();break;
             case 3: Listar();break;
             case 4: Actualizar();break;
             case 5: Buscar();break;
             default: IO.println("Saindo..."); break;
            }
        } while(op > 0 && op < 6);
    }

    private static void Actualizar() throws Exception{
        int index = io.enterInt("Insira o código do projecto a ser actualizado");
        if(proj.searchID(index) != null) {
            String loc = io.enterString("Insira a localização do projecto");
            String dt = io.enterString("Insira a data de Inicio \"aaaa-mm-dd\"");
            Date data = Date.valueOf(dt);
            int codDep = io.enterInt("Insira o código do departamento");
            proj.update(new Projecto(data, loc, dep.searchID(codDep)), index);
        } else {
            IO.println("Não existe projecto com esse código");
        }
    }

    private static void Buscar() throws Exception{
        int index = io.enterInt("Insira o código do Projecto");
        Projecto project = proj.searchID(index);
        if(project != null) {
            IO.println(project);
        } else {
            IO.println("O projecto não existe");
        }
    }

    private static void Remover() throws Exception{
        int index = io.enterInt("Insira o código do Projecto que deseja remover");
        proj.remove(index);
    }

    private static void Listar() throws Exception{
        ArrayList<Projecto> project = proj.list();
        for(Projecto p : project){
            IO.println(p);
        }
    }

    private static void Inserir() throws Exception{
        String loc = io.enterString("Insira a localização do projecto");
        String dt = io.enterString("Insira a data de Inicio \"aaaa-mm-dd\"");
        Date data =  Date.valueOf(dt);
        int codDep = io.enterInt("Insira o código do departamento");
        proj.add(new Projecto(data,loc,dep.searchID(codDep)));
    }
}
