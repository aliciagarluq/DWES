package ejercicio2_nomina2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribeFicheros {
	private static final String path = "D:\\GIT-PROYECTOS\\DesarrolloWebServidor\\AplicacionNominas_parte2\\empleados.txt";
	
	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		File textFile = new File(path);

		// Eliminamos el fichero si existe
		deleteIfExists(textFile);

		// Creamos el fichero
		createFile(textFile);

		// Escribimos el contenido del fichero
		writeContentFW(textFile);

		System.out.println("Finalizado en " + (System.currentTimeMillis() - inicio) + "ms");
	}

	/**
	 * Método para escribir el contenido de un fichero de texto utilizando
	 * FileWriter
	 * 
	 * @param textFile Fichero a escribir
	 */
	private static void writeContentFW(File textFile) {
		FileWriter fw = null;
		try {
			System.out.println("Abriendo el fichero...");
			fw = new FileWriter(textFile);

			System.out.println("Escribiendo el contenido...");
			for (int i = 0; i < 1000000; i++) {
				fw.write("Línea " + i + "\n");
				fw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fw) {
				try {
					System.out.println("Cerrando el fichero...");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Método para escribir el contenido de un fichero de texto utilizando
	 * BufferedWriter
	 * 
	 * @param textFile Fichero a escribir
	 */
	private static void writeContentBW(File textFile) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			System.out.println("Abriendo el fichero...");
			fw = new FileWriter(textFile);
			bw = new BufferedWriter(fw);

			System.out.println("Escribiendo el contenido...");
			for (int i = 0; i < 100000000; i++) {
				bw.write("Línea " + i);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando el fichero...");
				if (null != bw) {
					bw.close();
				}
				if (null != fw) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Método para crear un fichero
	 * 
	 * @param textFile Fichero a crear
	 * @return
	 * @throws IOException
	 */
	private static boolean createFile(File textFile) throws IOException {
		return textFile.createNewFile();
	}

	/**
	 * Método para eliminar un fichero (si existe)
	 * 
	 * @param textFile Fichero a eliminar
	 * @return
	 */
	private static boolean deleteIfExists(File textFile) {
		return textFile.delete();
	}
	
}


