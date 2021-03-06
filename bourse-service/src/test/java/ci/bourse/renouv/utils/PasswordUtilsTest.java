package ci.bourse.renouv.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for GenererJetonSaml.
 */
public class PasswordUtilsTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public PasswordUtilsTest(final String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PasswordUtilsTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testHacherMessageSHA256() {
		
		assertEquals("bcaed298a3779a4488a5137abb6b5faa",
				PasswordUtils.hacherMessageSHA256("login", "motDePasse"));

		assertTrue(PasswordUtils.isPasswordValid("bcaed298a3779a4488a5137abb6b5faa", "login" + "motDePasse"));

	}
}
