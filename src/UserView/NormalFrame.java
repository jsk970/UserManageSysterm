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
	System.out.println(p.getName()+"����"+"   "+"����Ȩ���ǣ���ͨ�û�");
	System.out.println("==================");
	Scanner scan = new Scanner(System.in);
	while(true)
	{
		System.out.println("�޸��Լ����û�--------1");
		System.out.println("��ѯ�Լ����û�--------2");
		System.out.println("�����˳�------------3");
		System.out.println("============");
		try{
 		   num3 = Integer.parseInt(scan.nextLine());
 		   
 		  }catch(Exception e)
 		  {
 			  System.out.println("������1~3������");
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
			System.out.println("�����˳��ɹ���");
			IndexFrame m = new IndexFrame();
			m.show();
			break;
		}
		default:
		{
			System.out.println("������1~3����");
			break;
		}
		}
	}
}
public void ChangeUser(User p){
	Scanner scan = new Scanner(System.in);
	System.out.println("������Ҫ�޸ĵ�name");
	String name = scan.next();
	if(us.Login(name) != null)
	{
	   System.out.println("�����û������ڣ�");	
	   System.out.println("����������");
	 ChangeUser(p);
	}
	System.out.println("������Ҫ�޸ĵ�password");
	String password = scan.next();
	System.out.println("������Ҫ�޸ĵ�email");
	String email = scan.next();
	if(TypeEmail.checkEmail(email) == false)
	{
		System.out.println("�����ʽ����");
		System.out.println("����������");
		ChangeUser(p);
	}
	else if(us.SameEmail().contains(email) == true)
	  {
		  System.out.println("�����Ѿ���ע�ᣡ");
		  ChangeUser(p);
	  }
	else if(uc.Update(p.getId(), name, password, email))
	{
		System.out.println("�޸ĳɹ���");
	}
	else
	{
		System.out.println("�޸�ʧ�ܣ�");
	}
}
public void SearchUser(User p){
	
	if(us.IDSelect(p.getId()) != null){
		System.out.println("ID = "+p.getId()+" "+" name = "+p.getName()+" "+"password = "+p.getPassword()
				+" "+"email = "+p.getEmail()+" "+"power = "+p.getPower());
	}
	else
	{
		System.out.println("ID������");
	}
}
}
