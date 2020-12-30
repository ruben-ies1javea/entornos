package entornos.documentacion.actividad.enunciado;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogOpcionesSalida extends Dialog implements ActionListener {
    
    private Button btSi, btNo;
    private boolean respuesta;
    
    

    public DialogOpcionesSalida(Frame propietario, String titulo, String mensaje) {
        super(propietario, titulo);
        
        setLayout(null);
        addWindowListener(new ManejadorVentana());
        setSize(600, 150);
        
        Label lblMensaje = new Label(mensaje);
        lblMensaje.setBounds(0, 50, 600, 25);
        lblMensaje.setAlignment(Label.CENTER);
        add(lblMensaje);
        
        btSi = new Button("Si");
        btSi.setBounds(100, 100, 150, 30);
        btSi.addActionListener(this);
        add(btSi);

        btNo = new Button("No");
        btNo.setBounds(350, 100, 150, 30);
        btNo.addActionListener(this);
        add(btNo);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        respuesta = (e.getSource() == btSi);
        dispose();
    }
    
   
    public boolean getRespuesta() {
        return respuesta;
    }
    
}
