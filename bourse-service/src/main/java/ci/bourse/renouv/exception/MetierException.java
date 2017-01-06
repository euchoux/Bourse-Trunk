package ci.bourse.renouv.exception;

/**
 * Exception gérant les erreurs métiers.
 * 
 * @author euchoux
 */
public class MetierException extends Exception {

	private static final long serialVersionUID = 4450024010891163274L;

	public MetierException() {
	}

	/**
	 * @param message
	 */
	public MetierException(final String message) {
		super(message);
	}

	/**
	 * @param e
	 */
	public MetierException(final Throwable e) {
		super(e);
	}

	/**
	 * @param message
	 * @param e
	 */
	public MetierException(final String message, final Throwable e) {
		super(message, e);
	}

}
