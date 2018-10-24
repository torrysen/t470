package innerClass;

public class OuterClassB {
    public void display(){
        System.out.println("haha--torrysen--OuterClass...");
    }
    
    public class InnerClass{
        public OuterClassB getOuterClass(){
        	// 可以使用OuterClassName.this，这样就能够产生一个正确引用外部类的引用了。
        	// 当然这点实在编译期就知晓了，没有任何运行时的成本
            return OuterClassB.this;
        }
    }
    
    public static void main(String[] args) {
    	// 对于一个名为OuterClass的外围类和一个名为InnerClass的内部类，
    	// 在编译成功后，会出现这样两个class文件：OuterClass.class和OuterClass$InnerClass.class
    	OuterClassB outerClass = new OuterClassB();
    	OuterClassB.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.getOuterClass().display();
    }
}