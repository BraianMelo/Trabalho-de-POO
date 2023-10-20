package entidades;

import java.util.Random;

public class Terreno {
	
	static final int LINHAS = 5;
	static final int COLUNAS = 5;
	private float[][] concenHelio3;
	
	public Celula[][] matrizTerreno =  new Celula[LINHAS][COLUNAS];
		
	public Terreno() {

		this.LINHAS = largura;
		this.COMPRIMENTO = altura;
		this.concenHelio3 = new float[largura][altura];
		
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
	
	public void DentroLimite(int x, int y){

		x >= 0 && x <= largura && y >= 0 && y <= altura;
		
	}

	public void DefiConcHelio(int x, int y){
		if(x >= 0 && x <= largura && y >= 0 && y <= altura){
			concenHelio3 = concentracao;
		
	}
	
	public void ObterConcHelio(int x, int y){
		if(x >= 0 && x <= largura && y >= 0 && y <= altura){
			return concenHelio3[x][y];
		
	}
}
