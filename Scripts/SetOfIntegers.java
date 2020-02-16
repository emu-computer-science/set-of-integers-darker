
package gitlabsetofintegers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class SetOfIntegers implements Serializable{
    
    private String sortType;
    private ArrayList<Integer> set;
    private boolean desending;
    
    public SetOfIntegers(String s)
    {
        String[] arr =  s.split(" ");
        set = new ArrayList<Integer>();
        for(String str : arr)
            set.add(Integer.parseInt(str));
        
        sortType = "Random";
    }
    
    public String GetSortType()
    {
        return sortType;
    }
    
    public ArrayList<Integer> GetSetOfIntegers()
    {
        return set;
    }
    
    public String Display()
    {
        String str = "";
        for(int i: set)
            str += i + ", ";
        str = str.substring(0, str.length() - 2);
        
        return "[" + sortType + "]{" + str +"}";
    }
    
    public void Sort()
    {
        int counter = 0;
        int n = set.size();
        for(int i = 1; i < n; i++)
        {
            int j = i;
            while(j >= 1 && set.get(j) < set.get(j - 1))
            {
                set.add(j - 1, set.remove(j));
                j--;
                counter++;
            }
        }
        sortType = "increasing";
        System.out.println("It took " + counter + " swaps to sort the set and resulted in " + Display());
    }
    
    public void Randomize()
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(set.size() > 0)
        {
            int r = (int)(Math.random() * set.size());
            temp.add(set.remove(r));
        }
        set = temp;
        sortType = "Random";
        System.out.println("The set has been randomized, resulting in " + Display());
    }
    
    public void Reverse()
    {
        Collections.sort(set, Collections.reverseOrder());
        if(sortType.equals("increasing"))
            sortType = "decreasing";
        else if(sortType.equals("decreasing"))
            sortType = "increasing";
        
        System.out.println("The set has been reversed, resulting in " + Display());
    }
}
