import java.util.*;
import java.io.*;

public class AtbashMain {

	public static void main (String[] args) throws IOException {
         Scanner scan= new Scanner(new File("atbash.dat"));
        // scan.next();
         Scanner keyboard = new Scanner(System.in);
         int select=0;
         String converted = "";
         String raw= "";
         
         
         while (select != 1 && select != 2)
         {
          System.out.println("Do you want to decrypt or encrypt? 1 for either");
          select= keyboard.nextInt();	     
         }
         
         if(select ==1)
         {
            raw= scan.nextLine();
            
            String [] split = raw.split("");
            
            for(int i =0; i< split.length; i++)
            {
            	if (split[i].charAt(0) != ' ') 
            	{
            	   converted += ""+ Atbash(split[i].charAt(0), select);
            	}
            	else if(split[i].charAt(0) == ' ')
            	{
            	   converted += ' ';
            	}
            }
            
         }
      
         System.out.println(converted);
             	
	}
	
  public static char Atbash(char let, int select)
  {
       char changed ='A';
  
       if(select == 1)
       {
          int letter= (int)let;
          letter= letter -65;
          letter= 25- letter;
          letter += 65;
          
          changed = (char) letter;
       }
      
      
       return changed;
  }
}
