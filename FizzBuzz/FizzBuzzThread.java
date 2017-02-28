import java.util.*;
public class FizzBuzzThread extends Thread{
   private boolean div3, div5;
   private int max;
   private String toPrint;
   protected static int current = 1;
   private static Object lock = new Object();
   
   public FizzBuzzThread(boolean div3, boolean div5, int n, String toPrint){
      this.div3 = div3;
      this.div5 = div5;
      this.max = n;
      this.toPrint = toPrint;
   }
   
   
   public void run(){
     while(true){
         //synchronized(lock){
            if(current>max){
               return;
             }
           
         if(((current%3 == 0) == div3) && ((current%5 == 0) == div5)){
            print();
            current++;

          }
        //}
        
      }
   }
   
   public void print(){
      System.out.println(toPrint);
   }
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter max:");
      
      int n = sc.nextInt();
      FizzBuzzThread[] threads = { new FizzBuzzThread(true, true, n, "FizzBuzz" ),
                           new FizzBuzzThread(true, false, n, "Fizz" ),
                           new FizzBuzzThread(false, true, n, "Buzz" ),
                           new NumberThread(false, false, n )};
     for(Thread thread: threads){
         thread.start();
     }
   
   }
   
}