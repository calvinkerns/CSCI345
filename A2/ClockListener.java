/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: clock listener prints out clock info
*/

public class ClockListener implements Listener {
    private String name;
    
    //constructor taking name string
    public ClockListener(String name) {
        this.name = name;
    }
    
    //override notify from Listener class, print out custom message with name and time
    @Override
    public void notify(String message) {
        System.out.println(name + " the time is: " + message);
    }
}