
import java.io.*;
import java.util.*;
public class AffineEncryptMain{
   
	
	public static void main (String[] args) throws IOException{
	
		Scanner scan= new Scanner(new File("affine.dat"));
		Scanner keyboard= new Scanner(System.in);

		String encrypt= "";
		String info=scan.nextLine();
    	String[] infos= info.split(" ");
    	
    	int a= 0;
    	int b= 0;
        for(int i =0; i< infos.length; i++)
        {
        	if(infos[i].equals(";")) 
        	{
        		a= Integer.parseInt(infos[i-1]);
        	    for(int j= i; j<infos.length ; j++)
        	    {
        	    	boolean checker = false;
        	    	for(int num=0; num<100 ;num++)
        	    	{
        	    		if((""+infos[j]+"").equals(""+num+""))
        	    			{ 
        	    			  b= Integer.parseInt(infos[j]);
        	    		      checker= true;
        	    		      break;
        	    			}
        	    	}
        	    	
        	    	if(checker== true)
        	    	{
        	    		break;
        	    	}
        	    }
        		
        	}
        	
        }
        
        System.out.println("What do you want \"a\" to be?");
        a= keyboard.nextInt();
        System.out.println("What do you want \"b\" to be?");
        b = keyboard.nextInt();
        
        String zed = "ABCDEFG";
        int asc = (int) zed.charAt(0);
        //Affine(a,b,zed,0);
        
        ArrayList<String> encrypts= new ArrayList<>();
        
        while(scan.hasNext()) 
        {
          	encrypt= scan.nextLine();
          	String encrypted ="";
          	for(int counter =0; counter<encrypt.length(); counter++) 
          	{
          		if(encrypt.charAt(counter) != ' ')
          		{
                    char val = Affine(a,b,encrypt,counter);
                    encrypted += ""+ val;

          		}
          		else if (encrypt.charAt(counter) == ' ') 
          		{
          			encrypted += " ";
          		}
                //Affine(a,b,encrypt,counter);

          	}
          	encrypts.add(encrypted);
          			
        }
        
        for(int c= 0; c<encrypts.size(); c++)
         System.out.println(encrypts.get(c));
       
      
    /*
      a = 7 ; b = 14
      WINGARDIUM LEVIOSA

     */
		
	}
	public static char Affine(int a, int b, String select, int index) {
		
        int asc = (int) select.charAt(index);
        asc= asc-65;
        
        int expression= (a*asc + b) % 26;
        
        asc= expression+65;
        
        char ans= (char) asc;
        
        
		return ans;
	}
}
