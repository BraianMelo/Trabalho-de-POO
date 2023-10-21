package entidades;

public class Robo {
	
	private String nome;
	private Celula posicao;
	private Direcoes direcao;
	
	private int tempoSegundos;
	

	public Robo(String nome, Celula posicao, int tempoSegundos, Direcoes direcao) {
		this.nome = nome;
		this.posicao = posicao;
		this.tempoSegundos = tempoSegundos;
		this.direcao = direcao;
	}
	
	public String getNome() {
		return nome;
	}

	public Celula obterPosicao() {
		//logica
		return posicao;
	}
	
	/*
	public float obterConcentracao() {
	       //logica
		return concentracao;
	}
	
	public float obterRugosidade() {
	      //logica
		return rugosidade;
	}

	*/

	//movimentacao---------------
	public void andar(){
        	int coordenadaX = -1;
        	int coordenadaY = -1;
        	
        	switch(direcao) {
        		case CIMA:
        			coordenadaX = posicao.getCoordenadaX();
        			coordenadaY = posicao.getCoordenadaY() - 1;
        			break;
        			
        		case BAIXO:
        			coordenadaX = posicao.getCoordenadaX();
        			coordenadaY = posicao.getCoordenadaY() + 1;
        			break;
        			
        		case DIREITA:
        			coordenadaX = posicao.getCoordenadaX() + 1;
        			coordenadaY = posicao.getCoordenadaY();
        			break;
        			
        		case ESQUERDA:
        			coordenadaX = posicao.getCoordenadaX() - 1;
        			coordenadaY = posicao.getCoordenadaY();
        			break;
        			
        		default:
        			return;
        	}
        	
        	if(Terreno.estaDentroDoLimite(coordenadaX, coordenadaY)) {
        		posicao = Terreno.getCelula(coordenadaX, coordenadaY);
        		System.out.println("Andou: ["+coordenadaX+", "+coordenadaY+"]");
        		
        	} else {
        		System.out.println("Ultrapassou a barreira do terreno! ["+coordenadaX+", "+coordenadaY+"]");
        	}
        	
    	}

    	public void virarParaEsquerda() {
    		switch(direcao) {
	    		case CIMA:
	    			direcao = Direcoes.ESQUERDA;
	    			break;
	    			
	    		case DIREITA:
	    			direcao = Direcoes.CIMA;
	    			break;
	    		
	    		case BAIXO:
	    			direcao = Direcoes.DIREITA;
	    			break;
	    			
	    		case ESQUERDA:
	    			direcao = Direcoes.BAIXO;
	    			break;
    		}
    	}
    	
    	public void virarParaDireita() {
    		switch(direcao) {
	    		case CIMA:
	    			direcao = Direcoes.DIREITA;
	    			break;
	    			
	    		case DIREITA:
	    			direcao = Direcoes.BAIXO;
	    			break;
	    		
	    		case BAIXO:
	    			direcao = Direcoes.ESQUERDA;
	    			break;
	    			
	    		case ESQUERDA:
	    			direcao = Direcoes.CIMA;
	    			break;
			}
    	}

    	

	//prospecção-----------------
    	public void sonda() {
        	//logica prospecção
   	}

}
