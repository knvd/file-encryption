import java.util.Scanner;

public class start {
	static boolean flag=true;
    
	public static void main(String[] args) {
	
				EncDec obj=new EncDec();
		    	while(flag)
		    	{
		    		Scanner chscanner =new Scanner(System.in);
		    		System.out.println("\n===============================================================\n 1.ENCRYPT a file \t 2.DECRYPT a file \t 3.Open a File\n 4.Exit Program\n===============================================================");
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
		    			FunctionSet.openfile();		//Static Call
		    			break;
		    		case 4:
		    			flag=false;
		    			System.out.println("Good Bye!");	
		    			chscanner.close();
		    			break;
		    		default:
		    			System.out.println("Wrong Option! Please Enter again...");	
		    		}	
		    	}	
		   	}
		}

