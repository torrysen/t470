package comparator;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Collections; 
import java.util.List; 


public class Student implements Comparable<Student> { 
    // 並び順にあまり意味はない…並び替えの名前もテキトー 
     public static enum SortMethod { 
         SORT_METHOD1,   /* 学年(ASC) > 学級(ASC) > 名前(ASC) > 班長(T>F) */ 
         SORT_METHOD2,   /* 学年(DSC) > 学級(ASC) > 名前(ASC) > 班長(T>F) */ 
     } 
     // まあ、そんなことをする人はいないと思うけど、ここはstaticじゃないとまずいですよ。 
     public static SortMethod method = SortMethod.SORT_METHOD1;   // めんどーなんでpubic 
     private int     grade;     /* 学年 */ 
     private String  clazz;     /* 学級 */ 
     private String  name;      /* 名前 */ 
     private boolean isLeader;  /* 班長 */ 
     // こんすとらくたー 
     public Student(int grade, String clazz, String name, boolean isLeader) { 
         this.grade = grade; 
         this.clazz = clazz; 
         this.name = name; 
         this.isLeader = isLeader; 
     } 
     // 以下無駄に長いgetter, setter ... 
     public int getGrade() { 
         return grade; 
     } 
     public void setGrade(int grade) { 
         this.grade = grade; 
     } 
     public String getClazz() { 
         return clazz; 
     } 
     public void setClazz(String clazz) { 
         this.clazz = clazz; 
     } 
     public String getName() { 
         return name; 
     } 
     public void setName(String name) { 
         this.name = name; 
     } 
     public boolean isLeader() { 
         return isLeader; 
     } 
     public void setLeader(boolean isLeader) { 
         this.isLeader = isLeader; 
     } 
     // 以上無駄に長いgetter, setter ... 
     @Override 
     public int compareTo(Student rhs) { 
         if (method == SortMethod.SORT_METHOD1) { 
             /* 学年(ASC) > 学級(ASC) > 名前(ASC) > 班長(T>F) */ 
             // Integer.valueOfでint -> Integerに変えているのが微妙…だけどまぁいいか。 
             int result = Integer.valueOf(this.grade).compareTo(Integer.valueOf(rhs.grade)); 
             if (result == 0) { 
                 result = this.clazz.compareTo(rhs.clazz); 
             } 
             if (result == 0) { 
                 result = this.name.compareTo(rhs.name); 
             } 
             if (result == 0) { 
                 result = Boolean.valueOf(this.isLeader).compareTo(Boolean.valueOf(rhs.isLeader)); 
             } 
             return result; 
         } 
         else if (method == SortMethod.SORT_METHOD2) { 
             /* 学年(DSC) > 学級(ASC) > 名前(ASC) > 班長(T>F) */ 
             int result = -Integer.valueOf(this.grade).compareTo(Integer.valueOf(rhs.grade)); 
             if (result == 0) { 
                 result = this.clazz.compareTo(rhs.clazz); 
             } 
             if (result == 0) { 
//                 result = this.name.compareTo(rhs.clazz);
            	 result = this.name.compareTo(rhs.name); 
             } 
             if (result == 0) { 
                 result = Boolean.valueOf(this.isLeader).compareTo(Boolean.valueOf(rhs.isLeader)); 
             } 
             return result; 
         } 
         return 0; 
     } 
     // めんどいんで、しゅつりょくをおーばーらいどしとく 
     @Override 
     public String toString() { 
         return "学年 [" + this.grade + "] クラス [" + this.clazz + "] 名前 [ " 
                 + String.format("%1$-20s", this.name)  // 20文字右スペース埋め (こんな便利なメソッドあったんだ) 
                 + "] " + (isLeader ? "班長" : ""); 
     } 
     public static void main(String[] args) { 
         // テキトーにデータをぶち込む 
         List<Student> students = new ArrayList<>( 
                 Arrays.asList( 
                     new Student(6, "A", "Robin Givens", true), 
                     new Student(6, "A", "Richard Burgi", false), 
                     new Student(2, "A", "Sarah Walker", false), 
                    new Student(2, "A", "Jon Casey", false), 
                    new Student(2, "B", "Morgan Grimes", false), 
                    new Student(1, "A", "Elenor Batorwski", false), 
                    new Student(6, "B", "Agatha Christie", true), 
                    new Student(5, "A", "Tony Todd", true), 
                    new Student(5, "A", "Matthew Bomer", false), 
                    new Student(4, "A", "Linda Hamilton", false), 
                    new Student(3, "A", "Lauren Cohan", true), 
                    new Student(2, "A", "Chales Bartowski", true), 
                    new Student(5, "B", "Rachel Bilson", true), 
                    new Student(4, "A", "Nicole Richie", false), 
                    new Student(1, "B", "Devon Woodcomb", false) 
                ) 
        ); 
        Student.method = Student.SortMethod.SORT_METHOD1; 
        Collections.sort(students); 
        for (Student s : students) { 
            System.out.println(s); 
        } 
        System.out.println("------------------------------------------------"); 
        Student.method = Student.SortMethod.SORT_METHOD2; 
        Collections.sort(students); 
        for (Student s : students) { 
            System.out.println(s); 
        } 
        System.out.println("------------------------------------------------"); 
    } 
} 
