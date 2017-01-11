package ci.bourse.renouv.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ci.bourse.renouv.exception.MetierException;

/**
 * Utilitaire de gestion des dates.
 * 
 * @author euchoux
 */
public class DateUtils {

	public static final String formatClassique = "dd-MM-yyyy";

	public DateUtils() {
	}

	/**
	 * Convertir un {@link String} en {@link Date}.
	 * 
	 * @param string
	 * @return
	 * @throws MetierException
	 */
	public static Date fromString(final String string, final String format) throws MetierException {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(string);
		} catch (final ParseException ex) {
			throw new MetierException(ex);
		}
	}

	/**
	 * Convertir une {@link Date} en {@link String}.
	 * 
	 * @param t
	 * @return
	 */
	public static String toString(final Date t, final String format) {
		return new SimpleDateFormat(format).format(t);
	}
}
