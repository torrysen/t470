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
// https://unmi.cc/jmockit-mock-private-methods-fields/
public class privateMethodMockTest1 {

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
 
        new Expectations(privateMethodMock.class) {
            {
                Deencapsulation.invoke(privateMethodMock.class, "fetchDataFromDB", "Unmi");
                result = "http://unmi.cc.tochy";
            }
        };
        

        new Expectations(privateMethodMock.class) {
            {
                Deencapsulation.invoke(privateMethodMock.class, "fetchDataFromDB", "Unmi");
                result = "http://unmi.cc.tochy";
            }
        };
 
        String actual = privateMethodMock.fetchData("Unmi");
        System.out.println("actual=" + actual);
        Assert.assertEquals("http://unmi.cc.tochy", actual);
        
        String tmp = "CUR8801";
        System.out.println(tmp.substring(0,3));
        System.out.println(tmp.substring(3,7));
    }

}
