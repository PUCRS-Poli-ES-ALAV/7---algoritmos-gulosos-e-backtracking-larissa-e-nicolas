import java.util.*;

public class ProblemaTroco {
    static List<Integer> trocoGuloso(int[] moedas, int valor) {

        Arrays.sort(moedas);

        for (int i = 0; i < moedas.length / 2; i++) {
            int aux = moedas[i];
            moedas[i] = moedas[moedas.length - 1 - i];
            moedas[moedas.length - 1 - i] = aux;
        }

        List<Integer> qntMoedas = new ArrayList<>();
        int iteracoes = 0;

        while (valor > 0) {
            boolean achou = false;
            for (int m : moedas) {
                if (m <= valor) {
                    qntMoedas.add(m);
                    valor -= m;
                    iteracoes++;
                    achou = true;
                    break;
                }
            }
            
            if (!achou) {
                System.out.println("Não foi possível dar troco com as moedas disponíveis.");
                break;
            }
        }

        System.out.println("Total de moedas: " + qntMoedas.size());
        System.out.println("Iterações: " + iteracoes);
        return qntMoedas;
    }

    public static void main(String[] args) {
        int[] moedas = {100, 25, 10, 5, 1}; 
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o valor do troco (em centavos): ");
        int valor = s.nextInt();
        s.close();

        List<Integer> resultado = trocoGuloso(moedas, valor);
        System.out.println("Moedas usadas: " + resultado);
    }
}
