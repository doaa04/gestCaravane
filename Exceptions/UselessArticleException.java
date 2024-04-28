package mainClasses;
public class UselessArticleException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UselessArticleException(String message) {
		super(message);
		System.err.println("Une exception UselessArticleException a été levée:"+ message);
	}

}


