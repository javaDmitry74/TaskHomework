package domain.interfaces;

import domain.enums.Categories;
import domain.enums.Priority;
import domain.enums.Types;

import java.time.LocalDate;

public interface TaskOperations {

	public void createTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate);
	
	public void editTask(String description, Categories category, Types type, Priority priority, boolean complete, LocalDate expirationDate);
}
