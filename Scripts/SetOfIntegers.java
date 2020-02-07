
package gitlabsetofintegers;

import java.util.ArrayList;

public class SetOfIntegers {
    
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
}
