import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;


public class Server {
	private static int MaxUserCount = 100;
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
		UserList.add(new User(a, b, c, d, e, f));
        FileSave(UserList);
	}
	
	public static boolean Login(String id, String pw) {
		for(int i = 0; i < UserList.size(); i++) {
			if(UserList.get(i).idCompare(id)) {
				if(UserList.get(i).pwCompare(pw)) {
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