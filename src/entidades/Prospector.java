package entidades;

public class Prospector {

    public void sondar(Celula celula) {
        // Verifica se há robôs na célula
        List<Robo> robosNaCelula = celula.getRobos();
        if (!robosNaCelula.isEmpty()) {
            System.out.println("Prospector: Há robôs na célula " + celula.getCoordenadas());
            for (Robo robo : robosNaCelula) {
                // Lógica para coletar Hélio-3 do robô, se ele estiver carregando
                if (robo.isCarregandoHelio3()) {
                    System.out.println("Prospector: Coletando Hélio-3 do robô " + robo.getId());
                    robo.coletarHelio3();
                } else {
                    System.out.println("Prospector: O robô " + robo.getId() + " não está carregando Hélio-3.");
                }
            }
        } else {
            System.out.println("Prospector: Não há robôs na célula " + celula.getCoordenadas());
        }
    }
}
