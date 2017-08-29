package br.eti.francisco.mobileserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Message;

@RepositoryRestResource(collectionResourceRel = "message", path = "messages")
public interface MessageDao extends PagingAndSortingRepository<Message, Integer>{

    @Query("select m from Message m where m.token = :token and m.type = :type")
    List<Message> findByTokenType(@Param("token")String token, @Param("type")String type);

}
