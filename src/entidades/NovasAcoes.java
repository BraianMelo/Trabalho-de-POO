package entidades;

public class Andar implements AcaoRobo {
    @Override
    public void realizarAcao(Robo robo) {
        robo.andar();
    }
}

package entidades;

public class VirarEsquerda implements AcaoRobo {
    @Override
    public void realizarAcao(Robo robo) {
        robo.virarParaEsquerda();
    }
}

package entidades;

public class VirarDireita implements AcaoRobo {
    @Override
    public void realizarAcao(Robo robo) {
        robo.virarParaDireita();
    }
}

package entidades;

public class Prospeccao implements AcaoRobo {
    @Override
    public void realizarAcao(Robo robo) {
        robo.sondar();
    }
}
