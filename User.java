package domain.models.users;

import domain.interfaces.UserOperations;

import java.util.Objects;

public class User<T> implements UserOperations, Comparable<User> {
	
	private T id;
	private String userName;
	private String login;
	private String password;
	
	public User(String userName, String login, String password, T id) {
		this.userName = userName;
		this.login = login;
		this.password = password;
		this.id = id;
	}
	
	public User() {
	}

	public static class Builder<T> {
		private final User<T> newUser;
		
		public Builder() {
			
			newUser = new User<>();
		}

		public Builder<T> withUserName(String userName) {
			newUser.userName = userName;
			return this;
		}
		
		public Builder<T> withLogin(String login) {
			newUser.login = login;
			return this;
		}
		
		public Builder<T> withPassword(String password) {
			newUser.password = password;
			return this;
		}
		
		public Builder<T> withID(T id) {
			newUser.id = id;
			return this;
		}
		
		public User<T> build() {
			
			return newUser;
		}
	}

	@Override
	public int compareTo(User user) {
		
		return this.login.compareTo(user.getLogin());
	}

	@Override
	public void editAccount(String userName, String login, String password) {
		
		setFirstName(userName);
		setLogin(login);
		setPassword(password);
	}

	@Override
	public String toString() {
		
		return  "Login: " + login + ".\n" +
				"First name: " + userName + ".\n" +
				"Password: " + password + ".\n" +
				"ID: " + id + '.';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof User)) return false;
		User<?> user = (User<?>) obj;
		return Objects.equals(getLogin(), user.getLogin());
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(getLogin());
	}

	public String getUserName() {
		
		return userName;
	}
	
	public void setFirstName(String userName) {
		
		this.userName = userName;
	}
	
	public String getLogin() {
		
		return login;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
	}

	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}

	public T getId() {
		
		return id;
	}
	
	public void setId(T id) {
		
		this.id = id;
	}
}
