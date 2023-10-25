package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import Utilitarios.LerArquivoJson;
import controladores.Jogo;
import entidades.Equipe;
import entidades.Robo;
import entidades.Terreno;

public class Programa {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); //Virgula vira ponto nos floats
		Scanner sc = new Scanner(System.in);
		
		LerArquivoJson lerJson = new LerArquivoJson();
		
		try {
			

			System.out.print("Informe o arquivo JSON com as propriedades da partida: ");
			String caminho = sc.nextLine();
			
			Jogo jogo = lerJson.lerArquivoTerrenoLunar(caminho);
			
			
			System.out.print("Informe o arquivo JSON com as propriedades das equipes: ");
			caminho = sc.nextLine();
			
			lerJson.LerArquivoEquipes(caminho, jogo);
			
			boolean jogoEmAndamento = true;
			
			while(jogoEmAndamento) {
				
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("* Terreno: ["+Terreno.linhas+", "+Terreno.colunas+"]");
				System.out.println("* Tempo decorrido: "+jogo.getTempoDaPartida()+"\n");
				
				
				for(Equipe equipe: jogo.getEquipes()) {
					System.out.println(equipe);
				}
				
				for(Robo robo: Terreno.getRoboresNoTerreno()) {
					if(robo.getTempoAcaoAtual() == 0) {
						System.out.print("Comando do "+robo.getNomeRobo()+", "+
								robo.getNomeEquipe()+": ");
						
						char comando = sc.next().charAt(0);
						jogo.realizarComando(comando, robo);
					}
				}
	
				if(jogo.getTempoDaPartida() <= 0) {
					jogoEmAndamento = false;
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					break;
				}
				
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Robos realizando as ações");
				jogo.esperarAcaoTerminar(jogoEmAndamento);
				
			}
			
			float maiorConcentracaoHelio = 0;
			String equipeVencedora = "";
			
			for(Equipe equipe: jogo.getEquipes()) {
				if(maiorConcentracaoHelio < equipe.getBarrisDeHelioEquipe()) {
					maiorConcentracaoHelio = equipe.getBarrisDeHelioEquipe();
					equipeVencedora = equipe.getNome();
					
				}
				
				System.out.println(equipe);
			}
			
			System.out.println("Equipe vencedora: "+equipeVencedora+"!\n");
			
			
			
	
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sc.close();
			
		}		
	}
}
