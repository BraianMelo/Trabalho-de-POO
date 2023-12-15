package entidades;

public class Terreno {

	private int linhas;
	private int colunas;
	
	private Celula[][] matrizTerreno;
	
	
	public Terreno(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		
		matrizTerreno = new Celula[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public boolean adicionarNoTerreno(Celula celula, Coordenadas coordenadas) {
		int x = coordenadas.getCoordenadaX();
		int y = coordenadas.getCoordenadaY();
		
		
		if(x < linhas && y < colunas) {
			matrizTerreno[x][y] = celula;
			return true;
		}
		
		return false;
	}
	
	public Celula getCelula(Coordenadas coordenada) {
		return matrizTerreno[coordenada.getCoordenadaX()] 
		                     [coordenada.getCoordenadaY()];
	}
	
	public boolean estaDentroDoLimite(Coordenadas coordenada){
		int coordenadaX = coordenada.getCoordenadaX();
		int coordenadaY = coordenada.getCoordenadaY();
		
		if((coordenadaX >= 0) && (coordenadaX < linhas))
			if((coordenadaY >= 0) && (coordenadaY < colunas))
				return true;
		
		return false;
	}
	
	  public boolean celulasVizinhasSemRobo(Coordenadas coordenadas) {
	        int x = coordenadas.getCoordenadaX();
	        int y = coordenadas.getCoordenadaY();

	        // Define as coordenadas das células vizinhas
	        int[] vizinhoX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	        int[] vizinhoY = { -1, 0, 1, -1, 1, -1, 0, 1 };

	        for (int i = 0; i < 8; i++) {
	            int novaX = x + vizinhoX[i];
	            int novaY = y + vizinhoY[i];

	            // Verifica se as coordenadas da célula vizinha estão dentro dos limites do terreno
	            if (estaDentroDoLimite(new Coordenadas(novaX, novaY))) {
	                Celula celulaVizinha = matrizTerreno[novaX][novaY];

	                // Verifica se a célula vizinha tem um robô
	                if (celulaVizinha.isRoboNaCelula()) {
	                    return false;  // Se tiver um robô, retorna false
	                }
	            }
	        }

	        return true;  // Se nenhuma célula vizinha tiver um robô, retorna true
	    }

	
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Celula celula = matrizTerreno[i][j];
                result.append("["+i+", "+j+"]: ");
                result.append(celula);
                result.append("\n");
            }
        }

        return result.toString();
    }
	
}
