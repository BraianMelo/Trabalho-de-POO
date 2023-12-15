package entidades;

import java.util.Random;

public class Celula {
	
	private float concentracaoHelio;
	private float coeficienteErroMax;
	private float coeficienteErroMin;
	private float rugosidade;
	private boolean roboNaCelula;
	
	public Celula(float concentracaoHelio, float coeficienteErroMax, float coeficienteErroMin, float rugosidade) {
		this.concentracaoHelio = concentracaoHelio;
		this.coeficienteErroMax = coeficienteErroMax;
		this.coeficienteErroMin = coeficienteErroMin;
		this.rugosidade = rugosidade;
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

	public void setConcentracaoHelio(float concentracaoHelio) {
		this.concentracaoHelio = concentracaoHelio;
	}
	
	public boolean isRoboNaCelula() {
		return roboNaCelula;
	}
	
	public void setRoboNaCelula(boolean roboNaCelula) {
		this.roboNaCelula = roboNaCelula;
	}


	public float volumeDeExtracao(){
		return concentracaoHelio * 1.5f;
	}
	
	
	
	public float sensoriamento(float porcentagem) {
		Random geradorDeNumeros = new Random();
		float helioComErro = 0f;
		
		while(helioComErro <= 0) {
			helioComErro = geradorDeNumeros.nextFloat
				(concentracaoHelio - (coeficienteErroMax * porcentagem), 
				concentracaoHelio + (coeficienteErroMax * porcentagem));
		}

		return helioComErro;
	}
	
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append(String.valueOf(concentracaoHelio)).append(", ");
	    sb.append(String.valueOf(coeficienteErroMin)).append(", ");
	    sb.append(String.valueOf(coeficienteErroMax)).append(", ");
	    sb.append(String.valueOf(rugosidade));
	    
	    return sb.toString();
	}
	

}
