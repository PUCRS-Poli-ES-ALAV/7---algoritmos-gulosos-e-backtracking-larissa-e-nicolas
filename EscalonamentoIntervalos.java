import java.util.*;

public class EscalonamentoIntervalos {
    static class Intervalo {
        int inicio, fim, indice;
        Intervalo(int inicio, int fim, int indice) {
            this.inicio = inicio;
            this.fim = fim;
            this.indice = indice;
        }
    }

    public static void main(String[] args) {
        List<Intervalo> intervalos = Arrays.asList(
            new Intervalo(4, 8, 1),
            new Intervalo(6, 7, 2),
            new Intervalo(13, 14, 3),
            new Intervalo(4, 5, 4),
            new Intervalo(2, 4, 5),
            new Intervalo(6, 9, 6),
            new Intervalo(7, 10, 7),
            new Intervalo(9, 11, 8),
            new Intervalo(1, 6, 9),
            new Intervalo(3, 13, 10),
            new Intervalo(9, 12, 11)
        );

        intervalos.sort(Comparator.comparingInt(i -> i.fim));

        List<Integer> selecionados = new ArrayList<>();
        int fimAnterior = -1;
        int iteracoes = 0;

        for (Intervalo i : intervalos) {
            iteracoes++;
            if (i.inicio > fimAnterior) {
                selecionados.add(i.indice);
                fimAnterior = i.fim;
            }
        }

        
        int n = intervalos.size();
        int[] X = new int[n];
        for (int idx : selecionados) {
            X[idx - 1] = 1; 
        }

        System.out.println("Numero de intervalos selecionados: " + selecionados.size());
        System.out.println("Vetor X (SDM): " + Arrays.toString(X));
        System.out.println("Total de iteracoes: " + iteracoes);
    }
}
