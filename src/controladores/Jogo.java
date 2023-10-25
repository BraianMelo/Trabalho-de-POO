package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enumeracoes.Direcoes;
import entidades.Celula;
import entidades.Coordenadas;
import entidades.Equipe;
import entidades.Robo;
import entidades.Terreno;

public class Jogo {
	
	public Terreno terreno;
	private int tempoDaPartida;
	
	List<Equipe> equipes = new ArrayList<Equipe>();
	
	
	public Jogo(int linhasTerreno, int colunasTerreno, int tempoDaPartida) {
		terreno = new Terreno(linhasTerreno, colunasTerreno);
		this.tempoDaPartida = tempoDaPartida;
	}
	
	public int getTempoDaPartida() {
		return tempoDaPartida;
	}
	
	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void adicionarEquipe(Equipe equipe) {
		
		Random geradorDeNumeros = new Random();
		
		for(int i = 1; i <= equipe.getQuantidadeDeRobores(); ++i) {
			int coordenadaX = geradorDeNumeros.nextInt(Terreno.linhas);
			int coordenadaY = geradorDeNumeros.nextInt(Terreno.colunas);
			
			Celula primeiraCelula = Terreno.getCelula(new Coordenadas(coordenadaX, coordenadaY));
			
			String nomeRobo = "Robo_"+i;
			
			Robo robo = new Robo(equipe.getNome(), nomeRobo, primeiraCelula, 0, Direcoes.BAIXO);
			
			terreno.adicionarRoboNoTerreno(robo);
			
			if(equipes.contains(equipe)) {
				equipe.adicionarRoboNaEquipe(robo);
				
			} else {
				equipes.add(equipe);
				equipe.adicionarRoboNaEquipe(robo);
			}
		}
	}
	
	
	public void realizarComando(char comando, Robo robo) {
		comando = Character.toUpperCase(comando); //Passa o caractere para maiusculo
		int tempo = 0;
		
		switch(comando) {
			case 'W': //Anda
				if(robo.andar()) {
					tempo = (int) (robo.getRugosidade() * 40f);
					robo.setTempo(tempo);
					
				} else {
					System.out.println("Erro! A célula está cheia, fora do terreno ou sendo prospectada.");
					
				}
				break;
				
			case 'A': //Vira pra a direita
				robo.virarParaEsquerda();
				tempo = (int) (robo.getRugosidade() * 20f);
				robo.setTempo(tempo);
				break;
				
			case 'D': //Vira pra a esquerda
				robo.virarParaDireita();
				tempo = (int) (robo.getRugosidade() * 20f);
				robo.setTempo(tempo);
				break;
				
			case 'S': //Sensoriamento
				int coordenadaX = -1;
	        	int coordenadaY = -1;
				
				switch(robo.getDirecao()) {
					case CIMA:
	        			coordenadaX = robo.getPosicao().getCoordenadaX();
	        			coordenadaY = robo.getPosicao().getCoordenadaY() - 1;
	        			break;
	        			
	        		case BAIXO:
	        			coordenadaX = robo.getPosicao().getCoordenadaX();
	        			coordenadaY = robo.getPosicao().getCoordenadaY() + 1;
	        			break;
	        			
	        		case DIREITA:
	        			coordenadaX = robo.getPosicao().getCoordenadaX() + 1;
	        			coordenadaY = robo.getPosicao().getCoordenadaY();
	        			break;
	        			
	        		case ESQUERDA:
	        			coordenadaX = robo.getPosicao().getCoordenadaX() - 1;
	        			coordenadaY = robo.getPosicao().getCoordenadaY();
	        			break;
					}
			
				Coordenadas coordenada = new Coordenadas(coordenadaX, coordenadaY);
				
				if(Terreno.estaDentroDoLimite(coordenada)) {
					System.out.println(Terreno.getCelula(coordenada).sensoriamento());
				} else {
					System.out.println("Erro! A célula está fora do terreno.");
				}
				
				break;
				
			case 'P': //Prospeccao de helio-3
				Equipe equipe = null;
				
				for(Equipe e: equipes) {
					if(e.getNome() == robo.getNomeEquipe())
						equipe = e;
						
				}	
				
				if(robo.sondar(equipe)) {
					
					tempo = (int) ((robo.getRugosidade() * robo.getConcetracao()) * 70f);
					robo.setTempo(tempo);
					Coordenadas posicao = robo.getPosicao();
					Terreno.getCelula(posicao).setConcentracaoHelio(0);
					
				} else {
					System.out.println("Celula adjacente sendo prospectada");
				}
				break; 
				
			default:
				System.out.println("Esse comando nao existe!");
				break;
		}
	}
	
	public void esperarAcaoTerminar(boolean jogoEmAndamento) throws InterruptedException {
		Integer menorTempo = null;
		
		for(Robo robo: Terreno.getRoboresNoTerreno()) {
			if(menorTempo == null)
				menorTempo = robo.getTempoAcaoAtual();
			
			if(menorTempo > robo.getTempoAcaoAtual())
				menorTempo = robo.getTempoAcaoAtual();
		}
		
		tempoDaPartida -= menorTempo;
		
		if(tempoDaPartida < 0) {
			jogoEmAndamento = false;
			return;
		}
		
		
		for(Robo robo: Terreno.getRoboresNoTerreno()) {
			robo.setTempo(robo.getTempoAcaoAtual() - menorTempo);
		}
		
		Thread.sleep(menorTempo * 1000); //Espera a menor acao terminar
		
	}

}
