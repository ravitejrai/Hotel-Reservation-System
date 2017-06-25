import java.awt.EventQueue;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class UI{

	public JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_Phone,textField_Phone1;
	private JTextField textField_Email,textField_Email1;
	private JTable CUSTOMER_table, bookloan_table, fines_table;
	private JTextField textField_ID;
	private JTextField textField_CARD;
	private JTextField textField_FNAME;
	private JTextField textField_LNAME;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_Date;
	private JTextField textField_Days;
	
	public static int res_type =0;
	public static int res_id =0;
	public static String name; 
    public static String card_no;
    public static String exp_date;
    public static String security_code;
    
	
/*public static void main(String[] args) {

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
	}
*/
	
	public UI() {
		initialize();     // makeNewReservation()
	}

	
	private void initialize() {
		RegisterController rc = new RegisterController();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize ( 500, 300 );
		frame.setLocationRelativeTo ( null );
		frame.setVisible ( true );
	    frame.getContentPane().setBackground(new Color(153, 204, 255));
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Reservation = new JPanel();
		tabbedPane.addTab("Reservation", null, Reservation, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Reservation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minoa Reservation System");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(475, 13, 657, 61);
		
		Reservation.add(lblNewLabel);
		

		JButton btnNewReservation = new JButton("Make New Reservation");
		btnNewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_Name.setText("");
	    	    textField_Phone.setText("");
	    	    textField_Email.setText("");
	    	    textField_Date.setText("");
	    	    textField_Days.setText("");
				rc.makeNewReservation();
				
				tabbedPane.setSelectedIndex(1);
			}});
		btnNewReservation.setBounds(500, 125, 250, 25);
		Reservation.add(btnNewReservation);
		
		
		JPanel CUSTOMER = new JPanel();
		tabbedPane.addTab("Guest", null, CUSTOMER, null);
		CUSTOMER.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("NAME *");
		lblNewLabel_2.setBounds(550, 125, 100, 30);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CUSTOMER.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PHONE_NO *");
		lblNewLabel_3.setBounds(550, 175, 100, 30);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CUSTOMER.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL");
		lblNewLabel_4.setBounds(550, 225, 100, 30);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CUSTOMER.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DATE");
		lblNewLabel_5.setBounds(550, 275, 100, 30);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CUSTOMER.add(lblNewLabel_5);
		
		JLabel lblNewLabel_61 = new JLabel("DAYS");
		lblNewLabel_61.setBounds(550, 325, 100, 30);
		lblNewLabel_61.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CUSTOMER.add(lblNewLabel_61);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(700, 125, 100, 30);
		CUSTOMER.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Phone = new JTextField();
		textField_Phone.setBounds(700, 175, 100, 30);
		CUSTOMER.add(textField_Phone);
		textField_Phone.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(700, 225, 100, 30);
		CUSTOMER.add(textField_Email);
		textField_Email.setColumns(10);
		

		textField_Date = new JTextField();
		textField_Date.setBounds(700, 275, 100, 30);
		CUSTOMER.add(textField_Date);
		textField_Date.setColumns(10);
		
		textField_Days = new JTextField();
		textField_Days.setBounds(700, 325, 100, 30);
		CUSTOMER.add(textField_Days);
		textField_Days.setColumns(10);

	    
	    JButton btnNewButton = new JButton("CHECK AVAILABILITY");
	    btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	String name = textField_Name.getText();
			String phone = textField_Phone.getText();
			String email = textField_Email.getText();
			String date = textField_Date.getText();
			String days = textField_Days.getText();
			rc.enterDetails(name,phone,email);
			
			try {
			boolean available = rc.checkAvailability(date, days);
			if (available) {
				tabbedPane.setSelectedIndex(2);
			}
			else {
				tabbedPane.setSelectedIndex(0);
				JOptionPane.showMessageDialog(frame, "Rooms not available");
			}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}});
		
		btnNewButton.setBounds(800, 375 , 250, 25);
		CUSTOMER.add(btnNewButton);
		

	    JButton btnNewButton1 = new JButton("CANCEL TRANSACTION");
	    
	    btnNewButton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		  			rc.cancelTransaction();
		  			textField_Name.setText("");
		    	    textField_Phone.setText("");
		    	    textField_Email.setText("");
		    	    textField_Date.setText("");
		    	    textField_Days.setText("");
		  			tabbedPane.setSelectedIndex(0);
		  			JOptionPane.showMessageDialog(frame, "Transaction Cancelled");
		  			
			}});
	    
	    btnNewButton1.setBounds(500, 375 , 250, 25);
		CUSTOMER.add(btnNewButton1);
			
		JPanel Type = new JPanel();
		tabbedPane.addTab("Reservation Type", null, Type, null);
		Type.setLayout(null);
		
		JLabel lbl1 = new JLabel("Select Reservation Type");
		lbl1.setBounds(70,20,500,30);
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    lbl1.setVisible(true);
	    Type.add(lbl1);

	    String[] choices_1 = { "Prepaid","60 Days Advance", "Conventional","Incentive"};

	    final JComboBox<String> types = new JComboBox<String>(choices_1);
	    types.setVisible(true);
	    types.setBounds(250,20,300,30);
	    Type.add(types);
				
		JButton btnNewButton_1 = new JButton("OK");
		Type.add(btnNewButton_1);		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				textField_14.setText("");
				textField_18.setText("");
				textField_15.setText("");
				textField_16.setText("");
				try{					
					 res_type = types.getSelectedIndex();
					 rc.enterType(res_type);			
					 float cost = 0;
					 cost = rc.calculateCost();
					 int dialogResult = JOptionPane.showConfirmDialog(frame, "The reservation cost is $"+cost, null,JOptionPane.OK_CANCEL_OPTION);
			            if (dialogResult == 0){
			            	System.out.println("dialog: "+dialogResult);
			            	tabbedPane.setSelectedIndex(3);			            	
			            }
			            else
			            {
			            	System.out.println("dialog: "+dialogResult);
			                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                 tabbedPane.setSelectedIndex(0);
			            }
			            	
			            	
				}
				catch(Exception ex){
					ex.printStackTrace();
			}
		}
			
				
			});
			btnNewButton_1.setBounds(83, 364, 132, 25);
		
						
			JPanel PaymentDetails = new JPanel();
            tabbedPane.addTab("PaymentDetails", null, PaymentDetails, null);
            PaymentDetails.setLayout(null);
            
            JLabel lblNewLabel_26 = new JLabel("NAME_ON_CARD");
            lblNewLabel_26.setBounds(120, 69, 122, 44);
            PaymentDetails.add(lblNewLabel_26);
            
            JLabel lblNewLabel_27 = new JLabel("CVV");
            lblNewLabel_27.setBounds(120, 99, 122, 44);
            PaymentDetails.add(lblNewLabel_27);
            
            JLabel lblNewLabel_28 = new JLabel("EXPIRATION DATE");
            lblNewLabel_28.setBounds(120, 129, 122, 44);
            PaymentDetails.add(lblNewLabel_28);
            
            JLabel lblNewLabel_30 = new JLabel("CARD_NUMBER");
            lblNewLabel_30.setBounds(120, 159, 122, 44);
            PaymentDetails.add(lblNewLabel_30);
            
            System.out.println(res_type);
           
            JButton btnNewButton_5 = new JButton("Save");
            
            
            btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					name = textField_14.getText();
					card_no = textField_18.getText();
					exp_date = textField_16.getText();
					security_code = textField_15.getText();
								
					
					try {
					Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(exp_date);
					res_id = rc.enterPaymentDetails(name,card_no, exp_date, security_code);
					
					if (res_type == 2 || res_type == 3)
					{
					JOptionPane.showMessageDialog(frame, "Successful! Reservation ID = "+ res_id );
					tabbedPane.setSelectedIndex(0);
					}
					else
					{
						tabbedPane.setSelectedIndex(4);
					}
					}
					catch (ParseException e){			
					}
				}});
            
            btnNewButton_5.setBounds(258, 240, 143, 25);
            PaymentDetails.add(btnNewButton_5);
           
            textField_14 = new JTextField();
            textField_14.setBounds(258, 80, 143, 25);
            PaymentDetails.add(textField_14);
            textField_14.setColumns(10);    
            
            textField_15 = new JTextField();
            textField_15.setBounds(258, 110, 143, 25);
            PaymentDetails.add(textField_15);
            textField_15.setColumns(10);
            
            textField_16 = new JTextField();
            textField_16.setBounds(258, 140, 143, 25);
            PaymentDetails.add(textField_16);
            textField_16.setColumns(10);
			
            textField_18 = new JTextField();
            textField_18.setBounds(258, 170, 143, 25);
            PaymentDetails.add(textField_18);
            textField_18.setColumns(10);
            
            //Make Payment
            JPanel MakePayment = new JPanel();
            tabbedPane.addTab("MakePayment", null, MakePayment, null);
    		tabbedPane.setForegroundAt(0, Color.BLACK);
    		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
    		MakePayment.setLayout(null);
    		MakePayment.setEnabled(false);
    		
    		JButton btnPay = new JButton("Make Payment");
    		btnPay.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {   
    			if (res_type == 2 || res_type == 3)
    			{	
    			res_id = rc.makePayment(name,card_no, exp_date, security_code);
    			
    			JOptionPane.showMessageDialog(frame, "Successful! Reservation ID = "+ res_id );
				tabbedPane.setSelectedIndex(0);
    			}
    			}});
    		btnPay.setBounds(500, 125, 250, 25);
    		MakePayment.add(btnPay);
      
}
}