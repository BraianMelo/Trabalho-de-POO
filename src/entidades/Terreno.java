package entidades;

import java.util.Random;

public class Terreno {
	
	static final int LINHAS = 5;
	static final int COLUNAS = 5;
	
	public Celula[][] matrizTerreno =  new Celula[LINHAS][COLUNAS];
		
	public Terreno() {
		
		Random geradorDeNumeros = new Random();
		
		for(int i = 0; i < LINHAS; ++i) {
			for(int j = 0; j < COLUNAS; ++j) {
				
				float concentracaoHelio = geradorDeNumeros.nextFloat(1);
				float coeficienteErro = geradorDeNumeros.nextFloat(0,1);
				float rugosidade = geradorDeNumeros.nextFloat(1);
				
				
				matrizTerreno[i][j] = new Celula(i, j,
						concentracaoHelio, coeficienteErro, rugosidade);
				
				System.out.println(matrizTerreno[i][j]);
				
			}
		}
		
	}
	
	

}
