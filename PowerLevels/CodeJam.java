// Google Code Jam



import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodeJam {
// declare template variables
   BufferedReader br = null;
   BufferedWriter bw = null;
   private File inFile;
   private File outFile;
   private int cases;
   int[] digits;

   public CodeJam(String inFile, String outFile) {
      this.inFile = new File(inFile);
      this.outFile = new File(outFile);
   }

   public static void main(String[] args) throws IOException {
   // inFile and outFile
      CodeJam cj = new CodeJam("C-large-practice.in", "C-large-practice.out");
   
      cj.solve();
      //cj.output();
   
      cj.bw.flush();
      cj.bw.close();
   }

   private void solve() throws FileNotFoundException {
      try {
         br = new BufferedReader(new FileReader(inFile));
         bw = new BufferedWriter(new FileWriter(outFile));
        
      
      // solve problem
      // get total number of cases from the first line
         cases = Integer.parseInt(br.readLine());
         int B = 0;
         prepareTable();
         System.out.println(digits[9000]);
         int t;
         String result = "";
         
      // read in each case  **some cases have more than one line
         for (int i = 0; i < cases; i++){
           
            
            t = Integer.parseInt(br.readLine());
            //binary search
            int hi = 9000;
            int lo = 1;
            int mid=0;
           //edge cases
            if(t>digits[9000]){
               /*while(lo<hi){
                  mid = (hi+lo)/2;
                  if(digits[mid]> t ){
                     lo=mid+1;
                  }
                  else{
                     hi = mid -1;
                  }
               
               }*/
               for(int n = 1; n<=9000; n++){
                  if(digits[n]<t){  
                     
                        mid = n;
                        break;
                      
                  }
                     
               }
               System.out.println(mid);
               StringBuilder res = new StringBuilder("IT'S OVER 9000");
               for(int n=0; n< mid; n++){
                  res.append("!");
               }
               result = res.toString();
            }
            else{
               result = "...";
               
            }
            int m = i+1;    
            String res = "Case #"+m+ ": "+result.toString();
            try {
               bw.write(res);
               bw.newLine();
            } 
            catch (IOException e) {
            // TODO Auto-generated catch block 
               e.printStackTrace();
            }
         
         }
      } 
      catch (IOException e) {
      // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   
   private void prepareTable(){
      digits = new int[9001];
      for(int i = 1; i<=9000;i++){
         double num_digits = 0;
         for(int j = 9000; j>0; j-=i){
            num_digits += Math.log10(j);
         }
         digits[i] = (int)Math.ceil(num_digits);
      }
   }
   
   private void output() {
   // ~edit this method for proper output
   // ~temp is just a placeholder for solution output
      int temp = 0;
   
   // build a string for each case
      for (int i = 0; i < temp; i++) {
         StringBuilder sb = new StringBuilder();
      
         sb.append("Case #" + (i + 1) + ": ");
      // ~output solution per case
      
      // try to append each case output to the file
         try {
            bw.write(sb.toString());
            bw.newLine();
         } 
         catch (IOException e) {
         // TODO Auto-generated catch block e.printStackTrace();
         }
      }
   }
}
