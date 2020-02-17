package gitlabsetofintegers;



import java.io.Serializable;
import java.util.ArrayList;

public class CollectionSetIntegers implements Serializable{
    private SetOfIntegers selected;
    ArrayList<SetOfIntegers> intset = new ArrayList<SetOfIntegers>();
    public int count;
    public CollectionSetIntegers()
    {
        count = 0;
    }
    public SetOfIntegers GetSelected()
    {
        return selected;
    }
    void SetSelected(int select) 
    {
    	selected = intset.get(select);
    }
    void NewSet(String s)
    {
		intset.add(new SetOfIntegers(s,count));
	   	count= count + 1;
    }
    void DeleteSet()
    {
    	intset.remove(selected.count);
    	count = count - 1;
    }
}
