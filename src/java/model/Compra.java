/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author lucas
 */
public class Compra {
    private Integer id;
    private Integer quantidade_compra;
    private Date data_compra;
    private Integer valor_compra;
    private Integer id_fornecedor;    
    private Integer id_produto;
    private Integer id_funcionario;
    
    public Compra() {
        
    }
    
    public Compra(Integer quantidade_compra, Date data_compra, Integer valor_compra, Integer id_fornecedor, Integer id_produto, Integer id_funcionario) {
        this.quantidade_compra = quantidade_compra;
        this.data_compra = data_compra;
        this.valor_compra = valor_compra;
        this.id_fornecedor = id_fornecedor;
        this.id_produto = id_produto;
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the quantidade_compra
     */
    public Integer getQuantidade_compra() {
        return quantidade_compra;
    }

    /**
     * @param quantidade_compra the quantidade_compra to set
     */
    public void setQuantidade_compra(Integer quantidade_compra) {
        this.quantidade_compra = quantidade_compra;
    }

    /**
     * @return the data_compra
     */
    public Date getData_compra() {
        return data_compra;
    }

    /**
     * @param data_compra the data_compra to set
     */
    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    /**
     * @return the valor_compra
     */
    public Integer getValor_compra() {
        return valor_compra;
    }

    /**
     * @param valor_compra the valor_compra to set
     */
    public void setValor_compra(Integer valor_compra) {
        this.valor_compra = valor_compra;
    }

    /**
     * @return the id_fornecedor
     */
    public Integer getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(Integer id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the id_produto
     */
    public Integer getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the id_funcionario
     */
    public Integer getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
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
    
    
}

    


