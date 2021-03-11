package domain.enums;

public enum Types {
	
	DISPOSABLE("Disposable"),
	REUSABLE("Reusable");
	
	private String type;
	
	Types(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
