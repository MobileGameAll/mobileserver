package br.eti.francisco.mobileserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.eti.francisco.mobileserver.model.Position;

@RepositoryRestResource(collectionResourceRel = "position", path = "positions")
public interface PositionDao extends PagingAndSortingRepository<Position, Integer>{

}
