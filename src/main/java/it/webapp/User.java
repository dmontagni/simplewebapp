package it.webapp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "iduser", nullable = false)
    private Integer idUser;
	@Column(name = "username")
    private String username;
	@Column(name = "password")
    private String password;
	@Column(name = "nome")
    private String nome;
	@Column(name = "cognome")
    private String cognome;
	@Column(name = "data_nascita")
    private Date data_nascita;
	@Column(name = "telefono")
    private String telefono;
	@Column(name = "email")
    private String email;


    public User() {
    }



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    
    

	public User(String password,String nome, String cognome, Date data_nascita, String telefono, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}



	public Integer getIdUser() {
		return idUser;
	}



	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public Date getData_nascita() {
		return data_nascita;
	}



	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", data_nascita=" + data_nascita + ", telefono=" + telefono + ", email="
				+ email + "]";
	}

  
    
}