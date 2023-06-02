package trabalho;

public class Andador extends RoboInicial{

	public Andador(int id, String nome, Tabuleiro t1) {
		super(id, nome, t1);
		this.setIcone('A');
	}
	public boolean andar(int ir) {
		if(tabuleiroRobo.podeMovimentar(posX, posY, 0, ir)) {
		posY = tabuleiroRobo.movimentarBaixo(this.posX,this.posY,ir,this);
		tabuleiroRobo.atualizarcelula(this);
		setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
		coordenadaX.add(posX);
		coordenadaY.add(posY);
		return true;
		}else
			return false;
	}
	public boolean retroceder(int voltar) {
		if(tabuleiroRobo.podeMovimentar(posX, posY, 0, -voltar)) {
		posY = tabuleiroRobo.movimentarCima(this.posX, this.posY, voltar,this);
		tabuleiroRobo.atualizarcelula(this);
		setPontuaçao(tabuleiroRobo.verificarPontos(posX,posY));
		coordenadaX.add(posX);
		coordenadaY.add(posY);
		return true;
		}else
			return false;
	}


}
