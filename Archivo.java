import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//Clase para leer el archivo
public class Archivo {
    private File archivo;

    public Archivo(String nameArchivo){
        archivo = new File(nameArchivo);
    }

    public ArrayList<String> leerArchivo() throws IOException {
        ArrayList<String> lispEntry = new ArrayList<>();
        FileReader fileReader = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(fileReader);

        String linea;
        while ((linea = lector.readLine()) != null){
            String[] elementos = linea.split("\\n+");
            for (String elemento : elementos) {
                if (elemento.matches("[a-zA-Z]+")){
                    lispEntry.add(elemento.toString());
                }
                else{
                    lispEntry.add(elemento.toString());
                }
            }
        }
        lector.close();
        return lispEntry;
    }



}