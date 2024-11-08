/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: used to notify clock
*/
import java.util.List;
import java.util.ArrayList;

abstract class Notifier {
    private List<Listener> listeners = new ArrayList<>();
    
    //recieves string with the time and notifies all listeners with given time string
    public void notifyListeners(String message) {
        for(Listener listener : listeners) {
            listener.notify(message);
        }
    }
    
    //method to create more listeners
    public void registerListener(Listener listener) {
        listeners.add(listener);
    }
}