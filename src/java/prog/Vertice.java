/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prog;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shaolin
 */
public class Vertice {
    private String nomeVertice;
    private List<Aresta> verticeAdj;
    private Float distancia;
    private int cor;
    private Vertice pai;
    private int tempoIni;
    private int tempoFin;
    
    Vertice(String nomeVertice){
        this.nomeVertice = nomeVertice;
        this.verticeAdj = new ArrayList<Aresta>();
    }
    
    void addAdj(Vertice vertice, int peso){
        Aresta a = new Aresta(vertice, peso);
        this.verticeAdj.add(a);
    }
//    void addAdj(Aresta aresta){
//        this.verticeAdj.add(aresta);
//    }
    
    public String getNomeVertice() {
        return nomeVertice;
    }

    public void setNomeVertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;
    }

    public List<Aresta> getVerticeAdj() {
        return verticeAdj;
    }

    public void setVerticeAdj(List<Aresta> verticeAdj) {
        this.verticeAdj = verticeAdj;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public int getTempoIni() {
        return tempoIni;
    }

    public void setTempoIni(int tempoIni) {
        this.tempoIni = tempoIni;
    }

    public int getTempoFin() {
        return tempoFin;
    }

    public void setTempoFin(int tempoFin) {
        this.tempoFin = tempoFin;
    }
    
    
}
