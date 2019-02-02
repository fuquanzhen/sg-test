package ChocolateQuestion;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			System.out.println("Creating unique Instance of Chocolate Boiler");
			uniqueInstance = new ChocolateBoiler();
		}
		System.out.println("returning Instance of Chocolate Boiler");
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}

	private boolean isEmpty() {
		return empty;
	}

	private boolean isBoiled() {
		return boiled;
	}
}
