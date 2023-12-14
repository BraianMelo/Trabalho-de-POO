package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Equipe;
import entidades.Terreno;
import utilitarios.Jogo;
import utilitarios.LerArquivoJson;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US); // Virgula vira ponto nos floats
		Scanner sc = new Scanner(System.in);

		LerArquivoJson lerJson = new LerArquivoJson();

		try {

			System.out.print("Informe o arquivo JSON com as propriedades da partida: ");
			String caminho = sc.nextLine();
			

			Terreno terreno = lerJson.lerArquivoTerrenoLunar(caminho);

			System.out.print("Informe o arquivo JSON com as propriedades das equipes: ");
			caminho = sc.nextLine();

			Jogo jogo = lerJson.lerArquivoJogo(caminho, terreno);

			boolean jogoEmAndamento = true;

			while (jogoEmAndamento) {

				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("* Terreno: [" + terreno.getLinhas() + ", " + terreno.getColunas() + "]");
				System.out.println("* Tempo decorrido: " + jogo.getTempoDaPartida() + "\n");
				
				for(Equipe equipe: jogo.getListaDeEquipes()) {
					System.out.println(equipe);
				}
				
				jogo.realizarComando();
				
				jogoEmAndamento = jogo.esperarAcaoTerminar();
				
			}
			
			String equipeVencedora = jogo.getListaDeEquipes().get(0).getNome();
			float helioColetado = jogo.getListaDeEquipes().get(0).getBarrisDeHelio();
			
			
			for(Equipe e: jogo.getListaDeEquipes()) {
				if(e.getBarrisDeHelio() > helioColetado) {
					helioColetado = e.getBarrisDeHelio();
					equipeVencedora = e.getNome();
					
				}
			}
			
			System.out.println("Equipe vencedora: "+ equipeVencedora);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			sc.close();

		}

	}

}
