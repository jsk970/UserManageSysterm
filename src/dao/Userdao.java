package dao;

import java.util.ArrayList;

import bean.User;

public interface Userdao {
	public User Login(String name);
	public int Update(int id,String name,String password,String email);
	public int MUpdate(int id,String name,String password,String email);
	public User IDSelect(int id);
	public ArrayList<User> AllSelect();
	public ArrayList<User> SimilarSelect(String same);
	public int DeleteUser(int id);
    public int AddUser(String name,String password,String email);
    public ArrayList<String> SameEmail();
}
