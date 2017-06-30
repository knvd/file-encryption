//GO THROUGH THE encr.java CODE FIRST.
//Code by Naveed Jeelani,Please give feedback if it was useful

	
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class decr {

	public static void main(String[] args) 
    {
    	try{
			//Get Filename from USER to be Decrypted
			boolean ans1;	
			String filename;
		do
		{			
			Scanner filescanner =new Scanner(System.in);
			System.out.println("Enter Name of the Encrypted File that is to be Decrypted(include path if outside):");
			filename = filescanner.next();
	        File filechk = new File(filename);
	        ans1=!filechk.isFile();		//check if it is valid FILE
	        if(ans1) System.out.println("'"+filename+"'"+" is not a Valid FILE!");
		}while(ans1);
    		
		
    			 //Get Original Extension for Decryption
		    Scanner extscanner =new Scanner(System.in);
			System.out.println("Enter EXTENSION to which file is to be Decrypted(e.g txt,pdf,jpg,mp3,mp4,etc):");
		    String extname = extscanner.next();
		    extname=extname.substring(extname.lastIndexOf(".") + 1);	//if user provided a '.' with extension
   
	 		//Get Directory name where Decrypted file will be saved
				boolean ans;	//To Store value of !dirchk.isDirectory()
				String dirname;
			do
			{			
				Scanner dirscanner =new Scanner(System.in);
				System.out.println("Enter Name of Directory where Decrypted file will be Stored:");
				dirname = dirscanner.next();
		        File dirchk = new File(dirname);
		        ans=!dirchk.isDirectory();	//check if it is valid DIRECTORY	
		        if(ans) System.out.println("'"+dirname+"'"+" is not a Valid Directory. Check Again!");
			}while(ans);   
		       
		    
    		RandomAccessFile in = new RandomAccessFile(filename, "rw");
	    	RandomAccessFile temp = new RandomAccessFile(dirname+"/dtmp.txt", "rw");
	    	RandomAccessFile out = new RandomAccessFile(dirname+"/dec."+extname, "rw");

	    	long incount=in.length();			//length() returns long
	    	System.out.println("No of characters in file:"+incount);
	    		
	    	
	    		//Get Unique Private Key from USER to decrypt
	    	Scanner keyscanner =new Scanner(System.in);
			System.out.println("Enter Your DECRYPTION KEY to decrypt the file: ");
			String key=keyscanner.nextLine();
			
			//Calculating Sum of the Key
			
			int len = key.length();
			//System.out.println("The Length of key is:"+len);
			int sum= 0;
			for(int i=0; i<=len-1;i++)
			{
				int k=key.charAt(i);	
				sum = sum + k;		
			}

			//DEcrypt using key
			int chr=0;	
			for(int j=0; j<=incount-1;j++)
			{
				chr=in.read();
				temp.write(chr^sum);		//Same XOR(^) to Decrypt
			}
			long count=temp.length(); 

			//APLLY DESHUFFLING
		    
			   int p=0;
		    	for(long i=count-1;i>=0;i--)	//Reverse Loop
				{
		    			//PERCENTAGE LOGIC >>
		    		long m=incount-1;
					double per = (p*100.0)/m; 
			        per = per * 100;
			        per = Math.round(per);
			        per = per/100;
			        System.out.println("Decrypting characters to File:"+per + "%");
		    		
		    		
		    		    //Writing on file>>
		    		 temp.seek(i);		//set cursor of TEMP file at last >> i=count-1
					 out.seek(p);		//set cursor of output file to start >> p=0
					int ch =temp.read(); //read() from TEMP
					out.write(ch);		//write it at start of output file
					
					 p=p+1;				
				}
		    	
		    	
			
	    	 System.out.println("\nFile DECRYPTED Successfully as dec."+extname+", Stored at "+"'"+dirname+"'");
	    	 	
	    	 File f1 = new File(dirname+"/dtmp.txt");	//delete the temporary file
	    	 File f2 = new File(dirname+"/enc.txt");	//DELETE THE ENCRYPTED FILE AFTER DECRYPTION
	    	 if(f1.delete()&&f2.delete())
	    	 {
	    		 System.out.println("Useless Temporary files deleted to save Memory!");
	    	 }
	    	 else 
	    	 {
	    		 System.out.println("\nCouldn't Locate Temp files to delete!");
	    	 }

	    	 //release resources
	    	 in.close();
	    	 out.close();
	    	 temp.close();
	    	 keyscanner.close();
	      	 extscanner.close();
	    	 
	    	 
		        
	    	}
 
catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
}    


