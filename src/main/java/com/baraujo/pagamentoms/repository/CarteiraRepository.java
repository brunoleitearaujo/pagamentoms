package com.baraujo.pagamentoms.repository;

import com.baraujo.pagamentoms.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    Optional<Carteira> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
