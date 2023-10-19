package entidades;

public class Robo {
	
	private String nome;
	private Celula posicao;
	private int tempoSegundos;
	
	/*public Robo() {
		//this.nome = nome;
	}*/

	public Robo(Celula posicao, int tempoSegundos) {
		this.nome = nome;
		this.posicao = posicao;
		this.tempoSegundos = tempoSegundos;
	}
	
	public void getNome() {
		return nome;
	}

	public void getPosicao() {
		return posicao;
	}

	//Sensoriamento
	public Celula obterPosicao() {
		//logica
		return posicao;
	}
	
	public float obterConcentracao() {
	       //logica
		return concentracao;
	}
	
	public float obterRugosidade() {
	      //logica
		return rugosidade;
	}
	
	
	
	

}
