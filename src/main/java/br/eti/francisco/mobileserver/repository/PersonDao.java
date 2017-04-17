package br.eti.francisco.mobileserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Person;

@RepositoryRestResource(collectionResourceRel = "person", path = "persons")
public interface PersonDao extends PagingAndSortingRepository<Person, Integer>{
    
    
    @Query("select a from Person a where upper(a.name) like upper(:name)")
    List<Person> listByName(@Param("name") String name);

}
