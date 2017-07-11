import java.util.Scanner;

class encr
{
	static boolean flag=true;
    public static void main(String[] args) 
    {
    	fxns obj=new fxns();			//make object of functions class
    	
    	
    	while(flag)
    	{
    		Scanner chscanner =new Scanner(System.in);
    		System.out.println("============================================================");
    		System.out.println("    1.ENCRYPT a file \t 2.DECRYPT a file \t 3.EXIT");
    		System.out.println("============================================================");
    		System.out.println("Enter Your Choice:\t");
    		int ch=chscanner.nextInt();
    			
    		switch(ch)
    		{
    		case 1:			
    	    	obj.encrypt();
    	    	
    			break;
    			
    		case 2:  			
    	    	obj.decrypt();	
    			break;
    			
    		case 3:
    			flag=false;
    			chscanner.close();
    			break;
    			
    		default:
    			System.out.println("Wrong Input! Please Enter again...");	
    		}
    		
    	}
    	
   	}

}
 