package mainClasses;

public class Medicament extends Article {
	
	static int medicamentsDisponibles = 0;
	
	public Medicament(int idArticle) {
		super(idArticle);
		medicamentsDisponibles++;
	}

}
