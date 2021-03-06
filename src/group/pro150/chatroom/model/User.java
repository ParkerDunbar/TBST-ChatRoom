package group.pro150.chatroom.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private Password password;

	public User(String firstName, String lastName, String username, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		Password p = new Password(password);
		this.password = p;
	}

	public User(String firstName, String lastName, String username, Password password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public boolean checkPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encodedPassTemp = Password.hashWith256(password, this.password.randGenStr);
		if (encodedPassTemp.equals(this.password.encodedPass)) {
			return true;
		} else {
			return false;
		}
	}

}
