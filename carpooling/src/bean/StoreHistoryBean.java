package bean;

public class StoreHistoryBean 
{
	private String id;
	private String p_id;
	private String p_name;
	private String p_mobile;
	private String p_mail;
	private String p_available_seats;
	public String getP_available_seats() {
		return p_available_seats;
	}
	public void setP_available_seats(String p_available_seats) {
		this.p_available_seats = p_available_seats;
	}
	private String p_booked_seats;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_mobile() {
		return p_mobile;
	}
	public void setP_mobile(String p_mobile) {
		this.p_mobile = p_mobile;
	}
	public String getP_mail() {
		return p_mail;
	}
	public void setP_mail(String p_mail) {
		this.p_mail = p_mail;
	}
	public String getP_booked_seats() {
		return p_booked_seats;
	}
	public void setP_booked_seats(String p_booked_seats) {
		this.p_booked_seats = p_booked_seats;
	}
	
	
}
