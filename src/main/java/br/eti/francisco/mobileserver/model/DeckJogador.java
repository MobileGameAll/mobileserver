package br.eti.francisco.mobileserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DeckJogador {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToMany
    private List<CartaJogador> cartas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public List<CartaJogador> getCartas() {
        return cartas;
    }
}
