package innerClass;
// 在Java中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类。
// 在成员内部类中要注意两点，第一：成员内部类中不能存在任何static的变量和方法；
// 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
public class OuterClassC {
    private String str;
    
    public void outerDisplay(){
        System.out.println("OuterClassC...");
    }
    
    public class InnerClass{
        public void innerDisplay(){
            //使用外围内的属性
            str = "chenssy...";
            System.out.println(str);
            //使用外围内的方法
            outerDisplay();
        }
    }
    
    /*推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 */
    public InnerClass getInnerClass(){
        return new InnerClass();
    }
    
    public static void main(String[] args) {
        OuterClassC outer = new OuterClassC();
        OuterClassC.InnerClass inner = outer.getInnerClass();
        inner.innerDisplay();
    }
}