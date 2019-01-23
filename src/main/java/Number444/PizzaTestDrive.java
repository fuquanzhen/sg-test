package Number444;

public class PizzaTestDrive {
	public static void main(String args[]) {
		DependentPizzaStore store = new DependentPizzaStore();
		store.orderPizza("NY", "cheese");
		store.orderPizza("NY", "clam");
		store.orderPizza("NY", "pepperoni");
		store.orderPizza("NY", "veggie");
		store.orderPizza("Chicago", "cheese");
		store.orderPizza("Chicago", "clam");
		store.orderPizza("Chicago", "pepperoni");
		store.orderPizza("Chicago", "veggie");
	}
}
