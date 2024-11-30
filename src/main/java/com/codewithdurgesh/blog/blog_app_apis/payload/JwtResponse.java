package com.codewithdurgesh.blog.blog_app_apis.payload;


public class JwtResponse {

	private String jwtToken;
	private String userName;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUserName() {
		return userName;
	}
	

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String jwtToken, String userName) {
		super();
		this.jwtToken = jwtToken;
		this.userName = userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private JwtResponse(Builder builder) {
		this.jwtToken = builder.jwtToken;
		this.userName = builder.username;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String jwtToken;
		private String username;

		public Builder jwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(this);
		}
	}
	
	
}
