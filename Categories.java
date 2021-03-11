package domain.enums;

public enum Categories {
	
	HOUSEWORK("Housework"),
	WORK("Work"),
	SHOPPING("Shopping"),
	PERSONAL("Personal"),
	FINISHED("Finished");
	
	public String category;

	Categories(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return category;
	}

	public String getCategory() {
		return category;
	}
}
