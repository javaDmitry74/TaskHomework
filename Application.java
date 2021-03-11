package Application;

import domain.enums.Categories;
import domain.enums.Priority;
import domain.enums.Types;
import domain.interfaces.UserOperations;
import domain.models.tasks.DisposableTask;
import domain.models.tasks.ReusableTask;
import domain.models.tasks.TaskModel;
import domain.models.users.User;
import domain.models.users.UserOperation;
import domain.service.TaskService;

import java.io.*;
import java.time.LocalDate;

public class Application {
	
	public static void main(String[] args){

		DisposableTask disposableTask1 = new DisposableTask(
				"buy car",
				Categories.SHOPPING,
				Types.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 29));
		
		TaskModel disposableTask2 = new DisposableTask(
				"",
				Categories.SHOPPING,
				Types.DISPOSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 29));
		
		ReusableTask reusableTask1 = new ReusableTask(
				"pay by installments",
				Categories.HOUSEWORK,
				Types.REUSABLE,
				Priority.IMPORTANT,
				false,
				LocalDate.of(2022, 1, 17),
				20);
		
		TaskModel reusableTask2 = new ReusableTask(
				"go to class",
				//new Date(),
				Categories.PERSONAL,
				Types.REUSABLE,
				Priority.URGENTLY,
				true,
				LocalDate.of(2022, 1, 17),
				7);
		
		TaskService.addTask(disposableTask1);
		TaskService.addTask(disposableTask2);
		TaskService.addTask(reusableTask1);
		TaskService.addTask(reusableTask2);
		
		TaskService.printListOfAllTasks();
		
		System.out.println("Users");
		User<String> user = new User.Builder<String>()
				.withUserName("User")
				.withLogin("user1234")
				.withPassword("12345")
				.withID("id12345")
				.build();
	

		User<Integer> admin = new User.Builder<Integer>()
				.withUserName("admin")
				.withLogin("Admin")
				.withPassword("123456")
				.withID(1234567)
				.build();

		UserOperation.addUser(user);
		UserOperation.addUser(admin);
		UserOperation.printListOfUsers();
	}
}
