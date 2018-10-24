package Expectations;
import javax.annotation.Resource;  

public class JMockitObject {
    @Resource  
   private UserService userService;  
 
   public void dealUser() {  
       String name = userService.getUserName(1);  
       System.out.println("userService.getUserName() : " + name);  
       sys(name);  
   }  
 
   private void sys(String name) {  
       System.out.println("sys() : " + name);  
   }  
 
   public String getString() {  
       getObject(this, "/zero");  
       return Utils.getObject(this, "/zero");  
   }  
 
   private void getObject(JMockitObject object, String str) {  
        System.out.println("--------");  
   }  

}
