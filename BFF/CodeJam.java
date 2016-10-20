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
   private int[] mapping;
   private int N;
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
        
      // read in each case  **some cases have more than one line
      //all numbers must appear in even number, if frequency is odd, it is missing
         for (int i = 1; i <= cases; i++){
            N  =  Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            mapping  = new int[N+1];
            for(int j = 1; j<=N;j++){
               mapping[j] = Integer.parseInt(arr[j-1]);
            }
            
            
            int ans = treeTraverse( new ArrayList<Integer>());                    
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
   
   private int treeTraverse( ArrayList<Integer> sofar){
      int len  = sofar.size();
      int maxlen = len;
      if(len==0 || (len>1 && len<N &&mapping[sofar.get(len-1)]== sofar.get(len-2))){
         for(int i = 1; i<=N; i++){
            if(!sofar.contains(i)){
               ArrayList<Integer> chain = new ArrayList<>(sofar);
               chain.add(i);
               
               maxlen = Math.max(maxlen, treeTraverse(chain));
               
            }
         }
         return maxlen;
      }
      else if( mapping[sofar.get(len-1)]==sofar.get(0) || (len==N &&mapping[sofar.get(len-1)]==sofar.get(len-2)) ){
           
         return len; //end of circle
      }
      else if(len==N &&mapping[sofar.get(len-1)]!=sofar.get(0) && mapping[sofar.get(len-1)]!=sofar.get(len-2)){
            return -1;
         
         
      }
      
      
      
      else if(sofar.contains(mapping[sofar.get(len-1)])){
         return -1;//impossible
      }
      else{//nothing special, just add the best friend and move on
         ArrayList<Integer> chain = new ArrayList<>(sofar);
         chain.add(mapping[sofar.get(len-1)]);
         return treeTraverse(chain);
      
        
      }
      
   }
   
   
   	
   
     
}
