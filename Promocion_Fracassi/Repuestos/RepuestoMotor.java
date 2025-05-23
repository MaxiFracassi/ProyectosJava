package Promocion_Fracassi.Repuestos;
public class RepuestoMotor extends Repuesto {
//llamamos al constructor padre 
    public RepuestoMotor ( String nombre, String tipoRepuesto, String ubicacion, double precio, int stock){
        super(nombre, tipoRepuesto, ubicacion, precio, stock);

    }

    @Override
    public double calcularPrecio(){
        return super.getPrecio();
    }
    
}
