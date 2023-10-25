package Utilitarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import controladores.Jogo;
import entidades.Equipe;

public class LerArquivoJson {
	
	public LerArquivoJson() {}
	
	public Jogo lerArquivoTerrenoLunar(String caminho) throws FileNotFoundException {
		
		Reader reader = new FileReader(caminho);
		
		JsonElement jsonElement = JsonParser.parseReader(reader);
			
		int linhas = jsonElement.getAsJsonObject().get("largura").getAsInt();
		int colunas = jsonElement.getAsJsonObject().get("altura").getAsInt();
		int tempoPartida = jsonElement.getAsJsonObject().get("tempoPartida").getAsInt();
			
		Jogo jogo = new Jogo(linhas, colunas, tempoPartida);
		
		return jogo;
		
	}
	
	public void LerArquivoEquipes(String caminho, Jogo jogo) throws FileNotFoundException{
		
		Reader reader = new FileReader(caminho);
		
		JsonElement jsonElement = JsonParser.parseReader(reader);
		
		JsonArray equipes = jsonElement.getAsJsonObject().get("equipes").getAsJsonArray();
		
		for(JsonElement equipeElement: equipes) {
			JsonObject equipe = equipeElement.getAsJsonObject();
			String nomeEquipe = equipe.get("nome").getAsString();
			int quantidadeDeRobos = equipe.get("quantidadeDeRobos").getAsInt();
			   

			jogo.adicionarEquipe(new Equipe(nomeEquipe, quantidadeDeRobos));
		}
		
		
		
	}
}
