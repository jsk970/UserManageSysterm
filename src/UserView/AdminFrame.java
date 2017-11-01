package UserView;

import java.util.Scanner;

import TypeUtil.TypeEmail;
import bean.User;

public class AdminFrame extends NormalFrame {
	public int num1 = 0;
	public int num2 = 0;
	public void show(User x){
	System.out.println("==================");
	System.out.println(x.getName()+"����"+"   "+"����Ȩ���ǣ�����Ա");
	System.out.println("==================");
	Scanner scan = new Scanner(System.in);
	while(true)
	{
		System.out.println("����û�------------1");
		System.out.println("ɾ���û�------------2");
		System.out.println("�޸��û�------------3");
		System.out.println("��ѯ�û�------------4");
		System.out.println("�����˳�------------5");
		System.out.println("������1~5֮�����ݣ�");	
		try{
			num1 = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			  System.out.println("�������������1~5������");
 			  
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
			System.out.println("�����˳��ɹ���");
			IndexFrame m = new IndexFrame();
			m.show();
			break;
		}
		default:
		{
			System.out.println("������1~5�е����֣�");
			break;
		}
		}
	}
}
	public void AddUser()
	{
	  Scanner scan = new Scanner(System.in);
	  System.out.println("������Ҫ����û�������");
		String name = scan.next();
		if(us.Login(name) != null)
		{
		   System.out.println("�����û������ڣ�");	
		   System.out.println("����������");
		   AddUser();
		}
		System.out.println("������Ҫ����û����룺");
		String password = scan.next();
		System.out.println("������Ҫ����û����䣺");
		String email = scan.next();
		if(TypeEmail.checkEmail(email) == false)
		{
			System.out.println("�����ʽ����");
			System.out.println("����������");
	        AddUser();
		}
		else if(us.SameEmail().contains(email) == true)
		  {
			  System.out.println("�����Ѿ���ע�ᣡ");
			  AddUser();
		  }
		else if(uc.AddUser(name, password, email))
  	  {
  		  System.out.println("����û��ɹ���");
  	  }
  	  else
  	  {
  		  System.out.println("����û�ʧ��");
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
		System.out.println("������Ҫɾ���û���ID");
		try{
			ID = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			 System.out.println("ID�������");
 			 DeleteUser();
 		  }
 		 if(uc.IDSelect(ID) == null)
 		{
  			 System.out.println("ID�����ڡ�");
 			System.out.println("ɾ�����û�ʧ�ܣ�");
 			DeleteUser();
 		}
 		 else if(uc.IDSelect(ID).getPower() == 1)
 		  {
 			  System.out.println("���û�Ϊ����Ա������ɾ����");
 			  
 		  }
 		 
		else 
		{
			uc.DeleteUser(ID);
			System.out.println("ɾ�����û��ɹ���");
		}
	}
	public void ChangeUser()
	{
		
		for(User t:us.AllSelect())
		{
			System.out.println("ID = "+t.getId()+" "+" name = "+t.getName()+" "+"password = "+t.getPassword()
					+" "+"email = "+t.getEmail()+" "+"power = "+t.getPower());
		}
		
		System.out.println("������Ҫ�޸��û���ID");
		Scanner scan = new Scanner(System.in);
		int ID = 0;
		try{
			ID = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			 System.out.println("ID�������");
 			System.out.println("����������");
 			ChangeUser();
 		  }
		System.out.println("������Ҫ�޸ĺ��û�������");
		String name = scan.next();
		if(us.Login(name) != null)
		{
		   System.out.println("�����û������ڣ�");	
		   System.out.println("����������");
		   ChangeUser();
		}
		System.out.println("������Ҫ�޸ĺ��û����룺");
		String password = scan.next();
		System.out.println("������Ҫ�޸ĺ��û����䣺");
		String email = scan.next();
		if(TypeEmail.checkEmail(email) == false)
		{
			System.out.println("�����ʽ����");
			System.out.println("����������");
			ChangeUser();
		}
		else if(us.SameEmail().contains(email) == true)
		  {
			  System.out.println("�����Ѿ���ע�ᣡ");
			  ChangeUser();
		  }
		else if(uc.MUpdate(ID, name, password, email) == true)
		{
			System.out.println("�޸ĳɹ���");
		
		}else {
			System.out.println("�޸ĳɹ���");
			System.out.println("ID�������޸�ʧ��");
			ChangeUser();
		}
		
	}
	public void SearchUser()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("��ѯȫ���û���---------1");
		System.out.println("����ID��ѯ�û���-------2");
		System.out.println("����������ѯ�û���-------3");
		System.out.println("���������ѡ�");
		
		try{
			num2 = Integer.parseInt(scan.nextLine());
			
 		  }catch(Exception e)
 		  {
 			  System.out.println("������1~3������");
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
				System.out.println("ֵΪ�ղ�ѯʧ�ܣ�");
			}
			break;
		}
		case 2:
		{
			System.out.println("������Ҫ��ѯ���û�ID");
			int m = scan.nextInt();
			if(us.IDSelect(m) != null){
				System.out.println("ID = "+us.IDSelect(m).getId()+" "+" name = "+us.IDSelect(m).getName()+" "+"password = "+us.IDSelect(m).getPassword()
						+" "+"email = "+us.IDSelect(m).getEmail()+" "+"power = "+us.IDSelect(m).getPower());
			}
			else
			{
				System.out.println("ID������");
			}
			break;
		}
		case 3:
		{
			System.out.println("������Ҫ��ѯ�û�������һ����");
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
				System.out.println("�����ַ������ڣ�");
			}
			break;
		}
		default:
		{
			System.out.println("������1~3�е����֣�");
			break;
		}
		}
	}
}
