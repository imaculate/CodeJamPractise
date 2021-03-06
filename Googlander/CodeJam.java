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
   long[][] table = new long[26][26];

   public CodeJam(String inFile, String outFile) {
      this.inFile = new File(inFile);
      this.outFile = new File(outFile);
   }

   public static void main(String[] args) throws IOException {
   // inFile and outFile
      CodeJam cj = new CodeJam("D-small-practice.in", "D-small-practice.out");
   
      cj.solve();
      //cj.output();
   
      cj.bw.flush();
      cj.bw.close();
   }

   private void solve() throws FileNotFoundException {
      try {
         br = new BufferedReader(new FileReader(inFile));
         bw = new BufferedWriter(new FileWriter(outFile));
         prepareTable();
        
      
      // solve problem
      // get total number of cases from the first line
         cases = Integer.parseInt(br.readLine());
        
         
      // read in each case  **some cases have more than one line
         for (int i = 1; i <= cases; i++){
           String[] arr = br.readLine().split(" ");
           int R = Integer.parseInt(arr[0]);
           int C = Integer.parseInt(arr[1]);
           long ans = -1;
           if(table[R][C]!=-1){
            ans = table[R][C];
           }else{
            ans = solve(R,C);
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
   
   private void prepareTable(){
      for(int i=0;i<26; i++){
         for(int j=0; j<26; j++){
            table[i][j]=-1;
         }
      }
            
   }
     
   private long solve(int r, int c){
      if(r==1 || c==1){
            table[r][c]=1;
       } 
       if(table[r][c]==-1){
           long ans = 0;
           for(int i = 1; i<=r; i++){
               ans+= solve(c-1, i);
           }
		     table[r][c] = ans;
        }
        return table[r][c];
   
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
