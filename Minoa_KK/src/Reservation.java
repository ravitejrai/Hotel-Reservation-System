
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reservation {
		
		private int ID;
		private Date date;
		private int no_of_days;
		private float cost;
		private String status;
		private Date check_in;
		private Date check_out;
		private float amount_paid;
		private static int res_type=0;
		private static String  res_date;
		private static Date date1;
		public static int reservation_id;
		
	    Reservation() {
			System.out.println("Reservation Initialized");
		}
	    public void create() {
	        System.out.println("Object created");
	    }
	    
	    public void destroy(){
	        System.out.println("Object Destroyed");
	    }
			
		public void enterType(int type){
			res_type = type;
			System.out.println(res_type);
		}
		
		public boolean checkAvailability(String date, String days) throws ParseException {
			int num = 10;
			no_of_days = Integer.parseInt(days) ;
			 	//date="31/12/1998";  
			date1 = new SimpleDateFormat("yyyy-mm-dd").parse(date); 
			boolean availability = false;
			res_date = date;
		        String query = "select count(*) as Available from reservation where Date ='" + date1 + "';";
		        
		        DB_Connection chk = new DB_Connection();
		        try {
		         ResultSet l = chk.Connection(query);					
					if (l.next() ) {
						num = l.getInt("Available");			    			    
					}
					if (num < 45){
			        	availability = true; }
			        else {
			        	availability = false; }
		        }
		         catch (Exception e) {}
		         return availability;
		}		
		
		public float calculate_cost()
		{
			int occupancy = 0;
			BaseRate br = new BaseRate();
			   if (res_type == 0){
			         cost = (float) (br.amount * 0.75 * no_of_days) ;
			    }
			    
			    if (res_type == 1) {
			        cost = (float) (br.amount * 0.85 * no_of_days) ;
			    }
			    
			    if (res_type == 2) {
			        cost = br.amount * no_of_days ;
			    }
			    
			    if (res_type == 3) {
			            
			        // connect to database 
			        // perform query on reservation table
			    	 String query = "select count(*) as Occ from reservation where Date ='" + res_date + "';";
				        DB_Connection chk = new DB_Connection();
				        try {
				         ResultSet l = chk.Connection(query);					
							if (l.next() ) {
								occupancy = l.getInt("Occ");							    			    
							}
							System.out.println(occupancy);
				        }
					    catch (Exception e) {}	
			        occupancy = (occupancy/45) * 100;
			        if (occupancy == 50)
			        	cost = (float) (br.amount * 0.8 * no_of_days) ;
			        else if (occupancy < 50)
			        	cost = (float) (br.amount * 0.7 * no_of_days) ;
			        else
			            cost = br.amount * no_of_days ;
				        }
			    return cost;
			}
		
		public int save()
		{
			DB_Connection conn = new DB_Connection();
			String ins_reservation= "insert into minoa.reservation values (null,'" + res_date + "',1,null,null," + cost +"," + res_type + "," + amount_paid + ");" ;			
			conn.Connect(ins_reservation);
			String read_reservation = "select max(reservation_id) as id from minoa.reservation";
			DB_Connection chk = new DB_Connection();
	        try {
	         ResultSet l = chk.Connection(read_reservation);					
				if (l.next() ) {
					reservation_id = l.getInt("id");							    			    
				}				
	        }
				catch (Exception e) {}
			return reservation_id;
	        }
		
		}
		
		
		

		
