public class NRainhas {

    public static void main(String[] args) {
        int n = 8; 
        int[] board = new int[n];

        if (resultado(board, 0, n)) {
            printTabuleiro(board, n);
        } else {
            System.out.println("nenhuma solução encontrada");
        }
    }

    public static boolean resultado(int[] board, int row, int n) {
        if (row == n) {
            return true; 
        }

        for (int col = 0; col < n; col++) {
            if (ehSeguro(board, row, col)) {
                board[row] = col; 
                if (resultado(board, row + 1, n)) {
                    return true;
                }
            }
        }
        return false; 
    }

    public static boolean ehSeguro(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int otherCol = board[i];
            if (otherCol == col || Math.abs(otherCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void printTabuleiro(int[] board, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row] == col) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
