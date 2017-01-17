package ci.bourse.renouv.utils;

import java.util.Calendar;

import ci.bourse.renouv.exception.MetierException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for GenererJetonSaml.
 */
public class DateUtilsTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DateUtilsTest(final String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DateUtilsTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws MetierException
	 */
	public void testFromString() throws MetierException {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 04, 22, 0, 0, 0);
		assertEquals(cal.getTime().getTime(), DateUtils.fromString("22-05-1980", DateUtils.CLASSIQUE_FORMAT).getTime());
	}

	public void testToString() throws MetierException {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 04, 22, 0, 0, 0);
		assertEquals("22-05-1980", DateUtils.toString(cal.getTime(), DateUtils.CLASSIQUE_FORMAT));
	}

	public void testBorneMinDate() throws MetierException {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2017, Calendar.JANUARY, 1, 0, 0);
		assertEquals(cal.getTime(), DateUtils.borneMinDate(2017));
	}

	public void testBorneMaxDate() throws MetierException {
		final Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2017, Calendar.DECEMBER, 31, 23, 59);
		assertEquals(cal.getTime(), DateUtils.borneMaxDate(2017));
	}

}
