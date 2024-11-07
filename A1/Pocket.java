/* 
# Name: Calvin Kerns
# Description: stuff
# Date: 10/1/2024
# Specification: 
#Pocket class to simulate pocket items with methods to insert and remove items
*ensuring weight ins't exceeded
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pocket implements Iterable<BackpackItem>{

    //Constants
    private int maxPocketWeight;
    private String pocketName;

    //Fields (Data members)
    private List<BackpackItem> pocketItems = new ArrayList<BackpackItem>();
    

    //Constructor

    //Constructor taking the name of the pocket and the max weight
    public Pocket(String pocketName, int maxPocketWeight){
        this.pocketName = pocketName;
        this.maxPocketWeight = maxPocketWeight;
    }

    //Methods

    //Insert item unless item weight is negative or exceeds max weight of pocket
    public void insertItemInPocket(String itemName, double itemWeight) throws Exception
    {
        //Check for invalid weight, throw error if so
        if(itemWeight <= 0){
            throw new Exception(String.format(
                    "Invalid weight exception. Pocket name: %s Item name: %s Item weight: %.1f", pocketName,
                    itemName, itemWeight), new Throwable("Insert"));
        }
        else if((itemWeight+getPocketTotalWeight()) > maxPocketWeight){
            throw new Exception(String.format(
                    "Weight exceeded exception. Pocket name: %s Current pocket weight: %.1f Maximum pocket weight: %d Item name: %s Item weight: %.1f",
                    pocketName, getPocketTotalWeight(), maxPocketWeight, itemName, itemWeight), new Throwable("Insert"));
        }
        else{
            BackpackItem item = new BackpackItem(itemName, itemWeight);
            pocketItems.add(item);
        }
    }

    //Search for item to remove, if not found throw exception
    public void removeItemFromPocket(String itemName) throws Exception {
        boolean found = false;

        for (int i = 0; i < this.pocketItems.size(); i++) {
            if (this.pocketItems.get(i).itemName.equals(itemName)) {
                this.pocketItems.remove(i);
                found = true;
            }
        }
        
        //throw exception
        if(!found){
            throw new Exception(
                    String.format("Item not found exception. Pocket name: %s Item name: %s", pocketName, itemName),
                    new Throwable("Remove"));
        }
    }

    public double getPocketTotalWeight()
    {
    	double totalWeight = 0;
        
        for(int i = 0; i < pocketItems.size(); i++){
            totalWeight += pocketItems.get(i).itemWeight;
        }
    	
    	
        return totalWeight;
    }

    public void listItemsInPocket() 
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


    // Implementing Iterable
    @Override
    public Iterator<BackpackItem> iterator() {
        return pocketItems.iterator();
    }
}