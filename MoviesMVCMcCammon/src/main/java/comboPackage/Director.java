package comboPackage;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="director")
public class Director {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Director(String firstName, String lastName, String address, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.setGender(gender);
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		final String INVALID_GENDER = "unknown";
		
		if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
			this.gender = gender.toLowerCase();
		} else {
			this.gender = INVALID_GENDER;
		}
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", gender=" + gender + "]";
	}
}
