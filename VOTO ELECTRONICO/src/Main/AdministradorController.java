/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.InsertarCandidato;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Francisco
 */
public class AdministradorController implements Initializable {
LoginController login;
static Stage escenaCandidatos;
static Stage escenaPartidos;
static Stage escenaCiudadanos;
static FXMLLoader loaderCiudadanos;
        
    /**
     * Initializes the controller class.
     */
/**
 * Abre la ventana para registrar Partidos
 * @throws IOException
 * @throws Exception 
 */    
public void abrirVentanaRegistroPartidos() throws IOException, Exception{
    
FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("RegistroPartidos.fxml"));
       Parent root1 = (Parent)fxmlloader.load();
       escenaPartidos = new Stage();
       escenaPartidos.setScene(new Scene(root1));
      escenaPartidos.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       escenaPartidos.setResizable(false);
       escenaPartidos.show();
       LoginController.escenaAdministrador.close();
       
   
}
/**
 * Abre la ventana para registrar ciudadanos
 * @throws IOException
 * @throws Exception 
 */    
public void abrirVentanaRegistroCiudadanos() throws IOException, Exception{
    
loaderCiudadanos = new FXMLLoader(getClass().getResource("RegistroCu.fxml"));
       Parent root1 = (Parent) loaderCiudadanos.load();
       escenaCiudadanos = new Stage();
       escenaCiudadanos.setScene(new Scene(root1));
       escenaCiudadanos.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       escenaCiudadanos.setResizable(false);
       escenaCiudadanos.show();
       LoginController.escenaAdministrador.close();
       
   
}
/**
 * Permite salir de la aplicacion
 */    
public void Salir(){
        
        System.exit(0);
    }
 
/**
 * Abre la ventana para registrar Candidatos
 * @throws IOException
 * @throws Exception 
 */
    public void abrirVentanaRegistroCandidatos() throws IOException, Exception{
    InsertarCandidato a= new InsertarCandidato();
        a.SacarPartido();
FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("RegistroCandidatos.fxml"));

       Parent root1 = (Parent)fxmlloader.load();
       escenaCandidatos = new Stage();
       escenaCandidatos.setScene(new Scene(root1));
       escenaCandidatos.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
       escenaCandidatos.setResizable(false);
       escenaCandidatos.show();
   
       LoginController.escenaAdministrador.close();
       
       
       
   
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
