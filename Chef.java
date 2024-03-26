public class Chef extends Thread {
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (true) {
            Dish dish = restaurant.getNextDish();
            try {
                System.out.println("Preparing: " + dish.getItem());
                Thread.sleep(3000); // dish preparation time
                synchronized (this) {
                    dish.setReady(true);
                    System.out.println("Dish ready: " + dish.getItem());
                    notify(); // Notify waiter that the dish is ready
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
