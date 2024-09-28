/* 
# Name: Calvin Kerns
# Description: A Backpack class that stores 'BackpackItem' objects in different pockets. It allows users 
#              to add, remove, and view items in different pockets of the backpack.
# Date: 9/24/2024
# Specification: 
# - The Backpack class will have private instance variables for pockets.
# - The class will provide methods to add items to either pocket.
# - The class will also include methods to remove items and check what items are in each pocket.
# - The class will ensure that the max weight per pocket isn't exceeded.
*/

import java.util.List;
import java.util.ArrayList;

public class Backpack
{
    //Constants
    private final int MAIN_POCKET_MAX_WEIGHT = 10;
    private final int LEFT_POCKET_MAX_WEIGHT = 5;
    private final int RIGHT_POCKET_MAX_WEIGHT = 5;

    //Fields (Data members)
    private List<BackpackItem> mainPocketItems = new ArrayList<BackpackItem>();
    private List<BackpackItem> leftPocketItems = new ArrayList<BackpackItem>();
    private List<BackpackItem> rightPocketItems = new ArrayList<BackpackItem>();
    
    //Methods
    public boolean insertItemInMainPocket(String itemName, double itemWeight)
    {
        boolean result = insertItemInPocket(mainPocketItems, itemName, itemWeight, MAIN_POCKET_MAX_WEIGHT);

        return result;
    }
    
    public boolean insertItemInRightPocket(String itemName, double itemWeight)
    {
    	boolean result = insertItemInPocket(rightPocketItems, itemName, itemWeight, RIGHT_POCKET_MAX_WEIGHT);

        return result;
    }
    
    public boolean insertItemInLeftPocket(String itemName, double itemWeight)
    {
    	boolean result = insertItemInPocket(leftPocketItems, itemName, itemWeight, LEFT_POCKET_MAX_WEIGHT);

        return result;
    }
    
    public boolean removeItemFromMainPocket(String itemName)
    {
    	boolean result = removeItemFromPocket(mainPocketItems, itemName);
        return result;
    }
    
    public boolean removeItemFromRightPocket(String itemName)
    {
    	boolean result = removeItemFromPocket(rightPocketItems, itemName);
        return result;
    }
    
    public boolean removeItemFromLeftPocket(String itemName)
    {
    	boolean result = removeItemFromPocket(leftPocketItems, itemName);
        return result;
    }
    
    public void listItemsInBackpack()
    {
    	System.out.println("Listing all backpack items...\n");
    	
    	listItemsInMainPocket();
    	System.out.println();
    	listItemsInRightPocket();
    	System.out.println();
    	listItemsInLeftPocket();
    	System.out.println();
    }
    
    public void listItemsInMainPocket()
    {
    	listItemsInPocket(mainPocketItems, "Main");
    }
    
    public void listItemsInRightPocket()
    {
    	listItemsInPocket(rightPocketItems, "Right");
    }
    
    public void listItemsInLeftPocket()
    {
    	listItemsInPocket(leftPocketItems, "Left");
    }
    
    public double getTotalWeight()
    {
    	double totalWeight = 0;
    	
    	totalWeight += getMainPocketTotalWeight();
    	totalWeight += getRightPocketTotalWeight();
    	totalWeight += getLeftPocketTotalWeight();

        return totalWeight;
    }
    
    public double getMainPocketTotalWeight()
    {
    	double totalWeight = getPocketTotalWeight(mainPocketItems);
    	
        return totalWeight;
    }
    
    public double getRightPocketTotalWeight()
    {
    	double totalWeight = getPocketTotalWeight(rightPocketItems);
    	
        return totalWeight;
    }
    
    public double getLeftPocketTotalWeight()
    {
    	double totalWeight = getPocketTotalWeight(leftPocketItems);
    	
        return totalWeight;
    }
    
    private boolean insertItemInPocket(List<BackpackItem> pocketItems, String itemName, double itemWeight, int pocketMaxWeight)
    {
        boolean result = false;

        if((itemWeight+getPocketTotalWeight(pocketItems)) <= pocketMaxWeight){
            BackpackItem item = new BackpackItem(itemName, itemWeight);

            pocketItems.add(item);
            result = true;
        }
        
        return result;
    }
    
    private boolean removeItemFromPocket(List<BackpackItem> pocketItems, String itemName)
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
    
    private double getPocketTotalWeight(List<BackpackItem> pocketItems)
    {
    	double totalWeight = 0;
        
        for(int i = 0; i < pocketItems.size(); i++){
            totalWeight += pocketItems.get(i).itemWeight;
        }
    	
    	
        return totalWeight;
    }
    
    private void listItemsInPocket(List<BackpackItem> pocketItems, String pocketName)
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
