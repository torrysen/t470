package reflect1;

public class Ship implements TansportMeans {

	String vehicleName;
	int A, B, C; // 构造方法

	public Ship(String vehicleName, int a, int b, int c) {
		this.vehicleName = vehicleName;
		A = a;
		B = b;
		C = c;
	}

	@Override
	public void getSpeed() {
		System.out.println(vehicleName + "的速度是:" + ((A + B) * C));
	}

}
