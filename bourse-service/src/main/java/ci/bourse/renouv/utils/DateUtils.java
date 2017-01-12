package ci.bourse.renouv.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	/**
	 * Retourne la date minimale pour une année
	 * 
	 * @param annee
	 * @return
	 */
	public static Date borneMinDate(final Integer annee) {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(annee, Calendar.JANUARY, 1, 0, 0);
		return cal.getTime();
	}

	/**
	 * Retourne la date maximale pour une année
	 * 
	 * @param annee
	 * @return
	 */
	public static Date borneMaxDate(final Integer annee) {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(annee, Calendar.DECEMBER, 31, 23, 59);
		return cal.getTime();
	}
}
