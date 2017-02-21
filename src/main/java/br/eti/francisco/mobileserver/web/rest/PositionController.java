package br.eti.francisco.mobileserver.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.francisco.mobileserver.model.Position;
import br.eti.francisco.mobileserver.repository.PositionDao;

@RestController
@RequestMapping(value="/position")
public class PositionController {

    @Autowired
    private PositionDao positionDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Position> position() {
        List<Position> target = new ArrayList<>();
        positionDao.findAll().forEach(target::add);
        return target;
    }

    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Position position) {
        positionDao.save(position);
        return ResponseEntity.ok(null);
    }
    
}
