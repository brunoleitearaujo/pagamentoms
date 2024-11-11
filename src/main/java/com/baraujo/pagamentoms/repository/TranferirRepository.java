package com.baraujo.pagamentoms.repository;

import com.baraujo.pagamentoms.entity.Transferir;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TranferirRepository extends JpaRepository<Transferir, UUID> {
}
