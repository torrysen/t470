package reflect1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 
 * @author ZhenShengSu
 *http://xiaoxuejie.iteye.com/blog/1346551
 *通过反射机制获取位于同一个包下的接口的所有实现类
 */

public class ClassUtils {
	public static void main(String[] args) {
		List<Class> classList = null;
		try {
			System.out.println("case 2-----------------------");
			classList = getAllImplClassesByInterface(TansportMeans.class);
			for(Class c:classList) {
				System.out.println(c.getName());
			}
			
			
			System.out.println("case 1-----------------------");
			classList = getClassesByPackageName("reflect1");
			for(Class c:classList) {
				System.out.println(c.getName());
			}
			

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Class> getAllImplClassesByInterface(Class c) {

        // 给一个接口，返回这个接口的所有实现类 
        List<Class> returnClassList = new ArrayList<Class>();// 返回结果 
        // 如果不是一个接口，则不做处理 
        if (c.isInterface()) { 
            String packageName = c.getPackage().getName();// 获得当前包名 
            try { 
                List<Class> allClass = getClassesByPackageName(packageName);// 获得当前包下以及包下的所有类 
                for (int i = 0; i < allClass.size(); i++) { 
                    /**
                     * 判定此 Class 对象所表示的类或接口与指定的 Class 参数cls所表示的类或接口是否相同，
                     * 或是否是其超类或(超)接口，如果是则返回 true，否则返回 false。
                     */
                    if (c.isAssignableFrom(allClass.get(i))) {
                        if (!c.equals(allClass.get(i))) {// 本身加不进去 
                            returnClassList.add(allClass.get(i)); 
                        } 
                    } 
                } 
            } catch (ClassNotFoundException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            } catch (IOException e) { 
                // TODO: handle exception 
                e.printStackTrace(); 
            } 
        } 
        return returnClassList;  
	}
	
	static List<Class> getClassesByPackageName(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); 
        String path = packageName.replace('.', '/'); 
        Enumeration<URL> resources = classLoader.getResources(path); 
        List<File> dirs = new ArrayList<File>(); 
        while (resources.hasMoreElements()) { 
            URL resource = resources.nextElement(); 
            dirs.add(new File(resource.getFile())); 
        } 
        ArrayList<Class> classes = new ArrayList<Class>(); 
        for (File directory : dirs) { 
            classes.addAll(findClasses(directory, packageName)); 
        } 
        return classes;  
	}
	
    static List<Class> findClasses(File directory, String packageName) 
            throws ClassNotFoundException { 
        List<Class> classes = new ArrayList<Class>(); 
        if (!directory.exists()) { 
            return classes; 
        } 
        File[] files = directory.listFiles(); 
        for (File file : files) { 
            if (file.isDirectory()) { 
                //递归查找文件夹【即对应的包】下面的所有文件
                assert !file.getName().contains("."); 
                /**
                 * J2SE 1.4在语言上提供了一个新特性，就是assertion(断言)功能，它是该版本在Java语言方面最大的革新。在软件开发中，assertion是一种经典的调试、测试方式。

                    在语法上，为了支持assertion，Java增加了一个关键字assert。它包括两种表达式，分别如下：
                   
                    　　assert expression1;
                   
                    　　assert expression1: expression2;
                   
                    　　在两种表达式中，expression1表示一个boolean表达式，expression2表示一个基本类型或者是一个对象(Object) ，基本类型包括boolean,char,double,float,int和long。由于所有类都为Object的子类，因此这个参数可以用于所有对象。
                   
                    　　assert
                   
                    　　如果为true，则程序继续执行。
                   
                    　　如果为false，则程序抛出AssertionError，并终止执行。
                 */
                classes.addAll(findClasses(file, packageName + '.' + file.getName())); 
            } else if (file.getName().endsWith(".class")) { 
                classes.add(Class.forName(packageName + "." + file.getName().substring(0,file.getName().length() - 6))); 
            } 
        } 
        return classes; 
    }
}
