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
public class Perro {
    //Atributos
    private int Codigo;
    private String Nombre;
    private char Genero;
    private String Raza;
    private Fecha FechaIngreso;
    private int CantDias;
    private String NombreDueño;
    private String TelDueño;
    //Constructores
    public Perro (int codigo){
        Codigo = codigo;
    }
    //Observadores
    public int getCodigo(){
        return Codigo;
    }
    public String getNombre(){
        return Nombre;
    }
    public char getGenero(){
        return Genero;
    }
    public String getRaza(){
        return Raza;
    }        
    public Fecha getFechaIngreso(){
        //
        return this.FechaIngreso;
    }
    public int getCantDias(){
        return this.CantDias;
    }
    public String getNombreDueño(){
        return this.NombreDueño;
    }
    public String getTelDueño(){
        return this.TelDueño;
    }
    @Override
    public String toString(){
        return this.Codigo + "/" + this.Nombre +"/"+this.Genero+"/"+this.Raza+"//"+this.FechaIngreso+"//"+this.CantDias+"/"+this.NombreDueño+"/"+this.TelDueño;
    }
    //Modificadores
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public void setGenero (char genero){
        Genero = genero;
    }
    public void setRaza (String raza){
        Raza = raza;
    }
    public void setFechaIngreso (Fecha fechaIng){
        FechaIngreso=fechaIng;
    }
    public void setCantDias (int cantDias){
        CantDias = cantDias;
    }
    public void setNombreDueño (String nomDueño){
        NombreDueño=nomDueño;
    }
    public void setTelDueño (String telDueño){
        TelDueño = telDueño;
    }
}
    
