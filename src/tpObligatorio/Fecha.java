/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpObligatorio;

/**
 *
 * @author Administrador
 */
public class Fecha {
    //Atributos
    private final int dia;
    private final int mes;
    private final int año;
    //Constructores
    public Fecha (int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.año = a;
                
    }
    //Observadores
    public int getDia (){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }
    @Override
    public String toString(){
        return this.dia + "/" + this.mes + "/" + this.año;
        
    }
    //Porpias del tipo
    public boolean esIgual (Fecha f){
        return (f.dia == this.dia && f.mes == this.mes && f.año == this.año);
    }
    public boolean esAnioBisiesto (){
        
        return ((this.año % 4 == 0) && ((this.año % 100 != 0) || (this.año % 400 == 0)));
    }
    
}
