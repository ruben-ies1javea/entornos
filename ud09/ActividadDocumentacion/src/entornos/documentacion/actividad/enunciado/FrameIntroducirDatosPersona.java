package entornos.documentacion.actividad.enunciado;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FrameIntroducirDatosPersona extends Frame {

	private TextField txtNombre;
	private TextField txtApellidos;
	private TextField txtTelefono;
	private TextField txtEdad;
	private AlmacenDatosPersona almacen;
	private Persona persona;


	public FrameIntroducirDatosPersona(String titulo) {

		super(titulo);
		setLayout(null);
		addWindowListener(new ManejadorVentana());
		setSize(600, 600);

		// para facilitar el posicionamiento
		int fila = 50, separacion = 30;

		Label lblNombre = new Label("Nombre:");
		lblNombre.setBounds(30, fila, 120, 25);
		add(lblNombre);
		txtNombre = new TextField();
		txtNombre.setBounds(150, fila, 350, 25);
		add(txtNombre);

		fila += separacion;
		Label lblApellidos = new Label("Apellidos:");
		lblApellidos.setBounds(30, fila, 120, 25);
		add(lblApellidos);
		txtApellidos = new TextField();
		txtApellidos.setBounds(150, fila, 350, 25);
		add(txtApellidos);

		fila += separacion;
		Label lblTelefono = new Label("Telefono:");
		lblTelefono.setBounds(30, fila, 120, 25);
		add(lblTelefono);
		txtTelefono = new TextField();
		txtTelefono.setBounds(150, fila, 350, 25);
		add(txtTelefono);

		fila += separacion;
		Label lblEdad = new Label("Edad:");
		lblEdad.setBounds(30, fila, 120, 25);
		add(lblEdad);
		txtEdad = new TextField();
		txtEdad.setBounds(150, fila, 350, 25);
		add(txtEdad);

		fila += (separacion * 2);
		Button btActualizar = new Button("Actualizar");
		btActualizar.setBounds(100, fila, 150, 30);
		btActualizar.addActionListener(new ManejadorBotonActualizar(this));
		add(btActualizar);

		Button btSalir = new Button("Salir");
		btSalir.setBounds(350, fila, 150, 30);
		btSalir.addActionListener(new ManejadorBotonSalir(this));
		add(btSalir);

		almacen = new AlmacenDatosPersona();
		try {
			persona = almacen.recuperarPersona();
			if (persona != null) {
				txtNombre.setText(persona.getNombre());
				txtApellidos.setText(persona.getApellidos());
				txtTelefono.setText(persona.getTelefono());
				txtEdad.setText(String.valueOf(persona.getEdad()));
			} else {
				persona = new Persona();
			}
		} catch (Exception ex) {
			GestorMensajes.mostrarMensajeError(ex);
		}
	}


	private void actualizarPersona() throws FileNotFoundException, IOException {

		persona.setNombre(txtNombre.getText());
		persona.setApellidos(txtApellidos.getText());
		persona.setTelefono(txtTelefono.getText());
		persona.setEdad(Integer.parseInt(txtEdad.getText()));

		almacen.actualizarPersona(persona);
	}


	class ManejadorBotonActualizar implements ActionListener {

		FrameIntroducirDatosPersona frame;

		public ManejadorBotonActualizar(FrameIntroducirDatosPersona frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				actualizarPersona();
			} catch (Exception ex) {
				GestorMensajes.mostrarMensajeError(ex);
			}
		}
	}


	class ManejadorBotonSalir implements ActionListener {

		Frame frame;

		public ManejadorBotonSalir(Frame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DialogOpcionesSalida dialogo = new DialogOpcionesSalida(frame, "Actualización de datos",
						"¿Desea actualizar la información en disco?");
				dialogo.setModal(true);
				UtilesAWT.centrarVentana(dialogo);
				dialogo.setVisible(true);
				if (dialogo.getRespuesta()) {
					actualizarPersona();
				}
			} catch (Exception ex) {
				GestorMensajes.mostrarMensajeError(ex);
			}
			frame.dispose();
		}
	}
}
