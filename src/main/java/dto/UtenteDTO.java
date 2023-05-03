package dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "utente")
public class UtenteDTO {
	@Override
	public String toString() {
		return "UtenteDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
//	
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private List<TrenoDTO> trenoDto = new ArrayList<>();

	public UtenteDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UtenteDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
