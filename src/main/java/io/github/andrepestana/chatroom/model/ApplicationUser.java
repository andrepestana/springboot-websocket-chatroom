package io.github.andrepestana.chatroom.model;

public class ApplicationUser {

	private Long id;
	private String username;
	private String password;
	
	public ApplicationUser() {
		super();
	}
	
	public ApplicationUser(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
