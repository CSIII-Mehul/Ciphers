import java.util.*;
import java.io.*;
public class VigenereDecryptMain {
     
	
	public static void main (String[] args) throws IOException{
		
		Scanner scan= new Scanner(new File("vigenere.dat"));
		Scanner keyboard = new Scanner(System.in);
		scan.nextLine();
		String raw = "";
		String key = "";
		String decrypted ="";
		while(scan.hasNext())
		{
		   raw = scan.nextLine();
		   System.out.println("What key?");
		   key= keyboard.nextLine();
		   key= key.toUpperCase();
		   decrypted = Vigenere(raw, key);
		   System.out.println(decrypted);
		}
		
		
	}
	
	
	public static String Vigenere(String raw, String key)
	{
	
	  String solved = "";
	  int counter =0;
	  for(int i=0; i< raw.length(); i++)
	  {
	      if(raw.charAt(i) != ' ')
	      {
	          solved+= "" +converted(raw.charAt(i), key.charAt(counter));
	      }
	      else if(raw.charAt(i) == ' ')
	      {
	         solved += " ";
	         counter--;
	      } 
	     
	     counter++;
	     
	     if(counter == key.length())
	     {
	       counter =0;
	     }
	  
	  }
	  
	
	  return solved;
	}
	
	public static char converted(char raw, char key)
	{
	   int asc = (int) raw;
	   int asc2 = (int) key;
	   
	   asc -= 65;
	   asc2 -= 65;
	   
	   int result =0; 
	   if(asc-asc2 < 0)
	      result = asc-asc2 + 26;
	   else 
	       result = asc-asc2;
	       
	   result += 65;
	       
	  char re = (char) result; 
	      
	   
	   
	   return re;
	}
}
