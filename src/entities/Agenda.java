package entities;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private String horario;
    private medico medicoSelecionado;
    private paciente pacienteSelecionado;
    public static List<Agenda> listaAgenda = new ArrayList<>();

    public Agenda(medico medicoSelecionado, paciente pacienteSelecionado, String horario) {
    	this.medicoSelecionado= medicoSelecionado;
    	this.horario= horario;
    	this.pacienteSelecionado =pacienteSelecionado;
    	
    	
        listaAgenda.add(this);

    	
        
    }
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
    	System.out.print(horario);
        this.horario = horario;
    }

    public medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    public void setMedicoSelecionado(medico medicoSelecionado) {
    	
        this.medicoSelecionado = medicoSelecionado;
        System.out.print(medicoSelecionado);
    }

    public paciente getPacienteSelecionado() {
        return pacienteSelecionado;
        
    }

    public void setPacienteSelecionado(paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
        System.out.print(pacienteSelecionado);
    }
    public static List<Agenda> getListaAgenda() {
        return listaAgenda;
    }
    @Override
	public String toString() {
		return  medicoSelecionado +"<>" +  horario +"<>" + pacienteSelecionado;
	}
}
