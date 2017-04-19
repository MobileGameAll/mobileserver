package br.eti.francisco.mobileserver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Jogador;

@RepositoryRestResource(collectionResourceRel = "jogador", path = "jogadores")
public interface JogadorDao extends PagingAndSortingRepository<Jogador, Integer>{
    
    @Query("select j from Jogador j where j.email= :email")
    Jogador findByEmail(@Param("email") String email);

    @Query("select j from Jogador j where j.facebookId= :facebookId")
    Jogador findByFacebook(@Param("facebookId") String facebookId);

}
