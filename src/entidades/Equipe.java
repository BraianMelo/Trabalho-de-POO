package entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
    private String nome;
    private int quantidadeDeRobores;
    private float barrisDeHelioEquipe;
    
    private List<Robo> roboresNaEquipe = new ArrayList<Robo>();;

    public Equipe(String nome, int quantidadeDeRobores) {
		this.nome = nome;
		this.quantidadeDeRobores = quantidadeDeRobores;
	}

	public String getNome() {
        return nome;
    }
	
    public int getQuantidadeDeRobores() {
		return quantidadeDeRobores;
	}
    
	public float getBarrisDeHelioEquipe() {
		return barrisDeHelioEquipe;
	}

	public void setBarrisDeHelioEquipe(float barrisDeHelioEquipe) {
		this.barrisDeHelioEquipe = barrisDeHelioEquipe;
	}

	public void adicionarRoboNaEquipe(Robo robo) {
        roboresNaEquipe.add(robo);
    }

    public void removerRoboDaEquipe(Robo robo) {
    	roboresNaEquipe.remove(robo);
    }

    public List<Robo> getRobos() {
        return roboresNaEquipe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+ "+nome+":\n");
        sb.append("  Barris coletados: "+String.format("%.2f", barrisDeHelioEquipe)+"\n\n");
        
        for(Robo robo: roboresNaEquipe) {
        	sb.append(robo);
        	sb.append("\n");
        }
        
        return sb.toString();
    }
}
