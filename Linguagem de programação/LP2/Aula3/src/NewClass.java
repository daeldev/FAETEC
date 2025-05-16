import java.util.Scanner;

public class NewClass {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        iniciarTabuleiro();
        jogar();
    }

    private static void iniciarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private static void jogar() {
        boolean jogoAcabou = false;
        Scanner scanner = new Scanner(System.in);

        while (!jogoAcabou) {
            exibirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada (linha [0-2] e coluna [0-2]):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '-') {
                System.out.println("Jogada inválida! Tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogadorAtual;

            if (verificarVitoria()) {
                exibirTabuleiro();
                System.out.println("Parabéns, jogador " + jogadorAtual + "! Você venceu!");
                jogoAcabou = true;
            } else if (verificarEmpate()) {
                exibirTabuleiro();
                System.out.println("O jogo terminou em empate!");
                jogoAcabou = true;
            }

            jogadorAtual = jogadorAtual == 'X' ? 'O' : 'X';
        }
    }

    private static void exibirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean verificarVitoria() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                return true;
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false; // Ainda há espaços vazios no tabuleiro
                }
            }
        }
        return true; // Todos os espaços estão preenchidos, mas não há vencedor
    }
}

