package entidades;

public class Celula {
	
	private int coordenadaX;
	private int coordenadaY;
	
	private float concentracaoHelio;
	private float coeficienteErro;
	private float rugosidade;
	
	public Celula() {}

	public Celula(int coordenadaX, int coordenadaY, float concentracaoHelio, float coeficienteErro, float rugosidade) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.concentracaoHelio = concentracaoHelio;
		this.coeficienteErro = coeficienteErro;
		this.rugosidade = rugosidade;
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
	
	public VolumedeExtracao(){
		volumeextracao = concetracaoHelio*1.5;
		return volumeextracao;
	}

	public float getCoeficienteErro() {
		return coeficienteErro;
	}

	public float getRugosidade() {
		//rugosidade = volumeextracao * 1.6;
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
