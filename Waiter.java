public class Waiter extends Thread {
    private final Restaurant restaurant;
    private final Chef chef;

    public Waiter(Restaurant restaurant, Chef chef) {
        this.restaurant = restaurant;
        this.chef = chef;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (chef) {
                try {
                    chef.wait(); // Wait for the chef to notify about dish readiness
                    // Assuming dish delivery to table after preparation
                    System.out.println("Dish served to table.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
