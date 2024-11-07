/*
# Name: Calvin Kerns, Cooper Morgan
# Date: 11/7/2024
# Description: used to notify clock
*/

abstract class Notifier {
    //fields
    List<Listener> Listeners = new ArrayList<>();

    //methods 
    public void notifyListeners(String message);

    public void registerListener(Listener listener);
}