package ci.bourse.renouv.utils;

import java.sql.Timestamp;
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

	public static final String CLASSIQUE_FORMAT = "dd-MM-yyyy";
	private static final String DEFAULT_FORMAT = "dd/MM/yyyy";

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

	/**
	 * Permet de retourner l'année en cours
	 * 
	 * @return
	 */
	public static Integer getAnneeScolaireCourante(){
		final Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Permet de formater une date avec le format par défaut.
	 * 
	 * @param date
	 * @return
	 */
	public static String format(final Date date){

		return toString(date, DEFAULT_FORMAT);
	}

	/**
	 * Copie une date vers une nouvelle (crée une nouvelle instance)
	 * 
	 * @param date
	 * @return
	 */
	public static Date copyOf(final Date date){
		Date res = null;
		if (date != null) {
			res = (Date) date.clone();
		}
		return res;
	}

	/**
	 * Copie une timestap vers une nouvelle (crée une nouvelle instance)
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp copyOf(final Timestamp date){
		Timestamp res = null;
		if (date != null) {
			res = (Timestamp) date.clone();
		}
		return res;
	}

	/**
	 * savoir si deux dates sont égales sans tenir compte de heure etc
	 * 
	 * @param date
	 * @param dateRef
	 * @return : vrai si c'est égale
	 */
	public static boolean isDateEgale(final Date date, final Date dateRef){
		boolean egale = true;
		if ((date != null) && (dateRef != null)) {
			final Calendar dateCourante = Calendar.getInstance();
			dateCourante.setTime(date);
			dateCourante.clear(Calendar.HOUR_OF_DAY);
			dateCourante.clear(Calendar.MINUTE);
			dateCourante.clear(Calendar.SECOND);
			dateCourante.clear(Calendar.MILLISECOND);

			final Calendar dateReference = Calendar.getInstance();
			dateReference.setTime(dateRef);
			dateReference.clear(Calendar.HOUR_OF_DAY);
			dateReference.clear(Calendar.MINUTE);
			dateReference.clear(Calendar.SECOND);
			dateReference.clear(Calendar.MILLISECOND);

			egale = dateCourante.compareTo(dateReference) == 0;
		}

		return egale;
	}
}
