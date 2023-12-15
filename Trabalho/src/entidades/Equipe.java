package entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
	private String nome;
	private float barrisDeHelio;
	private List<Robo> listaDeRobores = new ArrayList<Robo>();
	
	public Equipe(String nome) {
		this.nome = nome;
		this.barrisDeHelio = 0.0f;
	}

	public String getNome() {
		return nome;
	}

	public float getBarrisDeHelio() {
		return barrisDeHelio;
	}
	
	public void coletarHelio(float concentracao) {
		barrisDeHelio += concentracao;
	}
	
	public void addListaDeRobores(Robo robo) {
		listaDeRobores.add(robo);
	}

	public List<Robo> getListaDeRobores() {
		return listaDeRobores;
	}

	public void setListaDeRobores(List<Robo> listaDeRobores) {
		this.listaDeRobores = listaDeRobores;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Equipe: "+ nome + "\n");
		sb.append("Barris coletados:" + String.format("%.2f", barrisDeHelio));
		sb.append("\n");
		
		for(Robo r: listaDeRobores) {
			sb.append(r);
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	

}
