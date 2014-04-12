    package prog;

//import static prog.Algoritmos.bfs;

public class Main {
    public static void main(String[] args) {
//        System.out.print("parametros: ");
//        for (String s : args) {
//            System.out.print(s + " ");
//        }
//        System.out.println("");
        
        if (args[0].equals("bfs")){         //ok
            Grafo g = new Grafo(args[1]);
            Algoritmos.bfs(g);
        }
        if (args[0].equals("bf")){          //ok
            Grafo g = new Grafo(args[1]);
            Algoritmos.bfSingle(g);
        }
        if (args[0].equals("bfall")){       //ok
            Grafo g = new Grafo(args[1]);
            Algoritmos.bfAll(g);
        }
        if (args[0].equals("dk")){          //ok
            Grafo g = new Grafo(args[1]);
            Algoritmos.dkSingle(g);
        }
        if (args[0].equals("dkall")){       //ok
            Grafo g = new Grafo(args[1]);
            Algoritmos.dkAll(g);
        }
        if (args[0].equals("fw")){
            Grafo g = new Grafo(args[1]);
            Algoritmos.fw(g);
        }
        
        
        
        
//        Grafo g = new Grafo("testes/bf/1.g");
//        Algoritmos.bfSingle(g);
   }
}
