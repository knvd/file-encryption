//Code by Naveed Jeelani,Please give feedback if it was useful

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
class encr
{
    public static void main(String[] args) 
    {
    	try{
    				//Get Filename from USER to be Encrypted
    		Scanner fnamescanner =new Scanner(System.in);
    		System.out.println("Enter Name of the File to be Encrypted:");
            String filename = fnamescanner.next();

    		File chk = new File(filename);	//File Handler to check if any file of that name exists			
	if(!chk.exists())	
		{
				System.out.println("The File [" +filename+"] doesnot exist.Check Again!");	
		}
	else
		{
    		RandomAccessFile in = new RandomAccessFile(filename, "rw");  //input file to be encrypted 
	    	RandomAccessFile temp = new RandomAccessFile("tmp.txt", "rw"); //use as intermediate, to hold the file XOR-ed with key
	    	RandomAccessFile out = new RandomAccessFile("enc.txt", "rw"); // used to hold the shuffled the XOR-ed file

	    	long incount=in.length();		//length() returns long    
	    	System.out.println("No of characters in file:"+incount);
	    	
	    	
	    	//Get Desired Private Key from USER
	    	Scanner keyscanner =new Scanner(System.in);
			System.out.println("Enter Your Key to encrypt the file: ");
			String key=keyscanner.nextLine();
	
				//Calculating Sum of the Key
			int len = key.length();
			System.out.println("The Length of key is:"+len);
			int sum= 0;
			for(int i=0; i<=len-1;i++)
			{
				int k=key.charAt(i);
				sum = sum + k;		//Getting sum of the key =>charAt() returns integer value
			}

			//Encrypt using key
			int chr=0;	
			for(int j=0; j<=incount-1;j++)
			{
				chr=in.read();				//read from input file
				temp.write(chr^sum);		//XOR the char and write to TEMP file
			}
			
			long count=temp.length();		

			//APPLLY SHUFFLING
	    
		   int p=0;
	    	for(long i=count-1;i>=0;i--)	
			{
	    			//PERCENTAGE LOGIC >>
	    		long m=count-1;
				double per = (p*100.0)/m; 
		        per = per * 100;				//get 2 places from Right side of decimal to Left side
		        per = Math.round(per);			//Drop the Decimal part
		        per = per/100;					//get 2 places back to right side
		        System.out.println("Encrypting characters to File:"+per + "%");
	    		
	    		
	    		    //Writing on file>>
	    		 temp.seek(i);		//set cursor of TEMP file at last >> i=count-1
				 out.seek(p);		//set cursor of output file to start >> p=0
				int ch =temp.read(); //read() from TEMP
				out.write(ch);		//write it at start of output file
				
				 p=p+1;				//increment p
			}
	    	
	    	 System.out.println("\nFile ENCRYPTED Successfully!");
	    	 System.out.println("Encrypted File name is 'enc.txt'");

	    	 
	    	//delete the TEMP file
	    	 File tmp = new File("tmp.txt");	
	    	 tmp.delete();	
	    
	    	 //Release resources
	    	 in.close();
	    	 out.close();
	    	 temp.close();
	    	 fnamescanner.close();
	    	 keyscanner.close();
		
		        
	    	}
    	}
	catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    }
    

   
}
 
