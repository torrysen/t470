package privateClassMock;

public class privatepropertyMock {
    private String url = "";
    
    public String fetchData(String name){
        System.out.println("call MyService.fetchData");
        return this.url;
    }
}
