package ci.bourse.renouv;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/application-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class AbstractTest extends DBTestCase {


	public AbstractTest() {
	}

	/**
	 * Chargement des données en base (avant chaque test). Utilisation de
	 * DBSetup (effacement de toutes les données puis insertion).
	 */
	@Override
	@Before
	public void setUp() {
	}


	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
