package utilitarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Enumeracoes.Direcoes;
import entidades.Celula;
import entidades.Coordenadas;
import entidades.Equipe;
import entidades.Robo;
import entidades.Terreno;

public class LerArquivoJson {
	
	   public Terreno lerArquivoTerrenoLunar(String caminho) throws FileNotFoundException {
	        	
	            Reader reader = new FileReader(caminho);
	            JsonElement jsonElement = JsonParser.parseReader(reader);


	            int linhas = jsonElement.getAsJsonObject().get("linhas").getAsInt();
	            int colunas = jsonElement.getAsJsonObject().get("colunas").getAsInt();


	            Terreno terreno = new Terreno(linhas, colunas);


	            JsonArray celulasJson = jsonElement.getAsJsonObject().getAsJsonArray("celulas");
	            for (JsonElement celulaElement : celulasJson) {
	                JsonObject celulaObj = celulaElement.getAsJsonObject();

	                int x = celulaObj.getAsJsonObject("coordenadas").get("x").getAsInt();
	                int y = celulaObj.getAsJsonObject("coordenadas").get("y").getAsInt();
	                
	                float concentracaoHelio3 =  celulaObj.get("concentracaoHelio3").getAsFloat();
	                
	                float[] coeficienteErro = {
	                    celulaObj.getAsJsonArray("coeficienteErro").get(0).getAsFloat(),
	                    celulaObj.getAsJsonArray("coeficienteErro").get(1).getAsFloat()
	                };
	                
	                float rugosidade = (float) celulaObj.get("rugosidade").getAsDouble();


	                Coordenadas coordenada = new Coordenadas(x, y);
	                
	                
	                Celula celula = new Celula(concentracaoHelio3,
	                		coeficienteErro[1], coeficienteErro[0], rugosidade);
	               
	                
	                terreno.adicionarNoTerreno(celula,coordenada);
	                
	            }

	            return terreno;
	    }
	   
	 
	    public Jogo lerArquivoJogo(String caminho, Terreno terreno) throws IOException {
	        try (FileReader reader = new FileReader(caminho)) {
	        	
	            JsonElement jsonElement = JsonParser.parseReader(reader);
	            JsonObject jogoJson = jsonElement.getAsJsonObject();

	            Random gerador = new Random();
	            
	            int duracaoPartida = jogoJson.get("tempoDuracaoPartida").getAsInt();

	            Jogo jogo = new Jogo(terreno, duracaoPartida);
	 
	            
	            JsonArray equipesJson = jogoJson.getAsJsonArray("equipes");
	            int i = 0;

	            for (JsonElement equipeElement : equipesJson) {
	                JsonObject equipeJson = equipeElement.getAsJsonObject();

	                
	                String nomeEquipe = equipeJson.get("nome").getAsString();

	                
	                jogo.adicionarEquipe(new Equipe(nomeEquipe));
	                
	                
	                
	                JsonArray robosJson = equipeJson.getAsJsonArray("robos");

	                for (JsonElement roboElement : robosJson) {
	                    JsonObject roboJson = roboElement.getAsJsonObject();

	                    String nomeRobo = roboJson.get("nome").getAsString();
	                    
	                    Coordenadas coordenada;
	                    
	                    do {
		                    int x = gerador.nextInt(terreno.getLinhas());
		                    int y = gerador.nextInt(terreno.getColunas());
		                    coordenada = new Coordenadas(x, y);
	                    
	                    }while(terreno.getCelula(coordenada).isRoboNaCelula());
	                    
	                    
	                    jogo.getListaDeEquipes().get(i).addListaDeRobores(
	                    		new Robo(nomeRobo, jogo.getListaDeEquipes().get(i), 
	                    				coordenada, Direcoes.BAIXO));
	   
	                }
	                ++i;
	            }

	            // Criar e retornar a instância do jogo com as informações lidas
	            return jogo;
	        }
	    }
	}


