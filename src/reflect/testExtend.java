package reflect;

import java.lang.reflect.Field;

public class testExtend {
	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
		
		MyAccount t = new MySsAccount();
		
		Field[] fs = MyAccount.class.getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			System.out.println(f.getName());
			System.out.println(f.get(t));
		}
		
		MyAccount t1 = new MySsAccount();
		Field f1 = MyAccount.class.getDeclaredField("sql");
		f1.setAccessible(true);
		System.out.println(f1.get(t1));
	}
}
