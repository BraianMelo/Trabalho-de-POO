package entidades;

import java.util.Random;

public class Controlador {
	
	private Robo robo;

	public Controlador(Robo robo) {
		this.robo = robo;
	}

	public Robo getRobo() {
		return robo;
	}

	public void realizarAcao(Terreno terreno) {
		
		if(terreno.getCelula(robo.getCoordenadas()).getConcentracaoHelio() > 0) {
			if(robo.sonda(terreno))
				return;
		}
		
		
		if(!robo.andar(terreno)){
			Random geradorDeNumeros = new Random();
			int numero = geradorDeNumeros.nextInt(10);
			
			if(numero % 2 == 0) {
				robo.virarParaDireita(terreno);
			} else {
				robo.virarParaEsquerda(terreno);
			}
		}
	}
}
