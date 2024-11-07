/* 
# Name: Calvin Kerns
# Description: A backpackItem class created to be used with the 'Backpack' objects
# Date: 9/24/2024
# Specification: 
- Has public instance variables to hold the values of the weight and item of the item
- Has method to populate these variables given the values that they should be set to
*/

public class BackpackItem 
{
    public String itemName;
    public double itemWeight;
    
    public BackpackItem(String itemName, double itemWeight)
    {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }
}
