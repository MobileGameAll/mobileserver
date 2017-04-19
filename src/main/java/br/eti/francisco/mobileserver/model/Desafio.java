package br.eti.francisco.mobileserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Desafio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(optional=false)
    private Categoria categoria;
    
    @Column(nullable=false, length=5000)
    private String pergunta;
    
    @Column(nullable=false)
    private int resposta;
    
    @Column(nullable=false)
    private String opcao1;
    
    @Column(nullable=false)
    private String opcao2;
    
    @Column(nullable=false)
    private String opcao3;
    
    @Column(nullable=false)
    private String opcao4;
    
    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public int getResposta() {
        return resposta;
    }
    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
    public String getOpcao1() {
        return opcao1;
    }
    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }
    public String getOpcao2() {
        return opcao2;
    }
    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }
    public String getOpcao3() {
        return opcao3;
    }
    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }
    public String getOpcao4() {
        return opcao4;
    }
    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }
    public Integer getId() {
        return id;
    }
}
