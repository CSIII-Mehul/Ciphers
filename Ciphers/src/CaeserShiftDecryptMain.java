import java.io.*;
import java.util.*;

public class CaeserShiftDecryptMain {

public static void main (String[] args) throws IOException {
		
		Scanner scan= new Scanner(new File("caeserde.dat"));
		Scanner keyboard = new Scanner(System.in);
		int shift =0;
       
		ArrayList<String> encrypts = new ArrayList<String> ();
		String raw="";
		boolean tries= true;
		int select=0;
		while(scan.hasNext()) 
		{
			raw= scan.nextLine();
			System.out.println(raw);
			System.out.println("How much do you want to shift by?");
			shift = keyboard.nextInt();
			System.out.println(shifter(raw,shift));
			System.out.println("Do you want to try again? Press 1");
			select= keyboard.nextInt();
		    while(select==1)
		    {
		    	System.out.println("How much do you want to shift by?");
				shift = keyboard.nextInt();
				System.out.println(shifter(raw,shift));
				System.out.println("Do you want to try again? Press 1");
				select= keyboard.nextInt();
		    }
		
			

		  
		}
		
		
		
		
	}

public static String shifter(String raw, int shift) 
{
	String shifted= "";
	if(shift>26)
		shift= shift %26;
	for(int i=0; i<raw.length(); i++)
	{
		if(raw.charAt(i)!= ' ')
		{
			char a=raw.charAt(i);
			int asc= (int) a;
			if((asc+shift)-65 > 26)
				{
				asc= (asc+shift)-65-26;
			    asc= asc+65;
				}
			else if((asc+shift)-65 == 26)
			{
				asc=0+65;
			}
			else    
			  asc= asc+shift;
			char changed = (char) asc;
			shifted+= ""+changed;
		}
		else if(raw.charAt(i)== ' ') 
		{
			
			shifted+= " ";
		}
			
	}

	return shifted;
}

	
	
}
