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
    		
    		RandomAccessFile in = new RandomAccessFile("enc.txt", "rw");
	    	RandomAccessFile temp = new RandomAccessFile("dtmp.txt", "rw");
	    	RandomAccessFile out = new RandomAccessFile("dec.jpg", "rw");

	    	long incount=in.length();			//length() returns long
	    	System.out.println("No of characters in file:"+incount);
 	
	    	
	    	Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Your Key to decrypt the file: ");
		String key=scanner.nextLine();
			
		    	//USING KEY
			
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

		
	    	 File f1 = new File("dtmp.txt");	
	    	 File f2 = new File("enc.txt");	
	    	 if(f1.delete()&&f2.delete())	//delete the temporary file and Encrypted file after decryption
	    	 {
	    		 System.out.println("Useless Temporary files deleted to save Memory!");
	    	 }
	    	 else 
	    	 {
	    		 System.out.println("\nCouldn't Locate Temp files to delete!");
	    	 }

		
	    	 //RELEASE ALL RESOURCES
	    	 in.close();
	    	 out.close();
	    	 temp.close();
	    	 scanner.close();
	    	 
		        
	    	} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
}    


