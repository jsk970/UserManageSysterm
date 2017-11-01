package TypeUtil;

public class TypeEmail {

	/**
	 * @param args
	 */
	public static boolean checkEmail(String email) {
		String mail = email.replaceAll ("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.]" +
                "[a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", "");
		if(mail.length() == 0){
			return true;
		} else {
			return false;
		}
	}

}
