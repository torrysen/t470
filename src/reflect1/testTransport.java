package reflect1;

/**
 * https://blog.csdn.net/qq_21923867/article/details/60882017
 * https://www.jianshu.com/p/31e4b1a0ade7
 * 
 * 首先每种交通工具都需要一个单独的类，其中有交通工具种类，A，B，C四个成员变量，并且要有计算速度的getSpeed方法 
  然后需要一个主类，接收键盘数据，并初始化交通工具类，创建其对象并调用getSpeed方法以输出相应的数据
  需要接口，抽象出不同的交通工具子类的getSpeed方法，但由于接口不能实例化，无法利用接口直接调用各类的getSpeed方法
  最后创建一个Speed类，创建vehicleMethod方法，以接口对象为参数，
  在方法中调用各自的getSpeed方法，从而可以在主类中实现对象调用方法

 */

import java.lang.reflect.Constructor;

public class testTransport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test testTransport");
		ss();

	}

	public static void ss() {
		String vehicleName = "Car2";
		try {
			// 获取输入的类的字节码文件对象
			Class vehicleClass = Class.forName("reflect1.Car");

			// 获取构造方法,并将键盘接受的数据传入对其进行初始化
			Constructor constructor = 
					vehicleClass.getConstructor(String.class, int.class, int.class, int.class);
			// 创建接口对象。父类的引用指向子类的实例,实现多态
			TansportMeans t = (TansportMeans) constructor.newInstance(vehicleName, 2, 3, 6); // 创建speed对象,实现对vehicleMethod方法的调用
			Speed vehicle = new Speed();
			vehicle.vehicleMethod(t);
		} catch (Exception e) {

		}

	}
}
