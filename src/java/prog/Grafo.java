/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaolin
 */
public class Grafo {
    private List<Vertice> vertices = new ArrayList<Vertice>();

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public Grafo(String entrada){
        File arq;
        FileReader fr;
        BufferedReader br = null;
        String linha;
        Grafo g;
        
        g = new Grafo();
        arq = new File(entrada);
        try{
            fr = new FileReader(arq);
            br = new BufferedReader(fr);
            linha = br.readLine();
            while(!linha.equals("#")){
                this.addVertice(linha);
                linha = br.readLine();
            }
            
//mostra vertices            
//            System.out.println("vertices");
//            for(Vertice k : g.vertices){
//                System.out.println(k.getNomeVertice());
//            }
//            System.out.println("");
            
            while(br.ready()){
                String[] arestas = separaArestas(br.readLine());
                for(Vertice v: this.vertices){
                    if(v.getNomeVertice().equals(arestas[0])){
                        for(Vertice v2: this.vertices){
                            if(v2.getNomeVertice().equals(arestas[1])){
                                if (arestas.length == 3){
                                    addAresta(v, v2, Integer.parseInt(arestas[2]));
                                } else{
                                    addAresta(v, v2, 0);
                                }
                            }
                        }
                    }
                }
            }
            br.close();
            fr.close();
            
//            //mostra vertice + listaAdj
//            System.out.println("vertice + listaAdj");
//            for(Vertice v: this.vertices){
//                System.out.print("vertice:"+v.getNomeVertice()+"->");
//                for(Aresta a: v.getVerticeAdj()){
//                    System.out.print(" "+a.getAresta().getNomeVertice());
//                }
//                System.out.println("");
//            }
//            System.out.println("");

//            //mostra aresta + peso            
//            System.out.println("aresta + peso");
//            for (Vertice v: this.vertices){
//                for (Aresta a: v.getVerticeAdj()){
//                    System.out.println(v.getNomeVertice()+" "+a.getAresta().getNomeVertice()+" "+a.getPeso());
//                }
//            }
//            System.out.println("");            
        } catch (IOException ex){
            System.out.println("erro! arquivo invalido");
        }
    }
    
    public void addVertice(String vertice){
        Vertice v = new Vertice(vertice);
        vertices.add(v);
    }
    
    String[] separaArestas(String linha){
        String[] arestas;
        arestas = linha.split(" ");
        return arestas;
    }   
    
    public void addAresta(Vertice v, Vertice a, int peso){
        v.addAdj(a, peso);
        
    }
    
}
