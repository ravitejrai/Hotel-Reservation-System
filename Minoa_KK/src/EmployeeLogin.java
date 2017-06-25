
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class Login extends JFrame implements ActionListener
{
 /**
     * 
     */
    private static final long serialVersionUID = 1L;
JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
    Login()
    {
    	JLabel title = new JLabel("Minoa Reservation System");
    	title.setForeground(Color.BLACK);
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setBounds(10, 13, 50, 61);
		
		
        label1 = new JLabel();
        label1.setText("Employee Name:");
        text1 = new JTextField(15);
        label1.setBounds(10, 40, 50, 30);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		

        label2 = new JLabel();
        label2.setText("Password:");
        text2 = new JPasswordField(15);
        label2.setBounds(10, 80, 100, 30);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		        
        SUBMIT=new JButton("SUBMIT");
        
     //   panel=new JPanel(new GridLayout(4,2));
        panel=new JPanel();
        panel.add(title);
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        setTitle("MINOA LOGIN FORM");
    }
   public void actionPerformed(ActionEvent ae)
    {
        String value1=text1.getText();
        String value2=text2.getText();
        if (value1.equals("employee") && value2.equals("employee")) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                    	UI window = new UI();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        /*JLabel label = new JLabel("Welcome:"+value1);
        page.getContentPane().add(label);*/
    }
        else{
            System.out.println("enter the valid username and password");
            JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
    }
}


public static void main(String[] args) 
{
    try
    {
    Login frame=new Login();
    frame.setSize(325,300);
    frame.setVisible(true);    
    }
    
catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());}
}

}
