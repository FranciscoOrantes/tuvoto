package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


public class InsertarPartidos {

    private String NombreUsuario;
    private String NamePresidente;
    private String PerfilFile;
    private String StatusSelected;

   /**
    * Permite guardar los partidos en la base de datos
    */
    public void InsertarInfo() {
        NombreUsuario = Main.RegistroPartidosController.NombreUser;
        NamePresidente = Main.RegistroPartidosController.Nombre_Del_Presidente;
        PerfilFile = Main.RegistroPartidosController.imageFile;
        StatusSelected = Main.RegistroPartidosController.EstadoSeleccionado;

        Conexion con = new Conexion();
        Connection st = con.conectate();

        try {

            if (StatusSelected.equals("Nacional")) {
                StatusSelected = "00";
            }

            if (StatusSelected.equals("Aguascalientes")) {
                StatusSelected = "01";
            }
            if (StatusSelected.equals("Baja California")) {
                StatusSelected = "02";
            }
            if (StatusSelected.equals("Baja California Sur")) {
                StatusSelected = "03";
            }
            if (StatusSelected.equals("Campeche")) {
                StatusSelected = "04";
            }
            if (StatusSelected.equals("Coahuila de Zaragoza")) {
                StatusSelected = "05";
            }
            if (StatusSelected.equals("Colima")) {
                StatusSelected = "06";
            }
            if (StatusSelected.equals("Chiapas")) {
                StatusSelected = "07";
            }
            if (StatusSelected.equals("Chihuahua")) {
                StatusSelected = "08";
            }
            if (StatusSelected.equals("Distrito Federal")) {
                StatusSelected = "09";
            }
            if (StatusSelected.equals("Durango")) {
                StatusSelected = "10";
            }
            if (StatusSelected.equals("Guanajuato")) {
                StatusSelected = "11";
            }
            if (StatusSelected.equals("Guerrero")) {
                StatusSelected = "12";
            }
            if (StatusSelected.equals("Hidalgo")) {
                StatusSelected = "13";
            }
            if (StatusSelected.equals("Jalisco")) {
                StatusSelected = "14";
            }
            if (StatusSelected.equals("México")) {
                StatusSelected = "15";
            }
            if (StatusSelected.equals("Michoacán")) {
                StatusSelected = "16";
            }
            if (StatusSelected.equals("Morelos")) {
                StatusSelected = "17";
            }
            if (StatusSelected.equals("Nayarit")) {
                StatusSelected = "18";
            }
            if (StatusSelected.equals("Nuevo León")) {
                StatusSelected = "19";
            }
            if (StatusSelected.equals("Oaxaca")) {
                StatusSelected = "20";
            }
            if (StatusSelected.equals("Puebla")) {
                StatusSelected = "21";
            }
            if (StatusSelected.equals("Querétaro")) {
                StatusSelected = "22";
            }
            if (StatusSelected.equals("Quintana Roo")) {
                StatusSelected = "23";
            }
            if (StatusSelected.equals("San Luis Potosí")) {
                StatusSelected = "24";
            }
            if (StatusSelected.equals("Sinaloa")) {
                StatusSelected = "25";
            }
            if (StatusSelected.equals("Sonora")) {
                StatusSelected = "26";
            }
            if (StatusSelected.equals("Tabasco")) {
                StatusSelected = "27";
            }
            if (StatusSelected.equals("Tamaulipas")) {
                StatusSelected = "28";
            }
            if (StatusSelected.equals("Tlaxcala")) {
                StatusSelected = "29";
            }
            if (StatusSelected.equals("Veracruz")) {
                StatusSelected = "30";
            }
            if (StatusSelected.equals("Yucatán")) {
                StatusSelected = "31";
            }
            if (StatusSelected.equals("Zacatecas")) {
                StatusSelected = "32";
            }
           

            
            
            Statement execute = st.createStatement();

            PreparedStatement pst = st.prepareStatement(
                    "INSERT INTO partidos(idEstado,Nombre, NombrePresidente,Perfil) VALUES(?,?,?,?)");
            pst.setString(1, StatusSelected);
            pst.setString(2, NombreUsuario);
            pst.setString(3, NamePresidente);
            pst.setString(4, PerfilFile);

            int res = pst.executeUpdate();
            if (res > 0) {
                  Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
    dialogoAlerta.setTitle("Exito");
    dialogoAlerta.setHeaderText("Se han guardado los Datos");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
            }
        } catch (Exception e) {
              Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("Erro");
    dialogoAlerta.setHeaderText("Ha ocurrido un error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }

    }
}
