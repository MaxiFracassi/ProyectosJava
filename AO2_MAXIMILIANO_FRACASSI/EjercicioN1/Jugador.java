package AO2_MAXIMILIANO_FRACASSI.EjercicioN1;
import java.time.Duration;
import java.time.Instant;

public class Jugador {
    private String nombre;
    private Instant tiempoInicio;
    private Instant tiempoFinal;
    private int intentos; 
    private boolean adivino;

    public Instant getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(Instant tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    
   public Jugador(){
    this.intentos=0;

   }
    

    public Jugador(String nombre, int numero) {
        this.nombre = nombre;
        this.intentos = 0;
        this.adivino = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instant getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(Instant tiempoJugado) {
        this.tiempoInicio = tiempoJugado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void actualizarIntentos(){
        this.intentos = this.intentos + 1;
    }

    public boolean yaAdivino() {
        return this.adivino;
    }

    public void setAdivino(boolean bool) {
        this.adivino = bool;
    }

    public void actualizarJugadorGanador(){
        this.adivino = true;
    }
    public int getErrores(){
        return this.intentos  ;
    }

    public long getTiempoJugado(){
        Duration tiempoJugado = Duration.between(tiempoInicio, tiempoFinal);
        long segundos = tiempoJugado.getSeconds();
        return segundos;
    }
}
