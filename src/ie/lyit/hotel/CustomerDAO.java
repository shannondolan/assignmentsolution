package ie.lyit.hotel;


public interface CustomerDAO {
	

	public void add(); 
	public void list(); 
	public Customer view();
	public void edit();
	public void delete();
	public void serialize();
	public void deserialize(); 

}
