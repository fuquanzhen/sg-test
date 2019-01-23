package PizzaNewQuestion;

public class PizzaTestDrive {
	public static void main(String args[]) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
		nyPizzaStore.orderPizza("cheese");
		nyPizzaStore.orderPizza("clam");
		nyPizzaStore.orderPizza("pepperoni");
		nyPizzaStore.orderPizza("veggie");
		chicagoPizzaStore.orderPizza("cheese");
		chicagoPizzaStore.orderPizza("clam");
		chicagoPizzaStore.orderPizza("pepperoni");
		chicagoPizzaStore.orderPizza("veggie");
		californiaPizzaStore.orderPizza("cheese");
		californiaPizzaStore.orderPizza("clam");
		californiaPizzaStore.orderPizza("pepperoni");
		californiaPizzaStore.orderPizza("veggie");
	}
}
