
package Modelo;

import Main.RegistroCuController;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


/**
 *
 * @author Isurilop
 */
public class RegistrarVotantes {
    
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Nombres;
    private int AñoNacimiento;
    private int MesNacimiento;
    private int DiaNacimiento;
    private String Curp;
    private String Claveelectoral;
    private String idEstado;
    private String correoElectronico;
    private float voto = 0;
    private float votoEstatal = 0;
    private String password = "null";
   
    /**
     * Permite guardar la informacion de los ciudadanos en la base de datos
     */
        public void insertarDatos(){
        ApellidoPaterno= Main.RegistroCuController.apellidoP;
     ApellidoMaterno =Main.RegistroCuController.apellidoM;
     Nombres =Main.RegistroCuController.Nombres;
     AñoNacimiento= Main.RegistroCuController.ano;
     MesNacimiento =Main.RegistroCuController.mes;
     DiaNacimiento =Main.RegistroCuController.Dia;
     Curp = Main.RegistroCuController.Curp;
     Claveelectoral =Main.RegistroCuController.Clave;
     idEstado=Main.RegistroCuController.Entidad;
     correoElectronico = Main.RegistroCuController.CorreoElectronico;
     
     
        Conexion con = new Conexion();
        Connection st = con.conectate();
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "INSERT INTO ciudadanos(ApellidoPaterno,ApellidoMaterno,Nombres,AñoNacimiento,MesNacimiento,DiaNacimiento,Curp,Claveelectoral,idEstado,votoFederal, votoEstatal, correoElectronico,password, passwordEstatal) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    pst.setString(1, ApellidoPaterno);
    pst.setString(2, ApellidoMaterno);
    pst.setString(3, Nombres);
    pst.setInt(4, AñoNacimiento);
    pst.setInt(5, MesNacimiento);
    pst.setInt(6, DiaNacimiento);
    pst.setString(7, Curp);
    pst.setString(8, Claveelectoral);
    pst.setString(9, idEstado);
    pst.setFloat(10, voto);
    pst.setFloat(11, votoEstatal);
    pst.setString(12, correoElectronico);
    pst.setString(13, password);
    pst.setString(14, password);
    pst.executeUpdate();

            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
    dialogoAlerta.setTitle("Éxito");
    dialogoAlerta.setHeaderText("La Operacion se realizo con éxito");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }
        catch(Exception e){
        Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
    dialogoAlerta.setTitle("Ha Ocurrido un error con la BD");
        }
            
        }
        
    
    
}
