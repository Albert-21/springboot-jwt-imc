package com.grokonez.jwtauthentication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Pesos;
import java.util.List;


@Repository
public interface PesosRepository extends JpaRepository<Pesos, Long>{

    List<Pesos> findByUsername(String username);
}