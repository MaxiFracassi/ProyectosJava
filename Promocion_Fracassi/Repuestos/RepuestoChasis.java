package Promocion_Fracassi.Repuestos;
public class RepuestoChasis extends Repuesto {
    
    public RepuestoChasis (String nombre, String tipoRepuesto, String ubicacion, double precio, int stock){
        super (nombre,tipoRepuesto,ubicacion,precio,stock);
    }

    @Override

    public double calcularPrecio(){
        return super.getPrecio();
    }
    
}
