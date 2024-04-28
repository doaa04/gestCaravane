package mainClasses;
import java.util.ArrayList;

public class Paquet {

	private int idPaquet;
	private Famille famille;
	public ArrayList<Article> listeArticles;
	
	public Paquet(int idPaquet, Famille famille) {
		this.setIdPaquet(idPaquet);
		this.famille = famille;
		this.listeArticles = new ArrayList<>();
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
		famille.paquets.add(this);
	}

	public int getIdPaquet() {
		return idPaquet;
	}

	public void setIdPaquet(int idPaquet) {
		this.idPaquet = idPaquet;
	}
		
}
