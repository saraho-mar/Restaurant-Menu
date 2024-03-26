import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private final Queue<Dish> dishes = new LinkedList<>();
    private final Chef chef;
    private final Waiter waiter;

    public Restaurant() {
        this.chef = new Chef(this);
        this.waiter = new Waiter(this, chef);
    }

    public synchronized void addDish(Dish dish) {
        dishes.add(dish);
        System.out.println("Dish added: " + dish.getItem() + " for Table " + dish.getTableNumber());
        notifyAll();
    }

    public synchronized Dish getNextDish() {
        while (dishes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return dishes.poll();
    }

    public void startService() {
        waiter.start();
        chef.start();
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.startService();
    }
}

