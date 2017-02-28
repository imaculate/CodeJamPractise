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
      
      // read in each case  **some cases have more than one line
         for (int i = 0; i < cases; i++){
            String leader = "";
            int maxCount = -1;
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + (i + 1) + ": ");
                 
            String name;
            int count;
            for(int j =0; j<N; j++){
               name = br.readLine();
               count = countUnique(name);
               if(count>maxCount || ((count ==maxCount)&& (name.compareTo(leader)<0))){
                  maxCount = count;
                  leader = name;
               }
            } 
            sb.append(leader);                 
            try {
               bw.write(sb.toString());
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

   private int countUnique(String name){
     boolean[] letters = new boolean[26];
     for(int j = 0; j< name.length(); j++){
        int index = name.charAt(j) - 'A'; //space is 32 , behind A, hence negative
         if(index >=0 ){
            letters[index] = true;
         }
     }
     int count = 0;
     for(int j = 0; j<26; j++){
      if(letters[j])
         count++;
     }
     return count;
     
      
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