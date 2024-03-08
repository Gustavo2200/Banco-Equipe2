package br.com.cdb.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import br.com.cdb.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long> {

}
