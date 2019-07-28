package Main;



import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;



public class RegistroCuController {
@FXML  
private TextField tfApellidoPaterno;
@FXML 
private TextField tfApellidoMaterno;
@FXML 
private TextField tfNombres;
@FXML 
private TextField tfAño;
@FXML 
private TextField tfMes;
@FXML 
private TextField tfDia;
@FXML 
private TextField tfCurp;
@FXML 
private TextField tfClave;
@FXML 
private TextField tfEntidad;
@FXML private TextField tfCorreo;
public static String apellidoP;
public static String apellidoM;
public static String Nombres;
public static int mes;
public static int ano;
public static int Dia;
public static String Curp;
public static String Clave;
public static String Entidad;
public static String CorreoElectronico;


/**
 * Metodo que valida si se llenaron todos los campos y permite guardar la informacion previamente insertada
 */
public void registrar(){
    
    if(tfApellidoPaterno.getText().equals("")||tfApellidoPaterno.getText().equals("")||tfNombres.getText().equals("")||tfMes.getText().equals("")||tfAño.getText().equals("")||tfDia.getText().equals("")||tfClave.getText().equals("")||tfCurp.getText().equals("")||tfEntidad.getText().equals("")||tfCorreo.getText().equals(""))
    {
    Alert dialogoAlerta = new Alert(AlertType.WARNING);
    dialogoAlerta.setTitle("Advertencia");
    dialogoAlerta.setHeaderText("Campos No validos!");
   
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
    }else{
         apellidoP=tfApellidoPaterno.getText();
         apellidoM = tfApellidoMaterno.getText();
         Nombres = tfNombres.getText();
         mes = Integer.valueOf(tfMes.getText());        
         ano = Integer.valueOf(tfAño.getText());
         Dia = Integer.valueOf(tfDia.getText());
         Curp = tfCurp.getText();
         Clave = tfClave.getText();
         Entidad = tfEntidad.getText();
         CorreoElectronico = tfCorreo.getText();
         Modelo.RegistrarVotantes a= new Modelo.RegistrarVotantes();
         a.insertarDatos();  
    }
    
      
    
    
}

/**
 * Metodo para regresar a la ventana del administrador
 * @throws IOException
 * @throws Exception 
 */
public void RegresarVentanaAdministrador() throws IOException, Exception{
    
LoginController.escenaAdministrador.show();
       AdministradorController.escenaCiudadanos.close();
}

/**
 * Metodo para limpiar los campos
 */

public void LimpiarRegistros(){
tfApellidoMaterno.setText("");
tfApellidoPaterno.setText("");
tfAño.setText("");
tfClave.setText("");
tfCurp.setText("");
tfDia.setText("");
tfEntidad.setText("");
tfMes.setText("");
tfNombres.setText("");

}
/**
 * Metodo que permite regresar a la ventana del login
 */
public void RegresarLogin(){
AdministradorController.escenaCiudadanos.close();
Main.ventanaLogin.show();

}  
}







        
    