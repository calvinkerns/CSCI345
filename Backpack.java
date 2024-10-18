/* 
# Name: Calvin Kerns
# Description: A Backpack class that stores 'BackpackItem' objects in different pockets. It allows users 
#              to add, remove, and view items in different pockets of the backpack.
# Date: 9/24/2024
# Specification: 
# - The class will provide methods to add items to either pocket.
# - The class will also include methods to remove items and check what items are in each pocket.
# - The class will ensure that the max weight per pocket isn't exceeded.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

enum CurrentPocket{
    None,
    Main,
    Right,
    Left;
}

public class Backpack implements Iterable<Pocket> 
{
    //Constants
    private int MAIN_POCKET_MAX_WEIGHT = 10;
    private int LEFT_POCKET_MAX_WEIGHT = 5;
    private int RIGHT_POCKET_MAX_WEIGHT = 5;
    
    //Constructor

    //general backpack constructor that sets pocket main weights to max:10, left:5, right:5
    public Backpack(){
        mainPocket = new Pocket("Main", MAIN_POCKET_MAX_WEIGHT);
        leftPocket = new Pocket("Left", LEFT_POCKET_MAX_WEIGHT);
        rightPocket = new Pocket("Right", RIGHT_POCKET_MAX_WEIGHT);
    }

    //backpack constructor taking arguments of max weight for main right and left pockets
    public Backpack(int maxMain, int maxRight, int MaxLeft){
        this.MAIN_POCKET_MAX_WEIGHT = maxMain;
        this.RIGHT_POCKET_MAX_WEIGHT = maxRight;
        this.LEFT_POCKET_MAX_WEIGHT = MaxLeft;
        mainPocket = new Pocket("Main", MAIN_POCKET_MAX_WEIGHT);
        leftPocket = new Pocket("Left", LEFT_POCKET_MAX_WEIGHT);
        rightPocket = new Pocket("Right", RIGHT_POCKET_MAX_WEIGHT);
    }

    //Methods
    public void insertItemInMainPocket(String itemName, double itemWeight)
    {
        mainPocket.insertItemInPocket(itemName, itemWeight);
    }
    
    public void insertItemInRightPocket(String itemName, double itemWeight)
    {
        rightPocket.insertItemInPocket(itemName, itemWeight);
    }
    
    public void insertItemInLeftPocket(String itemName, double itemWeight)
    {
        leftPocket.insertItemInPocket(itemName, itemWeight);
    }
    
    public void removeItemFromMainPocket(String itemName)
    {
    	mainPocket.removeItemFromPocket(itemName);
    }
    
    public void removeItemFromRightPocket(String itemName)
    {
    	rightPocket.removeItemFromPocket(itemName);
    }
    
    public void removeItemFromLeftPocket(String itemName)
    {
    	leftPocket.removeItemFromPocket(itemName);
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

    // Implementing Iterable for Pocket
    @Override
    public Iterator<Pocket> iterator() {
        return pockets.iterator();
    }

    @Override
    public Pocket next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more pockets in the backpack.");
        }
        else{
            return CurrentPocket;
        }
    }

    @Override
    public boolean hasNext() {
        return CurrentPocket < pockets.length;
    }
}
