package it.webapp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customer", catalog = "iagica")
public class Customer {

    private Integer idCustomer;
    private String nome;
    private String cognome;
    private Date data_nascita;
    private String telefono;
    private String email;
    private Integer iduser_x;


    public Customer() {
    }

    public Customer(String nome, String cognome, Date data_nascita, String telefono, String email, Integer iduser_x) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.telefono = telefono;
        this.email = email;
        this.iduser_x = iduser_x;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idcustomer", nullable = false)
    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Column(name = "cognome")
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    @Column(name = "data_nascita")
    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "iduser_x")
    public Integer getIduser_x() {
        return iduser_x;
    }

    public void setIduser_x(Integer iduser_x) {
        this.iduser_x = iduser_x;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", iduser_x=" + iduser_x +
                '}';
    }
}

