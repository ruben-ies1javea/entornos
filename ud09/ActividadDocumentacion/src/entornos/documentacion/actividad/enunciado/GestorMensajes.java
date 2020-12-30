package entornos.documentacion.actividad.enunciado;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GestorMensajes {

    
	public static void mostrarMensajeError(Exception ex) {
        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
   
	public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(new JFrame(), mensaje, "Información", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
