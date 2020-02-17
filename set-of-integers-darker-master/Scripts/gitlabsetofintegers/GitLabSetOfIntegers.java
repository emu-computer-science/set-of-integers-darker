package gitlabsetofintegers;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GitLabSetOfIntegers {

    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        CollectionSetIntegers csi = new CollectionSetIntegers();
        while(1 == 1)
        {
            System.out.println("\n\n Commands: \n show \n new \n select \n delete \n sort "
                    + "\n reverse \n randomize \n save \n restore "
                    + "\n quit \n\n Enter Command\n\n");
            String command = kb.nextLine();
            command = command.toLowerCase();
            
            if(command.equals("show"))
            {
            	for(int i = 0; i < csi.count; i++)
            	{
            		if(csi.intset.get(i) == csi.GetSelected())
            		{
            			System.out.println("*" +((char)(i+65)) + ".  " + csi.intset.get(i).Display());
            		}
            		else
            		{
            		System.out.println(((char)(i+65)) + ".  " + csi.intset.get(i).Display());
            		}
            	}
            }
            else if(command.equals("new"))
            {
             	String input = "";
            	String x = "";
                System.out.println("Enter a number to add to the set or type quit");
                x = kb.nextLine().toLowerCase();
            	while(!(x.equals("quit")))
            	{
                 input += x + ":";
                 System.out.println("Enter a number to add to the set or type quit");
                 x = kb.nextLine().toLowerCase();
            	}
            	csi.NewSet(input);
            }
            else if(command.equals("select"))
            {
                System.out.println("Enter the character of the set you want to select:");
                char y = kb.next().charAt(0);
                y = Character.toUpperCase(y);
                int select = y - 65;
                csi.SetSelected(select);
            }
            else if(command.equals("delete"))
            {
                if(csi.GetSelected() == null)
                    NoSetSelected("delete");
                else {
                	csi.DeleteSet();
                	System.out.println("Selected Set Removed");
                }
            }
            else if(command.equals("sort"))
            {
                if(csi.GetSelected() == null)
                    NoSetSelected("sort");
                else
                    csi.GetSelected().Sort();
            }
            else if(command.equals("reverse"))
            {
                if(csi.GetSelected() == null)
                    NoSetSelected("reverse");
                else
                    csi.GetSelected().Reverse();
            }
            else if(command.equals("randomize"))
            {
                if(csi.GetSelected() == null)
                    NoSetSelected("randomize");
                else
                    csi.GetSelected().Randomize();
            }
            else if(command.equals("save"))
            {
                System.out.println("Enter name of file");
                String fileName = kb.nextLine();
                try{
                    Save(fileName, csi);
                    System.out.println("The state has bee saved to " + fileName);
                }
                catch(Exception e){
                    System.out.println("Unable to save state to " + fileName);
                }
            }
            else if(command.equals("restore"))
            {
                System.out.println("Enter name of file");
                String fileName = kb.nextLine();
                try{
                    csi = Restore(fileName);
                    System.out.println("The state has been restore to " + fileName);
                }
                catch(Exception e){
                    System.out.println("Unable to restore state to " + fileName);
                }
            }
            else if(command.equals("quit"))
            {
                System.out.println("Thank you for your time");
                break;
            }
            else
            {
                System.out.println("Sorry that is not a command, try again");
            }
            
        }
    }
    
    private static void Save(String s, CollectionSetIntegers csi) throws FileNotFoundException, IOException
    {
        FileOutputStream f = new FileOutputStream(new File(s));
        ObjectOutputStream o = new ObjectOutputStream(f);
        
        o.writeObject(csi);
        
        o.close();
        f.close();
    }
    
    private static CollectionSetIntegers Restore(String s) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fi = new FileInputStream(new File(s));
        ObjectInputStream oi = new ObjectInputStream(fi);
        
        CollectionSetIntegers rtn = (CollectionSetIntegers)oi.readObject();
        
        oi.close();
        fi.close();
        return rtn;
    }
    
    private static void TestSetOfIntegers()
    {
        String s = "6 5 4 3";
        SetOfIntegers set = new SetOfIntegers(s,0);
        System.out.println(set.Display());
        
        set.Sort();
        set.Reverse();
        set.Randomize();
    }
    
    private static void NoSetSelected(String s)
    {
        System.out.println("There is no currently selected set to " + s);
    }
}
