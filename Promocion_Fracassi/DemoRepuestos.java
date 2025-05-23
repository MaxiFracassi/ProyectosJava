package Promocion_Fracassi;

import Promocion_Fracassi.Input.Ingreso;
/*import Promocion_Fracassi.Repuestos.Repuesto;*/

public class DemoRepuestos {
    public static void main(String[] args) {

        int cantidadRepuestos = Ingreso.datoEntero("Ingrese la cantidad maxima de repuestos a registrar",
                "Cantidad de repuestos", 1);
        Sistema sistema = new Sistema(cantidadRepuestos);

        sistema.mostrarMenu();
    }

  /*  private static void ejemplosCargados (){
    Repuesto repuesto1 = new Repuesto("Turbo", "Motor", "Cajon A3", 30000, 4);
    Repuesto repuesto2 = new Repuesto("Parrilla"," Chasis", "Cajon B5", 16000, 2);
    Repuesto repuesto3 = new Repuesto(" Amortiguador", "Suspencion", "Cajon C4", 25000, 3); 

Sistema.aRepuesto [0]= repuesto1;
Sistema.aRepuesto [1]= repuesto2;
Sistema.aRepuestos[2]= repuesto3;
Sistema.cantidadRepuestos = 3;}*/
        
 
}