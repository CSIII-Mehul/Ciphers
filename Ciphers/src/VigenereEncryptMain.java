import java.util.*;
import java.io.*;
public class VigenereEncryptMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("vigenere.dat"));
		Scanner keyboard = new Scanner(System.in);
		scan.nextLine();
		String key= "";
		String raw= "";
		int select =3;
		while(scan.hasNext())
		{
		 
		   System.out.println("What is the key you want to use to encrypt?");
		   key= keyboard.nextLine();
		   key = key.toUpperCase();
		   raw= scan.nextLine();
		   System.out.println(Vigenere(raw, key));
		   
		     
		}

	}
	
	
	public static String Vigenere(String raw, String key)
	{
	    String encrypted = "";
	    
	    for (int i=0, counter= 0; i<raw.length(); i++, counter++)
	    {
	      if (counter == key.length())
	           counter= 0; 
	    
	      if(raw.charAt(i)!= ' ')
	        {
	         encrypted += ""+ converted(raw.charAt(i), key.charAt(counter));
	         System.out.println(key.charAt(counter));
	         
	         
	        }
	      else if(raw.charAt(i) == ' ')
	      {
	        --counter;
	        encrypted += " ";
	      }
	      
	     
	    }
	    
	
		return encrypted;
	}
	
	public static char converted(char raw, char key)
	{
	   int asc = (int) raw;
	   int asc2= (int) key;
	   
	   asc= asc -65;
	   asc2 = asc2-65;
	   
	   int result = asc +asc2;
	   
	   if(result > 26)
	      result = result - 26;
	      
	   result += 65;
	   
	   char c = (char) result; 
	      
	      
	   
	 return c;
	}

}
