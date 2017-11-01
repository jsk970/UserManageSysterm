package bean;

public class User {
private int id;
private String name;
private String password;
private String email;
private int power;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public int getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}
public User(int id, String name, String password, String email,
		 int power) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.email = email;
	this.power = power;
}
public User() {
	super();
}

}
