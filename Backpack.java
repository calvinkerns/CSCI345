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
    private int MAIN_POCKET_MAX_WEIGHT = 10;
    private int LEFT_POCKET_MAX_WEIGHT = 5;
    private int RIGHT_POCKET_MAX_WEIGHT = 5;

    final Pocket mainPocket;
    final Pocket leftPocket;
    final Pocket rightPocket;
    
    //Constructor
    public Backpack(){
        mainPocket = new Pocket("Main", MAIN_POCKET_MAX_WEIGHT);
        leftPocket = new Pocket("Left", LEFT_POCKET_MAX_WEIGHT);
        rightPocket = new Pocket("Right", RIGHT_POCKET_MAX_WEIGHT);
    }

    public Backpack(int maxMain, int maxRight, int MaxLeft){
        this.MAIN_POCKET_MAX_WEIGHT = maxMain;
        this.RIGHT_POCKET_MAX_WEIGHT = maxRight;
        this.LEFT_POCKET_MAX_WEIGHT = MaxLeft;
        mainPocket = new Pocket("Main", MAIN_POCKET_MAX_WEIGHT);
        leftPocket = new Pocket("Left", LEFT_POCKET_MAX_WEIGHT);
        rightPocket = new Pocket("Right", RIGHT_POCKET_MAX_WEIGHT);
    }

    //Methods
    public boolean insertItemInMainPocket(String itemName, double itemWeight)
    {
        boolean result = mainPocket.insertItemInPocket(itemName, itemWeight);

        return result;
    }
    
    public boolean insertItemInRightPocket(String itemName, double itemWeight)
    {
    	boolean result = rightPocket.insertItemInPocket(itemName, itemWeight);

        return result;
    }
    
    public boolean insertItemInLeftPocket(String itemName, double itemWeight)
    {
    	boolean result = leftPocket.insertItemInPocket(itemName, itemWeight);

        return result;
    }
    
    public boolean removeItemFromMainPocket(String itemName)
    {
    	boolean result = mainPocket.removeItemFromPocket(itemName);

        return result;
    }
    
    public boolean removeItemFromRightPocket(String itemName)
    {
    	boolean result = rightPocket.removeItemFromPocket(itemName);

        return result;
    }
    
    public boolean removeItemFromLeftPocket(String itemName)
    {
    	boolean result = leftPocket.removeItemFromPocket(itemName);

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
    	mainPocket.listItemsInPocket();
    }
    
    public void listItemsInRightPocket()
    {
    	rightPocket.listItemsInPocket();
    }
    
    public void listItemsInLeftPocket()
    {
    	leftPocket.listItemsInPocket();
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
    	double totalWeight = mainPocket.getPocketTotalWeight();
    	
        return totalWeight;
    }
    
    public double getRightPocketTotalWeight()
    {
    	double totalWeight = rightPocket.getPocketTotalWeight();
    	
        return totalWeight;
    }
    
    public double getLeftPocketTotalWeight()
    {
    	double totalWeight = leftPocket.getPocketTotalWeight();
    	
        return totalWeight;
    }
}
