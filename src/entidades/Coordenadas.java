package entidades;

public class Coordenadas {
	
	/*Ao invés de retornar a celula inteira no getPosicao ou mandar a cooerdenada
	 * X e Y, melhor mandar retornar uma classe*/
	
	private int coordenadaX;
	private int coordenadaY;
	
	public Coordenadas(int coordenadaX, int coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}
	
	@Override
	public String toString() {
		return "["+coordenadaX+", "+coordenadaY+"]";
	}

}
