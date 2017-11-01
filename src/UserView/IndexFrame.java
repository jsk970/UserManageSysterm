package UserView;

import java.util.Scanner;

import TypeUtil.TypeEmail;
import bean.User;
import controller.Usercontrol;
import dao.Userdao;
import dao.UserdaoImple;

public class IndexFrame{
  public Userdao us = new UserdaoImple();
  public Usercontrol uc = new Usercontrol();
  public int num;
   public  void show(){
	   Scanner scan = new Scanner(System.in);
	      
	    	  while(true){
	    		  System.out.println("欢迎使用黎达的用户管理系统");
	    	      System.out.println("====================");
	    	      System.out.println("用户登录---------------1");
	    	      System.out.println("用户注册---------------2");
	    	      System.out.println("退出程序---------------3");
	    	      System.out.println("请选择操作：");
	    	         
	    		  try{
	    		   num = Integer.parseInt(scan.nextLine());
	    		   
	    		  }catch(Exception e)
	    		  {
	    			  System.out.println("请输入1~3中数字");
	    			  continue;
	    		  }
	    	      switch(num)
	    	      {
	    	      
	    	      case 1:{
	    	    	  System.out.println("用户登录界面");
	    	    	  System.out.println("=================");
	    	    	  System.out.println("请输入您的用户名");
	    	    	  String name = scan.nextLine();
	    	    	  System.out.println("请输入您的密码");
	    	    	  String password = scan.nextLine();
	    	    	  if(uc.Login(name,password))
	    	    	  {
	    	    		  System.out.println("登陆成功。");
	    	    		  NormalFrame nf ;
	    	    		  if(us.Login(name).getPower()==0){
	    	    			  nf = new NormalFrame();
	    	    			  nf.show(us.Login(name));
	    	    		  }
	    	    		  else{
	    	    			  nf = new AdminFrame();
	    	    			  nf.show(us.Login(name));
	    	    		  }
	    	    	  }
	    	    	  else{
	    	    		  System.out.println("登录失败！");
	    	    	  }
	    	    	  break;
	    	      }
	    	      case 2:{
	    	    	  System.out.println("用户注册界面");
	    	    	  System.out.println("=================");
	    	    	  System.out.println("请输入您的用户名");
	    	    	  String name = scan.nextLine();
	    	    	  if(us.Login(name) != null)
	    	    	  {
	    	    		  System.out.println("用户名已经存在！");
	    	    		  break;
	    	    	  }
	    	    	  System.out.println("请输入您的密码");
	    	    	  String password = scan.nextLine();
	    	    	  System.out.println("请输入您的邮箱");
	    	    	  String email = scan.nextLine();
	    	    	  if(TypeEmail.checkEmail(email) == false)
	    	    	  {
	    	    		  System.out.println("邮箱格式错误！");
	    	    	  }else if(us.SameEmail().contains(email) == true)
	    	    	  {
	    	    		  System.out.println("邮箱已经被注册！");
	    	    	  }
	    	    	  else if (uc.AddUser(name, password, email)==true)
	    	    	  {
	    	    		  
	    	    		  System.out.println("注册成功");
	    	    	  }
	    	    	  break;
	    	      }
	    	      case 3:{
	    	    	  System.out.println("退出程序成功！");
	    	    	  System.exit(0);
	    	    	  break;
	    	      }
	    	      default:{
	    	    	  System.out.println("请输入1~3中数字");
	    	    	  break;
	    	      }
	    	      }
	    		}
   }
}
