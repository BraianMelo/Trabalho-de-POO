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

	//sensoriamento-----------------
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


	//movimentacao---------------
	public void andar() {
        	//logica andar
    	}

    	public void moverParaEsquerda() {
        	//logica esquerda
    	}

    	public void moverParaDireita() {
        	//logica direita
    	}

	//prospecção-----------------
    	public void sonda() {
        	//logica prospecção
   	}
	

}
