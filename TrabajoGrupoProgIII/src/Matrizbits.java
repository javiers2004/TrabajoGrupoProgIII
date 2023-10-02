import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matrizbits {
	
	protected int[][] matrizdebits;
	
	protected int[][] getMatrizdebits() {
		return matrizdebits;
	}
	
	protected void setMatrizdebits(int[][] matrizdebits) {
		this.matrizdebits = matrizdebits;
	}
	
	public Matrizbits() {
		super();
        String rutaArchivoCSV = "archivo.csv";  // Reemplazar con la ruta del archivo CSV

        int[][] matriz = leerMatrizDesdeCSV(rutaArchivoCSV);
        if (matriz != null) {
            System.out.println("Matriz leída desde el archivo CSV:");
        } else {
            System.out.println("No se pudo leer la matriz desde el archivo CSV.");
        }
        this.setMatrizdebits(matriz);
    }



	public static int[][] leerMatrizDesdeCSV(String rutaArchivo) {
		try (FileReader fileReader = new FileReader(rutaArchivo);
				BufferedReader reader = new BufferedReader(fileReader)) {
			String linea;
			int fila = 0;
			int[][] matriz;

			// Contar el número de filas y columnas para inicializar la matriz
			int numFilas = (int) reader.lines().count();
			matriz = new int[numFilas][];  // Solo inicializamos el número de filas por ahora
			
			// Volver a abrir el archivo para leerlo desde el principio
			fileReader.close();  // Cerramos el FileReader antes de volver a abrirlo
			reader.close();
			FileReader newFileReader = new FileReader(rutaArchivo);
			BufferedReader newReader = new BufferedReader(newFileReader);
			while ((linea = newReader.readLine()) != null) {
				String[] valores = linea.split(",");
				matriz[fila] = new int[valores.length];
				for (int col = 0; col < valores.length; col++) {
					matriz[fila][col] = Integer.parseInt(valores[col]);
				}
				fila++;
			}
			return matriz;
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error al leer la matriz desde el archivo CSV: " + e.getMessage());
			return null;
		}
	}
}
