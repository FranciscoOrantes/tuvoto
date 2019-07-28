/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Conexion;
import Modelo.ConsultaCandidatosGobierno;
import Modelo.ProcesoVoto;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Isurilop
 */
public class BoletaController implements Initializable {
ProcesoVoto miVoto = new ProcesoVoto();
   static Stage estadisticas;
   static FXMLLoader loaderEstadisticas;
    @FXML
    private Label nombre1;
    @FXML
    private Label nombre2;
    @FXML
    private Label nombre3;
    @FXML
    private Label nombre4;
    @FXML
    private Label nombre5;
    @FXML
    private Label nombre6;
    @FXML
    private Label nombre7;
    @FXML
    private Label nombre8;
    @FXML
    private Label nombre9;
    @FXML
    private Label nombre10;
     @FXML
    private Label GobNombre1;
     @FXML
    private Label GobNombre2;
     @FXML
    private Label GobNombre3;
     @FXML
    private Label GobNombre4;
     @FXML
    private Label GobNombre5;
     @FXML
    private Label GobNombre6;
     @FXML
    private Label GobNombre7;
     @FXML
    private Label GobNombre8;
     @FXML
    private Label GobNombre9;
     @FXML
    private Label GobNombre10;
    @FXML
    private ImageView imagen1;
     @FXML
    private ImageView imagen2;
     @FXML
    private ImageView imagen3;
     @FXML
    private ImageView imagen4;
     @FXML
    private ImageView imagen5;
     @FXML
    private ImageView imagen6;
     @FXML
    private ImageView imagen7;
     @FXML
    private ImageView imagen8;
     @FXML
    private ImageView imagen9;
    @FXML
    private ImageView imagen10; 
    @FXML
    private ImageView Gobimagen1; 
      @FXML
    private ImageView Gobimagen2; 
      @FXML
    private ImageView Gobimagen3; 
      @FXML
    private ImageView Gobimagen4; 
      @FXML
    private ImageView Gobimagen5; 
      @FXML
    private ImageView Gobimagen6; 
      @FXML
    private ImageView Gobimagen7; 
      @FXML
    private ImageView Gobimagen8; 
      @FXML
    private ImageView Gobimagen9; 
       @FXML
    private ImageView Gobimagen10; 
    @FXML 
    private Label nombreCiudadano;
    
    public static String usuario;
    public static String correoElectronicoUsuario;
      
      public void ciudadano() throws SQLException{
       String clave;
       clave = LoginController.clave;
       
     String Consulta1 = "SELECT Nombres,ApellidoPaterno,ApellidoMaterno, correoElectronico FROM ciudadanos WHERE Claveelectoral='"+clave+"'";
    ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta1);
    cons.getError();
     ResultSet rs;
      if (cons.getError() == null) {
        rs = cons.getResultado();

            while (rs.next()) {

                String nombre = (String) rs.getObject("Nombres");
                String apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                String apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                String correoElectronico = (String) rs.getObject("correoElectronico");
                usuario = nombre +" "+apellidoPaterno +" "+apellidoMaterno;
                correoElectronicoUsuario = correoElectronico;
            }
          

        }
    nombreCiudadano.setText(usuario);
    
          
          
      }
      
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Conexion conn = new Conexion();
        Connection con = conn.conectate();
    try {
        ciudadano();
    } catch (SQLException ex) {
        Logger.getLogger(BoletaController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void extraer() throws SQLException {

       
         String nombres[] = new String[25];
         String fotos[] = new String[25];
         int contador = 0;
        ResultSet rs;
      
        String Consulta1 = "SELECT partidos.Perfil, Nombres, ApellidoPaterno, ApellidoMaterno FROM candidato_p_republica INNER JOIN partidos ON partidos.idPartido = candidato_p_republica.idPartido ";
        ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta1);
        cons.getError();

        if (cons.getError() == null) {
            rs = cons.getResultado();

            while (rs.next()) {

                String nombre = (String) rs.getObject("Nombres");
                String apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                String apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                String path = (String) rs.getObject("Perfil");
                nombres[contador]= nombre +" "+ apellidoPaterno+" "+apellidoMaterno;
                fotos[contador]= path;
              
  contador++;
            }
             nombre1.setText(nombres[0]);
            Image image = new Image(fotos[0]);
            imagen1.setImage(image);
            
            nombre2.setText(nombres[1]);
            Image image1 = new Image(fotos[1]);
           imagen2.setImage(image1);
            
            nombre3.setText(nombres[2]);
            Image image3 = new Image(fotos[2]);
            imagen3.setImage(image3);
            
              nombre4.setText(nombres[3]);
            Image image4 = new Image(fotos[3]);
            imagen4.setImage(image4);
            
              nombre5.setText(nombres[4]);
            Image image5 = new Image(fotos[4]);
           imagen5.setImage(image5);
            
               nombre6.setText(nombres[5]);
            Image image6 = new Image(fotos[5]);
            imagen6.setImage(image6);
                       nombre7.setText(nombres[6]);
            Image image7 = new Image(fotos[6]);
              imagen7.setImage(image7);
              
                    nombre8.setText(nombres[7]);
            Image image8 = new Image(fotos[7]);
              imagen8.setImage(image8);
            
                    nombre9.setText(nombres[8]);
            Image image9 = new Image(fotos[8]);
              imagen9.setImage(image9);
              
               nombre10.setText(nombres[9]);
            Image image10 = new Image(fotos[9]);
              imagen10.setImage(image10);
        
            
        
           
          

        }


    }

 
 
  public void extraerdos() throws SQLException{
      
      
       
         String nombres[] = new String[25];
         String fotos[] = new String[25];
      
        int contador = 0;
        ResultSet rs;
        String Consulta1 = "SELECT nombre, Nombres,ApellidoPaterno,ApellidoMaterno, partidos.Perfil, candidato_gobierno.idEstado Estado FROM candidato_gobierno INNER JOIN partidos ON partidos.idPartido = candidato_gobierno.idPartido WHERE candidato_gobierno.idEstado='"+LoginController.IdEstado+"'";
        
        ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta1);
        
        cons.getError();

        if (cons.getError() == null) {
            rs = cons.getResultado();
           
            while (rs.next()) {

                String nombre = (String) rs.getObject("Nombres");
                String apellidop = (String) rs.getObject("ApellidoPaterno");
                String apellidom = (String) rs.getObject("ApellidoMaterno");
                String url =(String) rs.getObject("partidos.perfil");
                 nombres[contador] =nombre +" "+ apellidop+ " "+ apellidom;
                 fotos[contador]= url;
           
              contador++;
           
            }
            
            GobNombre1.setText(nombres[0]);
            Image image = new Image(fotos[0]);
            Gobimagen1.setImage(image);
            
            GobNombre2.setText(nombres[1]);
            Image image1 = new Image(fotos[1]);
            Gobimagen2.setImage(image1);
            
            GobNombre3.setText(nombres[2]);
            Image image3 = new Image(fotos[2]);
            Gobimagen3.setImage(image3);
            
             GobNombre4.setText(nombres[3]);
            Image image4 = new Image(fotos[3]);
            Gobimagen4.setImage(image4);
            
             GobNombre5.setText(nombres[4]);
            Image image5 = new Image(fotos[4]);
            Gobimagen5.setImage(image5);
            
               GobNombre6.setText(nombres[5]);
            Image image6 = new Image(fotos[5]);
              Gobimagen6.setImage(image6);
            
                  GobNombre7.setText(nombres[6]);
            Image image7 = new Image(fotos[6]);
              Gobimagen7.setImage(image7);
              
                    GobNombre8.setText(nombres[7]);
            Image image8 = new Image(fotos[7]);
              Gobimagen8.setImage(image8);
            
                    GobNombre9.setText(nombres[8]);
            Image image9 = new Image(fotos[8]);
              Gobimagen9.setImage(image9);
              
               GobNombre10.setText(nombres[9]);
            Image image10 = new Image(fotos[9]);
              Gobimagen10.setImage(image10);
         
         
           
           
                    
      
    }
      
      
  }
  
  

  
  

  

  //sacar partido
public void RegresarLogin(){
Main.ventanaLogin.show();
LoginController.escenaBoleta.close();

}
public void VotarCandidatoFederal(){
 ProcesoVoto.idCandidatoFederal = 1;
 miVoto.buscarVotoFederal();
 } 
public void VotarCandidatoFederal1(){
 ProcesoVoto.idCandidatoFederal = 1;
 miVoto.buscarVotoFederal();
 }
 public void VotarCandidatoFederal2(){
 ProcesoVoto.idCandidatoFederal = 2;
 miVoto.buscarVotoFederal();
 }
 public void VotarCandidatoFederal3(){
 ProcesoVoto.idCandidatoFederal = 3;
 miVoto.buscarVotoFederal();
 }
 public void VotarCandidatoFederal4(){
 ProcesoVoto.idCandidatoFederal = 4;
 miVoto.buscarVotoFederal();
 }
 public void VotarCandidatoEstatal(){
 miVoto.buscarVotoEstatal();
 }
 public void VotarCandidatoEstatal1(){
 ProcesoVoto.idCandidatoEstatal = 1;
     miVoto.buscarVotoEstatal();
 }
 public void VotarCandidatoEstatal2(){
 ProcesoVoto.idCandidatoEstatal = 2;
     miVoto.buscarVotoEstatal();
 }
 public void VotarCandidatoEstatal3(){
 ProcesoVoto.idCandidatoEstatal = 3;
     miVoto.buscarVotoEstatal();
 }
 public void VotarCandidatoEstatal4(){
 ProcesoVoto.idCandidatoEstatal = 4;
     miVoto.buscarVotoEstatal();
 }
 public void VotarCandidatoEstatal5(){
 ProcesoVoto.idCandidatoEstatal = 5;
     miVoto.buscarVotoEstatal();
 }
 public void contarVotosEstatal() throws SQLException{
 int votos = 0;
       
       
     String Consulta1 = "SELECT COUNT(DISTINCT idRegistroVotos) FROM registrovoto WHERE idCandidato=1 AND idTipoVoto = 1";
    ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta1);
    cons.getError();
     ResultSet rs;
      if (cons.getError() == null) {
        rs = cons.getResultado();

            while (rs.next()) {

                votos = (int) rs.getObject("COUNT(DISTINCT idRegistroVotos)");
                
            }
          

        }
 }
 public void mostrarVentanaEstadisticas() throws IOException{
 loaderEstadisticas = new FXMLLoader(getClass().getResource("Estadisticas.fxml"));
       Parent root1 = (Parent)loaderEstadisticas.load();
       estadisticas = new Stage();
       estadisticas.setScene(new Scene(root1));
       estadisticas.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       estadisticas.setResizable(false);
       estadisticas.show();
       LoginController.escenaBoleta.close();
 }
 public void mostrarVentanaEstadisticasGob() throws IOException{
 loaderEstadisticas = new FXMLLoader(getClass().getResource("EstadisticasGobierno.fxml"));
       Parent root1 = (Parent)loaderEstadisticas.load();
       estadisticas = new Stage();
       estadisticas.setScene(new Scene(root1));
       estadisticas.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       estadisticas.setResizable(false);
       estadisticas.show();
       LoginController.escenaBoleta.close();
 }
}
