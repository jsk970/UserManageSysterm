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
	    		  System.out.println("��ӭʹ�������û�����ϵͳ");
	    	      System.out.println("====================");
	    	      System.out.println("�û���¼---------------1");
	    	      System.out.println("�û�ע��---------------2");
	    	      System.out.println("�˳�����---------------3");
	    	      System.out.println("��ѡ�������");
	    	         
	    		  try{
	    		   num = Integer.parseInt(scan.nextLine());
	    		   
	    		  }catch(Exception e)
	    		  {
	    			  System.out.println("������1~3������");
	    			  continue;
	    		  }
	    	      switch(num)
	    	      {
	    	      
	    	      case 1:{
	    	    	  System.out.println("�û���¼����");
	    	    	  System.out.println("=================");
	    	    	  System.out.println("�����������û���");
	    	    	  String name = scan.nextLine();
	    	    	  System.out.println("��������������");
	    	    	  String password = scan.nextLine();
	    	    	  if(uc.Login(name,password))
	    	    	  {
	    	    		  System.out.println("��½�ɹ���");
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
	    	    		  System.out.println("��¼ʧ�ܣ�");
	    	    	  }
	    	    	  break;
	    	      }
	    	      case 2:{
	    	    	  System.out.println("�û�ע�����");
	    	    	  System.out.println("=================");
	    	    	  System.out.println("�����������û���");
	    	    	  String name = scan.nextLine();
	    	    	  if(us.Login(name) != null)
	    	    	  {
	    	    		  System.out.println("�û����Ѿ����ڣ�");
	    	    		  break;
	    	    	  }
	    	    	  System.out.println("��������������");
	    	    	  String password = scan.nextLine();
	    	    	  System.out.println("��������������");
	    	    	  String email = scan.nextLine();
	    	    	  if(TypeEmail.checkEmail(email) == false)
	    	    	  {
	    	    		  System.out.println("�����ʽ����");
	    	    	  }else if(us.SameEmail().contains(email) == true)
	    	    	  {
	    	    		  System.out.println("�����Ѿ���ע�ᣡ");
	    	    	  }
	    	    	  else if (uc.AddUser(name, password, email)==true)
	    	    	  {
	    	    		  
	    	    		  System.out.println("ע��ɹ�");
	    	    	  }
	    	    	  break;
	    	      }
	    	      case 3:{
	    	    	  System.out.println("�˳�����ɹ���");
	    	    	  System.exit(0);
	    	    	  break;
	    	      }
	    	      default:{
	    	    	  System.out.println("������1~3������");
	    	    	  break;
	    	      }
	    	      }
	    		}
   }
}
