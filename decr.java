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
			Scanner fnamescanner =new Scanner(System.in);
			System.out.println("Enter Name of the Encrypted File that is to be Decrypted:");
		    String filename = fnamescanner.next();


		    File chk = new File(filename);	//File Handler to check if any file of that name exists			
if(!chk.exists())	
	{
		System.out.println("The File [" +filename+"] doesnot exist.Check Again!");	
	}
else
	{
			 //Get Original Extension for decryption
		    Scanner extscanner =new Scanner(System.in);
			System.out.println("Enter EXTENSION to which file is to be Decrypted(e.g txt,pdf,jpg,mp3,mp4,etc):");
		    String extname = extscanner.next();
		    extname=extname.substring(extname.lastIndexOf(".") + 1);	//if user provided a '.' with extension
    		
    		RandomAccessFile in = new RandomAccessFile(filename, "rw");
	    	RandomAccessFile temp = new RandomAccessFile("dtmp.txt", "rw");
	    	RandomAccessFile out = new RandomAccessFile("dec."+extname, "rw");

	    	long incount=in.length();			//length() returns long
	    	System.out.println("No of characters in file:"+incount);
	    		
	    	
	    		//Get Unique Private Key from USER to decrypt
	    	Scanner keyscanner =new Scanner(System.in);
			System.out.println("Enter Your Key to decrypt the file: ");
			String key=keyscanner.nextLine();
			
			//Calculating Sum of the Key
			
			int len = key.length();
			System.out.println("The Length of key is:"+len);
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
		    	
		    	
			
	    	 System.out.println("\nFile DECRYPTED Successfully!");
	    	 	
	    	 File f1 = new File("dtmp.txt");	//delete the temporary file
	    	 File f2 = new File("enc.txt");	//DELETE THE ENCRYPTED FILE AFTER DECRYPTION
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
	    	 fnamescanner.close();
	    	 extscanner.close();
	    	 
	    	 
		        
	    	}
    }
catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
}    


