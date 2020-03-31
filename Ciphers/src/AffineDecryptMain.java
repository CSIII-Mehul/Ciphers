
import java.io.*;
import java.util.*;

public class AffineDecryptMain {

	public static void main (String[] args) throws IOException{
		Scanner scan= new Scanner(new File("affinede.dat"));
		Scanner keyboard= new Scanner(System.in);

        String  info= scan.nextLine();
    	String[] infos= info.split(" ");
        
    	int inv_a = 0;
    	int b= 0;
    	boolean inv_A = false;
		for(int i =0; i< infos.length; i++) 
		{
		  for(int num=0; num<101; num++)
		  {
			  if(inv_A== false && infos[i].equals(""+num))
			  {
				  inv_a = Integer.parseInt(infos[i]);
				  inv_A= true;
				  continue;
			  }
			  if(inv_A== true && infos[i].equals(""+num))
			  {
				  b = Integer.parseInt(infos[i]);

			  }

		  }
		}
		
		System.out.println("What do you want \"inv_a\" to be?");
        inv_a= keyboard.nextInt();
        System.out.println("What do you want \"b\" to be?");
        b = keyboard.nextInt();
		
	    ArrayList<String> decrypts = new ArrayList<>();
	    String decrypted = "";
	    String raw = "";
		while(scan.hasNext()) 
		{
			raw= scan.nextLine();
			for(int i=0; i< raw.length(); i++)
			{
				if(raw.charAt(i)!= ' ') 
				{
					decrypted += ""+ Affine(inv_a, b,raw, i);
				}
				else if(raw.charAt(i) == ' ') 
				{
					decrypted += " ";
				}
			}
			decrypts.add(decrypted);
					
		}
		for(int counter=0; counter< decrypts.size(); counter++)
	    	System.out.println(decrypts.get(counter));
      		
	}
	
	public static char Affine(int inv_a, int b, String raw, int index) 
	{
		
		int asc= (int) raw.charAt(index);
		asc = asc-65;
		int expression = (inv_a * (asc-b)) % 26 +26;
		if(expression == 26)
		 expression= 0+65;
		else
		 expression = expression+65;
		
		char val= (char) expression;
		
		return val;
	}

}
