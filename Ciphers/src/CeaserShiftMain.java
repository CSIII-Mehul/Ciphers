
import java.io.*;
import java.util.*;


public class CeaserShiftMain {
      
	public static void main (String[] args) throws IOException {
		
		Scanner scan= new Scanner(new File("Ceaser.dat"));
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How much do you want to shift by?");
		int shift = keyboard.nextInt();
       
		ArrayList<String> encrypts = new ArrayList<String> ();
		String raw="";
		while(scan.hasNext()) 
		{
		   raw= scan.nextLine();   	
		   encrypts.add(shifter(raw,shift));
		  
		   
		}
		
		for(int c=0; c<encrypts.size() ;c++)
		 System.out.println(encrypts.get(c));
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
