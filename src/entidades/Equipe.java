package entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Robo> robos;

    public Equipe(String nome) {
        this.nome = nome;
        this.robos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarRobo(Robo robo) {
        robos.add(robo);
    }

    public void removerRobo(Robo robo) {
        robos.remove(robo);
    }

    public List<Robo> getRobos() {
        return robos;
    }

    public String toString() {
        return "Equipe: " + nome;
    }
}
