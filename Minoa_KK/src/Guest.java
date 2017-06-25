
public class Guest {
	public static String Name;
	public static String phone_number;
	public static String email;
	
	public Guest(String name, String phone_no, String email)
	{
		Name = name;
		phone_number = phone_no;
		this.email = email ;
		System.out.println("guest object created");
	}
	public void create() {
        System.out.println("Object created");
    }
    
    public void destroy(){
        System.out.println("Object Destroyed");
    }
		
	public void save()
	{
		DB_Connection conn = new DB_Connection();
		System.out.println("resid "+ Reservation.reservation_id);
		String ins_guest= "insert into Guest values ('" + phone_number + "'," + Reservation.reservation_id + ", '" + Name + "','" + email + "');" ;
		conn.Connect(ins_guest);
	}
}
