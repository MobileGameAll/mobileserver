package br.eti.francisco.mobileserver.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.francisco.mobileserver.model.Desafio;
import br.eti.francisco.mobileserver.repository.CategoriaDao;
import br.eti.francisco.mobileserver.repository.DesafioDao;
import br.eti.francisco.mobileserver.repository.JogadorDao;


@RestController
@RequestMapping(value="/educ")
public class DesafioController {

    @Autowired
    private DesafioDao desafioDao;
    
    @Autowired
    private JogadorDao jogadorDao;
    
    @Autowired
    private CategoriaDao categoriaDao;

    
    @RequestMapping(value="/desafio", method = RequestMethod.GET)
	public List<Desafio> desafio() {
		List<Desafio> target = new ArrayList<>();
		desafioDao.findAll().forEach(target::add);
		return target;
	}

    @RequestMapping(value = "/desafio/{id}", method = RequestMethod.GET)
    public Desafio desafio(@PathVariable int id) {
        return desafioDao.findOne(id);
    }

    @RequestMapping(value = "/desafio/byLastId/{id}", method = RequestMethod.GET)
    public List<Desafio> desafio(@PathVariable Integer id) {
        return desafioDao.listByLastId(id);
    }


}
