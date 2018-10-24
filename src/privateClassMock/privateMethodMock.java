package privateClassMock;

public class privateMethodMock {
    public static String fetchData(String name){
        System.out.println("call MyService.fetchData");
        System.out.println("20171210".substring(0,6));
        String testStr1 = "2-1-1";
        String testStr2 = "2-1-28";
        System.out.println(testStr1.substring(testStr1.lastIndexOf("-") + 1));
        System.out.println(testStr2.substring(testStr2.lastIndexOf("-") + 1));
        
        System.out.println(getPubMd("1"));
        return fetchDataFromDB(name);
    }
    
    private static String fetchDataFromDB(String name){
        throw new RuntimeException("Not implemented yet!");
    }

    public static String getPubMd(String name){
       return "trueData";
    }
}
