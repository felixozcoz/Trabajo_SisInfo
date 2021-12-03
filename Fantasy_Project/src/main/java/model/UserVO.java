package emodel;

import java.util.Date;

/**
 * tabla users
 * @author sisinf
 *
 */
public class UserVO {
	private String Nombre;
	private String Contraseña;
	
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	public UserVO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	
}
