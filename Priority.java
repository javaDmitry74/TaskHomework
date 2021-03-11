package domain.enums;

public enum Priority {
	
	URGENTLY("Urgently"),
	IMPORTANT("Important");
	
	public String priority;

	Priority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		
		return priority;
	}

	public String getPriority() {
		
		return priority;
	}
}
