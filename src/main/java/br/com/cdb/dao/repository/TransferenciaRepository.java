package br.com.cdb.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdb.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer>{

}
