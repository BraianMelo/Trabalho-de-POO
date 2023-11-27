package entidades;

import java.util.Scanner;

public class InterfaceUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Terreno terreno = new Terreno();

        Equipe equipeA = new Equipe("Equipe A");
        Equipe equipeB = new Equipe("Equipe B");

        Robo roboa = new Robo("Robô Equipe A", terreno.getCelula(0, 0), 0, Direcoes.DIREITA, 0);
        Robo robob = new Robo("Robô Equipe B", terreno.getCelula(3, 1), 0, Direcoes.DIREITA, 0);

        equipeA.adicionarRobo(roboa);
        equipeB.adicionarRobo(robob);

        terreno.addRoboNaLista(roboa);
        terreno.addRoboNaLista(robob);
        
        //Como funcionaria o jogo para o usuário (somente o robô A):
        boolean jogoRodando = true; 
        while (jogoRodando) {
            System.out.println("Escolha uma ação para " + roboa.getNome() + ":");
            System.out.println("w - Andou para frente");
            System.out.println("a - Girou para a esquerda");
            System.out.println("d - Girou para a direita");
            System.out.println("r - Iniciou prospecção");

            int movimento = scanner.nextInt();

            switch (movimento) {
                case w:
                    roboa.andar();
                    break;
                case a:
                    roboa.virarParaEsquerda();
                    break;
                case d:
                    roboa.virarParaDireita();
                    break;
                case r:
                    roboa.sondar(terreno.getCelula(roboa.obterTempo()), terreno.getCelula(roboa.obterPosicao()));
                    break;
                default:
                    System.out.println("Movimento Inválido");
            }
            

            InterfaceUsuario.exibirInformacoesRobo(roboa);

        }

        scanner.close();
    }
//
    public static void exibirInformacoesRoboa(Robo roboa) {
        System.out.println("Nome da Equipe: " + roboa.getobterNome());
        System.out.println("Posição do robô: " + roboa.obterPosicao());
        System.out.println("Nível de concentração de Hélio-3: " + roboa.obterConcetracao());
        System.out.println("Nível de Rugosidade: " + roboa.obterRugosidade());
        System.out.println("Tempo desde o início da prospecção: " + roboa.obterTempo() + " segundos");
        System.out.println("Quantidade de barris de Hélio-3 coletados: " + roboa.obterBarris());
      
      
      public static void exibirInformacoesRobob(Robo robob) {
        System.out.println("Nome da Equipe: " + robob.getobterNome());
        System.out.println("Posição do robô: " + robob.obterPosicao());
        System.out.println("Nível de concentração de Hélio-3: " + robob.obterConcetracao());
        System.out.println("Nível de Rugosidade: " + robob.obterRugosidade());
        System.out.println("Tempo desde o início da prospecção: " + robob.obterTempo() + " segundos");
        System.out.println("Quantidade de barris de Hélio-3 coletados: " + robob.obterBarris());
    }
}

/* package entidades;

import java.util.Scanner;

public class InterfaceUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Terreno terreno = new Terreno();

        Equipe equipeA = new Equipe("Equipe A");
        Equipe equipeB = new Equipe("Equipe B");

        Robo roboa = new Robo("Robô Equipe A", equipeA, 0, Direcoes.DIREITA);
        Robo robob = new Robo("Robô Equipe B", equipeB, 0, Direcoes.DIREITA);

        terreno.adicionarRoboNoTerreno(roboa);
        terreno.adicionarRoboNoTerreno(robob);

        // Como funcionaria o jogo para o usuário (somente o robô A):
        boolean jogoRodando = true;
        while (jogoRodando) {
            System.out.println("Escolha uma ação para " + roboa.getNomeRobo() + ":");
            System.out.println("w - Andou para frente");
            System.out.println("a - Girou para a esquerda");
            System.out.println("d - Girou para a direita");
            System.out.println("r - Iniciou prospecção");

            char movimento = scanner.next().charAt(0);

            switch (movimento) {
                case 'w':
                    roboa.andar();
                    break;
                case 'a':
                    roboa.virarParaEsquerda();
                    break;
                case 'd':
                    roboa.virarParaDireita();
                    break;
                case 'r':
                    roboa.sondar(terreno.getCelula(roboa.getPosicao()));
                    break;
                default:
                    System.out.println("Movimento Inválido");
            }

            InterfaceUsuario.exibirInformacoesRobo(roboa);

        }

        scanner.close();
    }

    public static void exibirInformacoesRobo(Robo robo) {
        System.out.println("Nome da Equipe: " + robo.getEquipe().getNome());
        System.out.println("Posição do robô: " + robo.getPosicao());
        System.out.println("Nível de concentração de Hélio-3: " + robo.getConcentracao());
        System.out.println("Nível de Rugosidade: " + robo.getRugosidade());
        System.out.println("Tempo desde o início da prospecção: " + robo.getTempo() + " segundos");
        System.out.println("Quantidade de barris de Hélio-3 coletados: " + robo.getBarrisDeHelio());
    }
}
*/
