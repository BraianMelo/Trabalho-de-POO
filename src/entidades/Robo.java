package entidades;

public class Robo {
	
	private String nome;
	private Celula posicao;
	private Direcoes direcao;
	
	private int tempoSegundos;
	private float barris;

	public Robo(String nome, Celula posicao, int tempoSegundos, Direcoes direcao, float barris) {
		this.nome = nome;
		this.posicao = posicao;
		this.tempoSegundos = tempoSegundos;
		this.direcao = direcao;
		this.barris = barris;
	}
	
	public String getobterNome() {
		return nome;
	}

	//sensoriamento
	public Celula obterPosicao() { //public robo ou public celula ?
		return posicao;
	}

	public Celula obterConcetracao() {
		//concentracao de helio da celula atual
		return concentracaoHelio;
	}

	public Celula obterRugosidade() {
		//rugosidade da celula atual
		return rugosidade;
	}

	public Celula obterTempo() {
		//tempo desde o inicio da prospeccao
		return tempoSegundos;
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

	*/ //rugosidade é da celula



	//movimentacao---------------
	public void andar(){
        	int coordenadaX = -1;
        	int coordenadaY = -1;
        	if(sondar == 1) //o robo em prospeccao não pode se movimentar
			return;
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
		if(sondar == 1)//o robo em prospeccao não pode se movimentar
			return;
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
    	
    	public void virarParaDireita() { //tem que ter o tempo de execução de acordo com a rugosidade
		if(sondar == 1)//o robo em prospeccao não pode se movimentar
			return;
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
    	public void sondar(Celula tempoSegundos, Celula volumeExtracao) {
		try {
		Thread.sleep(tempoSegundos.getValor());
		barris += volumeExtracao.getValor();
		}
	} 
	//catch (InterruptedException e) {
   	 // Lida com exceção, se necessário
}

   	}

}
