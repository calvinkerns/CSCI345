public class Program
{
    public static void main(String[] args)
    {
    	Clock clock = new Clock();
		
		Listener mickey = new ClockListener("Mickey");
		Listener donald = new ClockListener("Donald");

		clock.registerListener(mickey);
		clock.registerListener(donald);

		clock.setTimerPeriod(2);

        clock.activate();
    }
}
