package trabalho;

public class Regras {
	public void movimentos() {
		System.out.println("Os robôs possuem os seguintes movimentos:\nO Andador movimenta-se em qualquer número de celulas desejada:\n"
				+ "Avançar: para cima\r\n"
				+ "Retroceder: para baixo\n"
				+ "O Peao movimenta-se apenas uma celula em cada rodada:\n"
				+ "Avançar: para direita\r\n"
				+ "○ Retroceder: para esquerda\n"
				+ "A Torre movimenta-se duas celulas em cada rodada:\n"
				+ "Avançar: para cima\r\n"
				+ "○ Retroceder: para baixo\n"
				+ "O Bispo movimenta-se pelas diagonais até duas celulas em cada rodada:\n"
				+ "Avançar: para cima\r\n"
				+ "○ Retroceder: para baixo\n"
				+ "O Cavalo movimenta-se pelas diagonais até duas celulas em cada rodada:\n"
				+ "Avançar: para direita\r\n"
				+ "○ Retroceder: para esquerda\n"
				+ "O Rei movimenta-se pelas diagonais até quatro celulas em cada rodada:\n"
				+ "Avançar: para direita\r\n"
				+ "○ Retroceder: para esquerda\n"
				+ "O Rainha mmovimenta-se pelas diagonais até quatro celulas em cada rodada:\n"
				+ "Avançar: para cima\r\n"
				+ "○ Retroceder: para baixo\n Começando o jogo...\n");
	}
	public void objetivos() {
		System.out.println("O objetivo do jogo eh encontrar todos os Alunos perdidos,previamente ocultados no tabuleiro,\nque serão "
				+"resgatados quando um robo passar na celula onde os mesmos estao,\ntodas as celulas serao identificadas no "
				+ "tabuleiro para facilitar o desenvolvimento do jogador.\n");
	}
}
