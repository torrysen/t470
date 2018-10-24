package privateClassMock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import mockit.Deencapsulation;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;
public class privatepropertyMockTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testFetchData() {
        final privatepropertyMock service = new privatepropertyMock();
        Deencapsulation.setField(service, "url", "http://unmi.cc");
 
        String actual = service.fetchData("Unmi");
        System.out.println("actual=" + actual);
        Assert.assertEquals("http://unmi.cc", actual);
    }


}
