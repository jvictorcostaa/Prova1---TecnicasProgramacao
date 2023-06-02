package trabalho;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o tamanho do seu tabuleiro,quantos alunos e quantos bugs :");
		Tabuleiro t1 = new Tabuleiro(scan.nextInt(),scan.nextInt(),scan.nextInt());
		Jogar jogo1 = new Jogar(t1);
		jogo1.iniciarJogo();
	}
}