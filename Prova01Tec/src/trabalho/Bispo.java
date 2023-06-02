package trabalho;
import java.util.Scanner;

public class Bispo extends RoboInicial{
	public int direçao;
	public Bispo(int id, String nome, Tabuleiro t1) {
		super(id, nome, t1);
		this.setIcone('B');
		limMovimento = 2;
	}

	public boolean andar(int ir) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Escreva 1 para a direita ou 2 para a esquerda: ");
			direçao = scan.nextInt();
			if(direçao == 1) {
				if(tabuleiroRobo.podeMovimentar(posX, posY, ir, ir) && tabuleiroRobo.limitadorMovimento(ir, limMovimento)) {
				this.posY = tabuleiroRobo.movimentarBaixo(posX, posY, ir,this);
				this.posX = tabuleiroRobo.movimentarDireita(posX, posY, ir,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
				}else
					return false;
			}else if(direçao == 2) {
				if(tabuleiroRobo.podeMovimentar(posX, posY, -ir, ir) && tabuleiroRobo.limitadorMovimento(ir, limMovimento)) {
				this.posY = tabuleiroRobo.movimentarBaixo(posX, posY, ir,this);
				this.posX = tabuleiroRobo.movimentarEsquerda(posX, posY, ir,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
				}else
					return false;
			}else
				return false;
		}

	public boolean retroceder(int voltar) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Escreva 1 para a direita ou 2 para a esquerda: ");
			direçao = scan.nextInt();
			if(direçao == 1){
				if(tabuleiroRobo.podeMovimentar(posX, posY, voltar,-voltar) && tabuleiroRobo.limitadorMovimento(voltar, limMovimento)) {
				this.posY = tabuleiroRobo.movimentarCima(posX, posY, voltar,this);
				this.posX = tabuleiroRobo.movimentarDireita(posX, posY, voltar,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
				}else
					return false;
			}else if(direçao == 2) {
				if(tabuleiroRobo.podeMovimentar(posX, posY, -voltar,-voltar) && tabuleiroRobo.limitadorMovimento(voltar, limMovimento)) {
				this.posY = tabuleiroRobo.movimentarCima(posX, posY, voltar,this);
				this.posX = tabuleiroRobo.movimentarEsquerda(posX, posY, voltar,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
				}else
					return false;
			}else
				return false;
	}
}
