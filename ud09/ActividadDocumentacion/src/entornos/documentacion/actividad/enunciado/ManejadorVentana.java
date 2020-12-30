package entornos.documentacion.actividad.enunciado;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


 public class ManejadorVentana extends WindowAdapter {
        
        @Override
        public void windowClosing(WindowEvent e) {
            Window v = (Window) e.getSource();
            v.dispose();
        }
    }