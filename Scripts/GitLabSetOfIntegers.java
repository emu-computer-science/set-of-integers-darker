
package gitlabsetofintegers;

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
                
            }
            else if(command.equals("new"))
            {
                
            }
            else if(command.equals("select"))
            {
                
            }
            else if(command.equals("delete"))
            {
                if(csi.GetSelected() == null)
                    NoSetSelected("delete");
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
                
            }
            else if(command.equals("restore"))
            {
                
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
    
    private static void TestSetOfIntegers()
    {
        String s = "6 5 4 3";
        SetOfIntegers set = new SetOfIntegers(s);
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
