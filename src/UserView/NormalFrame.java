package UserView;
import java.util.Scanner;

import controller.Usercontrol;

import dao.Userdao;

import bean.User;

import TypeUtil.TypeEmail;
import UserView.IndexFrame;
public class NormalFrame extends IndexFrame {
	int num3;
public void show(User p){
	System.out.println("==================");
	System.out.println(p.getName()+"您好"+"   "+"您的权限是：普通用户");
	System.out.println("==================");
	Scanner scan = new Scanner(System.in);
	while(true)
	{
		System.out.println("修改自己的用户--------1");
		System.out.println("查询自己的用户--------2");
		System.out.println("程序退出------------3");
		System.out.println("============");
		try{
 		   num3 = Integer.parseInt(scan.nextLine());
 		   
 		  }catch(Exception e)
 		  {
 			  System.out.println("请输入1~3中数字");
 		  }
		switch(num3)
		{
		case 1:
		{
			ChangeUser(p);
			break;
		}
		case 2:
		{
			SearchUser(p);
			break;
		}
		case 3:
		{
			System.out.println("程序退出成功！");
			IndexFrame m = new IndexFrame();
			m.show();
			break;
		}
		default:
		{
			System.out.println("请输入1~3数字");
			break;
		}
		}
	}
}
public void ChangeUser(User p){
	Scanner scan = new Scanner(System.in);
	System.out.println("请输入要修改的name");
	String name = scan.next();
	if(us.Login(name) != null)
	{
	   System.out.println("输入用户名存在！");	
	   System.out.println("请重新输入");
	 ChangeUser(p);
	}
	System.out.println("请输入要修改的password");
	String password = scan.next();
	System.out.println("请输入要修改的email");
	String email = scan.next();
	if(TypeEmail.checkEmail(email) == false)
	{
		System.out.println("邮箱格式错误！");
		System.out.println("请重新输入");
		ChangeUser(p);
	}
	else if(us.SameEmail().contains(email) == true)
	  {
		  System.out.println("邮箱已经被注册！");
		  ChangeUser(p);
	  }
	else if(uc.Update(p.getId(), name, password, email))
	{
		System.out.println("修改成功！");
	}
	else
	{
		System.out.println("修改失败！");
	}
}
public void SearchUser(User p){
	
	if(us.IDSelect(p.getId()) != null){
		System.out.println("ID = "+p.getId()+" "+" name = "+p.getName()+" "+"password = "+p.getPassword()
				+" "+"email = "+p.getEmail()+" "+"power = "+p.getPower());
	}
	else
	{
		System.out.println("ID不存在");
	}
}
}
