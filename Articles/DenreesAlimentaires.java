package mainClasses;

public class DenreesAlimentaires extends Article {
	
	static int denreesAlimentairesDisponibles = 0;

	public DenreesAlimentaires(int idArticle) {
		super(idArticle);
		denreesAlimentairesDisponibles++;
	}

}
