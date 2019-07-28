
package Main;


import Modelo.InsertarCandidato;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
   static Stage ventanaLogin;
    
   /**
    * Metodo que abre la ventana del login
    * @param stage
    * @throws Exception 
    */
   @Override
    public void start(Stage stage) throws Exception {
       
        this.ventanaLogin = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        ventanaLogin.setScene(scene);
        ventanaLogin.setResizable(false);
        ventanaLogin.getIcons().add(new Image("Resourses/Imagenes/iso.png"));
        ventanaLogin.show();
         
        
        
    }

 
    public static void main(String[] args)  {
        launch(args);
        
    }
    
}
