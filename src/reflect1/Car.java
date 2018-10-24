package reflect1;

public class Car implements TansportMeans {

	String vehicleName;
	int A, B, C;

	/** * @Description:car类构造方法,用于初始化类 */
	public Car(String vehicleName, int a, int b, int c) {
		this.vehicleName = vehicleName;
		A = a;
		B = b;
		C = c;
	}

	/** * @Description:car类计算速度的方法 */
	@Override
	public void getSpeed() {
		System.out.println(vehicleName + "的速度是:" + (A * B / C));
	}

}
