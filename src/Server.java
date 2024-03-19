import java.io.*;

public class Server {
	private static int MaxUserCount = 100, UserCount;
	private static User[] UserList = new User[MaxUserCount];

	public static void main(String[] args) {
		startsystem();
	}
	
	private static void startsystem() {
		//UserList[0] = new User();
		//UserList[0].Register(2004, 12, 7, "KIM", "JINWOO", "ADMIN");
		//FileSave(UserList);
		
		FileLoad();
		UserCount = UserList.length;
		UserList[0].Print();
	}
	
	private static void FileSave(User[] u) {
		try {
            FileOutputStream fileOut = new FileOutputStream("UserList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            out.writeObject(u);
            out.close();
            
            fileOut.close();
            
            System.out.println("객체가 직렬화되어 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static void FileLoad() {
		try {
            FileInputStream fileIn = new FileInputStream("UserList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            UserList = (User[]) in.readObject();
                        
            in.close();
            fileIn.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
	}
}

class User implements Serializable  {	
	int BirthY, BirthM, BirthD;
	String LastName, RealName, NickName;
		
	public void Register(int t_y, int t_m, int t_d, String ln, String rn, String nn) {
		BirthY = t_y;
		BirthM = t_m;
		BirthD = t_d;
		
		LastName = ln;
		RealName = rn;
		NickName = nn;
	}
	
	public void Print() {
		System.out.println(LastName + " " + RealName);
	}
}