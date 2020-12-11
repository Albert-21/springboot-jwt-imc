package com.grokonez.jwtauthentication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Pesos;

@Repository
public interface PesosRepository extends JpaRepository<Pesos, Long>{

}