package br.eti.francisco.mobileserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Desafio;

@RepositoryRestResource(collectionResourceRel = "desafio", path = "desafios")
public interface DesafioDao extends PagingAndSortingRepository<Desafio, Integer>{
    
    @Query("select d from Desafio d where d.id > :id")
    List<Desafio> listByLastId(@Param("id") int id);

}
