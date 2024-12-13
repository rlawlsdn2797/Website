import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class Server {
	private static int MaxUserCount = 100; //유저 최대 길이
	private static ArrayList<User> UserList = new ArrayList<User>();

	public static void main(String[] args) {
		startsystem();
	}
	
	private static void startsystem() {				
		FileLoad();
	}
	
	private static void FileSave(ArrayList u) {
		try {
            FileOutputStream fileOut = new FileOutputStream("UserList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            out.writeObject(u);
            out.close();
            
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static void FileLoad() {
		try {
			File file = new File("UserList.ser");
			
			if(!file.exists()) {
				UserList.add(new User("20041207", "KIM", "JINWOO", "ADMIN", "admin", "1234"));
	            FileSave(UserList);
			}
			
            FileInputStream fileIn = new FileInputStream("UserList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            UserList = (ArrayList<User>) in.readObject();
                                    
            in.close();
            fileIn.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
	}
	
	public static void Register(String a, String b, String c, String d, String e, String f) {
		//저장 순서: 생년월일, 성, 이름, 닉네임, 아이디, 비밀번호.
		String hash = hashPassword(f);
		UserList.add(new User(a, b, c, d, e, hash));
				
        FileSave(UserList);
	}
	
	public static boolean Login(String id, String pw) {
		for(int i = 0; i < UserList.size(); i++) {
			if(UserList.get(i).idCompare(id)) { //유저 리스트에 ID가 있는가?
				if(UserList.get(i).pwCompare(hashPassword(pw))) { //유저 리스트에 그 ID와 PW가 맞는가?
					System.out.println("로그인 성공 / 닉네임 : " + UserList.get(i).GetName());
					return true;
				}
				else {
					System.out.println("비밀번호가 틀렸습니다.");
					return false;
				}
			}
		}
		
		System.out.println("존재하지 않는 아이디입니다.");
		return false;
	}
	
	public static String hashPassword(String password) { //해시 함수
        try {
        	System.out.println(password);
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //SHA-256 타입
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            System.out.println(hexString.toString());
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("해쉬 에러: ", e);
        }
    }
}

class User implements Serializable  {	
	private String Birth;
	private String LastName, RealName, NickName;
	private String id, pw;
	
	public User(String Birth, String LastName, String RealName, String NickName, String id, String pw) {
		this.Birth = Birth;
		
		this.LastName = LastName;
		this.RealName = RealName;
		this.NickName = NickName;
		
		this.id = id;
		this.pw = pw;
	}
	
	public void Print() {
		System.out.println(NickName);
	}
	
	public boolean idCompare(String t_id) {
		if(id.equals(t_id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean pwCompare(String t_pw) {
		if(pw.equals(t_pw)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String GetName() {
		return LastName + " " + RealName;
	}
}