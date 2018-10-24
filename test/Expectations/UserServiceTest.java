package Expectations;

import org.junit.*;  
import org.junit.runner.RunWith;  
  
import mockit.*;  
import mockit.integration.junit4.JMockit;  
  
@RunWith(JMockit.class)  
public final class UserServiceTest {  
    @Tested  
    @Mocked  
    private JMockitObject jMockitObject;  
  
    @Injectable  
    private UserService userService;  
  
    @Test  
    public void testDealUser() {  
        new NonStrictExpectations() {// 录制预期模拟行为  
            {  
                userService.getUserName(anyInt);//mock public方法  
                result = "zero";// 也可以使returns("zero");  
                times = 1;  
  
                Deencapsulation.invoke(jMockitObject, "sys", anyString);//mock private方法  
                // sys()无返回值，没定义result,则调用的结果返回空，故result = null; 可写可不写  
                result = null;  
            }  
        };  
        jMockitObject.dealUser();//回放  
    }  
  
    @Test  
    public void testSys() {  
        Deencapsulation.invoke(jMockitObject, "sys", "Hello World!");//测试private方法  
    }  
  
    @Test  
    public void testStaticField() {// mock 静态私有属性  
        new NonStrictExpectations(Utils.class) {  
            {  
                Deencapsulation.setField(Utils.class, "URL_STRING",  
                        "www.baidu.com");  
            }  
        };  
        // 第二种方式：  
        // new MockUp<Utils>() {  
        // {  
        // // 修改静态私有属性  
        // Deencapsulation.setField(Utils.class, "URL_STRING",  
        // "www.baidu.com");  
        // }  
        // };  
        String str = Deencapsulation.getField(Utils.class, "URL_STRING");  
        Assert.assertEquals("www.baidu.com", str);  
    }  
  
    @Test  
    public void testStaticFunction() {// mock 静态私有方法  
        new MockUp<Utils>() {  
            @Mock  
            private void deal() {// 注意在MockUp中的方法除了不包含static关键字以外，其他都和被Mock的方法签名相同，并且使用@Mock标注  
                System.out.println("mock deal2() ");  
                String[] xx = new String[] {"1", "2"};
                System.out.println(xx.toString());  
            }  
        };  
        Deencapsulation.invoke(Utils.class, "deal");  
    }  
  
    @Test  
    public void testGetString() {  
        new NonStrictExpectations() {  
            {  
                Deencapsulation.invoke(jMockitObject, "getObject",  
                        withAny(JMockitObject.class), withAny(String.class));// 不能使用any这样的参数，否则必须使用正确类型的参数；  
                // withAny(JMockitObject.class), anyString); 可以  
            }  
        };  
        new NonStrictExpectations(Utils.class) {  
            {  
                Utils.getObject((JMockitObject) any, anyString);  
                returns("zero");  
            }  
        };  
  
        Assert.assertEquals("zero", jMockitObject.getString());  
    }  
}  

