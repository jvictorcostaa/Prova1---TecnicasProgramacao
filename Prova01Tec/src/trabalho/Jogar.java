package trabalho;
import java.util.Scanner;
public class Jogar {
	public Tabuleiro tabuleiro;
	private String nomePlayer;
	private Regras regras;
	private int rodada;
	
	public Jogar(Tabuleiro t1) {
		tabuleiro = t1;
		Andador A = new Andador(0,"A",this.tabuleiro);
		tabuleiro.setRoboPlano(A);
		Peao P = new Peao(1,"P",this.tabuleiro);
		tabuleiro.setRoboPlano(P);
//		Torre T = new Torre(2,"T",this.tabuleiro);
//		tabuleiro.setRoboPlano(T);
//		Bispo B = new Bispo(3,"B",this.tabuleiro);
//		tabuleiro.setRoboPlano(B);
//		Cavalo C = new Cavalo(4,"C",this.tabuleiro);
//		tabuleiro.setRoboPlano(C);
//		Rei r = new Rei(5,"r",this.tabuleiro);
//		tabuleiro.setRoboPlano(r);
		Rainha R = new Rainha(6,"R",this.tabuleiro);
		tabuleiro.setRoboPlano(R);
		regras = new Regras();
	}
	public void iniciarJogo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome do jogador:");
		nomePlayer = scan.nextLine();
		System.out.println("Bem vindo ao Resgate dos Alunos de Tecnicas de Programação na ilha java");
		regras.objetivos();
		regras.movimentos();
		tabuleiro.imprimirPlano();
		rodada = 1;
		
		do{
			for(RoboInicial roboInicial : tabuleiro.robos) {
				boolean repMovimento = false;
				while(repMovimento == false) {
				System.out.println("Digite '1' para andar ou '2' para retroceder "+roboInicial.getClass().getSimpleName()+" "+ roboInicial.getNome());
				int mover = scan.nextInt();
				if(mover == 1){
					System.out.println("Quantas casas deseja andar com o "+roboInicial.getClass().getSimpleName()+" "+ roboInicial.getNome());
					repMovimento = roboInicial.andar(scan.nextInt());
				}else if(mover == 2) {
					System.out.println("Quantas casas deseja retroceder com o "+roboInicial.getClass().getSimpleName()+" "+ roboInicial.getNome());
					repMovimento = roboInicial.retroceder(scan.nextInt());
				}
				}
				tabuleiro.imprimirPlano();
			}
			tabuleiro.relatorioRodada(rodada);
			rodada++;
		}while(tabuleiro.fimDeJogo());
		tabuleiro.relatorioFinal(nomePlayer);
	}
}
