package entornos.documentacion.actividad.enunciado;


public class Principal {

   
    public static void main(String[] args) {
        FrameIntroducirDatosPersona frame = new FrameIntroducirDatosPersona("Datos de la persona");
        UtilesAWT.centrarVentana(frame);
        frame.setVisible(true);
    }
}
