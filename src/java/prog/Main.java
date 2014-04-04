package prog;

public class Main {
    public static void main(String[] args) {
        System.out.print("parametros: ");
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
        Grafo g = new Grafo("testes/bfs/1.g");
        Algoritmos.executar(g);
    }
}
