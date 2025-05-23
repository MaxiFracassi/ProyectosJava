package Promocion_Fracassi;

import Promocion_Fracassi.Repuestos.Repuesto;
import Promocion_Fracassi.Repuestos.RepuestoMotor;
import Promocion_Fracassi.Repuestos.RepuestoChasis;
import Promocion_Fracassi.Repuestos.RepuestoSuspension;
import Promocion_Fracassi.Input.Ingreso;
import Promocion_Fracassi.Input.Salida;

public class Sistema {
    private Repuesto[] aRepuestos;
    private static int cRepuestosCreados = 0;
    public static int cantidadRepuestos;

    public Sistema(int cantidadRepuestos) {
        this.aRepuestos = new Repuesto[cantidadRepuestos];
    }

    public void mostrarMenu() {
        int opciones = Ingreso.datoEntero(this.getMensajeMenu(), "MENU PRINCIPAL", 1);
        do {
            switch (opciones) {
                case 1:
                    this.registrarRepuesto();
                    break;

                case 2:
                    this.listarRepuestos();
                    break;

                case 3:
                    this.mostrarPrecios();
                    break;

                case 4:
                    this.mostrarDatosRepuestos();
                    break;

                case 5:
                    this.buscarRepuestosPorNombre();
                    break;

                case 6:
                    this.mostrarTotalInventario();
                    break;
                case 7:
                    this.modificarStock();
                    break;
                case 8:
                    this.mostrarStock();
                    break;
                case 0:
                    return;

                default:
                    break;
            }

            opciones = Ingreso.datoEntero(this.getMensajeMenu(), null, 1);
        } while (opciones != 0);
    }

    public String getMensajeMenu() {
        return String.format("""
                Presione 1 para registrar un nuevo repuestos
                Presione 2 para listar los repuestos registrados
                Presione 3 para mostrar precios de los repuestos
                Presione 4 para mostrar repuestos ordenados por precio
                Presione 5 para buscar repuestos por nombre
                Presione 6 para mostrar valor total del inventario
                Presione 7 para modificar el Stock
                Presione 8 para mostrar el Stock
                Presione 0 para salir""");
    }

    public void registrarRepuesto() {
        if (cRepuestosCreados + 1 > aRepuestos.length) {
            Salida.mError("No se pueden crear mas repuestos", "Error al registrar");
            return;
        }
        String nombreRepuesto = Ingreso.datoString("Ingrese nombre del repuesto", "Nombre de repuesto", 1);
        String ubicacion = Ingreso.datoString("Ingrese ubicacion del repuesto", "Ubicacion", 1);
        Double precio = Ingreso.datoDoble("Ingrese precio del respuesto", "Precio", 1);
        int stock = Ingreso.datoEntero("Ingrese cantidad en stock", "Stock", 1);

        int dato;
        while (true) {
            dato = Ingreso.datoEntero("""
                    Presione 1 si es repuesto de motor \n
                    Presione 2 si es repuesto de chasis \n
                    Presione 3 si es repuesto de suspension """, "Tipo de respuesto", 1);

            // tenemos que validar que la opcion es valida
            if (dato >= 1 && dato <= 3) {
                break;

            }
            Salida.mError("Opcion no valida. Intente denuevo", "Error");

        }

        Repuesto nuevoRepuesto;

        switch (dato) {
            case 1:
                nuevoRepuesto = new RepuestoMotor(nombreRepuesto, "Motor", ubicacion, precio, stock);
                break;

            case 2:
                nuevoRepuesto = new RepuestoChasis(nombreRepuesto, "Chasis", ubicacion, precio, stock);
                break;

            case 3:
                nuevoRepuesto = new RepuestoSuspension(nombreRepuesto, "Suspension", ubicacion, precio, stock);
                break;

            default:
                Salida.mError("Opcion no valida", "Error");
                return;

        }
        // encontramos el epacio vacio
        int contador = 0;
        while (contador < aRepuestos.length && aRepuestos[contador] != null) {
            contador++;

        }

        // aca agregamos el repuesto si hay espacio
        if (contador < aRepuestos.length) {
            aRepuestos[contador] = nuevoRepuesto;
            cRepuestosCreados += 1;
            Salida.mMensaje("Repuesto registrado con exito", "Registro existoso");

        } else {
            Salida.mError("No hay espacio para mas repuestos", "Error");
        }

    }

    public void listarRepuestos() {
        StringBuilder sDato = new StringBuilder();
        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null) {
                sDato.append(repuesto.getNombre()).append("\n");

            }
        }

        Salida.mMensaje(sDato.toString(), "Lista de Repuestos");

    }

    public void mostrarPrecios() {
        StringBuilder sDato = new StringBuilder();
        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null) {
                sDato.append(String.format("%s - $%.2f\n",
                        repuesto.getNombre(), repuesto.calcularPrecio()));

            }
        }

        Salida.mMensaje(sDato.toString(), "Precios del repuesto");
    }

    public void ordenarRepuestos() {
        for (int i = 0; i < aRepuestos.length - 1; i++) {
            for (int j = 0; j < aRepuestos.length - 1; j++) {
                if (aRepuestos[j] != null && aRepuestos[j + 1] != null &&
                        aRepuestos[j].calcularPrecio() > aRepuestos[j + 1].calcularPrecio()) {
                    Repuesto aux = aRepuestos[j];
                    aRepuestos[j] = aRepuestos[j + 1];
                    aRepuestos[j + 1] = aux;

                }
            }
        }
    }

    public void mostrarDatosRepuestos() {
        this.ordenarRepuestos();
        StringBuilder sDato = new StringBuilder();
        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null) {
                sDato.append(repuesto.toString()).append("\n");

            }
        }

        Salida.mMensaje(sDato.toString(), "Repuestos ordenados");
    }

    public void buscarRepuestosPorNombre() {
        String nombreBuscado = Ingreso.datoString("Ingrese nombre del repuesto a buscar", "Busqueda", 0);
        boolean encontrado = false;
        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null && repuesto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                Salida.mMensaje(repuesto.toString(), "Repuesto encontrado");
                encontrado = true;
                break;
            }

        }

        if (!encontrado) {
            Salida.mMensaje("No se encontro el repuesto", "Busqueda repuesto");

        }
    }

    public void modificarStock() {
        int nuevoStock = 0;
        int c = 0;
        String nombreRep = Ingreso.datoString("Ingrese el nombre del repuesto ", "Actualizar Stock", 0);
        while (c < aRepuestos.length && !nombreRep.equals(aRepuestos[c].getNombre())) {
            c++;
        }
        if (aRepuestos[c] != null) {
            Salida.mMensaje("Se encontro el repuesto con exito ", "Stock a modificar");
            nuevoStock = Ingreso.datoEntero("Ingrese el nuevo Stock ", "Actualizacion de Stock", 0);
            aRepuestos[c].setStock(nuevoStock);
        } else {
            Salida.mMensaje("No se encontró el repuesto", "Busqueda Repuesto");
        }
    }

    public void mostrarTotalInventario() {
        double totalInventario = 0;
        StringBuilder sDato = new StringBuilder("Precio del repuesto:\n");

        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null) {
                double precioTotal = repuesto.calcularPrecio() * repuesto.getStock();
                totalInventario += precioTotal;
                sDato.append(String.format("%s: $%.2f\n", repuesto.getNombre(), precioTotal));
            }
        }

        sDato.append(String.format("\nPrecio total del inventaario: $%.2f", totalInventario));
        Salida.mMensaje(sDato.toString(), "Total inventario");
    }

    public void mostrarStock() {
        this.ordenarRepuestos();
        StringBuilder sDato = new StringBuilder();
        for (Repuesto repuesto : aRepuestos) {
            if (repuesto != null) {
                sDato.append(String.format("Nombre repuesto: %s \n Stock: %d \n", repuesto.getNombre(),
                        repuesto.getStock()));

            }
        }

        Salida.mMensaje(sDato.toString(), "Stock de repuestos");
    }

    

}
