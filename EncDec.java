
	import java.io.IOException;
	import java.io.RandomAccessFile;
	import java.util.Scanner;

public class EncDec {
		int flag=0;
		double percent;
		String filename="",dirname="";
		Scanner inputscanner =new Scanner(System.in);
		
		
		void encrypt()			//encrypt function
		{
			try{
				
				do
				{
				System.out.println("Enter Name of the File to be Encrypted(include path if outside):");				
				filename=inputscanner.next();
				flag=FunctionSet.check(filename);
				}while(flag!=1);
				
				do
				{
				System.out.println("Enter Name of Directory to store Encrypted file:");				
				dirname=inputscanner.next();
				flag=FunctionSet.check(dirname);
				}while(flag!=2);
				          
				RandomAccessFile in = new RandomAccessFile(filename, "rw");  
		    	RandomAccessFile out = new RandomAccessFile(dirname+"/enc.txt", "rw"); 

		    	System.out.println("Enter Your Private Key to Encrypt the file(REMEMBER it for Decryption):");
				String key=inputscanner.next();
				
				//Apply XOR
				FunctionSet.xor(in, out, key);
	System.out.println("\nFile ENCRYPTED Successfully as 'enc.txt', Stored at"+"'"+dirname+"'");
		    	 //Release resources
		    	 in.close();out.close();
		    	}    	
		catch ( IOException e) {
			System.out.println(e);
			}
	    }
			
		
		
		void decrypt() //decrypt fxn
		{
			try{
				do
				{
				System.out.println("Enter Name of the Encrypted File that is to be Decrypted(include path if outside):");				
				filename=inputscanner.next();
				flag=FunctionSet.check(filename);
				}while(flag!=1);

				//Get Original Extension for Decryption
				System.out.println("Enter EXTENSION to which file is to be Decrypted(e.g txt,pdf,jpg,mp3,mp4,etc):");
			    String extname = inputscanner.next();
			    extname=extname.substring(extname.lastIndexOf(".") + 1);	//if user provided a '.' with extension
	   
				do
				{
				System.out.println("Enter Name of Directory where Decrypted file will be Stored:");				
				dirname=inputscanner.next();
				flag=FunctionSet.check(dirname);
				}while(flag!=2);

		 		RandomAccessFile in = new RandomAccessFile(filename, "rw");
		    	RandomAccessFile out = new RandomAccessFile(dirname+"/dec."+extname, "rw");
		
				System.out.println("Enter Your Private KEY to decrypt the file:");
				String key=inputscanner.next();
				FunctionSet.xor(in,out,key);

				System.out.println("\nFile DECRYPTED Successfully as dec."+extname+", Stored at "+"'"+dirname+"'");

				FunctionSet.delencf(dirname);
		    	 //release resources
		    	 in.close();out.close();
		    	}
	catch ( IOException e) {
		 System.out.println(e);
					}		
		}

}
