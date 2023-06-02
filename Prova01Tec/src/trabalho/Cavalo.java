package trabalho;

public class Cavalo extends RoboInicial{

	public Cavalo(int id, String nome, Tabuleiro t1) {
		super(id, nome, t1);
		limMovimento = 2;
		this.setIcone('C');
	}

	public boolean andar(int ir) {
		if(ir<=limMovimento && tabuleiroRobo.podeMovimentar(posX, posY, ir, ir)) {
			this.posY = tabuleiroRobo.movimentarBaixo(posX, posY, ir,this);
			this.posX = tabuleiroRobo.movimentarDireita(posX, posY, ir,this);
			tabuleiroRobo.atualizarcelula(this);
			setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
			coordenadaX.add(posX);
			coordenadaY.add(posY);
			return true;
		}else
			return false;
}
		public boolean retroceder(int voltar) {
		if(voltar<=limMovimento &&  tabuleiroRobo.podeMovimentar(posX, posY, -voltar, -voltar)) {
			this.posY = tabuleiroRobo.movimentarCima(posX, posY, voltar,this);
			this.posX = tabuleiroRobo.movimentarEsquerda(posX, posY, voltar,this);
			tabuleiroRobo.atualizarcelula(this);
			setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
			coordenadaX.add(posX);
			coordenadaY.add(posY);
			return true;
		}else
			return false;
		
	}


	
}
