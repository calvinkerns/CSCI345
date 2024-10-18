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
    public boolean insertItemInPocket(String itemName, double itemWeight)
    {
        boolean result = false;
        
        //Check for invalid weight, throw error if so
        if(itemWeight <= 0 || ((itemWeight+getPocketTotalWeight()) > maxPocketWeight)){
            String message = "Invalid Weight Exception. Item name: " + itemName + " Weight: " + itemWeight + ".";
            throw new IllegalArgumentException(message);
        }
        else{
            BackpackItem item = new BackpackItem(itemName, itemWeight);

            pocketItems.add(item);
            result = true;
        }
        
        return result;
    }

    public boolean removeItemFromPocket(String itemName) 
    {
    	boolean result = false;
        
        for(int i=0; i < pocketItems.size(); i++){
            if(pocketItems.get(i).itemName.equals(itemName)){
                pocketItems.remove(i);
                result = true;
            }
        }
        
        //Throw exception if item not found
        if(!result){
            String message = "Item not found exception. Item name: " + itemName;
            throw new NoSuchElementException(message);
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
        return new PocketIterator();
    }

    // Inner class for Iterator
    private class PocketIterator implements Iterator<BackpackItem> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < pocketItems.size();
        }

        @Override
        public BackpackItem next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items in the pocket.");
            }
            return pocketItems.get(currentIndex++);
        }
    }
}