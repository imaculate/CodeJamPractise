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
      CodeJam cj = new CodeJam("D-small-practice-2.in", "D-small-practice-2.out");
   
      cj.solve();
      //cj.output();
   
      cj.bw.flush();
      cj.bw.close();
   }
   


	public static StringBuilder permutation(StringBuilder sb) { 
			Random rn = new Random();
			int pos = rn.nextInt(26);
			int pos2 =  rn.nextInt(26);
			while(pos2==pos){	
				pos2 =  rn.nextInt(26);
			}
			String one = sb.charAt(pos)+"";	
			String two = sb.charAt(pos2)+"";
			sb = sb.replace(pos, pos+1,two );
			sb = sb.replace(pos2, pos2+1,one );
			return sb;
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
			 System.out.println("Case #" + (i + 1));
			 StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			 String s = "";
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            boolean impossible = false;
            for(int j = 0; j< N; j++){
				s = arr[j];
				if(s.length()==1){
					sb=new StringBuilder("IMPOSSIBLE");
					impossible = true;
					break;
				}
				
			}
			boolean permute = !impossible;
		
			while(permute){
				permute = false;
				
				for(int j = 0; j< N; j++){
					s = arr[j];
					if(sb.indexOf(s)>=0){
						permute = true;
						break;
					}	
					
				}
				if(permute)
					sb = permutation(sb);
			
			}
            
           
			StringBuilder res = new StringBuilder();
            res.append("Case #" + (i + 1) + ": "+sb.toString());
                       
            try {
               bw.write(res.toString());
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
