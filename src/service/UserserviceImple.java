package service;

import java.util.ArrayList;

import bean.User;

import dao.Userdao;
import dao.UserdaoImple;


public class UserserviceImple implements Userservice {
    Userdao dao;
	@Override
	public boolean Login(String username, String password) {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.Login(username) != null){
			if(dao.Login(username).getPassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public boolean AddUser(String name,String password,String email) {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.AddUser(name, password, email) >0){
			
				return true;
			}
			else{
				return false;
			}
		
	}
	@Override
	public boolean DeleteUser(int id) {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.DeleteUser(id) > 0){
			
				return true;
			}
			else{
				return false;
			}
	}
	public boolean Update(int id,String name,String password,String email) {
		dao = new UserdaoImple();
		if(dao.Update(id,name,password,email) >0){
			
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public ArrayList<User> AllSelect() {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.AllSelect() != null)
		return dao.AllSelect();
		else
		return null;
	}
	@Override
	public User IDSelect(int id) {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.IDSelect(id) != null)
			return dao.IDSelect(id);
		else
		return null;
	}
	@Override
	public boolean MUpdate(int id, String name, String password, String email) {
		dao = new UserdaoImple();
		// TODO Auto-generated method stub
        if(dao.MUpdate(id,name,password,email) >0){
			
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public ArrayList<User> SimilarSelect(String same) {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.SimilarSelect(same) != null)
			return dao.SimilarSelect(same);
		else
		return null;
	}

	@Override
	public ArrayList<String> SameEmail() {
		// TODO Auto-generated method stub
		dao = new UserdaoImple();
		if(dao.SameEmail() != null)
			return dao.SameEmail();
		else
		return null;
	}
	

}
