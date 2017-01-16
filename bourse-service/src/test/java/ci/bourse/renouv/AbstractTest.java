package ci.bourse.renouv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public abstract class AbstractTest extends DBTestCase {

	protected List<String> dataSetFileList = new ArrayList<String>();

	private IDataSet fullDataSet = null;

	public AbstractTest() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
				"org.hsqldb.jdbcDriver");

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:hsqldb:mem:bourse");

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "test");

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "test");
	}

	@Override
	protected IDataSet getDataSet() throws Exception{

		if (CollectionUtils.isEmpty(dataSetFileList)) {
			return new DefaultDataSet();
		}
		final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();

		final List<ITable> tables = new ArrayList<ITable>();

		for (final String dataSetFileName : dataSetFileList) {
			final FlatXmlDataSet autreDataSet = builder.build(
					this.getClass().getResourceAsStream("/datas/" + dataSetFileName));

			if (autreDataSet.getTables() != null) {
				tables.addAll(Arrays.asList(autreDataSet.getTables()));
			}
		}

		fullDataSet = new FilteredDataSet(
				new DatabaseSequenceFilter(getConnection()),
				new DefaultDataSet(tables.toArray(new ITable[tables.size()])));

		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), fullDataSet);

		return fullDataSet;
	}

	@Override
	@Before
	public void setUp() throws Exception{
		super.setUp();
	}

	@After
	@Override
	public void tearDown() throws Exception{
		super.tearDown();
		dataSetFileList = new ArrayList<String>();
		if (fullDataSet != null) {
			DatabaseOperation.DELETE_ALL.execute(getConnection(), fullDataSet);
		}
	}

}
