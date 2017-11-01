package UserView;

import java.util.Scanner;

import TypeUtil.TypeEmail;
import bean.User;

public class AdminFrame extends NormalFrame {
	public int num1 = 0;
	public int num2 = 0;
	public void show(User x){
	System.out.println("==================");
	System.out.println(x.getName()+"您好"+"   "+"您的权限是：管理员");
	System.out.println("==================");
	Scanner scan = new Scanner(System.in);
	while(true)
	{
		System.out.println("添加用户------------1");
		System.out.println("删除用户------------2");
		System.out.println("修改用户------------3");
		System.out.println("查询用户------------4");
		System.out.println("程序退出------------5");
		System.out.println("请输入1~5之间数据：");	
		try{
			num1 = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			  System.out.println("输入错误，请输入1~5中数字");
 			  
 		  }
		System.out.println("============");
		switch(num1)
		{
		case 1:
		{
			  AddUser();
	    	  break;
		}
		case 2:
		{
			DeleteUser();
			break;
		}
		case 3:
		{
			ChangeUser();
			break;
		}
		case 4:
		{
			SearchUser();
			break;	
		}
		case 5:
		{
			System.out.println("程序退出成功！");
			IndexFrame m = new IndexFrame();
			m.show();
			break;
		}
		default:
		{
			System.out.println("请输入1~5中的数字！");
			break;
		}
		}
	}
}
	public void AddUser()
	{
	  Scanner scan = new Scanner(System.in);
	  System.out.println("请输入要添加用户姓名：");
		String name = scan.next();
		if(us.Login(name) != null)
		{
		   System.out.println("输入用户名存在！");	
		   System.out.println("请重新输入");
		   AddUser();
		}
		System.out.println("请输入要添加用户密码：");
		String password = scan.next();
		System.out.println("请输入要添加用户邮箱：");
		String email = scan.next();
		if(TypeEmail.checkEmail(email) == false)
		{
			System.out.println("邮箱格式错误！");
			System.out.println("请重新输入");
	        AddUser();
		}
		else if(us.SameEmail().contains(email) == true)
		  {
			  System.out.println("邮箱已经被注册！");
			  AddUser();
		  }
		else if(uc.AddUser(name, password, email))
  	  {
  		  System.out.println("添加用户成功！");
  	  }
  	  else
  	  {
  		  System.out.println("添加用户失败");
  	  }
	}
	public void DeleteUser()
	{
		for(User t:us.AllSelect())
		{
			System.out.println("ID = "+t.getId()+" "+" name = "+t.getName()+" "+"password = "+t.getPassword()
					+" "+"email = "+t.getEmail()+" "+"power = "+t.getPower());
		}
		Scanner scan = new Scanner(System.in);
		int ID = 0;
		System.out.println("请输入要删除用户的ID");
		try{
			ID = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			 System.out.println("ID输入错误！");
 			 DeleteUser();
 		  }
 		 if(uc.IDSelect(ID) == null)
 		{
  			 System.out.println("ID不存在。");
 			System.out.println("删除该用户失败！");
 			DeleteUser();
 		}
 		 else if(uc.IDSelect(ID).getPower() == 1)
 		  {
 			  System.out.println("该用户为管理员，不能删除！");
 			  
 		  }
 		 
		else 
		{
			uc.DeleteUser(ID);
			System.out.println("删除该用户成功！");
		}
	}
	public void ChangeUser()
	{
		
		for(User t:us.AllSelect())
		{
			System.out.println("ID = "+t.getId()+" "+" name = "+t.getName()+" "+"password = "+t.getPassword()
					+" "+"email = "+t.getEmail()+" "+"power = "+t.getPower());
		}
		
		System.out.println("请输入要修改用户的ID");
		Scanner scan = new Scanner(System.in);
		int ID = 0;
		try{
			ID = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			 System.out.println("ID输入错误！");
 			System.out.println("请重新输入");
 			ChangeUser();
 		  }
		System.out.println("请输入要修改后用户姓名：");
		String name = scan.next();
		if(us.Login(name) != null)
		{
		   System.out.println("输入用户名存在！");	
		   System.out.println("请重新输入");
		   ChangeUser();
		}
		System.out.println("请输入要修改后用户密码：");
		String password = scan.next();
		System.out.println("请输入要修改后用户邮箱：");
		String email = scan.next();
		if(TypeEmail.checkEmail(email) == false)
		{
			System.out.println("邮箱格式错误！");
			System.out.println("请重新输入");
			ChangeUser();
		}
		else if(us.SameEmail().contains(email) == true)
		  {
			  System.out.println("邮箱已经被注册！");
			  ChangeUser();
		  }
		else if(uc.MUpdate(ID, name, password, email) == true)
		{
			System.out.println("修改成功！");
		
		}else {
			System.out.println("修改成功！");
			System.out.println("ID不存在修改失败");
			ChangeUser();
		}
		
	}
	public void SearchUser()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("查询全部用户：---------1");
		System.out.println("根据ID查询用户：-------2");
		System.out.println("根据姓名查询用户：-------3");
		System.out.println("请输入你的选项：");
		
		try{
			num2 = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			  System.out.println("请输入1~3中数字");
 		  }
		switch (num2)
		{
		case 1:
		{
			if(us.AllSelect() != null)
			{
			for(User t:us.AllSelect())
			{
				System.out.println("ID = "+t.getId()+" "+" name = "+t.getName()+" "+"password = "+t.getPassword()
						+" "+"email = "+t.getEmail()+" "+"power = "+t.getPower());
			}
			}
			else
			{
				System.out.println("值为空查询失败！");
			}
			break;
		}
		case 2:
		{
			System.out.println("请输入要查询的用户ID");
			int m = scan.nextInt();
			if(us.IDSelect(m) != null){
				System.out.println("ID = "+us.IDSelect(m).getId()+" "+" name = "+us.IDSelect(m).getName()+" "+"password = "+us.IDSelect(m).getPassword()
						+" "+"email = "+us.IDSelect(m).getEmail()+" "+"power = "+us.IDSelect(m).getPower());
			}
			else
			{
				System.out.println("ID不存在");
			}
			break;
		}
		case 3:
		{
			System.out.println("请输入要查询用户的名字一部分");
			String PartName = scan.next();
			if(us.SimilarSelect(PartName) != null)
			{
			for(User t:us.SimilarSelect(PartName))
			{
				System.out.println("ID = "+t.getId()+" "+" name = "+t.getName()+" "+"password = "+t.getPassword()
						+" "+"email = "+t.getEmail()+" "+"power = "+t.getPower());
			}
			}
			else
			{
				System.out.println("输入字符不存在！");
			}
			break;
		}
		default:
		{
			System.out.println("请输入1~3中的数字！");
			break;
		}
		}
	}
}
