import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class RegisterController {
	
	static Reservation r ;
	static Guest g;
	static Payment p;
	
	public static void makeNewReservation() {
		r = new Reservation();
	}
	
	public int makePayment(String name, String card_no, String exp_date, String security_code) {
		if (UI.res_type == 0 || UI.res_type == 1)  //prepaid or 60 days advance
		{
			r.save();
			g.save();
			p = new Payment();			
			return (p.processPayment(name, card_no, exp_date,security_code));
		}
		else 
			return 0;
		
	}
	
	public void enterDetails(String name, String phone_no, String email) {
		g = new Guest(name, phone_no, email);
	}
	public void cancelTransaction() {
		System.out.println("cancelled transaction");
		
	}
	
	public int enterPaymentDetails(String name, String card_no, String exp_date, String security_code) {
		if (UI.res_type == 2 || UI.res_type == 3)   //conventional or incentive
		{			
			r.save();
			g.save();
			p = new Payment();
			return (p.createPayment(name, card_no, exp_date,security_code));
		}
		else
			return 0;
				
		
	}
	
	public float calculateCost() {
		return (r.calculate_cost());	
		
	}
	public void enterType(int type){
			r.enterType(type);
	}
	public boolean checkAvailability(String date, String no_of_days) throws ParseException{
		
	  RegisterController.makeNewReservation();
	  boolean availability = r.checkAvailability(date,no_of_days);	
	  return availability;
	}
}



