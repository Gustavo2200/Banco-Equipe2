package br.com.cdb.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdb.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

}
