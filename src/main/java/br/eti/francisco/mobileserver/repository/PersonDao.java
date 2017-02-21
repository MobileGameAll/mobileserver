package br.eti.francisco.mobileserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Person;

@RepositoryRestResource(collectionResourceRel = "person", path = "persons")
public interface PersonDao extends PagingAndSortingRepository<Person, Integer>{

}
