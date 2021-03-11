package domain.models.tasks;

import domain.exceptions.DateException;
import domain.enums.Categories;
import domain.enums.Priority;
import domain.enums.Types;
import domain.interfaces.TaskOperations;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

abstract public class TaskModel implements TaskOperations{
	
	private String name;
	private Categories categories;
	private Types types;
	private Priority priority;
	private boolean complete = true;
	private LocalDate creationDate;
	private LocalDate deadline;
	private long daysLeft;
	
	public TaskModel() {
	}
	
	public TaskModel(String name, Categories categories, Types types, Priority priority, boolean complete, LocalDate deadline) {
		this.name = name;
		this.categories = categories;
		this.types = types;
		this.priority = priority;
		this.complete = complete;
		this.deadline = deadline;
	}
	
	@Override
	public void createTask(String name, Categories category, Types type, Priority priority, boolean complete, LocalDate deadline) {
		setName(name);
		setCategories(category);
		setTypes(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(deadline);
	}
	
	@Override
	public void editTask(String name, Categories category, Types type, Priority priority, boolean complete, LocalDate deadline) {
		setName(name);
		setCategories(category);
		setTypes(type);
		setPriority(priority);
		setComplete(complete);
		setExpirationDateOfTask(deadline);
	}
	
	@Override
	public boolean equals(Object that) {
		if (this == that) return true;
		if (!(that instanceof TaskModel)) return false;
		TaskModel taskModel = (TaskModel) that;
		return name.equals(taskModel.name);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("\n");
		sb.append("Description: ").append(getName()).append(".\n");
		sb.append("Creation date: ").append(getCreationDate()).append(".\n");
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreationDate() {
		creationDate = LocalDate.now();
		return creationDate.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
	}

	public String getExpirationDate() throws DateException{
		
		daysLeft = ChronoUnit.DAYS.between(creationDate, deadline);
		
		if (daysLeft >= 0){
			return deadline.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
		} else {
			throw new DateException("expired date");
		}
	}
	
	public String setExpirationDate(String deadline) {
		return deadline;
	}
	
	public void setCreationDateOfTask(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public void setExpirationDateOfTask(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Categories getCategories() {
		return categories;
	}
	
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Types getTypes() {
		return types;
	}
	
	public void setTypes(Types types) {
		this.types = types;
	}

	public boolean isComplete() {
		return complete;
	}
	
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public long getDaysLeft(){
		
		daysLeft = ChronoUnit.DAYS.between(creationDate, deadline);
		if (daysLeft < 0) {
			daysLeft = 0;
		}
		return daysLeft;
	}
	
	public void setDaysLeft(long daysLeft) {
		this.daysLeft = daysLeft;
	}
}
