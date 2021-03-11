package domain.models.tasks;

import domain.enums.Priority;
import domain.enums.Categories;
import domain.enums.Types;

import java.io.Serializable;
import java.time.LocalDate;

public class DisposableTask extends TaskModel{
	
	public DisposableTask() {
	}
	
	public DisposableTask(String description, Categories categories, Types types, Priority priority, boolean complete, LocalDate expirationDate) {
		super(description, categories, types, priority, complete, expirationDate);
	}
}
