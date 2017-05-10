package br.eti.francisco.mobileserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.DeckJogador;

@RepositoryRestResource(collectionResourceRel = "deck", path = "decks")
public interface DeckJogadorDao extends PagingAndSortingRepository<DeckJogador, Integer>{
    

}
