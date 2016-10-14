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
        
         String line;
         String result;
      // read in each case  **some cases have more than one line
         for (int i = 1; i <= cases; i++){
             line = br.readLine(); 
             char max = line.charAt(0);
             result = max+"";
             for(int j=1; j< line.length(); j++){
               char c = line.charAt(j);
               if(c>= max){
                  result = c+ result;
                  max = c;
               }else{
                  result+= c;
               }
             }           
                        
            String res = "Case #"+i+ ": "+ result;
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
