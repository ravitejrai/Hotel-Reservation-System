

import java.util.Date;
import javax.swing.JPanel;
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


public class Payment{
    
    private String Card_no;
    private Date Exp_date;
    private int security_code;

   public int processPayment(String name, String card_no, String exp_date, String security_code)
   {
	   return(save(name, card_no, exp_date, security_code));
   }
	
	
   public int createPayment(String name, String card_no, String exp_date, String security_code)
   {
		   return(save(name, card_no, exp_date, security_code));
   }
   

	public int save(String name, String card_no, String exp_date, String security_code)
	{
		DB_Connection conn = new DB_Connection();
		String ins_guest= "insert into Payment values ('" + card_no + "'," + Reservation.reservation_id + ",'" + Guest.phone_number + "','" + name + "','" + exp_date + "','" + security_code + "');" ;
		conn.Connect(ins_guest);
		return (Reservation.reservation_id);
	}
	
   
    
}
     