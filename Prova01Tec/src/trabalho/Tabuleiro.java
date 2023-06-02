package trabalho;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
	private ArrayList<Celula> plano;
	protected ArrayList<RoboInicial> robos;
	private int tamanho;
	private int alunos;
	

	public Tabuleiro(int tamanho,int alunos,int bugs) {
		this.tamanho = tamanho;
		this.alunos = alunos;
		int tempNum = 0;
		robos = new ArrayList<RoboInicial>();
		plano = new ArrayList<Celula>();
		int cont = 0;
		for(int y = 1;y<=this.tamanho;y++) {
			for(int x = 1;x<=this.tamanho;x++) {
				plano.add(new Celula(cont,y,x));
				if(x==1 && y ==1)
					tempNum = cont;
				cont++;
		}
	}
		Random numAleatorio = new Random();
		ArrayList<Integer> listaNumAleatorios = new ArrayList<>();
		int num;
		while(listaNumAleatorios.size()<(alunos+bugs)) {
			do {
				num = numAleatorio.nextInt(tamanho*tamanho);
			} while(listaNumAleatorios.contains(num) || tempNum == num);
			listaNumAleatorios.add(num);
		}
		for (int i = 0;i<listaNumAleatorios.size();i++) {
			if(i<bugs) {
				plano.get(listaNumAleatorios.get(i)).setTrueTemBug();
			}else
				plano.get(listaNumAleatorios.get(i)).setTrueTemAluno();
		}
} 
	public boolean limitadorMovimento(int mov,int lim) {
		if(mov<=lim)
			return true;
		else {
			return false;
		}
	}
	public void atualizarcelula(RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == robo.posX && celula.posY == robo.posY)
				celula.setCelulaRobo(robo);
		}
	}
	public boolean podeMovimentar(int RoboX,int RoboY,int x,int y) {
		if((RoboX + x >= this.tamanho+1) || (RoboY + y >= this.tamanho+1)||(RoboX + x <= 0) || (RoboY+ y <= 0)) {
			System.out.println("movimento invalido");
			return false;
		}
		else
			return true;
	}
	public void adicionarRobo(RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == 1 && celula.posY == 1) {
				celula.setCelulaRobo(robo);
			}	
		}
	}
	public int verificarPontos(int roboX,int roboY) {
		for (Celula celula : plano) {
				if((celula.posX == roboX && celula.posY == roboY)){
					if(celula.comp.isPodePontuar())
					return celula.comp.getPontucao();
					}
		}
		return 0;
	}
	public boolean fimDeJogo() {
		int contAlu = 0;
		for (Celula celula : plano) {
			if(celula.comp.checarComponenteAluno() && celula.comp.isPodePontuar()) {
				contAlu++;
			}
		}
		if(contAlu >= this.alunos) {
			return false;
			}
		return true;
	}
	public void imprimirPlano() {
		int contcelula = 1;
		for (Celula celula : plano) {
			System.out.print(celula.imprimirCelula());
			if(contcelula == tamanho) {
				System.out.println();
				contcelula = 0;
			}
			contcelula++;
		}
		System.out.println();
	}
	public int movimentarCima(int roboX,int roboY,int y,RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == roboX && celula.posY == roboY) {
				celula.removeCelulaRobo(robo);
			}				
//			if(celula.posY == roboY - y && celula.posX == roboX) {
//				celula.setTemRobo(true);
//				celula.setCelulaRobo(robo);
//			}
		}
		return roboY-y;
	}
	public int movimentarDireita(int roboX,int roboY,int x,RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == roboX && celula.posY == roboY) {
				//celula.removeCelulaRobo(robo);
			}
//			if(celula.posY == roboY && celula.posX == roboX + x) {
//				celula.setTemRobo(true);
//				celula.setCelulaRobo(robo);
//			}
		}
		return roboX+x;
	}
	public int movimentarBaixo(int roboX,int roboY,int y,RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == roboX && celula.posY == roboY) {
				celula.removeCelulaRobo(robo);
			}
//			if(celula.posY == roboY + y && celula.posX == roboX) {
//				celula.setTemRobo(true);
//				celula.setCelulaRobo(robo);
//			}
		}
		return roboY+y;
	}
	public int movimentarEsquerda(int roboX,int roboY,int x,RoboInicial robo) {
		for (Celula celula : plano) {
			if(celula.posX == roboX && celula.posY == roboY) {
			//	celula.removeCelulaRobo(robo);
			}
//			if(celula.posY == roboY && celula.posX == roboX - x) {
//				celula.setTemRobo(true);
//				celula.setCelulaRobo(robo);
//			}
		}
		return roboX-x;
	}
	public void relatorioRodada(int rodada) {
		for(RoboInicial robo : robos) {
			System.out.println("O robo "+robo.getNome()+" tem "+robo.getPontuaçao()+"na rodada "+rodada);
		}
	}
	public void relatorioFinal(String nome) {
		String ganhador = null;
		for (RoboInicial robo : robos){
			for(int i = 0;i<robo.coordenadaX.size();i++) {
				System.out.print("["+robo.coordenadaX.get(i)+","+robo.coordenadaY.get(i)+"] ");
			}
			//pontuacao
			int temp = 0;
			 System.out.println("O robo "+robo.getClass().getSimpleName()+" "+robo.getNome()+" pontuou :"+robo.getPontuaçao());
			if(robo.getPontuaçao()>temp)
				ganhador = robo.getNome();
			System.out.println("Encontrou: "+robo.getAluFind() +" Alunos e " +robo.getBugFind()+" Bugs");
		}
		System.out.println("O jogador:"+nome+" teve como robo campeao o "+ganhador);
	}
	public void setRoboPlano(RoboInicial robo) {
		robos.add(robo);
	}
//	public void celulaDoRobo(int roboX,int roboY,RoboInicial robo) {
//		for (Celula celula : plano) {
//			if(roboX == celula.posX && roboY == celula.posY)
//				celula.setCelulaRobo(robo);
//		}
//	}
}
