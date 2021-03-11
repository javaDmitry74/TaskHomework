package domain.models.tasks;

import domain.exceptions.DateException;
import domain.enums.Categories;
import domain.enums.Priority;
import domain.enums.Types;

import java.io.Serializable;
import java.time.LocalDate;

public class ReusableTask extends TaskModel{
	
	private int count;
	
	public ReusableTask() {
	}
	
	public ReusableTask(String description, Categories categories, Types types, Priority priority, boolean complete, LocalDate expirationDate, int count) {
		super(description, categories, types, priority, complete, expirationDate);
		this.count = count;
	}
	
	public void createTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate, int count) {
		createTask(description, category, type, priority, complete, expirationDate);
		this.count = count;
	}
	
	public void editTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate, int count) {
		editTask(description, category, type, priority, complete, expirationDate);
		this.count = count;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getName()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
		sb.append("Repeat: ").append(getRepeat()).append(".\n");
		sb.append("Priority: ").append(getPriority()).append(".\n");
		sb.append("Category: ").append(getCategories()).append(".\n");
		try {
			sb.append("Expiration date: ").append(getExpirationDate()).append(".\n");
		} catch (DateException e) {
			sb.append(setExpirationDate("expired date")).append(".\n");
		}
		sb.append("Days left: ").append(getDaysLeft()).append(" days.\n");
		sb.append("Complete: ").append(isComplete()).append(".\n");
		return sb.toString();
	}
	
	public int getRepeat() {
		return count;
	}
	
	public void setRepeat(int count) {
		this.count = count;
	}
}
