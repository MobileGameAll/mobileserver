package br.eti.francisco.mobileserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.DeckJogador;

@RepositoryRestResource(collectionResourceRel = "carta", path = "cartas")
public interface CartaJogadorDao extends PagingAndSortingRepository<DeckJogador, Integer>{
    

}
