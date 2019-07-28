package Main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

public class RegistroCandidatosController implements Initializable {

    ObservableList cargo = FXCollections.observableArrayList();
    ObservableList partidos = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> fxCargos;
    @FXML
    private ComboBox<String> fxpartidos;
    @FXML
    private TextField fxnombre;
    @FXML
    private TextField fxapellidoPaterno;
    @FXML
    private TextField fxapellidoMaterno;
    @FXML
    private TextField fxedad;
    @FXML
    private TextField fxEstado;
    @FXML
    private TextField fxCiudad;
    @FXML
    private Button fxGuardar;
    @FXML
    private Button fxGuardarPerfil;
    @FXML
    private TextField fxSlogan;
    @FXML
    private ImageView fxImagen;
    @FXML
    private TextField fxIdCandidato;

    public static String ApellidoPaterno;
    public static String ApellidoMaterno;
    public static String Nombre;
    public static String PustoAspirar;
    public static String Estado;
    public static String Ciudad;
    public static int Edad;
    public static String Slogan;
    public static String imageFile;
    public static int idC;
    String P_Republica = Modelo.InsertarCandidato.P_Republic;
    String Gobernador = Modelo.InsertarCandidato.G_gobernador;
    

    String encuentroSocial = Modelo.InsertarCandidato.Part1;
    String independiente = Modelo.InsertarCandidato.Part2;
    String morena = Modelo.InsertarCandidato.Part3;
    String movCiudadano = Modelo.InsertarCandidato.Part4;
    String nuevaAlianza = Modelo.InsertarCandidato.Part5;
    String partVerde = Modelo.InsertarCandidato.Part6;
    String pan = Modelo.InsertarCandidato.Part7;
    String prd = Modelo.InsertarCandidato.Part8;
    String pri = Modelo.InsertarCandidato.Part9;
    String pt = Modelo.InsertarCandidato.Part10;
    String otro = Modelo.InsertarCandidato.Part11;
    String otro2 = Modelo.InsertarCandidato.Part12;
    public static String Cargoelegido;
    public static String PartidoElegido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCargos();
        loadPartidos();
    }

    /**
     * Valida si se lleno todos los campos y guarda la informacion previamente insertada
     * @throws SQLException 
     */
    public void LoadInfo() throws SQLException {
        if(fxCiudad.getText().equals("")||fxEstado.getText().equals("") || fxSlogan.getText().equals("") || fxapellidoMaterno.getText().equals("")|| fxapellidoPaterno.getText().equals("") || fxedad.getText().equals("") ||fxnombre.getText().equals("") || fxIdCandidato.getText().equals(""))
        {
        Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
    dialogoAlerta.setTitle("Advertencia");
    dialogoAlerta.setHeaderText("Campos No validos!");
   
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }else{
            
            ApellidoPaterno = fxapellidoPaterno.getText();
        ApellidoMaterno = fxapellidoMaterno.getText();
        Nombre = fxnombre.getText();
        Estado = fxEstado.getText();
        Ciudad = fxCiudad.getText();
        Edad = Integer.valueOf(fxedad.getText());
        Slogan = fxSlogan.getText();
        Cargoelegido = fxCargos.getValue();
        PartidoElegido = fxpartidos.getValue();
        idC = Integer.parseInt(fxIdCandidato.getText());
        Modelo.InsertarCandidato InfoInsert = new Modelo.InsertarCandidato();
        InfoInsert.InsertCandidato();
        fxapellidoPaterno.setText("");
        fxapellidoMaterno.setText("");
        fxnombre.setText("");
        fxEstado.setText("");
        fxCiudad.setText("");
        fxedad.setText("");
        fxSlogan.setText("");
        fxImagen.setImage(null);
        }
    }

    /**
     * Carga los puestos disponibles para el candidato (Presidente Federal o gobernador)
     */
    @FXML
    private void loadCargos() {
        cargo.removeAll(cargo);
        cargo.addAll(P_Republica, Gobernador);
        
        fxCargos.getItems();
        fxCargos.setItems(cargo);
    }
    
    /**
     * Carga los partidos disponibles para el candidato
     */
    @FXML
    private void loadPartidos() {
        partidos.removeAll(partidos);
        partidos.addAll(encuentroSocial, independiente, morena, movCiudadano, nuevaAlianza, partVerde, pan, prd, pri, pt, otro, otro2);
        fxpartidos.getItems();
        fxpartidos.setItems(partidos);
    }

    /**
     * Permite guardar la imagen del candidato a registrar
     * @param event
     * @throws MalformedURLException 
     */
    @FXML
    private void GuardarImagen(ActionEvent event) throws MalformedURLException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(fxGuardarPerfil.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();

            Image image = new Image(imageFile);
            fxImagen.setImage(image);
        } else {
            fxGuardarPerfil.setText("Image file selection cancelled.");
        }
    }
    
    /**
     * Metodo que regresa a la ventana del Administrador
     * @throws IOException
     * @throws Exception 
     */ 
    public void RegresarVentanaAdministrador() throws IOException, Exception{
    
LoginController.escenaAdministrador.show();
       AdministradorController.escenaCandidatos.close();
}

}
