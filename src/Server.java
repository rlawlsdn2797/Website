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
		
		JFrame frm = new JFrame("로그인");
		frm.setSize(350, 300);
		frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setLayout(null);
        
        JFrame frm2 = new JFrame("회원가입");
        frm2.setSize(350, 300);
        frm2.setLocationRelativeTo(null);
        frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm2.getContentPane().setLayout(null);
      
        JButton btn1 = new JButton("로그인");
        JButton btn2 = new JButton("회원가입");
        JButton btn3 = new JButton("회원가입");
        JTextField text1 = new JTextField();
        JPasswordField text2 = new JPasswordField();
        JTextField text3 = new JTextField();
        JTextField text4 = new JTextField();
        JTextField text5 = new JTextField();
        JTextField text6 = new JTextField();
        JTextField text7 = new JTextField();
        JTextField text8 = new JTextField();
        JLabel label3 = new JLabel("아이디");
        JLabel label4 = new JLabel("비밀번호");
        JLabel label5 = new JLabel("성");
        JLabel label6 = new JLabel("이름");
        JLabel label7 = new JLabel("생년월일");
        JLabel label8 = new JLabel("닉네임");
        
        btn1.setBounds(30, 170, 122, 30);
        btn2.setBounds(182, 170, 122, 30);
        btn3.setBounds(110, 215, 122, 30);
        text1.setBounds(60, 50, 200, 25);
        text2.setBounds(60, 75, 200, 25);
        text3.setBounds(125, 25, 125, 25);
        label3.setBounds(50, 25, 200, 25);
        text4.setBounds(125, 55, 125, 25);
        label4.setBounds(50, 55, 200, 25);
        text5.setBounds(125, 85, 125, 25);
        label5.setBounds(50, 85, 200, 25);
        text6.setBounds(125, 115, 125, 25);
        label6.setBounds(50, 115, 200, 25);
        text7.setBounds(125, 145, 125, 25);
        label7.setBounds(50, 145, 200, 25);
        text8.setBounds(125, 175, 125, 25);
        label8.setBounds(50, 175, 200, 25);

        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
        frm.getContentPane().add(text1);
        frm.getContentPane().add(text2);
        
        frm2.getContentPane().add(text3);
        frm2.getContentPane().add(text4);
        frm2.getContentPane().add(text5);
        frm2.getContentPane().add(text6);
        frm2.getContentPane().add(text7);
        frm2.getContentPane().add(text8);
        
        frm2.getContentPane().add(btn3);
        
        frm2.getContentPane().add(label3);
        frm2.getContentPane().add(label4);
        frm2.getContentPane().add(label5);
        frm2.getContentPane().add(label6);
        frm2.getContentPane().add(label7);
        frm2.getContentPane().add(label8);
        
        btn1.addActionListener(e -> {
            Login(text1.getText(), text2.getText());
        });
        btn2.addActionListener(e -> {
        	frm.setVisible(false);
            frm2.setVisible(true);
        });
        btn3.addActionListener(e -> {
            frm.setVisible(true);
            frm2.setVisible(false); //생일 성 이름 닉네임 아이디 비번
            UserList.add(new User(text7.getText(), text5.getText(), text6.getText(), text8.getText(), text3.getText(), text4.getText()));
            FileSave(UserList);
        });
        
        frm.setVisible(true);
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