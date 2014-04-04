/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prog;

/**
 *
 * @author shaolin
 */
public class Aresta {
    private Vertice aresta;
    private int peso;

    Aresta(Vertice aresta, int peso) {
        this.aresta = aresta;
        this.peso = peso;
    }

    public Vertice getAresta() {
        return aresta;
    }

    public void setAresta(Vertice aresta) {
        this.aresta = aresta;
    } 

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
