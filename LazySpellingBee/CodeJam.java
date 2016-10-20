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
   //global variables
   
   public CodeJam(String inFile, String outFile) {
      this.inFile = new File(inFile);
      this.outFile = new File(outFile);
   }

   public static void main(String[] args) throws IOException {
   // inFile and outFile 
      CodeJam cj = new CodeJam("A-large-practice.in", "A-large-practice.out");
   
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
         String s;
        
      // read in each case  **some cases have more than one line
      //all numbers must appear in even number, if frequency is odd, it is missing
         for (int i = 1; i <= cases; i++){
            
            s = br.readLine();
            long ans = 1;
            int count = 1;
          
            for(int j = 0;j< s.length(); j++){
               count = 1;
               if(j-1>=0 && s.charAt(j-1)!=s.charAt(j) ){
                  count++;
               }
               
               if((j+1)<s.length() && s.charAt(j+1)!=s.charAt(j) && (j-1<0 || s.charAt(j+1)!=s.charAt(j-1) )){
                  count++;
               }
               ans*= count;
               ans%=  1000000007;
               
            } 
                   
            String res = "Case #"+i+ ": "+ ans;
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
   
         
      
  

   
   	
   
     
}
