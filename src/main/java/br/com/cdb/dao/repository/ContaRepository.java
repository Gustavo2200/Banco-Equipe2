package br.com.cdb.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends jpaRepository<Conta,Integer> {

}
