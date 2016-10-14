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
      CodeJam cj = new CodeJam("B-large-practice.in", "B-large-practice.out");
   
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
         int N;
      // read in each case  **some cases have more than one line
      //all numbers must appear in even number, if frequency is odd, it is missing
         for (int i = 1; i <= cases; i++){
            N  =  Integer.parseInt(br.readLine());
            
            HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
             
            for(int j = 0; j<2*N-1; j++){
               line = br.readLine(); 
               String[] arr = line.split(" ");
               for(int k = 0; k< N; k++){
                  int n = Integer.parseInt(arr[k]);
                  counts.put(n, counts.getOrDefault(n, 0) + 1);
               }
            }
            
            int[] missing = new int[N];
            int r = 0;
            for(Integer n: counts.keySet()){
               
               if(counts.get(n)%2!=0){
                  missing[r] =n;
                  r++;
                } 
             }
             Arrays.sort(missing);
             String ans = "";
             for(int j = 0; j< N; j++){
               ans+= missing[j]+ " ";
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
