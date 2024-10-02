/* 
# Name: Calvin Kerns
# Description: stuff
# Date: 10/1/2024
# Specification: 
# - stuff
*/

import java.util.List;
import java.util.ArrayList;

public class Pocket{

    //Constants
    private int maxPocketWeight;
    private String pocketName;

    //Fields (Data members)
    private List<BackpackItem> pocketItems = new ArrayList<BackpackItem>();

    //Constructor
    public Pocket(String pocketName, int maxPocketWeight){
        this.pocketName = pocketName;
        this.maxPocketWeight = maxPocketWeight;
    }

    //Methods
    public boolean insertItemInPocket(String itemName, double itemWeight)
    {
        boolean result = false;

        if((itemWeight+getPocketTotalWeight()) <= maxPocketWeight){
            BackpackItem item = new BackpackItem(itemName, itemWeight);

            pocketItems.add(item);
            result = true;
        }
        
        return result;
    }

    public boolean removeItemFromPocket(String itemName) //todo, why must this be public
    {
    	boolean result = false;
        
        for(int i=0; i < pocketItems.size(); i++){
            if(pocketItems.get(i).itemName == itemName){
                pocketItems.remove(i);
                result = true;
            }
        }
        return result;
    }

    public double getPocketTotalWeight()
    {
    	double totalWeight = 0;
        
        for(int i = 0; i < pocketItems.size(); i++){
            totalWeight += pocketItems.get(i).itemWeight;
        }
    	
    	
        return totalWeight;
    }

    public void listItemsInPocket() //todo, same\
    {
    	System.out.println("Listing " + pocketName + " Pocket Items..." );
    	
    	for (int index = 0; index < pocketItems.size(); index++)
    	{
    		System.out.println("Pocket Item: " 
    				+ pocketItems.get(index).itemName
    				+ " " 
    				+ pocketItems.get(index).itemWeight);
    	}
    }
}