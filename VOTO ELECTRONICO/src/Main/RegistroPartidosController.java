package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class RegistroPartidosController implements Initializable {
    
    ObservableList Estados = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> fxEstados;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNombrePresidente;
    @FXML
    private Button fxGuardarinfo;
    @FXML
    private Button fxSaveImage;
    @FXML
    private ImageView fxImagen;

    public static String imageFile;
    public static String NombreUser;
    public static String Nombre_Del_Presidente;
    public static String EstadoSeleccionado;
     
    public void initialize(URL url, ResourceBundle rb) {
        loadEstdos() ;
    }

    /**
     * Metodo que permite guardar los datos de los partidos a registrar
     * @param event 
     */
    @FXML
    private void GuardarDatos(ActionEvent event) {

        NombreUser = txtNombre.getText();
        Nombre_Del_Presidente = txtNombrePresidente.getText();
        EstadoSeleccionado = fxEstados.getValue();

        Modelo.InsertarPartidos datosPartido = new Modelo.InsertarPartidos();
        datosPartido.InsertarInfo();
        txtNombre.setText("");
        txtNombrePresidente.setText("");
        fxImagen.setImage(null);
    }

    /**
     * Metodo que permite guardar la imagen del partido
     * @param event
     * @throws MalformedURLException 
     */
    @FXML
    private void SaveImage(ActionEvent event) throws MalformedURLException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(fxSaveImage.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();

            Image image = new Image(imageFile);
            fxImagen.setImage(image);
        } else {
            fxSaveImage.setText("Image file selection cancelled.");
        }
    }
    
    
    /**
     * Metodo que carga los estados disponibles
     */
    @FXML
    private void loadEstdos() {
        Estados.removeAll(Estados);
        Estados.addAll("Seleccionar","Nacional","Aguascalientes","Baja California","Baja California Sur","Campeche",
                "Coahuila de Zaragoza","Colima","Chiapas","Chihuahua","Distrito Federal",
                "Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México","Michoacán",
                "Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo",
                "San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz",
                "Yucatán","Zacatecas");
        fxEstados.getItems();
        fxEstados.setItems(Estados);
    }
    /**
     * Metodo que permite regresar a la ventana del Administrador
     * @throws IOException
     * @throws Exception 
     */
    public void RegresarVentanaAdministrador() throws IOException, Exception{
    
LoginController.escenaAdministrador.show();
       AdministradorController.escenaPartidos.close();
}

}
