package entornos.documentacion.actividad.enunciado;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;


public class UtilesAWT {
    
  
	public static void centrarVentana(Window ventana) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        ventana.setLocation(screenWidth/2 - ventana.getWidth()/2, screenHeight/2 - ventana.getHeight()/2);
    }
    
  
	public static void centrarControlHorizontal(Window ventana, Component control) {
        control.setLocation(ventana.getWidth()/ 2 - control.getWidth()/ 2, control.getY());
    }
    
}
