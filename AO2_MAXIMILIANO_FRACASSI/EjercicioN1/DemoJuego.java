package AO2_MAXIMILIANO_FRACASSI.EjercicioN1;

import javax.swing.JOptionPane;


import AO2_MAXIMILIANO_FRACASSI.inputOuput.Salida;

public class DemoJuego {
    public static void main(String[] args) {
        int seleccion = 0;
        
        Juego juego = new Juego(enteroPositivo("Ingrese la cantidad de jugadores", "Jugadores", 1));

        String[] opciones = {
                "Ganador",
                "El mas rapido",
                "El mas lento",
                "Promedio de errores",
                "Jugador con mas performan",
                "Jurgador con menos performan",
                "Informe final",
                "Salir"
        };

        do {
            seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion ", "Menu principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opciones, opciones[0]);
       
            switch (seleccion) {
                case 0:
                 // El nombre del ganador (el que hizo menos intentos).
                String ganador2 = juego.mostrarGanador();
                Salida.mMensaje("El ganador es: " + ganador2, "GANADOR");

                    break;
                case 1:
                //El nombre del jugador más rápido (el que lo hizo en menor tiempo).
                String ganador = juego.mostarMasRapido();
                Salida.mMensaje("El ganador es: " + ganador, "GANADOR");

                    break;
                case 2:
                //El nombre del jugador más lento (el que lo hizo en mayor tiempo).
                juego.mostarMasLento();
                    break;
                case 3:
                //El promedio de errores cometidos por todos los jugadores.
                double promedio = juego.promedioErrores();
                Salida.mMensaje("El promedio de errores es: " + promedio, "Promedio errores");
                    break;
                case 4:
                //El nombre del jugador que ganó el premio (el que tuvo menos intentos y errores).

                String ganador1= juego.jugadorPremiado();
                Salida.mMensaje("El ganador es: " + ganador1, "GANADOR");
                    break;
                case 5:
                //El nombre del jugador que con menor performance (el que tuvo más intentos y más errores).
                juego.jugadorMenorPerformance();
                    break;
                case 6:
                //Informe Final: Mostrar los resultados con el ganador, el jugador más rápido, el promedio de 
                //errores y quién obtuvo el premio.
                
                juego.resultadoFinal();
                    break;
                case 7:
                    System.exit(0);
                    break;

            }

        } while (seleccion != 7);
    }
    public static int enteroPositivo(String cMensaje, String cTitulo, int icono) {
        int numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje ,cTitulo,icono);
                numero = Integer.parseInt(input);
                valido = numero > 0? true : false;
                
                if(!valido) throw new Error();
            } catch (Error e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero positivo.","ERROR",0);
            }
        } while (!valido);
        return numero;
    }

}
