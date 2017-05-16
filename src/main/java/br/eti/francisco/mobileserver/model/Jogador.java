package br.eti.francisco.mobileserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    
    private int energia;
    
    private int moedas;
    
    private int diamantes;

    @Column(unique=true)
    private String facebookId;
    
    @Column(unique=true)
    private String email;
    
    private int level;
    
    @OneToMany
    @JoinColumn(name="cartajogador_id")
    private List<CartaJogador> cartas = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    private DeckJogador deck = new DeckJogador();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public void setDiamantes(int diamantes) {
        this.diamantes = diamantes;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<CartaJogador> getCartas() {
        return cartas;
    }

    public DeckJogador getDeck() {
        return deck;
    }

    public void setDeck(DeckJogador deck) {
        this.deck = deck;
    }

    
}
