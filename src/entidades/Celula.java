package entidades;

import java.util.Random;

public class Celula {
	
	private int coordenadaX;
	private int coordenadaY;
	
	private float concentracaoHelio;
	private float coeficienteErro;
	private float rugosidade;

	private float volumeExtracao;
	
	public Celula() {}

	public Celula(int coordenadaX, int coordenadaY, float concentracaoHelio, float coeficienteErro, float rugosidade, float volumeExtracao) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.concentracaoHelio = concentracaoHelio;
		this.coeficienteErro = coeficienteErro;
		this.rugosidade = rugosidade;
		this.volumeExtracao = volumeExtracao;
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public float getConcentracaoHelio() {
		Random gerador = new Random();
		concentracaoHelio = gerador.nextFloat();
		return concentracaoHelio;
	}

	public float getCoeficienteErro() {
		Random gerador = new Random();
		coeficienteErro = gerador.nextGaussian();
		return coeficienteErro;
	}

	public float getRugosidade() {
		Random gerador = new Random();
		rugosidade = gerador.nextGaussian();
		return rugosidade;
	}

	public VolumeDeExtracao(){
		volumeExtracao = concetracaoHelio*1.5f;
		return volumeExtracao;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("["+coordenadaX+","+coordenadaY+"]: ");
		sb.append(String.format("%.2f", concentracaoHelio)+", ");
		sb.append(String.format("%.2f", coeficienteErro)+", ");
		sb.append(String.format("%.2f", rugosidade));
		
		return sb.toString();
	}

}
