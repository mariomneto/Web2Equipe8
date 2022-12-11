/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class PagamentoCartao{
    private double valor;
    private Date data;
    private int numerocartao;
    private int cvc;
    private String titular;
    private String validadecartao;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public PagamentoCartao(double valor, Date data, int numerocartao, int cvc, String titular, String validadecartao) {
        this.valor = valor;
        this.data = data;
        this.numerocartao = numerocartao;
        this.cvc = cvc;
        this.titular = titular;
        this.validadecartao = validadecartao;
    }

   
    public PagamentoCartao() {
        
    }
   
    public int getNumerocartao() {
        return numerocartao;
    }
    public void setNumerocartao(int numerocartao) {
        this.numerocartao = numerocartao;
    }

   

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getValidadeCartao() {
        return validadecartao;
    }
    
    public void setValidadeCartao(String validadecartao) {
        this.validadecartao = validadecartao;
    }
}
    