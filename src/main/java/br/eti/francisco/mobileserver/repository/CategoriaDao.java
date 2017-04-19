package br.eti.francisco.mobileserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Categoria;

@RepositoryRestResource(collectionResourceRel = "categoria", path = "categorias")
public interface CategoriaDao extends PagingAndSortingRepository<Categoria, Integer>{
    
}
