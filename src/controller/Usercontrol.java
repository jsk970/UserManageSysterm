package controller;

import java.util.ArrayList;

import dao.UserdaoImple;
import bean.User;
import service.Userservice;
import service.UserserviceImple;

public class Usercontrol extends User {
	Userservice user0; 
	public boolean Login(String name, String password) {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.Login(name, password)){
			if(user0.Login(name,password)){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	public boolean AddUser(String name,String password,String email) {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.AddUser(name, password, email)){
			
				return true;
			}
			else{
				return false;
			}
		
	}
	public boolean DeleteUser(int id) {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.DeleteUser(id) ){
			
				return true;
			}
			else{
				return false;
			}
	}
	public boolean Update(int id,String name,String password,String email) {
		user0 = new UserserviceImple();
		if(user0.Update(id,name,password,email)){
			
			return true;
		}
		else{
			return false;
		}
	}
	
	public ArrayList<User> AllSelect() {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.AllSelect() != null)
		return user0.AllSelect();
		else
		return null;
	}

	public User IDSelect(int id) {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.IDSelect(id) != null)
			return user0.IDSelect(id);
		else
		return null;
	}

	public boolean MUpdate(int id, String name, String password, String email) {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
        if(user0.MUpdate(id, name, password, email)){
			
			return true;
		}
		else{
			return false;
		}
	}

	public ArrayList<User> SimilarSelect(String same) {
		// TODO Auto-generated method stub
		if(user0.SimilarSelect(same) != null)
			return user0.SimilarSelect(same);
		else
		return null;
	}
	public ArrayList<String> SameEmail() {
		// TODO Auto-generated method stub
		user0 = new UserserviceImple();
		if(user0.SameEmail() != null)
			return user0.SameEmail();
		else
		return null;
	}
}
