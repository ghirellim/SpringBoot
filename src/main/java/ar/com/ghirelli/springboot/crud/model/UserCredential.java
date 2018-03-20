package ar.com.ghirelli.springboot.crud.model;

public class UserCredential {
	
	private String user;
	private String passw;
	
	public UserCredential() {
	
	}
	
	
	
	public UserCredential(String user, String passw) {
		super();
		this.user = user;
		this.passw = passw;
	}



	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the passw
	 */
	public String getPassw() {
		return passw;
	}
	/**
	 * @param passw the passw to set
	 */
	public void setPassw(String passw) {
		this.passw = passw;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCredential [user=" + user + ", passw=" + passw + "]";
	}
 
}
