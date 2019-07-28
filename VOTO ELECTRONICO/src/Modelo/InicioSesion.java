
package Modelo;


import Main.BoletaController;
import Main.LoginController;
import Main.Main;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


/**
 *
 * @author Francisco
 */
public class InicioSesion {
    String claveElectoral;
    String idEstado;
    LoginController logincontroller = new LoginController();
    Main main = new Main();
 
    
/**
 * Guarda la clave electoral del ciudadano que ingresa sesion
 * @param claveElectoral : clave electoral del ciudadano
 */   
    public void setClaveElectoral(String claveElectoral){
    this.claveElectoral = claveElectoral;
    }
    /**
     * Guarda el numero de estado en el que esta registrado el ciudadano
     * @param idEstado : numero de estado del ciudadano
     */
    public void setIdEstado(String idEstado){
    this.idEstado = idEstado;
    }
    /**
     * Retorna la clave electoral del ciudadano
     * @return claveElectoral 
     */
    public String getClaveElectoral(){
    return claveElectoral;
    }
    /**
     * Retorna el numero de Estado del ciudadano
     * @return idEstado
     */
    public String getIdEstado(){
    return idEstado;
    }
    /**
     * Metodo que permite, (en caso de que el ciudadano este registrado) iniciar sesion
     */
    public void buscarCiudadano(){
    
        Conexion con = new Conexion();
        Connection st = con.conectate();
        ResultSet rs;
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    
    "SELECT * FROM ciudadanos WHERE Claveelectoral= ? && idEstado = ?");
     
  pst.setString(1,this.getClaveElectoral() );
   pst.setString(2,this.getIdEstado() );
    rs = pst.executeQuery();
    if(rs.next()){
    logincontroller.abrirVentana();

    }else{
   Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
    dialogoAlerta.setTitle("Advertencia");
    dialogoAlerta.setHeaderText("Datos No Validos");
    dialogoAlerta.setContentText("Clave Electoral, ó Estado invalido");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
    }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
    dialogoAlerta.setTitle("Error");
    dialogoAlerta.setHeaderText("Ha Ocurrido un error con la BD");

    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }


    }
}
