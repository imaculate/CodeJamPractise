public class NumberThread extends FizzBuzzThread{
    
   public NumberThread(boolean div3, boolean div5, int n){
      super(div3, div5, n, null);    
   }
   
   
   public void print(){
      System.out.println(current);
      }
}