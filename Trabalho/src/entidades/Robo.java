package entidades;

import Enumeracoes.Direcoes;

public class Robo {
	
	private String nome;
	private Equipe equipe;
	private Coordenadas coordenadas;
	private Direcoes direcao;
	private float barrisColetados;
	private Controlador controlador;
	private int tempoAcaoAtual;

	public Robo(String nome, Equipe equipe, Coordenadas coordenadas, Direcoes direcao) {
		this.nome = nome;
		this.equipe = equipe;
		this.coordenadas = coordenadas;
		this.direcao = direcao;
		this.barrisColetados = 0.0f;
		this.controlador = new Controlador(this);
		this.tempoAcaoAtual = 0;
	}

	public String getNome() {
		return nome;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public Direcoes getDirecao() {
		return direcao;
	}

	public float getBarrisColetados() {
		return barrisColetados;
	}

	public int getTempoAcaoAtual() {
		return tempoAcaoAtual;
	}
	
	public Controlador getControlador() {
		return controlador;
	}

	public void setTempoAcaoAtual(int tempoAcaoAtual) {
		this.tempoAcaoAtual = tempoAcaoAtual;
	}
	
	
	
	public float sensoriamento(Terreno terreno) {
		return terreno.getCelula(coordenadas).sensoriamento(1);
	}
	
	public Coordenadas calcularProximaCoordenada() {

		int coordenadaX = -1;
		int coordenadaY = -1;

		switch(getDirecao()) {
		case CIMA:
			coordenadaX = coordenadas.getCoordenadaX();
			coordenadaY = coordenadas.getCoordenadaY() - 1;
			break;

		case BAIXO:
			coordenadaX = coordenadas.getCoordenadaX();
			coordenadaY = coordenadas.getCoordenadaY() + 1;
			break;

		case DIREITA:
			coordenadaX = coordenadas.getCoordenadaX() + 1;
			coordenadaY = coordenadas.getCoordenadaY();
			break;

		case ESQUERDA:
			coordenadaX = coordenadas.getCoordenadaX() - 1;
			coordenadaY = coordenadas.getCoordenadaY();
			break;
		}
		
		Coordenadas coordenada = new Coordenadas(coordenadaX, coordenadaY);
		
		
		return coordenada;
		
	}
	
	public void virarParaEsquerda(Terreno terreno) {
		switch(direcao) {
		case CIMA:
			direcao = Direcoes.ESQUERDA;
			break;

		case DIREITA:
			direcao = Direcoes.CIMA;
			break;

		case BAIXO:
			direcao = Direcoes.DIREITA;
			break;

		case ESQUERDA:
			direcao = Direcoes.BAIXO;
			break;
		}
		
		tempoAcaoAtual = 7;
	}

	public void virarParaDireita(Terreno terreno) { 
		switch(direcao) {
		case CIMA:
			direcao = Direcoes.DIREITA;
			break;

		case DIREITA:
			direcao = Direcoes.BAIXO;
			break;

		case BAIXO:
			direcao = Direcoes.ESQUERDA;
			break;

		case ESQUERDA:
			direcao = Direcoes.CIMA;
			break;
		}
		
		tempoAcaoAtual = 7;
	
	}

	public boolean andar(Terreno terreno) {
		
		Coordenadas proximaCoordenada = calcularProximaCoordenada();
		
		if(terreno.estaDentroDoLimite(proximaCoordenada)){
			if(!terreno.getCelula(proximaCoordenada).isRoboNaCelula()) {
				terreno.getCelula(coordenadas).setRoboNaCelula(false);
				coordenadas = proximaCoordenada;
				tempoAcaoAtual = (int) (terreno.getCelula(proximaCoordenada).getRugosidade() * 40f);
				terreno.getCelula(coordenadas).setRoboNaCelula(true);
				return true;
			}
		}
		return false;
		
	}
	
	public boolean sonda(Terreno terreno) {
		Celula celula = terreno.getCelula(coordenadas);
		
		if(!terreno.celulasVizinhasSemRobo(coordenadas))
			return false;
		
		tempoAcaoAtual = (int) (terreno.getCelula(coordenadas).getRugosidade() * 
				terreno.getCelula(coordenadas).getConcentracaoHelio() * 10f);
		
		barrisColetados += celula.volumeDeExtracao();
		equipe.coletarHelio(celula.volumeDeExtracao());
		
		celula.setConcentracaoHelio(0);
		
		
		return true;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t"+nome+" "+coordenadas+"\n");
		sb.append("\tBarris coletados: ");
		sb.append(String.format("%.2f", barrisColetados)+"\n");
		sb.append("\tDireção: apontando para "+direcao.toString()+"\n\n");
		return sb.toString();

	}
	
	
	
	
	
}
