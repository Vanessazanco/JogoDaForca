import java.util.Scanner;

public class JogoDaForca {
    private static final String[] palavras = {"GATO", "CACHORRO", "COMPUTADOR", "MAMÃO", "LIVRO"};
    private static String palavraEscolhida;
    private static char[] palavraEscondida;
    private static int tentativasRestantes;
    private static boolean jogoGanho;
    private static int pontuacao;

    public static void main(String[] args) {
        iniciarJogo();
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0 && !jogoGanho) {
            System.out.println("Palavra: " + new String(palavraEscondida));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Pontuação: " + pontuacao);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (verificarLetra(letra)) {
                System.out.println("Boa! A letra '" + letra + "' está correta.");
                pontuacao += 10;
            } else {
                System.out.println("A letra '" + letra + "' não está na palavra.");
                tentativasRestantes--;
                pontuacao -= 5;
            }

            verificarVitoria();
        }

        if (jogoGanho) {
            System.out.println("Parabéns! Você ganhou! A palavra era: " + palavraEscolhida);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavraEscolhida);
        }

        System.out.println("Sua pontuação final é: " + pontuacao);
        scanner.close();
    }

    private static void iniciarJogo() {
        palavraEscolhida = palavras[(int) (Math.random() * palavras.length)];
        palavraEscondida = new char[palavraEscolhida.length()];
        for (int i = 0; i < palavraEscondida.length; i++) {
            palavraEscondida[i] = '_';
        }
        tentativasRestantes = 6;
        pontuacao = 0;
        jogoGanho = false;
    }

    private static boolean verificarLetra(char letra) {
        boolean letraCorreta = false;
        for (int i = 0; i < palavraEscolhida.length(); i++) {
            if (palavraEscolhida.charAt(i) == letra) {
                palavraEscondida[i] = letra;
                letraCorreta = true;
            }
        }
        return letraCorreta;
    }

    private static void verificarVitoria() {
        jogoGanho = new String(palavraEscondida).equals(palavraEscolhida);
    }
}