import java.util.Scanner;

public class JogoDaForca {
    private static final String[] palavras = {"GATO", "CACHORRO", "COMPUTADOR", "MAMÃO", "LIVRO"};
    private static String palavraEscolhida;
    private static char[] palavraEscondida;
    private static int tentativasRestantes;
    private static boolean jogoGanho;

    public static void main(String[] args) {
        iniciarJogo();
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0 && !jogoGanho) {
            System.out.println("Palavra: " + new String(palavraEscondida));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (verificarLetra(letra)) {
                System.out.println("Boa! A letra '" + letra + "' está correta.");
            } else {
                System.out.println("A letra '" + letra + "' não está na palavra.");
                tentativasRestantes--;
            }

            verificarVitoria();
        }

        if (jogoGanho) {
            System.out.println("Parabéns! Você ganhou! A palavra era: " + palavraEscolhida);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavraEscolhida);
        }

        scanner.close();
    }
}
