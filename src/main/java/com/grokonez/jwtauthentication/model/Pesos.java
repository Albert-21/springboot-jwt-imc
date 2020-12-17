package com.grokonez.jwtauthentication.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pesos")
public class Pesos {
    private long id_user;
    private String username;
    private String imc;
    private String estado;
    private String peso_min;
    private String peso_max;
 
 
    public Pesos() {
  
    }
 
    public Pesos(String username, long id_user, String imc, String estado, String peso_min, String peso_max) {
        this.username = username;
        this.id_user = id_user;
        this.imc = imc;
        this.estado= estado;
        this.peso_min =  peso_min;
        this.peso_max = peso_max;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id_user;
    }
    public void setId(long id_user) {
        this.id_user = id_user;
    }
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
 
    @Column(name = "imc", nullable = false)
    public String getImc() {
        return imc;
    }
    public void setImc(String imc) {
        this.imc = imc;
    }
 
    @Column(name = "estado", nullable = false)
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
 
    @Column(name = "peso_min", nullable = false)
    public String getPeso_min() {
        return peso_min;
    }
    public void setPeso_min(String peso_min) {
        this.peso_min = peso_min;
    }
    
    @Column(name = "peso_max", nullable = false)
    public String getPeso_max() {
        return peso_max;
    }
    public void setPeso_max(String peso_max) {
        this.peso_max = peso_max;
    }

    @Override
    public String toString() {
        return "Pesos [id=" + id_user + ", imc=" + imc + ", estado=" + estado + ", peso_min=" + peso_min
        + ", peso_max=" + peso_max + "]";
    }
 
}