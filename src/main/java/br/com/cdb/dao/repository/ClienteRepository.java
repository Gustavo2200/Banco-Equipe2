package br.com.cdb.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import br.com.cdb.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
