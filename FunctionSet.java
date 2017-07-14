/* This Class Contains:
	 * XOR function
	 * Shuffle Function
	 * file/DIR check function
	 * Percentage function
	 * openfile function
	 */
	import java.io.File;
	import java.io.IOException;
	import java.io.RandomAccessFile;
	import java.util.Scanner;

public class FunctionSet {
	Scanner inscan=new Scanner(System.in);
		
	public static void xor(RandomAccessFile in,RandomAccessFile temp,String key)
		{
			int len_var=0;
			try
			{
				long incount=in.length();int p=0;double percent;
				for(int j=0; j<=incount-1;j++)
				{
					int intchr=in.read();
					temp.write(intchr^key.charAt(len_var));
								
					len_var++;		
						if(len_var>key.length()-1)		
							len_var=0;
					percent=percentage(p,incount);
					p++;
					System.out.println("Current Progress:"+percent + "%"); 	
				}
			}
			catch(Exception e){
							
			}
		}


	public static void shuffle(RandomAccessFile in,RandomAccessFile out)
		{
		
		try {
			int p=0;
			double percent;
			long count=in.length();

			for(long i=count-1;i>=0;i--)	
				{
				    //Writing on file>>
				 	in.seek(i);		//set cursor of TEMP file at last >> i=count-1
					out.seek(p);		//set cursor of output file to start >> p=0
					int ch =in.read(); //read() from TEMP
					out.write(ch);		//write it at start of output file				
					p=p+1;				//increment p
					 
					percent=percentage(p,count);
			    	System.out.println("Current Progress:"+percent + "%"); 	
				}
		} catch (IOException e) {
			System.out.println(e); 	
		}
	 	
		
		}




	public static int check(String filename)
	{	
		int flag=0;	 
	    File filechk = new File(filename);
	        if(filechk.isFile())
	        	flag=1;
			else if(filechk.isDirectory())
			    flag=2;
		if(flag!=1&&flag!=2)
			System.out.println("'"+filename+"'"+" is not a Valid FILE/DIRECTORY!");
	 return flag;
		
	}

	public static double percentage(long no, long total)			//percent function
	{
		double per = (no*100.0)/total; 
		per = per * 100;		
	    per = Math.round(per);	
	    per = per/100;			
	    return per;
	}

	
	
	public static void openfile()
	{
		int flag=0;
		String filename="";
		do
		{
		System.out.println("Enter Name of the File to be opened:");		
		FunctionSet obj=new FunctionSet();
		filename=obj.inscan.next();
		flag=FunctionSet.check(filename);
		}while(flag!=1);
		
		try {
			RandomAccessFile in=new RandomAccessFile(filename,"r");
			int check=0;
			while(check==0)
			{	
				String str=in.readLine();
				if(str==null)
					{	check=1;
						break;
					}
				else
					System.out.println(str);
				
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
				}
		
	}
	
	

public static void delencf(String dirname)
{
	FunctionSet obj=new FunctionSet();
	System.out.println("Do you want to delete the Encrypted file which is decrypted?\nEnter Y for yes and N for No:");
	String ch=obj.inscan.next();
	
	if(ch=="y"||ch=="Y")
	{
	File f = new File(dirname+"/enc.txt");	
	 if(f.delete())
		 System.out.println("Useless Temporary and Encrypted Files deleted to save Memory!");
	 else 
		 System.out.println("\nCouldn't Locate Temp files to delete!");
	}
}



}
