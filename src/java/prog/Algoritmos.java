/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prog;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author shaolin
 */
public class Algoritmos {
    
    public static void bfs(Grafo g){
        for (Vertice v: g.getVertices()){
            v.setCor(0);  //0=branco; 1=cinza; 2=preto
            v.setDistancia(-1);
            v.setPai(null);
            
        }
        g.getVertices().get(0).setDistancia(0);
        g.getVertices().get(0).setCor(1);
    
        LinkedList<Vertice> fila = new LinkedList<>();
        Vertice v;
        fila.add(g.getVertices().get(0));
        while (!fila.isEmpty()){
            v = fila.removeFirst();
            for (Aresta a: v.getVerticeAdj()){
                if (a.getAresta().getCor() == 0){
                    a.getAresta().setDistancia(v.getDistancia()+1);
                    a.getAresta().setPai(v);
                    a.getAresta().setCor(1);
                    fila.add(a.getAresta());
                }
            }
            v.setCor(2);
        }
        printBFS(g);
    }
    
    private static void printBFS(Grafo g){
        for (int i=0; i<g.getVertices().size(); i++){
            if (g.getVertices().get(i).getDistancia() != -1){
                System.out.println(g.getVertices().get(0).getNomeVertice()+" "+g.getVertices().get(i).getNomeVertice()+" "+(int)g.getVertices().get(i).getDistancia());
            }
        }
    }
    
    public static void initializaSingleSource(Grafo g, int ini){
        Float infinito = Float.POSITIVE_INFINITY;
        for (int i=0; i<g.getVertices().size(); i++){
            g.getVertices().get(i).setDistancia(infinito);
            g.getVertices().get(i).setPai(null);
        }
        g.getVertices().get(ini).setDistancia(0);
    }
    
//    public static ArrayList<Vertice> topologicalSort(Grafo g){
//        ArrayList<Vertice> ordTopo;
//        ordTopo = dfs(g);
//        return ordTopo;
//    }
//    
//    public static void fw(Grafo g){
//        ArrayList<Vertice> ordTopo = null;
//        int w;
//        
//        ordTopo = topologicalSort(g);
//        System.out.println("000000000000000000000000");
//        for (Vertice k: ordTopo){
//            System.out.println(k.getNomeVertice()+" "+k.getTempoIni()+" "+k.getTempoFin());
//        }
//        System.out.println("000000000000000000000000");
//
//        initializaSingleSource(g, 0);
//        for (Vertice u: ordTopo){
//            for (Aresta v: u.getVerticeAdj()){
//                w = pegaPeso(u, v.getAresta());
//                relax(u, v.getAresta(), w);
//            }
//        }
//        printFW(g);
//    }
//    
//    public static void printFW(Grafo g){
//        for (Vertice v: g.getVertices()){
//            for (Aresta e: v.getVerticeAdj()){
//                System.out.println(v.getNomeVertice()+" "+e.getAresta().getNomeVertice()+" "+e.getPeso());
//            }
//        }
//    }
    
    public static void bfSingle(Grafo g){
        bf(g, 0);
        printBF(g);
    }
    
    public static void bfAll(Grafo g){
        for (int v=0; v<g.getVertices().size(); v++){
            bf(g, v);
            printBF(g);
        }
    }
    
    private static void bf(Grafo g, int ini){
        
//        System.out.println("testando pegaPeso");
//        System.out.println(g.getVertices().get(0).getNomeVertice()+" "+g.getVertices().get(0).getVerticeAdj().get(1).getAresta().getNomeVertice()+" "+pegaPeso(g.getVertices().get(0), g.getVertices().get(0).getVerticeAdj().get(1).getAresta()));
        
        Float infinito = Float.POSITIVE_INFINITY;
        for (int i=0; i<g.getVertices().size(); i++){
            g.getVertices().get(i).setDistancia(infinito);
            g.getVertices().get(i).setPai(null);
        }
        g.getVertices().get(ini).setDistancia(0);
        
        for (int i=1; i<(g.getVertices().size()-1); i++){
            for (Vertice u:g.getVertices()){
                for (Aresta v:u.getVerticeAdj()){
                    int w = pegaPeso(u, v.getAresta());
                    relax(u, v.getAresta(), w);
                }
            }
        }
//        //verifica se tem loop negativo      
//        for (Vertice u: g.getVertices()){
//            for (int v=0; v<u.getVerticeAdj().size(); v++){
//                if (u.getVerticeAdj().get(v).getAresta().getDistancia() > u.getDistancia() + pegaPeso(u, u.getVerticeAdj().get(v).getAresta())){
//                    return false;
//                }
//            }
//        }
//        return true;
    }
    
    private static void printBF(Grafo g){
        Vertice u;
        LinkedList<String> pilha = new LinkedList<>();
        Float infinito = Float.POSITIVE_INFINITY;
        for (Vertice v: g.getVertices()){
            float dist = v.getDistancia();
            if (dist != infinito){
                pilha.add(String.valueOf((int)dist));
                pilha.add(v.getNomeVertice());
                u = v.getPai();
                int i=1;
                while (u != null){
                    i++;
                    pilha.add(u.getNomeVertice());
                    u = u.getPai();
                }
                while (!pilha.isEmpty()){
                    System.out.print(pilha.removeLast()+" ");
                }
                System.out.println("");
            }
        }
        
//        //print distancia entre vertices apos relax (saida dos arquivos arquivo.out)
//        Float infinito = Float.POSITIVE_INFINITY;
//        for (int v=0; v<g.getVertices().size(); v++){
//            if (g.getVertices().get(v).getDistancia() != infinito ){
//                System.out.println(g.getVertices().get(ini).getNomeVertice()+" "+g.getVertices().get(v).getNomeVertice()+" "+(int)g.getVertices().get(v).getDistancia());
//            }
//        }
    }
        
    private static void relax(Vertice u, Vertice v, int w){
        if (v.getDistancia() > u.getDistancia() + w){
            v.setDistancia((int) u.getDistancia()+w);
            v.setPai(u);
        }
    }
    
    private static int pegaPeso(Vertice u, Vertice v){
        int peso = 0;
        for (Aresta i: u.getVerticeAdj()){
            if (i.getAresta().getNomeVertice().equals(v.getNomeVertice())){
                peso = i.getPeso();
            }
        }
        return peso;
    }
    
    public static void dkAll(Grafo g){
        for (int v=0; v<g.getVertices().size(); v++){
            dk(g, v);
            printDK(g);
        }
    }
    
    public static void dkSingle(Grafo g){
        dk(g, 0);
        printDK(g);
    }
    
    private static void dk(Grafo g, int ini){
        ArrayList<Vertice> S, Q;
        Vertice u;
        int min, peso;
        
        initializaSingleSource(g, ini);
        S = new ArrayList<>();
        Q = new ArrayList<>();
        for (Vertice v: g.getVertices()){
            Q.add(v);
        }
        while (!Q.isEmpty()){
            min = extractMin(Q);
            S.add(Q.get(min));
            for (Aresta v: Q.get(min).getVerticeAdj()){
                peso = pegaPeso(Q.get(min), v.getAresta());
                relax(Q.get(min), v.getAresta(), peso);
            }
            Q.remove(min);  
        }
    }
    
    private static int extractMin(ArrayList<Vertice> Q){
        int min;
        min = 0;
        for (int v=1; v<Q.size(); v++){
            if (Q.get(v).getDistancia() < Q.get(min).getDistancia()){
                min = v;
            }
        }
        return min;
    }
    
    private static void printDK(Grafo g){
        Vertice u;
        LinkedList<String> pilha = new LinkedList<>();
        Float infinito = Float.POSITIVE_INFINITY;
        for (Vertice v: g.getVertices()){
            float dist = v.getDistancia();
            if (dist != infinito){
                pilha.add(String.valueOf((int)dist));
                pilha.add(v.getNomeVertice());
                u = v.getPai();
                int i=1;
                while (u != null){
                    i++;
                    pilha.add(u.getNomeVertice());
                    u = u.getPai();
                }
                while (!pilha.isEmpty()){
                    System.out.print(pilha.removeLast()+" ");
                }
                System.out.println("");
            }
        }
        
        
//        //verifica saida dos arquivos arquivo.out
//        Float infinito = Float.POSITIVE_INFINITY;
//        for (int v=0; v<g.getVertices().size(); v++){
//            if (g.getVertices().get(v).getDistancia() != infinito ){
//                System.out.println(g.getVertices().get(ini).getNomeVertice()+" "+g.getVertices().get(v).getNomeVertice()+" "+(int)g.getVertices().get(v).getDistancia());
//            }
//        }
    }
    
    private static int[][] criaMatrizAdj(Grafo g){
        int[][] matAdj = new int[g.getVertices().size()][g.getVertices().size()];
        Vertice v;
        Aresta e;
        
        Integer infinito = Integer.MAX_VALUE;
        for (int l=0; l<g.getVertices().size(); l++){
            for (int c=0; c<g.getVertices().get(l).getVerticeAdj().size(); c++){
                for (int k=0; k<g.getVertices().size(); k++){
                    if (g.getVertices().get(l).getVerticeAdj().get(c).getAresta().equals(g.getVertices().get(k))){
                        v = g.getVertices().get(l);
                        e = g.getVertices().get(l).getVerticeAdj().get(c);
                        matAdj[l][k] = pegaPeso(v, e.getAresta());   
                    } 
                }
            }
        }
        
        for (int l=0; l<g.getVertices().size(); l++){
            for (int c=0; c<g.getVertices().size(); c++){
                if ((l!=c) && (matAdj[l][c]==0)){
                    matAdj[l][c] = infinito;
                }
            }
        }
        //imprime matriz de adjacencia
//        for (int l=0; l<g.getVertices().size(); l++){
//            for (int c=0; c<g.getVertices().size(); c++){
//                System.out.print(" "+matAdj[l][c]);
//            }
//            System.out.println();
//        }
        return matAdj;
    }
    
    
    public static void fw(Grafo g){
        int[][] matAdj, matPai;
        matAdj = criaMatrizAdj(g);
        matPai = criaMatrizPai(matAdj);
        
        Integer infinito = Integer.MAX_VALUE;
        for (int k=0; k<matAdj.length; k++){
            for (int i=0; i<matAdj.length; i++){
                for (int j=0; j<matAdj.length; j++){
                    if ((matAdj[i][k] != infinito) & (matAdj[k][j] != infinito)){
                        if (matAdj[i][j] > matAdj[i][k] + matAdj[k][j]){
                            matAdj[i][j] = matAdj[i][k] + matAdj[k][j];
                            matPai[i][j] = matPai[k][j];
                        }
                    }
                }
            }
        }
        printFW(matPai);
    }
    
    private static int[][] criaMatrizPai(int[][] mat){
        int[][] matPai = new int[mat.length][mat.length];
        
        Integer infinito = Integer.MAX_VALUE;
        for (int l=0; l<mat.length; l++){
            for (int c=0; c<mat.length; c++){
                if ((mat[l][c] != 0) && (mat[l][c] != infinito)){
                    matPai[l][c] = l;
                } else{
                    matPai[l][c] = -1;
                }
            }
        }
        return matPai;
    }
    
    private static void printFW(int[][] matPai){
        
        
//        //imprime a saida dos arquivos arquivo.out
//        Integer infinito = Integer.MAX_VALUE;
//        for (int l=0; l<mat.length; l++){
//            for (int c=0; c<mat.length; c++){
//                if (mat[l][c] != infinito){
//                    System.out.println(" "+g.getVertices().get(l).getNomeVertice()+" "+g.getVertices().get(c).getNomeVertice()+" "+mat[l][c]);
//                }
//            }
//        }
    }
    
    
    
    private static Grafo criaTransposto(Grafo g){
        Grafo gT = new Grafo();
        
        for (Vertice v: g.getVertices()){
            gT.addVertice(v.getNomeVertice());
        }
        
        for (Vertice v: g.getVertices()){
            for (Aresta u: v.getVerticeAdj()){
                gT.addAresta(u.getAresta(), v, u.getPeso());
            }
        }
        return gT;
    }
    
    private static void scc(Grafo g){
        Grafo gT;
        ArrayList<Vertice> saida, saidaT;
        saida = dfs(g);
        gT = criaTransposto(g);
        saidaT = dfs(gT);
    }
    
    private static ArrayList<Vertice> dfs(Grafo g){
        int tempo;
        ArrayList<Vertice> ordTopo = new ArrayList<>();
        
        for (Vertice v: g.getVertices()){
            v.setCor(0);
            v.setPai(null);
        }
        tempo = 0;
        for (Vertice v: g.getVertices()){
            if (v.getCor() == 0){
                ordTopo = dfsVisit(v, tempo, ordTopo);
            }
        }
        return ordTopo;
    }
    
    private static ArrayList<Vertice> dfsVisit(Vertice v, int tempo, ArrayList<Vertice> saida){
        tempo ++;
        v.setCor(1);
        v.setTempoIni(tempo);
        for (Aresta e: v.getVerticeAdj()){
            if (e.getAresta().getCor() == 0){
                e.getAresta().setPai(v);
                dfsVisit(e.getAresta(), tempo, saida);
            }
        }
        v.setCor(2);
        tempo ++;
        v.setTempoFin(tempo);
        saida.add(v);
        return saida;
    }
}
