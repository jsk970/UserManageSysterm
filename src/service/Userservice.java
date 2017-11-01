package service;

import java.util.ArrayList;

import bean.User;

public interface Userservice {
	public boolean Login(String name,String password);
	public boolean Update(int id,String name,String password,String email);
	public boolean MUpdate(int id,String name,String password,String email);
	public User IDSelect(int id);
	public ArrayList<User> AllSelect();
	public ArrayList<User> SimilarSelect(String same);
	public boolean DeleteUser(int id);
    public boolean AddUser(String name,String password,String email);
    public ArrayList<String> SameEmail();
}
