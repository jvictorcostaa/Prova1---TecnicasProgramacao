package trabalho;
import java.util.ArrayList;
public abstract class RoboInicial {
	private String nome;
	protected ArrayList<Integer> coordenadaX;
	protected ArrayList<Integer> coordenadaY;
	private int id;
	private int pontuaçao;
	private char icone;
	protected Tabuleiro tabuleiroRobo;
	protected int posX,posY;
	protected int limMovimento;
	private int aluFind;
	private int bugFind;
	
	public RoboInicial(int id,String nome,Tabuleiro t1) {
		this.id = id;
		this.nome = nome;
		this.tabuleiroRobo = t1;
		posX = 1;
		posY = 1;
		pontuaçao = 0;
		tabuleiroRobo.adicionarRobo(this);
		coordenadaX = new ArrayList<Integer>();
		coordenadaY = new ArrayList<Integer>();
		aluFind = 0;
		bugFind = 0;
	}
	public abstract boolean andar(int ir);
	public abstract boolean retroceder(int voltar);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPontuaçao() {
		return pontuaçao;
	}
	public void setPontuaçao(int pontuaçao) {
		this.pontuaçao += pontuaçao;
		if(pontuaçao>0)
			aluFind++;
		else if(pontuaçao<0)
			bugFind++;
			
	}
	public int getAluFind() {
		return aluFind;
	}
	public void setAluFind(int aluFind) {
		this.aluFind = aluFind;
	}
	public int getBugFind() {
		return bugFind;
	}
	public void setBugFind(int bugFind) {
		this.bugFind = bugFind;
	}
	public char getIcone() {
		return icone;
	}
	public void setIcone(char icone) {
		this.icone = icone;
	}
	public void setCoordenadaX(int x) {
		coordenadaX.add(x);
	}
	public void setCoordenadaY(int y) {
		coordenadaY.add(y);
	}
}
