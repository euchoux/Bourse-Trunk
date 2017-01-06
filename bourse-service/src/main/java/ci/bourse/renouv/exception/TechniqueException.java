package ci.bourse.renouv.exception;

/**
 * Exception gérant les erreurs techniques.
 * 
 * @author euchoux
 */
public class TechniqueException extends Exception {

	private static final long serialVersionUID = 4450024010891163274L;

	public TechniqueException() {
	}

	/**
	 * @param message
	 */
	public TechniqueException(final String message) {
		super(message);
	}

	/**
	 * @param e
	 */
	public TechniqueException(final Throwable e) {
		super(e);
	}

	/**
	 * @param message
	 * @param e
	 */
	public TechniqueException(final String message, final Throwable e) {
		super(message, e);
	}

}
