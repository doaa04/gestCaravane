package mainClasses;

abstract class Article {
	
	private int idArticle; 
	protected Paquet paquet;
	List<Paquet> tousLesPaquets = new ArrayList<>();
		
	public Article(int idArticle) {
		this.idArticle = idArticle;
		this.paquet = null;
	}
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public Paquet getPaquet() {
		return paquet;
	}
	
	public void setPaquet(Paquet paquet) throws UselessArticleException {
		 for (Paquet autrePaquet : tousLesPaquets) {
		        if (autrePaquet.listeArticles.contains(this)) {
		            throw new UselessArticleException("L'article est déjà dans un autre paquet.");
		        }
		    }
		this.paquet = paquet;
		paquet.listeArticles.add(this);
	}
			
}
