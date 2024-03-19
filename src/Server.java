public class Server {
	public static void main(String[] args) {
		startsystem();
	}
	
	private static void startsystem() { //시스템시작
		int MaxUserCount = 100;
		User[] u = new User[MaxUserCount];
		
		int UserCount = 10;
		
		u[0].Register(2004, 12, 7, "KIM", "JINWOO", "ADMIN");
	}
}

class User {
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
}