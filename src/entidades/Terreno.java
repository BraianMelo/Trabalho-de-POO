package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terreno {
	
	public static int linhas;
	public static int colunas;
	
	private static List<Robo> roboresNoTerreno = new ArrayList<>();
	
	public static Celula[][] matrizTerreno;
		
	public Terreno(int linhas, int colunas) {
		Terreno.linhas = linhas;
		Terreno.colunas = colunas;
		
		Random geradorDeNumeros = new Random();
		
		matrizTerreno = new Celula[linhas][colunas];
		
		for(int x = 0; x < linhas; ++x) {
			for(int y = 0; y < colunas; ++y) {
				
				float concentracaoHelio = geradorDeNumeros.nextFloat(1);
				
				float coeficienteErroMax = geradorDeNumeros.nextFloat(0,1);
				float coeficienteErroMin = geradorDeNumeros.nextFloat(0,1);
				
				if(coeficienteErroMin > coeficienteErroMax) { //Caso o Min seje maior que o Max
					float auxiliar = coeficienteErroMin;
					coeficienteErroMin = coeficienteErroMax;
					coeficienteErroMax = auxiliar;
	
				}

				float rugosidade = geradorDeNumeros.nextFloat(1);
				
				matrizTerreno[x][y] = new Celula(new Coordenadas(x, y),
						concentracaoHelio, coeficienteErroMin, 
						coeficienteErroMax, rugosidade);
				
								
			}	
		}
	}
	/*private Celula[][] celulas;

    public Terreno() {
        // Inicialização do terreno
    }

    public Celula getCelula(Posicao posicao) {
        return celulas[posicao.getX()][posicao.getY()];
    }

    public void adicionarRoboNoTerreno(Robo robo) {
        getCelula(robo.getPosicao()).adicionarRobo(robo);
    }
}
*/
	
	//Lista de Robores
	public void adicionarRoboNoTerreno(Robo robo) {
		roboresNoTerreno.add(robo);
	}
	
	public void removerRoboDoTerreno(Robo robo) {
		roboresNoTerreno.remove(robo);
	}
	
	
	/* OBS: nao fazia sentido o robo saber/receber o Terreno inteiro, então 
	 * as funcoes viraram static para o robo conseguir acessar */
	
	public static List<Robo> getRoboresNoTerreno() {
		return roboresNoTerreno;
	}


	public static Celula getCelula(Coordenadas coordenada) {
		int coordenadaX = coordenada.getCoordenadaX();
		int coordenadaY = coordenada.getCoordenadaY();
		
		
		return matrizTerreno[coordenadaX][coordenadaY];
	}
	
	public static boolean estaDentroDoLimite(Coordenadas coordenada){
		int coordenadaX = coordenada.getCoordenadaX();
		int coordenadaY = coordenada.getCoordenadaY();
		
		if((coordenadaX >= 0) && (coordenadaX < linhas))
			if((coordenadaY >= 0) && (coordenadaY < colunas))
				return true;
		
		return false;
	}
	
	public static boolean celulaEstaVazia(Coordenadas coordenada, String nomeEquipe) {
		int coordenadaX = coordenada.getCoordenadaX();
		int coordenadaY = coordenada.getCoordenadaY();
		
		for(Robo r: roboresNoTerreno) { //For percorrendo a lista de robores
			if(r.getNomeEquipe() != nomeEquipe)
				if(r.getPosicao().getCoordenadaX() == coordenadaX)
					if(r.getPosicao().getCoordenadaY() == coordenadaY)
						return false; 
		}
		return true;
	}
	
	public static boolean celulasAdjacentesLivres(Coordenadas coordenada, String nomeEquipe) {
		int coordenadaX = coordenada.getCoordenadaX();
		int coordenadaY = coordenada.getCoordenadaY();
		
		for(int x = coordenadaX-1; x <= coordenadaX+1; ++x) {
			for(int y = coordenadaY-1; y <= coordenadaY+1; ++y) {
				if(estaDentroDoLimite(new Coordenadas(x, y)))
					if(!celulaEstaVazia(new Coordenadas(x, y), nomeEquipe))
						return false;
			}
		}
		
		return true;
	}
	
}
