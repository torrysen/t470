package reflect;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;


public class reflectType<T> {
	private Map<String, Integer> list = null;
	private T t;

	public static void main(String[] args) {
//		testmd1();
		testmd2();

	}
	

	public static void testmd1() {

    Field field;
	try {
		field = reflectType.class.getDeclaredField("list");
	    Type type = field.getGenericType();

	    if (type instanceof ParameterizedType) {
	        ParameterizedType pType = (ParameterizedType) type;
	        Type[] types = pType.getActualTypeArguments();

	        System.out.println(types[0]);// class java.lang.String
	        System.out.println(types[1]);// class java.lang.Integer
	        System.out.println(pType.getRawType());// class java.lang.Integer 
	    }
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	

	public static void testmd2() {
        System.out.println("testmd2 test start");
	try {
        Field field = reflectType.class.getDeclaredField("t");

        Type type = field.getGenericType();

        if (type instanceof TypeVariable) {
            TypeVariable tType = (TypeVariable) type;

            GenericDeclaration genericDeclaration = tType.getGenericDeclaration();
            System.out.println(genericDeclaration);//class reflect.reflectType
            System.out.println(tType.getName());//class reflect.reflectType
        }
        
        System.out.println("testmd2 test end");
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}
}
