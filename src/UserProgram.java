import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserProgram {
	public static void main(String args[]) {
		Server ser = new Server();
		
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
        JButton btn4 = new JButton("뒤로가기");
        JTextField text1 = new JTextField(); //로그인 아이디
        JPasswordField text2 = new JPasswordField(); //로그인 비번
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
        btn3.setBounds(30, 215, 122, 30);
        btn4.setBounds(182, 215, 122, 30);
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
        frm2.getContentPane().add(btn4);
        
        frm2.getContentPane().add(label3);
        frm2.getContentPane().add(label4);
        frm2.getContentPane().add(label5);
        frm2.getContentPane().add(label6);
        frm2.getContentPane().add(label7);
        frm2.getContentPane().add(label8);
        
        btn1.addActionListener(e -> {
            ser.Login(text1.getText(), text2.getText());
        });
        
        btn2.addActionListener(e -> {
        	frm.setVisible(false);
            frm2.setVisible(true);
            
            text1.setText(null);
            text2.setText(null);
        });
        
        btn3.addActionListener(e -> {
            frm.setVisible(true);
            frm2.setVisible(false); //생일 성 이름 닉네임 아이디 비번
            
            if(text3.getText().isEmpty()) {
            	return;
            }
            else if(text4.getText().isEmpty()) {
            	return;
            }
            else if(text5.getText().isEmpty()) {
            	return;
            }
            else if(text6.getText().isEmpty()) {
            	return;
            }
            else if(text7.getText().isEmpty()) {
            	return;
            }
            else if(text8.getText().isEmpty()) {
            	return;
            }

            System.out.println("회원가입 완료");
            
            ser.Register(text7.getText(), text5.getText(), text6.getText(), text8.getText(), text3.getText(), text4.getText());
            
            text3.setText(null);
            text4.setText(null);
            text5.setText(null);
            text6.setText(null);
            text7.setText(null);
            text8.setText(null);
        });
        
        btn4.addActionListener(e -> {
            frm.setVisible(true);
            frm2.setVisible(false); //생일 성 이름 닉네임 아이디 비번
            
            text3.setText(null);
            text4.setText(null);
            text5.setText(null);
            text6.setText(null);
            text7.setText(null);
            text8.setText(null);
        });
        
        frm.setVisible(true);
	}
}
