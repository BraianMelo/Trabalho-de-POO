package entidades;

import Enumeracoes.Direcoes;

public class Robo {
	
	private String nomeEquipe;
	private String nomeRobo;
	private Celula posicao;
	private Direcoes direcao;
	private float barrisDeHelio;
	
	private int tempoAcaoAtual;
	

	public Robo(String nomeEquipe, String nomeRobo, Celula posicao, int tempoAcaoAtual, Direcoes direcao) {
		this.nomeEquipe = nomeEquipe;
		this.nomeRobo = nomeRobo;
		this.posicao = posicao;
		this.tempoAcaoAtual = tempoAcaoAtual;
		this.direcao = direcao;
		barrisDeHelio = 0.0f;
	}
	
	public String getNomeEquipe() {
		return nomeEquipe;
	}


	public String getNomeRobo() {
		return nomeRobo;
	}
	
	public double getBarrisDeHelio() {
		return barrisDeHelio;
	}

	//sensoriamento
	public Coordenadas getPosicao() { //public robo ou public celula ? Celula, sempre
		//o tipo da variável de retorno
		return posicao.getCoordenadas();
	}

	public float getConcetracao() {
		//concentracao de helio da celula atual
		return posicao.getConcentracaoHelio();
	}

	public float getRugosidade() {
		//rugosidade da celula atual
		return posicao.getRugosidade();
	}

	public Direcoes getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcoes direcao) {
		this.direcao = direcao;
	}

	public int getTempoAcaoAtual() {
		//tempo desde o inicio da ação
		return tempoAcaoAtual;
	}
	
	public void setTempo(int tempo) {
		this.tempoAcaoAtual = tempo;
	}

	//movimentacao---------------
	public boolean andar(){
        	int coordenadaX = -1;
        	int coordenadaY = -1;
        	
        	/*if(sondar == 1) //o robo em prospeccao não pode se movimentar
        		return;*/
        	
        	switch(direcao) {
        		case CIMA:
        			coordenadaX = posicao.getCoordenadas().getCoordenadaX();
        			coordenadaY = posicao.getCoordenadas().getCoordenadaY() - 1;
        			break;
        			
        		case BAIXO:
        			coordenadaX = posicao.getCoordenadas().getCoordenadaX();
        			coordenadaY = posicao.getCoordenadas().getCoordenadaY() + 1;
        			break;
        			
        		case DIREITA:
        			coordenadaX = posicao.getCoordenadas().getCoordenadaX() + 1;
        			coordenadaY = posicao.getCoordenadas().getCoordenadaY();
        			break;
        			
        		case ESQUERDA:
        			coordenadaX = posicao.getCoordenadas().getCoordenadaX() - 1;
        			coordenadaY = posicao.getCoordenadas().getCoordenadaY();
        			break;
        			
        		default:
        			return false;
        	}
        	
        	Coordenadas coordenada = new Coordenadas(coordenadaX, coordenadaY);
        	
        	if(Terreno.estaDentroDoLimite(coordenada) & 
        			(Terreno.celulaEstaVazia(coordenada, nomeEquipe))){
        		
	        		posicao = Terreno.getCelula(coordenada);
	        		return true;		
        		}
        	 else {
        		return false;
        	}
    	}

    	public void virarParaEsquerda() {
		/*if(sondar == 1)//o robo em prospeccao não pode se movimentar
			return;*/
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
    	public boolean sondar(Equipe equipe) {
    		if(Terreno.celulasAdjacentesLivres(posicao.getCoordenadas(), nomeEquipe)) {
	        	float volume = posicao.volumeDeExtracao();
	        	barrisDeHelio += volume;
	        	equipe.setBarrisDeHelioEquipe(equipe.getBarrisDeHelioEquipe() + volume);
	        	return true;
    		}
    		
    		return false;
   	}
    	
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\t"+nomeRobo+" "+posicao.getCoordenadas()+"\n");
    	sb.append("\tBarris coletados: ");
    	sb.append(String.format("%.2f", barrisDeHelio)+"\n");
    	sb.append("\tDireção: apontando para "+direcao.toString()+"\n");
    	return sb.toString();
    	
    }

}
