package dev.swapi.starwars.entity;

public class StarwarsTPMV {

    public int getNumeroParada(int numeroParada) {
        return this.numeroParada;
    }

    public void setNumeroParada(int numeroParada) {
        this.numeroParada = numeroParada;
    }

    public int getDistanciaEmMGLT(int distanciaEmMGLT) {
        return this.distanciaEmMGLT;
    }

    public void setDistanciaEmMGLT(int distanciaEmMGLT) {
        this.distanciaEmMGLT = distanciaEmMGLT;
    }

    public int getQtdEmViagem(int qtdEmViagem) {
        return this.qtdEmViagem;
    }

    public void setQtdEmViagem(int qtdEmViagem) {
        this.qtdEmViagem = qtdEmViagem;
    }

    public int getTotalDeParadas(int totalDeParadas) {
        return this.totalDeParadas;
    }

    public void setTotalDeParadas(int totalDeParadas) {
        this.totalDeParadas = totalDeParadas;
    }

    private int numeroParada;
    private int distanciaEmMGLT;
    private int qtdEmViagem;
    private int totalDeParadas;
}
