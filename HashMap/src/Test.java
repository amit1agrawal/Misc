import java.util.*;

public class Test {
 
    public static void main(String[] args) {
 
        class MyKey {
            Integer i;
            public MyKey(Integer i){
                this.i =i;
            }
 
            @Override
            public int hashCode() {
            	return 1;
            	/*int key = 2097152-1;
                return key+2097152*i;
*/            }
 
            @Override
            public boolean equals(Object obj) {
            	 if (obj instanceof MyKey) {
                     return i.equals(((MyKey) obj).i);
                 } else
                     return false;
            }
 
        }
        Date begin = new Date();
        Map <MyKey,String> myMap= new HashMap<>(2_500_000,1);
        System.out.println("Created The HashMap");
        for (int i=0;i<2_000_000;i++){
            myMap.put( new MyKey(i), "test "+i);
        }
        System.out.println("Finished putting keys into the HashMap");
        Date end = new Date();
        System.out.println("Duration (ms) "+ (end.getTime()-begin.getTime()));
    }
}