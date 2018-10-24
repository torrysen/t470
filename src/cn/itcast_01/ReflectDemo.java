package cn.itcast_01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 
 * @author ZhenShengSu
 * 
        Method[] methods = c.getMethods(); // 获取自己的包括父亲的公共方法
        Method[] methods = c.getDeclaredMethods(); // 获取自己的所有的方法
 *
 */

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException  {
    	//test01();
    	//test02();
    	test05();
    }
    
    static void test01() throws ClassNotFoundException{
        // 方式1
        Person p = new Person();
        Class c = p.getClass();
        Person p2 = new Person();
        Class c2 = p2.getClass();
        System.out.println(p == p2);// false
        System.out.println(c == c2);// true
        // 方式2
        Class c3 = Person.class;
        // int.class;
        // String.class;
        System.out.println(c == c3);
        // 方式3
        // ClassNotFoundException
        Class c4 = Class.forName("cn.itcast_01.Person");
        System.out.println(c == c4);	
    }
    
    static void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        // 获取字节码文件对象
        Class c = Class.forName("cn.itcast_01.Person");
        // 获取带参构造方法对象
        // public Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor con = c.getConstructor(String.class, int.class,
                String.class);
        // 通过带参构造方法对象创建对象
        // public T newInstance(Object... initargs)
        Object obj = con.newInstance("林青霞", 27, "北京");
        
        System.out.println(obj);
    }
    
    static void test03() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 获取字节码文件对象
        Class c = Class.forName("cn.itcast_01.Person");
        // 获取私有构造方法对象
        // NoSuchMethodException：每个这个方法异常
        // 原因是一开始我们使用的方法只能获取公共的，下面这种方式就可以了。
        Constructor con = c.getDeclaredConstructor(String.class);
        // 用该私有构造方法创建对象
        // IllegalAccessException:非法的访问异常。
        // 暴力访问
        con.setAccessible(true);// 值为true则指示反射的对象在使用时应该取消Java语言访问检查。
        Object obj = con.newInstance("风清扬");
        System.out.println(obj);
    }
    
    static void test04() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        // 获取字节码文件对象
        Class c = Class.forName("cn.itcast_01.Person");
        // 获取所有的成员变量
        // Field[] fields = c.getFields();
        // Field[] fields = c.getDeclaredFields();
        // for (Field field : fields) {
        // System.out.println(field);
        // }
        /*
         * Person p = new Person(); p.address = "北京"; System.out.println(p);
         */
        // 通过无参构造方法创建对象
        Constructor con = c.getConstructor();
        Object obj = con.newInstance();
        System.out.println(obj);
        // 获取单个的成员变量
        // 获取address并对其赋值
        Field addressField = c.getField("address");
        // public void set(Object obj,Object value)
        // 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
        addressField.set(obj, "北京"); // 给obj对象的addressField字段设置值为"北京"
        System.out.println(obj);
        // 获取name并对其赋值
        // NoSuchFieldException
        Field nameField = c.getDeclaredField("name");
        // IllegalAccessException
        nameField.setAccessible(true);
        nameField.set(obj, "林青霞");
        System.out.println(obj);
        // 获取age并对其赋值
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj, 27);
        System.out.println(obj);
    }
    
    static void test05() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        // 获取字节码文件对象
        Class c = Class.forName("cn.itcast_01.Person");
        // 获取所有的方法
        // Method[] methods = c.getMethods(); // 获取自己的包括父亲的公共方法
        // Method[] methods = c.getDeclaredMethods(); // 获取自己的所有的方法
        // for (Method method : methods) {
        // System.out.println(method);
        // }
        Constructor con = c.getConstructor();
        Object obj = con.newInstance();
        /*
         * Person p = new Person(); p.show();
         */
        // 获取单个方法并使用
        // public void show()
        // public Method getMethod(String name,Class<?>... parameterTypes)
        // 第一个参数表示的方法名，第二个参数表示的是方法的参数的class类型
        Method m1 = c.getMethod("show");
        // obj.m1(); // 错误
        // public Object invoke(Object obj,Object... args)
        // 返回值是Object接收,第一个参数表示对象是谁，第二参数表示调用该方法的实际参数
        m1.invoke(obj); // 调用obj对象的m1方法
        System.out.println("----------");
        // public void method(String s)
        Method m2 = c.getMethod("method", String.class);
        m2.invoke(obj, "hello");
        System.out.println("----------");
        // public String getString(String s, int i)
        Method m3 = c.getMethod("getString", String.class, int.class);
        Object objString = m3.invoke(obj, "hello", 100);
        System.out.println(objString);
        // String s = (String)m3.invoke(obj, "hello",100);
        // System.out.println(s);
        System.out.println("----------");
        // private void function()
        Method m4 = c.getDeclaredMethod("function");
        m4.setAccessible(true);
        m4.invoke(obj);
    }    
    
    
    
    
}