/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: Clock class to simulate ticking clock
*/

import java.io.*;
import java.lang.Thread;

public class Clock extends Notifier {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private int tickPeriodInSeconds;
    
    //activates clock, ticking according to tickPeriodInSeconds
    public void activate() {
        while(true) {
            try {
                Thread.sleep(tickPeriodInSeconds * MILLISECONDS_PER_SECOND);
                tick();
            } catch(InterruptedException e) {
                System.out.println("Error caught " + e);
            }
        }
    }
    
    public void setTimerPeriod(int tickPeriodInSeconds) {
        this.tickPeriodInSeconds = tickPeriodInSeconds;
    }
    
    //get current time and pass as string to notifyListeners
    public void tick() {
        java.time.LocalTime currentTime = java.time.LocalTime.now();
        String timeStr = String.format("%02d.%02d.%02d", 
            currentTime.getHour(),
            currentTime.getMinute(),
            currentTime.getSecond());
        notifyListeners(timeStr);
    }
}