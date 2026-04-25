package com.upiiz.examen2.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;

    private String titular;
    private String email;
    private String password;


    public Cuenta() {}

    public Cuenta(Long id, String titular, String email, String password) {
        this.id = id;
        this.titular = titular;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters... (los que ya tenías están perfectos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}