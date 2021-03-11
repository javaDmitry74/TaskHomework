package domain.service;

import domain.exceptions.EmptyNameException;
import domain.enums.Categories;
import domain.enums.Priority;
import domain.models.tasks.TaskModel;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TaskService {
	
	private static List<TaskModel> tasksList = new LinkedList<TaskModel>();
	
	public TaskService() {
	}
	
	public static void addTask(TaskModel taskModel) {
			tasksList.add(taskModel);
	}
	
	public static void filterByPriority(Priority priority) {
		tasksList.stream()
				.filter(task -> task.getPriority().equals(priority))
				.forEach(System.out :: println);
	}
	
	public static void filterByCategory(Categories categories) {
		tasksList.stream()
				.filter(taskItem -> taskItem.getCategories().equals(categories))
				.forEach(System.out :: println);
	}
	
	public static void deleteDuplicateTasks() {
		tasksList.stream()
				.distinct()
				.forEach(System.out :: println);
	}
	
	public static void sortByCategory() {
		tasksList.stream()
				.sorted(Comparator.comparing(TaskModel :: getCategories))
				.forEach(System.out :: println);
	}
	
	public static void sortByPriority() {
		tasksList.stream()
				.sorted(Comparator.comparing(TaskModel :: getPriority))
				.forEach(System.out :: println);
		
	}
	
	public static void sortByType() {
		tasksList.stream()
				.sorted(Comparator.comparing(TaskModel :: getTypes))
				.forEach(System.out :: println);
	}
	
	public static void delete(String name) {
		tasksList.stream()
				.filter(task -> task.getName().equals(name))
				.findFirst()
				.ifPresent(tasksList :: remove);
	}

	public static void print(TaskModel taskModel) throws EmptyNameException {
		if (taskModel.getName().equals("")) {
			System.out.println(taskModel);
		} else {
			throw new EmptyNameException("Write a description of task");
		}
	}
	
	public static void printListOfAllTasks() {
		tasksList.forEach((t) -> {
			if (t.getName().equals("")) {
				try {
					throw new EmptyNameException("Write a description of task");
				} catch (EmptyNameException e) {
					t.setName("no description");
				}
			}
			System.out.println(t);
		});
	}

	public static void printNameOfTasks() {
		tasksList.forEach((t) -> {
			Optional<String> descriptionOfTasks = Optional.of(t.getName());
			System.out.println(descriptionOfTasks);
		});
	}
	
	public static void getNameLength() {
		tasksList.forEach((t) -> {
			boolean allMatch = tasksList.stream()
					.allMatch(word -> (t.getName()).length() > 1);
			System.out.println(allMatch);
		});
	}
	
	public static List<TaskModel> getTasks() {
		return tasksList;
	}
	
	public static void setTasks(List<TaskModel> tasksList) {
		TaskService.tasksList = tasksList;
	}
}
