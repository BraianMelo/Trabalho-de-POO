package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terreno {
	
	private static final int LINHAS = 5;
	private static final int COLUNAS = 5;
	
	private List<Robo> roboresNoTerreno = new ArrayList<>();
	
	public static Celula[][] matrizTerreno =  new Celula[LINHAS][COLUNAS];
		
	public Terreno() {
		
		Random geradorDeNumeros = new Random();
		
		for(int x = 0; x < LINHAS; ++x) {
			for(int y = 0; y < COLUNAS; ++y) {
				
				float concentracaoHelio = geradorDeNumeros.nextFloat(1);
				float coeficienteErro = geradorDeNumeros.nextFloat(0,1);
				float rugosidade = geradorDeNumeros.nextFloat(1);
				
				matrizTerreno[x][y] = new Celula(x, y,
						concentracaoHelio, coeficienteErro, rugosidade);

				
			}
		}
	}
	
	//Lista de Robores
	
	public void addRoboNaLista(Robo robo) {
		roboresNoTerreno.add(robo);
	}
	
	public void removerRoboNaLista(Robo robo) {
		roboresNoTerreno.remove(robo);
	}
	
	/*OBS: nao fazia sentido o robo saber/receber o Terreno, ent�o as funcoes 
	viraram static para o robo conseguir acessar*/
	
	public static Celula getCelula(int coordenadaX, int coordenadaY) {
		return matrizTerreno[coordenadaX][coordenadaY];
	}
	
	public static boolean estaDentroDoLimite(int coordenadaX, int coordenadaY){
		if((coordenadaX >= 0) && (coordenadaX < LINHAS))
			if((coordenadaY >= 0) && (coordenadaY < COLUNAS))
				return true;
		
		return false;
	}
	
	

}
