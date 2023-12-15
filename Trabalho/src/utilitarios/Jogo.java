package utilitarios;

import java.util.ArrayList;
import java.util.List;

import entidades.Equipe;
import entidades.Robo;
import entidades.Terreno;

public class Jogo {
	
	private Terreno terreno;
	private int tempoDaPartida;
	private List<Equipe> listaDeEquipes = new ArrayList<Equipe>();
	
	public Jogo(Terreno terreno, int tempoDaPartida) {
		this.terreno = terreno;
		this.tempoDaPartida = tempoDaPartida;
	}

	public Terreno getTerreno() {
		return terreno;
	}
	
	public int getTempoDaPartida() {
		return tempoDaPartida;
	}

	public List<Equipe> getListaDeEquipes() {
		return listaDeEquipes;
	}

	public void adicionarEquipe(Equipe equipe) {
		listaDeEquipes.add(equipe);
	}
	
	public void realizarComando() {
		for(Equipe equipes: listaDeEquipes) {
			for(Robo robo: equipes.getListaDeRobores()){
				if(robo.getTempoAcaoAtual() == 0) {
					robo.getControlador().realizarAcao(terreno);
					terreno.getCelula(robo.getCoordenadas()).setRoboNaCelula(true);
				}
			}
		}
	}
	
	public boolean esperarAcaoTerminar() throws InterruptedException {
		Integer menorTempo = null;
		
		for(Equipe equipes: listaDeEquipes) {
			for(Robo robo: equipes.getListaDeRobores()){
				if(menorTempo == null)
					menorTempo = robo.getTempoAcaoAtual();
				
				if(menorTempo > robo.getTempoAcaoAtual())
					menorTempo = robo.getTempoAcaoAtual();
			}
		}
		
		tempoDaPartida -= menorTempo;
		
		if(tempoDaPartida < 0) {
			return false;
		}
		
		for(Equipe equipes: listaDeEquipes) {
			for(Robo robo: equipes.getListaDeRobores()){
				robo.setTempoAcaoAtual(robo.getTempoAcaoAtual() - menorTempo);
			}
		}
		
		Thread.sleep(menorTempo * 1000);
		return true;
		
	}
	

	
	
	
	

}
