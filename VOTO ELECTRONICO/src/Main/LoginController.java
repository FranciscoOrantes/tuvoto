
package Main;
import Modelo.Conexion;
import Modelo.InicioSesion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class LoginController implements Initializable {
    public  static String clave;
    public String estado;
    public static String IdEstado;
    
    Conexion conexion = new Conexion();
    static   Stage escenaAdministrador;
    static FXMLLoader loaderAdministrador;
    @FXML 
    public TextField cuadroClaveElectoral;
    @FXML 
   public  TextField cuadroEntidad;
     
     static Stage escenaBoleta;

     /**
      * Metodo que abre la ventana de Boleta
      * @throws IOException
      * @throws Exception 
      */
     public void abrirVentana() throws IOException, Exception{

     FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Boleta.fxml"));
       Parent root1 = (Parent)fxmlloader.load();
       escenaBoleta = new Stage();
       escenaBoleta.setScene(new Scene(root1));
       escenaBoleta.setResizable(false);
       escenaBoleta.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       escenaBoleta.show();
       Main.ventanaLogin.close();     
}
    /**
     * Metodo que abre la ventana del Administrador
     * @throws IOException 
     */
     @FXML  
    private void handleButtonAction() throws IOException {
        clave = cuadroClaveElectoral.getText();
    if(clave.equals("123a")){
   loaderAdministrador = new FXMLLoader(getClass().getResource("Administrador.fxml"));
       Parent root1 = (Parent)loaderAdministrador.load();
       escenaAdministrador = new Stage();
       escenaAdministrador.setScene(new Scene(root1));
       escenaAdministrador.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       escenaAdministrador.setResizable(false);
       escenaAdministrador.show();
       Main.ventanaLogin.close();
    }else{
    InicioSesion sesion = new InicioSesion();
   
    sesion.setClaveElectoral(cuadroClaveElectoral.getText());
        sesion.setIdEstado(cuadroEntidad.getText());    
        
    sesion.buscarCiudadano();
    IdEstado = cuadroEntidad.getText();
    
    }
    } 
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
   
    public void limitarCaracteresClaveElectoral(KeyEvent event){
    int limit = 18;
    if(cuadroClaveElectoral.getText().length()==limit){
    event.consume();
    clave = cuadroClaveElectoral.getText();
    }
   
    }
    /**
     * Metodo que iguala a una variable lo que el usuario escriba en el textField de clave Electoral
     */
    public void escribeClave(){
    clave = cuadroClaveElectoral.getText();
    }
    
    
    
    
     public void limitar(KeyEvent event){
     int limit = 3;
     if(cuadroEntidad.getText().length()==limit){
     event.consume();
     estado = cuadroEntidad.getText();
     }
    
     }
     /**
      * Metodo que iguala a una variable lo que el usuario escribe en el campo de Entidad
      */
     public void escribeEntidad(){
     estado = cuadroEntidad.getText();
     }
     @FXML private TextField cuadroCiudad;
     public void limitar2(KeyEvent event){
     int limit = 3;
     if(cuadroCiudad.getText().length()==limit){
     event.consume();
     }
     } 
}
