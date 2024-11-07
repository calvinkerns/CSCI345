/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: clock listener prints out clock info
*/

public class ClockListener implements Listener{
    //fields
    private String name;

    ClockListener(String name){
        this.name = name;
    }

    @override
    public void notify(String message){
        System.out.println(name + " the time is: " + message);
    }

    public void registerListener(Listener listener){
        
    }
}