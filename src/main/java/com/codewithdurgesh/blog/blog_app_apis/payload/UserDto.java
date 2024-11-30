package com.codewithdurgesh.blog.blog_app_apis.payload;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;

=======
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {
	
<<<<<<< HEAD
	private Long id;
=======
	private int id;
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	
	@NotEmpty
	@Size(min = 4, message="User name must contain 4 letters")
	private String name;
	
	@Email(message="Your email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="Password must be min of 3 letters and amx of 10 letters")
	private String password;
	
	@NotEmpty
	private String about;
	
<<<<<<< HEAD
	private Set<RoleDto> roles = new HashSet<>();
	
=======
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	
	public UserDto() {
		super();

	}
	
<<<<<<< HEAD
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


=======
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
<<<<<<< HEAD

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}
=======
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	
	
}
