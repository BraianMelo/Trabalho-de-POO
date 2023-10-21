package aplicacao;

import java.util.Locale;

import entidades.Direcoes;
import entidades.Robo;
import entidades.Terreno;

public class Programa {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); //Virgula vira ponto nos floats
		
		Terreno terreno = new Terreno();
		
		Robo r = new Robo("Braia", Terreno.getCelula(0, 0), 10, Direcoes.BAIXO);

	}

}
