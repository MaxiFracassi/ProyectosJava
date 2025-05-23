package Promocion_Fracassi.Repuestos;
public abstract class Repuesto {
    public static Repuesto[] aRepuestos;
    private String nombre;
    private String tipoRepuesto;
    private String ubicacion;
    private double precio;
    private int stock;

    public Repuesto (String nombre, String tipoRepuesto, String ubicacion, double precio, int stock){
        this.nombre = nombre;
        this.tipoRepuesto = tipoRepuesto;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.stock = stock;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return tipoRepuesto;
    }

    public void setMarca(String tipoRepuesto) {
        this.tipoRepuesto = tipoRepuesto;
    }

    public String getModelo() {
        return ubicacion;
    }

    public void setModelo(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString(){
        return String.format("Repuesto: %s \n Tipo de repuesto: %s \n Precio: $%.2f \n Ubicacion: %s \n Stock: %d" ,
        nombre,tipoRepuesto,precio,ubicacion,stock);
    }
}
