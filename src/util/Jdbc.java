package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc implements Serializable {

	/**
	 * @param args
	 */
	 private static final long serialVersionUID=1L;
     private static String DB_USER;
     private static String DB_PWD;
     private static String DB_URL;
     private static String DB_DRIVER;
     private static Properties properties ;
     static{
    	 //ʵ����
    	 properties = new Properties();
    	 //�����ļ�
    	 InputStream in = Jdbc.class.getClassLoader().getResourceAsStream("db.properties");
    	 //װ���ļ�
    	 try {
			properties.load(in);
			//��ֵ
			DB_USER = properties.getProperty("db_user");
			DB_PWD = properties.getProperty("db_pwd");
			DB_URL = properties.getProperty("db_url");
			DB_DRIVER = properties.getProperty("db_driver");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     }
     /**
      * 
      * @return
      * @throws SQLException
      */
     public static Connection getConnection()throws SQLException{
    	 //��������
    	 try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����Connection
		return DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
     }
     public static void close(
    	 Connection conn,Statement st,ResultSet rs){
    	 
    		 
    			 try {
    				 if(conn != null){
					conn.close();
					}
    				 if(st != null){
    					 st.close();
    				 }
    				 if(rs != null)
    				 {
    					 rs.close();
    				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		 }
}
