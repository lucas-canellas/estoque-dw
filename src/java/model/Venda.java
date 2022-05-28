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
public class Venda {
    private Integer id;
    private Integer quantidade_venda;
    private Date data_venda;
    private Double valor_venda;
    private Integer id_cliente;    
    private Integer id_produto;
    private Integer id_funcionario;
    
    public Venda() {
        
    }
    
    public Venda(Integer quantidade_venda, Date data_venda, Double valor_venda, Integer id_cliente, Integer id_produto, Integer id_funcionario) {
        this.quantidade_venda = quantidade_venda;
        this.data_venda = data_venda;
        this.valor_venda = valor_venda;
        this.id_cliente = id_cliente;
        this.id_produto = id_produto;
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the quantidade_venda
     */
    public Integer getQuantidade_venda() {
        return quantidade_venda;
    }

    /**
     * @param quantidade_venda the quantidade_venda to set
     */
    public void setQuantidade_venda(Integer quantidade_venda) {
        this.quantidade_venda = quantidade_venda;
    }

    /**
     * @return the data_venda
     */
    public Date getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }


    /**
     * @return the id_cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
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

    /**
     * @return the valor_venda
     */
    public Double getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(Double valor_venda) {
        this.valor_venda = valor_venda;
    }
    
    

    
    
}
