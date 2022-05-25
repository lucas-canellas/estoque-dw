/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Produto {
    private Integer id;
    private String nome_produto;
    private String descricao;
    private Double preco_compra;
    private Double preco_venda;
    private Integer quantidade_disponivel;
    private String liberado_venda;
    private Integer id_categoria;
    
    public Produto() {
        
    }
    
    public Produto(String nome_produto, String descricao, Double preco_compra, Double preco_venda, Integer quantidade_disponivel, String liberado_venda, Integer id_categoria ) {
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade_disponivel = quantidade_disponivel;
        this.liberado_venda = liberado_venda;
        this.id_categoria = id_categoria;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco_compra
     */
    public Double getPreco_compra() {
        return preco_compra;
    }

    /**
     * @param preco_compra the preco_compra to set
     */
    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the quantidade_disponivel
     */
    public Integer getQuantidade_disponivel() {
        return quantidade_disponivel;
    }

    /**
     * @param quantidade_disponivel the quantidade_disponivel to set
     */
    public void setQuantidade_disponivel(Integer quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }

    /**
     * @return the liberado_venda
     */
    public String getLiberado_venda() {
        return liberado_venda;
    }

    /**
     * @param liberado_venda the liberado_venda to set
     */
    public void setLiberado_venda(String liberado_venda) {
        this.liberado_venda = liberado_venda;
    }

    /**
     * @return the id_categoria
     */
    public Integer getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    
    
}
