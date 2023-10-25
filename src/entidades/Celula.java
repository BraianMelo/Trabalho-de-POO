package entidades;

import java.util.Random;

public class Celula {
	
	private Coordenadas coordenadas;
	
	private float concentracaoHelio;
	private float coeficienteErroMax;
	private float coeficienteErroMin;
	private float rugosidade;

	
	public Celula() {}
	
	public Celula(Coordenadas coordenadas, float concentracaoHelio, 
			float coeficienteErroMin, float coeficienteErroMax,
			float rugosidade) {
		
		this.coordenadas = coordenadas;
		this.concentracaoHelio = concentracaoHelio;
		this.coeficienteErroMin = coeficienteErroMin;
		this.coeficienteErroMax = coeficienteErroMax;
		this.rugosidade = rugosidade;
	}

	public Coordenadas getCoordenadas() { 
		return coordenadas;
	}

	public float getConcentracaoHelio() {
		return concentracaoHelio;
	}

	public float getCoeficienteErroMax() {
		return coeficienteErroMax;
	}

	public float getCoeficienteErroMin() {
		return coeficienteErroMin;
	}
	
	public float getRugosidade() {
		return rugosidade;
	}
	
	public String sensoriamento() {
		Random geradorDeNumeros = new Random();
		float helioComErro = 0f;
		
		while(helioComErro <= 0) {
			helioComErro = geradorDeNumeros.nextFloat
				(concentracaoHelio - coeficienteErroMax, 
				concentracaoHelio + coeficienteErroMax);
		}

		return "Concentração de helio: "+String.format("%.2f", helioComErro);
	}
	
	public void setConcentracaoHelio(float concentracaoHelio) {
		this.concentracaoHelio = concentracaoHelio;
	}

	public float volumeDeExtracao(){
		return concentracaoHelio * 1.5f;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(coordenadas+": ");
		sb.append(String.format("%.2f", concentracaoHelio)+", ");
		sb.append(String.format("%.2f", coeficienteErroMin+", "));
		sb.append(String.format("%.2f", coeficienteErroMax+", "));
		sb.append(String.format("%.2f", rugosidade));
		
		return sb.toString();
	}

}
