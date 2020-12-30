package entornos.documentacion.actividad.enunciado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class AlmacenDatosPersona {


	private final static String FICHERO = "persona.bin";


	public void actualizarPersona(Persona persona) throws FileNotFoundException, IOException {

		FileOutputStream file = null;
		ObjectOutputStream writer = null;

		try {
			file = new FileOutputStream(FICHERO);
			writer = new ObjectOutputStream(file);
			writer.writeObject(persona);
		} finally {

			// nos aseguramos de que el fichero se cierre pese a poder haber algún error
			if (writer != null) {
				writer.close();
			}

			if (file != null) {
				file.close();
			}
		}
	}


	public Persona recuperarPersona() throws IOException, ClassNotFoundException {

		Persona persona = null;
		FileInputStream file = null;
		ObjectInputStream reader = null;

		try {
			file = new FileInputStream(FICHERO);
			reader = new ObjectInputStream(file);

			persona = (Persona) reader.readObject();

			return persona;

		} finally { 

			// nos aseguramos de que el fichero se cierre pese a poder haber algún error
			if (reader != null) {
				reader.close();
			}

			if (file != null) {
				file.close();
			}
		}
	}
}
