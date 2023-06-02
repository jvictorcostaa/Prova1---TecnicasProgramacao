package trabalho;

public class Peao extends RoboInicial{

	public Peao(int id, String nome, Tabuleiro t1) {
		super(id, nome, t1);
		limMovimento = 1;
		this.setIcone('P');
	}

	public boolean andar(int ir) {
		if(ir<=limMovimento && tabuleiroRobo.podeMovimentar(posX, posY, ir, 0)) {
		this.posY = tabuleiroRobo.movimentarBaixo(posX, posY, 0, this);
		this.posX = tabuleiroRobo.movimentarDireita(posX,posY,ir,this);
		tabuleiroRobo.atualizarcelula(this);
		setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
		coordenadaX.add(posX);
		coordenadaY.add(posY);
		return true;
		}else
			return false;
	}

	public boolean retroceder(int voltar) {
		if(voltar<=limMovimento && tabuleiroRobo.podeMovimentar(posX, posY, -voltar, 0)) {
		this.posY = tabuleiroRobo.movimentarCima(posX, posY, 0, this);
		this.posX = tabuleiroRobo.movimentarEsquerda(posX,posY,voltar,this);
		tabuleiroRobo.atualizarcelula(this);
		setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
		coordenadaX.add(posX);
		coordenadaY.add(posY);
		return true;
		}else
			return false;
	}

}
