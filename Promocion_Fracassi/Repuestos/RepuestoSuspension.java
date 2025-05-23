package Promocion_Fracassi.Repuestos;
public class RepuestoSuspension extends Repuesto{

    public RepuestoSuspension (String nombre, String tipoRepuesto, String ubicacion, double precio, int stock){
            super(nombre, tipoRepuesto, ubicacion, precio, stock);

    }

    @Override
    public double calcularPrecio(){
        return super.getPrecio();
    }
    
}
    
