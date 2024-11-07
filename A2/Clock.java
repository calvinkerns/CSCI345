/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: Clock class to simulate ticking clock
*/

import java.io.*;
import java.lang.Thread;

public class Clock extends Notifier{
    
    //fields
    private int tickPeriodInSeconds;

    //methods
    public void activate(){

        while(1){
            try{
                Thread.sleep(tickPeriodInSeconds * MILLISECONDS_PER_SECOND)
            }
            catch(Exception e){
                System.out.println("Error caught " + e);
            }
        }
    }

    public void setTimerPeriod(int tickPeriodInSeconds){
        this.tickPeriodInSeconds = tickPeriodInSeconds;
    }

    public void tick(){
        
    }

    public void notifyListeners(String message);

    public void registerListener(Listener listener);
}