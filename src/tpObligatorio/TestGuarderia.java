/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpObligatorio;

import Utiles.TecladoIn;
import Utiles.Aleatorio;

/**
 *
 * @author Administrador
 */
public class TestGuarderia {

    public static boolean verifFecha(int d, int m, int a) {
        //Modulo que me verica si la fecha ingresada es valida

        return (((m == 11 || m == 4 || m == 6 || m == 9) && d <= 30) || (m == 2 && d <= 29) || ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && (d <= 31))) && (a > 2016 && a < 2050);

    }
    
    public static void nuevaFecha (boolean verif){
        int d,m,a;
        while (verif == false) {
            System.out.println("Error fecha ingresada, vuelva a ingresar fecha");
            System.out.println("Ingrese el dia");
            d = TecladoIn.readLineInt();
            System.out.println("Ingrese el mes(1-12)");
            m = TecladoIn.readLineInt();
            System.out.println("Ingrese el año(aaaa)");
            a = TecladoIn.readLineInt();
            verifFecha(d, m, a);
        }
    }

    public static boolean verifTel(String t) {
        //Modulo que me verifica si el telefono ingresado es valido
        int i, cont = 0;
        boolean verif = false;
        for (i = 0; i <= t.length() - 1; i++) {
            if (t.charAt(i) == '0' || t.charAt(i) == '1' || t.charAt(i) == '2' || t.charAt(i) == '3' || t.charAt(i) == '4' || t.charAt(i) == '5' || t.charAt(i) == '6' || t.charAt(i) == '7' || t.charAt(i) == '8' || t.charAt(i) == '9') {
                cont = cont + 1;
            }
        }
        if (cont == t.length()) {
            verif = true;
        }
        return verif;
    }

    public static void cargarPrimerosPerros(Perro[] x) {
        //Carga en forma aleatoria 20 primeros perros en una misma fecha
        int i;
        Fecha f1;
        Perro p1;
        String nombreP = "";

        for (i = 0; i < 20; i++) {
            p1 = new Perro(Aleatorio.intAleatorio(0,20));
            nombreP = Aleatorio.nombrePerroAleatorio();
            p1.setNombre(nombreP);
            if ((nombreP).equals("Mila") || (nombreP).equals("Nina")) {
                p1.setGenero('H');
            } else {
                p1.setGenero('M');
            }
            p1.setRaza(Aleatorio.nombreRazaAleatorio());
            p1.setCantDias(Aleatorio.intAleatorio(1, 90));
            p1.setNombreDueño(Aleatorio.nombreAleatorio());
            p1.setTelDueño(Aleatorio.stringTelAleatorio(6));
            f1 = new Fecha(21, 11, 2017);
            p1.setFechaIngreso(f1);
            x[i] = p1;
        }
    }

    public static void cargarPerro(Perro[] x, int i) {
        //opcion 1, cargar perros
        String nombre, raza, nombreDueño, telDueño;
        Fecha f1;
        Perro p1 = new Perro(i);
        char genero;
        int cantDias, d, m, a, an;
        System.out.println("Ingrese el nombre del perro:");
        nombre = TecladoIn.readLine();
        p1.setNombre(nombre);
        System.out.println("Ingrese el genero (M/H)");
        genero = TecladoIn.readLineNonwhiteChar();
        while (genero != 'H' && genero != 'M'&&genero!='h'&&genero!='m') {
            System.out.println("Genero no encontrado");
            System.out.println("Ingrese el genero (M/H)");
            genero = TecladoIn.readLineNonwhiteChar();
        }
        p1.setGenero(genero);
        System.out.println("Ingrese la raza");
        raza = TecladoIn.readLine();
        p1.setRaza(raza);
        System.out.println("Ingrese el dia");
        d = TecladoIn.readLineInt();
        System.out.println("Ingrese el mes(1-12)");
        m = TecladoIn.readLineInt();
        System.out.println("Ingrese el año(aaaa)");
        a = TecladoIn.readLineInt();
        verifFecha(d, m, a);
        nuevaFecha(verifFecha(d,m,a));
        f1 = new Fecha(d, m, a);
        if (d == 29 && m == 2) {
            while (f1.esAnioBisiesto() == false) {
                System.out.println("El año ingresado no es biciesto");
                System.out.println("Ingrese el año(aaaa)");
                an = TecladoIn.readLineInt();
                f1 = new Fecha(d, m, an);
                f1.esAnioBisiesto();
            }
        }
        p1.setFechaIngreso(f1);
        System.out.println("Ingrese la cantidad de dias");
        cantDias = TecladoIn.readLineInt();
        p1.setCantDias(cantDias);
        System.out.println("Ingrese el nombre del dueño del perro");
        nombreDueño = TecladoIn.readLine();
        p1.setNombreDueño(nombreDueño);
        System.out.println("Ingrese el telefono del dueño");
        telDueño = TecladoIn.readLine();
        verifTel(telDueño);
        while (verifTel(telDueño) == false) {
            System.out.println("Numero no valido, ingrese nuevamente");
            telDueño = TecladoIn.readLine();
            verifTel(telDueño);
        }
        p1.setTelDueño(telDueño);
        x[i] = p1;

    }

    public static int cuantosLabHem(Perro[] x, int l) {
        //Cuenta cuantos labradores hembras hay
        int cont, i;
        String raza, labrador = "Labrador";
        char genero;
        cont = 0;
        for (i = 0; i < l; i++) {
            raza = x[i].getRaza();
            genero = x[i].getGenero();
            if (raza.equals(labrador) && genero == 'H') {
                cont++;
            }
        }
        return cont;
    }

    public static String infoPerroFecha(Perro[] x, int l) {
        //Da la informacion de los perros para una determinada fecha
        int a, d, m, i;
        String info = "";
        Fecha f1, fecha;
        System.out.println("Ingrese el dia");
        d = TecladoIn.readLineInt();
        System.out.println("Ingrese el mes");
        m = TecladoIn.readLineInt();
        System.out.println("Ingrese el año");
        a = TecladoIn.readLineInt();
        verifFecha(d, m, a);
        nuevaFecha(verifFecha(d,m,a));
        f1 = new Fecha(d, m, a);

        for (i = 0; i < l; i++) {
            fecha = x[i].getFechaIngreso();
            if (f1.esIgual(fecha)) {
                info = info + "\n" + x[i].toString();
            } else {
                info = "En esa fecha no ingresaron perros";
            }
        }
        return info;
    }

    public static String listaOvejeros(Perro[] x, int l) {
        //Lista todos los overjeros con estadia mayor a 20 dias
        int i;
        String lista = "", raza, r = "Ovejero";

        for (i = 0; i < l; i++) {
            if (x[i].getCantDias() > 20) {
                raza = x[i].getRaza();
                if (raza.equals(r)) {
                    lista = lista + "\n" + x[i].toString();
                }
            }
        }
        return lista;
    }

    public static String datosDueño(Perro[] x, int l) {
        //Dado un codigo del perro, me da la informacion del dueño
        int c;
        String datDueño;

        System.out.println("Ingrese el cogido del perro");
        c = TecladoIn.readLineInt();
        if (c <= l) {
            datDueño = (x[c].getNombreDueño() + "/" + x[c].getTelDueño());
        } else {
            datDueño = "El codigo ingresado no corresponde a ningun perro";
        }
        return datDueño;
    }
    
    public static void todosLosPerros (Perro [] x, int l){
        //muestra todos los perros que hay en la guarderia
        int i;
        for (i=0; i<l; i++){
            System.out.println(x[i].toString());
        }
    }
    public static void ordenarNombre (Perro [] x, int l){
        //ordena por nombre el arreglo utilizando el metodo de burbuja mejorado
        int i,j=0;
        for (i=0; i<l-1; i++){
            while (j<=l-1){
                if (x[j].equals("Nina")){
            }
        }
    }
    }
    public static void ordenarFecha (Perro []x, int l){
        //Ordena el arreglo por fecha utilizando el método de seleccion
        int i, j, min;
        for (i=0;i<l-1;i++){
            
        }
    }
    public static void orgenarTelefono (Perro [] x, int l){
        //Ordena el arreglo por telefono utilziando el Metodo de Seleccion
    }
    public static void ordenaDias (Perro [] x, int l){
        //Ordena el arreglo por cantidad de dias utilizando un Metodo Avanzado
    }
    public static void telDueño (Perro [] x, int l,String tel ){
        //Dado el telefono del dueño buscar el arreglo y mostrar todos los datos del perro, aplicando el Método Busqeuda Binaria
        int inicio=0, fin=l,pos,resultado;
        while (inicio<fin){
            pos=(inicio+fin)/2;
            if ((x[pos].getTelDueño()).equals(tel)){
                System.out.println(x[pos].toString());
            }
            else {
                inicio = pos+1;
                
            }
        }
    }
    public static int contarGenero (Perro [] x, int l, char g){
        //Contar mediante metodo recursivo la cantidad de perros de un determinado género
        int cont = 0;
        if (x[0].getGenero() == g){
            cont = cont + 1;
        }else{
            contarGenero(x, l-1,g);
        }
     return cont;       
    }

    public static void Menu() {
        System.out.println("");
        System.out.println("1-Ingresar un perro a la guarderia");
        System.out.println("2-Contar cuantos Labradores hembra hay o pasaron por la guarderia durante el verano");
        System.out.println("3-Listar todos los perros (con su respectiva informacion) que ingresaron en una determinada fecha");
        System.out.println("4-Listar todos los Ovejeros con estadia mayor a 20 dias");
        System.out.println("5-Dado el codigo de un perro, informar los datos de su dueño");
        System.out.println("6-Mostrar todos los perros");
        System.out.println("7-Ordenar el arreglo por nombre utilizando el Método de Burbuja Mejorado");
        System.out.println("8-Ordenar el arreglo por fecha utilizando el Método de Selección");
        System.out.println("9-Ordenar el arreglo por teléfono del dueño utilizando el Método de Insercción");
        System.out.println("10- Ordenar el arreglo por cantidad de días utilizando un Metodo Avanzado");
        System.out.println("11- Dado un telefono de dueño, buscar el arreglo y mostrar los datos del perro correspondiente, aplicando el Método busqueda Binaria");
        System.out.println("12- Contar, mediante un mètodo recursivo, la cantidad de perros de un determinado género");
        System.out.println("0-Salir");

    }

    public static void main(String[] args) {
        int opcion, posArreglo = 20;
        char genero;

        Perro[] guarderia;
        guarderia = new Perro[100];

        cargarPrimerosPerros(guarderia);

        Menu();
        opcion = TecladoIn.readLineInt();
        while ((opcion != 0)) {
            switch (opcion) {
                case 1:
                    cargarPerro(guarderia, posArreglo);
                    posArreglo++;
                    break;
                case 2:
                    System.out.println(cuantosLabHem(guarderia, posArreglo));
                    break;
                case 3:
                    System.out.println(infoPerroFecha(guarderia, posArreglo));
                    break;
                case 4:
                    System.out.println(listaOvejeros(guarderia, posArreglo));
                    break;
                case 5:
                    System.out.println(datosDueño(guarderia, posArreglo));
                    break;
                case 6 :
                    todosLosPerros(guarderia,posArreglo);
                    break;
                case 12 :
                    System.out.println("Ingrese el genero deseado (M/H)");
                    genero = TecladoIn.readLineNonwhiteChar();
                    contarGenero(guarderia,posArreglo,genero);
                default:
                    System.out.println("opcion incorrecta, vuelva a ingresar");

            }
            Menu();
            opcion = TecladoIn.readLineInt();
        }

    }
}
