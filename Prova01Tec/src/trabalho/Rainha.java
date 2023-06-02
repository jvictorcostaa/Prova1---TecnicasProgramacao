package trabalho;

import java.util.Scanner;

public class Rainha extends RoboInicial{
	public int direçao;
	public Rainha(int id, String nome, Tabuleiro t1) {
		super(id, nome, t1);
		this.setIcone('R');
		limMovimento = 4;
		
	}
	public boolean andar(int ir) {
		if(ir<=limMovimento) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Escreva 1 para a direita ou 2 para a esquerda: ");
			direçao = scan.nextInt();
			
			if(direçao == 1 && tabuleiroRobo.podeMovimentar(posX, posY, ir, ir)) {
				this.posY = tabuleiroRobo.movimentarBaixo(posX, posY, ir,this);
				this.posX = tabuleiroRobo.movimentarDireita(posX, posY, ir,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
			}else if(direçao == 2 && tabuleiroRobo.podeMovimentar(posX, posY, -ir, ir)) {
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
		if(voltar<=limMovimento) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Escreva 1 para a direita ou 2 para a esquerda: ");
			direçao = scan.nextInt();
			
			if(direçao == 1 && tabuleiroRobo.podeMovimentar(posX, posY, voltar, -voltar)) {
				this.posY = tabuleiroRobo.movimentarCima(posX, posY, voltar,this);
				this.posX = tabuleiroRobo.movimentarDireita(posX, posY, voltar,this);
				tabuleiroRobo.atualizarcelula(this);
				setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
				coordenadaX.add(posX);
				coordenadaY.add(posY);
				return true;
			}else if(direçao == 2 && tabuleiroRobo.podeMovimentar(posX, posY, -voltar,-voltar)) {
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
