import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;

public class Server {
	private static int MaxUserCount = 100, UserCount;
	private static ArrayList<User> UserList = new ArrayList<User>();

	public static void main(String[] args) {
		startsystem();
	}
	
	private static void startsystem() {
		//UserList.add(new User(2004, 12, 7, "KIM", "JINWOO", "ADMIN", "kjw2797", "jin5858"));
		//FileSave(UserList);
				
		//FileLoad();
		//UserCount = Length();
	}
	
	private static int Length() {
		for(int i = 0; i < MaxUserCount; i++) {
			try {
				
			}
			catch (NullPointerException e) {
				return i;
			}
		}
		
		return 100;
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
	
	private static boolean Login(String id, String pw) {
		for(int i = 0; i < UserCount; i++) {
			/*if(UserList.get(i).idCompare(id)) {
				if(UserList[i].pwCompare(pw)) {
					System.out.println("로그인 성공");
					return true;
				}
				else {
					System.out.println("비밀번호가 틀렸습니다.");
					return false;
				}
			}*/
		}
		
		System.out.println("존재하지 않는 아이디입니다.");
		return false;
	}
}

class User implements Serializable  {	
	private int BirthY, BirthM, BirthD;
	private String LastName, RealName, NickName;
	private String id, pw;
		
	public User(int t_y, int t_m, int t_d, String ln, String rn, String nn, String t_id, String t_pw) {
		BirthY = t_y;
		BirthM = t_m;
		BirthD = t_d;
		
		LastName = ln;
		RealName = rn;
		NickName = nn;
		
		id = t_id;
		pw = t_pw;
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