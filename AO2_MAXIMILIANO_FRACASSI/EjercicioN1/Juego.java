package AO2_MAXIMILIANO_FRACASSI.EjercicioN1;

import java.time.Instant;

import AO2_MAXIMILIANO_FRACASSI.inputOuput.Ingreso;
import AO2_MAXIMILIANO_FRACASSI.inputOuput.Salida;

public class Juego {
    private Jugador[] jugadores;
    private int[] numerosAAdivinar;

    public Juego(int cantidadJugadores) {
        this.jugadores = obtenerArrayDeJugadores(cantidadJugadores);
        this.numerosAAdivinar = new int[cantidadJugadores];
        cargarJugador();
        iniciarJuego();
        mostrarResultados();
    }

    private Jugador[] obtenerArrayDeJugadores(int cantidadJugadores) {
        Jugador[] jugadores = new Jugador[cantidadJugadores];
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = new Jugador();
            jugadores[i] = jugador;
        }
        return jugadores;
    }

    private void mostrarResultados() {

        for (int i = 0; i < jugadores.length; i++) {

            Salida.mMensaje("El jugador " + jugadores[i].getNombre() + " ha tardado " +
                    +jugadores[i].getTiempoJugado() + " segundos.", "Datos jugador ");

            
        }
    }

    private void iniciarJuego() {
        int cantRondas = 0;
        while (this.jugadoresEnJuego() != 0) {
            realizarRonda(cantRondas);
            cantRondas++;
        }
    }

    private void realizarRonda(int cantidadRondas) {
        for (int i = 0; i < jugadores.length; i++) {
            if (!jugadores[i].yaAdivino()) {
                realizarIntento(i, cantidadRondas);
            }
        }
    }

    private void realizarIntento(int indJugador, int ronda) {
        if (ronda == 0) {
            Instant tiempoIniciado = Instant.now();
            jugadores[indJugador].setTiempoInicio(tiempoIniciado);
            System.out.println(jugadores[indJugador].getTiempoInicio());
        }
        int numeroIngresado = Ingreso.datoEntero("Ingrese numero a adivinar",
                jugadores[indJugador].getNombre(), 1);

        if (jugadorHaAdivinado(indJugador, numeroIngresado)) {
            jugadorAcerto(indJugador);
        } else {
            jugadorFallo(indJugador, numeroIngresado);
        }
    }

    private boolean jugadorHaAdivinado(int indJugador, int numeroIngresado) {
        return this.numerosAAdivinar[indJugador] == numeroIngresado;
    }

    private void jugadorFallo(int i, int numeroIngresado) {
        if (numeroIngresado > numerosAAdivinar[i]) {
            Salida.mMensaje("Demasiado alto", "Error");
            jugadores[i].actualizarIntentos();
        } else {
            Salida.mMensaje("Demasiado bajo", "Error");
            jugadores[i].actualizarIntentos();
        }

    }

    private void jugadorAcerto(int i) {
        jugadores[i].setAdivino(true);
        Instant tiempoFinal = Instant.now();
        jugadores[i].setTiempoFinal(tiempoFinal);
        Salida.mMensaje(jugadores[i].getNombre() + " Ha adivinado", "Felicitaciones!");
    }

    private int jugadoresEnJuego() {
        int jEnJuego = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (!jugadores[i].yaAdivino()) {
                jEnJuego++;
            }
        }
        return jEnJuego;
    }

    private void cargarJugador() {
        for (int i = 0; i < jugadores.length; i++) {
            String nombre = Ingreso.datoString("Ingrese nombre del jugador", " Jugador " +
                    (i + 1), 1);
            int numero = (int) (Math.random() * 100 + 1);
            this.numerosAAdivinar[i] = numero;
            jugadores[i].setNombre(nombre);
        }
    }

    public  String mostrarGanador() {
        int intentos = this.jugadores[0].getIntentos();
        Jugador ganador = this.jugadores[0];
        long menorTiempo = this.jugadores[0].getTiempoJugado();

        for (int i = 1; i < this.jugadores.length; i++) {
            if (this.jugadores[i].getIntentos() <= intentos && this.jugadores[i].getTiempoJugado()<= menorTiempo) {
                intentos = this.jugadores[i].getIntentos();
                menorTiempo = this.jugadores[i].getTiempoJugado();
                ganador = this.jugadores[i];
            }
        }
  return ganador.getNombre();
        

    }

    public String mostarMasRapido() {
        long menorTiempo = this.jugadores[0].getTiempoJugado();
        Jugador ganador = this.jugadores[0];
        for (int i = 1; i < this.jugadores.length; i++) {
            if (this.jugadores[i].getTiempoJugado() < menorTiempo) {
                ganador = this.jugadores[i];
            }
        }
        return ganador.getNombre();
        
    }

    public void mostarMasLento() {
        long mayorTiempo = this.jugadores[0].getTiempoJugado();
        Jugador ganador = this.jugadores[0];
        for (int i = 1; i < this.jugadores.length; i++) {
            if (this.jugadores[i].getTiempoJugado() >= mayorTiempo) {
                ganador = this.jugadores[i];
            }
        }
        Salida.mMensaje("El mas lento es: " + ganador.getNombre(), "Mas lento");
    }

    public double promedioErrores() {
        int errores = 0;

        for (int i = 0; i < this.jugadores.length; i++) {

            errores += this.jugadores[i].getErrores();

        }

        double promedio = errores / this.jugadores.length;
        return promedio;
        
    }

    public String jugadorPremiado() {
        int intentos = this.jugadores[0].getIntentos();
        Jugador ganador = this.jugadores[0];
        long menorTiempo = this.jugadores[0].getTiempoJugado();

        for (int i = 1; i < this.jugadores.length; i++) {
            if (this.jugadores[i].getIntentos() <= intentos && this.jugadores[i].getTiempoJugado() < menorTiempo) {
                intentos = this.jugadores[i].getIntentos();
                menorTiempo = this.jugadores[i].getTiempoJugado();
                ganador = this.jugadores[i];
            }
        }
         return ganador.getNombre();
        

    }

    public void jugadorMenorPerformance() {
        int intentos = this.jugadores[0].getIntentos();
        Jugador ganador = this.jugadores[0];

        for (int i = 1; i < this.jugadores.length; i++) {
            if (this.jugadores[i].getIntentos() > intentos) {
                ganador = this.jugadores[i];
            }
        }

        Salida.mMensaje("El jugador con menos performance " + ganador.getNombre(), "Menos Performance");

    }

    public void resultadoFinal(){

        StringBuilder sData = new StringBuilder();
        String mensaje;
          mensaje = String.format("------- Informe Final ------ \n  Ganador: %s \n"+
          " Jugador mas rapido: %s  \n Promedio de errores: %.2f  \n Jugador premieado: %s ",
           this.mostrarGanador(),
           this.mostarMasRapido(),
           this.promedioErrores(),
           this.jugadorPremiado()
          );
               sData.append(mensaje);
            
        
        Salida.mMensaje(sData.toString(), "------- Informe Final ------");

       
    }

}
