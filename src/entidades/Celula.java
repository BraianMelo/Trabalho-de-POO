package entidades;

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
		return concentracaoHelio;
	}
	
	public VolumeDeExtracao(){
		volumeExtracao = concetracaoHelio*1.5;
		return volumeExtracao;
	}

	public float getCoeficienteErro() {
		return coeficienteErro;
	}

	public float getRugosidade() {
		//rugosidade = volumeExtracao * 1.6;
		return rugosidade;
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
