package trabalho;
import java.util.ArrayList;

public class Celula {
	protected int posX;
	protected int posY;
	private int id;
	private boolean temRobo;
	private boolean tinhaRobo;
	private int quantRobos;
	private ArrayList<RoboInicial> celulaRobo;
	protected Componentes comp;
	
	
	public Celula(int id, int y, int x) {
		celulaRobo = new ArrayList<RoboInicial>();
		this.id = id;
		this.posX = x;
		this.posY = y;
		temRobo = false;
		tinhaRobo = false;
		quantRobos = 0;
		comp = new Componentes();
	}
	public String imprimirCelula() {
		if(temRobo)
			return (celulaRobo.get(celulaRobo.size()-1).getIcone()+" ");
		else if(tinhaRobo) {
			if(comp.checarComponenteAluno() || comp.checarComponenteBug())
				return (comp.imprimirComponente()+" ");
			else
				return ("& ");
		} else {
			return ("* ");
		}
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTemRobo() {
		return temRobo;
	}
	public void setTemRobo(boolean temRobo) {
		this.quantRobos++;
		this.temRobo = temRobo;
	}

	public boolean isTemAluno() {
		return comp.checarComponenteAluno();
	}

	public void setTrueTemAluno() {
		comp.adicionarAluno();
	}

	public boolean isTemBug() {
		return comp.checarComponenteBug();
	}

	public void setTrueTemBug() {
		comp.adicionarBug();
	}

	public int getQuantRobos() {
		return quantRobos;
	}

	public void setQuantRobos(int quantRobos) {
		this.quantRobos += quantRobos;
		if(this.quantRobos <= 0) {
			this.temRobo = false;
			this.tinhaRobo = true;
	}else
		this.temRobo = true;
}
	public void setCelulaRobo(RoboInicial robo) {
		celulaRobo.add(robo);
		setQuantRobos(1);
	}
	public void removeCelulaRobo(RoboInicial robo) {
		celulaRobo.remove(robo);
		setQuantRobos(-1);
	}



	public boolean isTinhaRobo() {
		return tinhaRobo;
	}



	public void setTinhaRobo(boolean tinhaRobo) {
		this.tinhaRobo = tinhaRobo;
	}


	public Componentes getComp() {
		return comp;
	}

	public void setComp(Componentes comp) {
		this.comp = comp;
	}
	
}
