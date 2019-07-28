/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Main.BoletaController;
import Main.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author Francisco
 */
public class ProcesoVoto {
    private float voto = 1;
    public static int idCandidatoFederal;
    public  static int idCandidatoEstatal;
    private int idRegistroVoto = 0;
    private int tipoVotoFederal = 1;
    private int tipoVotoEstatal = 2;
    private String password;
    private String passwordEstatal;
   /**
    * Metodo que evalua si el ciudadano ya votó o no
    */
       public void buscarVotoFederal(){
    
        Conexion con = new Conexion();
        Connection st = con.conectate();
        ResultSet rs;
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    
    "SELECT * FROM ciudadanos WHERE Claveelectoral= ? && votoFederal=?");
     
  pst.setString(1,LoginController.clave );
  pst.setFloat(2, 0);
    rs = pst.executeQuery();
    if(rs.next()){
        
   Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle(" DIALOGO DE CONFIRMACION ");
alert.setContentText(" ESTA SEGURO QUE DESEA VOTAR POR DICHO CANDIDATO?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
  RegistrarPasswordAleatoria();
  try{ 
  Properties props = new Properties();
   props.setProperty("mail.smtp.host", "smtp.gmail.com");
   props.setProperty("mail.smtp.starttls.enable", "true");
   props.setProperty("mail.smtp.port", "587");
   props.setProperty("mail.smtp.auth", "true");
   Session session = Session.getDefaultInstance(props);
   String correoRemitente = "tu.votoelectronico@gmail.com";
   String passwordRemitente = "jesucristo123a";
   String correoDestinatario = BoletaController.correoElectronicoUsuario;
   
   String asunto = " Contraseña de seguridad para confirmar voto de las elecciones Federales ";
   String mensaje = "Contraseña de seguridad :  " + password ;
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(correoRemitente));
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
   message.setSubject(asunto);
    message.setText(mensaje);
    
    Transport t = session.getTransport("smtp");
    t.connect(correoRemitente, passwordRemitente);
    t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    t.close();
  }catch(AddressException ex){
 Logger.getLogger(ProcesoVoto.class.getName()).log(Level.SEVERE,null, ex); 
  }catch(MessagingException ex){
 Logger.getLogger(ProcesoVoto.class.getName()).log(Level.SEVERE,null, ex);
  }
   TextInputDialog dialog = new TextInputDialog();
dialog.setTitle(" Ventana de seguridad ");
dialog.setHeaderText(" Confirmacion de contraseña ");
dialog.setContentText(" Porfavor ingrese la contraseña que se le envió al correo electronico registrado");

// Traditional way to get the response value.
Optional<String> result2 = dialog.showAndWait();
if (result2.isPresent()){
    if(result2.get().equals(password)){
   // idCandidatoFederal();
   VotarFederal();
    RegistrarVotoFederal();
    }else{
    JOptionPane.showMessageDialog(null, " No es correcta la contraseña ");
    }
}

// The Java 8 way to get the response value (with lambda expression).

} else {
    // ... user chose CANCEL or closed the dialog
}
   
    }else{
    Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("Error");
    dialogoAlerta.setHeaderText("Usted Ya Voto");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
    
    }

           
        }
        catch(Exception e){
          
        Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD" + e);
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }


    }
       /**
        * Metodo que realiza el voto federal
        */
    public void VotarFederal(){
 Conexion con = new Conexion();
        Connection st = con.conectate();
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "UPDATE ciudadanos SET votoFederal=? WHERE Claveelectoral=?");
  pst.setFloat(1,voto);
  pst.setString(2,LoginController.clave);
 int res =    pst.executeUpdate();  
 if(res >0){
 Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Se ha Votado Con Éxito");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
 }
        }
        catch(Exception e){
              Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }
}
 /**
  * Metodo que saca la id de los candidatos de las elecciones Federales
  */
 public void idCandidatoFederal(){
 Conexion con = new Conexion();
 Connection st = con.conectate(); 
 ResultSet rs;
 try{
 Statement execute = st.createStatement();
 PreparedStatement pst = st.prepareStatement(
 "SELECT idCandidato FROM candidato_p_republica" );
 rs = pst.executeQuery();
 if(rs.next()){
  idCandidatoFederal = rs.getInt("idCandidato"); 
  
 }
 }catch(Exception e){
 }
 }
 /**
  * Metodo que saca la id de los candidatos de las elecciones estatales
  */
 public void idCandidatoEstatal(){
 Conexion con = new Conexion();
 Connection st = con.conectate(); 
 ResultSet rs;
 try{
 Statement execute = st.createStatement();
 PreparedStatement pst = st.prepareStatement(
 "SELECT idCandidatoGob FROM candidato_gobierno" );
 rs = pst.executeQuery();
 if(rs.next()){
  idCandidatoEstatal = rs.getInt("idCandidatoGob"); 
  
 }
 }catch(Exception e){
 }
 
 
 }
 /**
  * Metodo que evalua si el ciudadano ya voto en las elecciones estatales
  */
public void buscarVotoEstatal(){
Conexion con = new Conexion();
        Connection st = con.conectate();
        ResultSet rs;
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    
    "SELECT * FROM ciudadanos WHERE Claveelectoral= ? && votoEstatal=?");
     
  pst.setString(1,LoginController.clave );
  pst.setFloat(2, 0);
    rs = pst.executeQuery();
    if(rs.next()){
       Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle(" DIALOGO DE CONFIRMACION ");
alert.setContentText(" ESTA SEGURO QUE DESEA VOTAR POR DICHO CANDIDATO?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
  RegistrarPasswordEstatalAleatoria();
  try{ 
  Properties props = new Properties();
   props.setProperty("mail.smtp.host", "smtp.gmail.com");
   props.setProperty("mail.smtp.starttls.enable", "true");
   props.setProperty("mail.smtp.port", "587");
   props.setProperty("mail.smtp.auth", "true");
   Session session = Session.getDefaultInstance(props);
   String correoRemitente = "tu.votoelectronico@gmail.com";
   String passwordRemitente = "jesucristo123a";
   String correoDestinatario = BoletaController.correoElectronicoUsuario;
   String asunto = " Contraseña de seguridad para confirmar voto en las elecciones estatales";
   String mensaje = "Contraseña de seguridad :  " + passwordEstatal ;
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(correoRemitente));
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
   message.setSubject(asunto);
    message.setText(mensaje);
    
    Transport t = session.getTransport("smtp");
    t.connect(correoRemitente, passwordRemitente);
    t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    t.close();
  }catch(AddressException ex){
 Logger.getLogger(ProcesoVoto.class.getName()).log(Level.SEVERE,null, ex); 
  }catch(MessagingException ex){
 Logger.getLogger(ProcesoVoto.class.getName()).log(Level.SEVERE,null, ex);
  }
   TextInputDialog dialog = new TextInputDialog();
dialog.setTitle(" Ventana de seguridad ");
dialog.setHeaderText(" Confirmacion de contraseña ");
dialog.setContentText(" Porfavor ingrese la contraseña que se le envió al correo electronico registrado");

// Traditional way to get the response value.
Optional<String> result2 = dialog.showAndWait();
if (result2.isPresent()){
    if(result2.get().equals(passwordEstatal)){
  //  idCandidatoEstatal();
   VotarEstatal();
    RegistrarVotoEstatal();
    }else{
    JOptionPane.showMessageDialog(null, " No es correcta la contraseña ");
    }
}

// The Java 8 way to get the response value (with lambda expression).

} else {
    // ... user chose CANCEL or closed the dialog
}
        
    }else{
    Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("Error");
    dialogoAlerta.setHeaderText("Usted Ya Voto");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
    }     
        }
        catch(Exception e){
          
        Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }


}

/**
 * Metodo que permite realizar las votaciones estatales
 */
public void VotarEstatal(){
Conexion con = new Conexion();
        Connection st = con.conectate();
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "UPDATE ciudadanos SET votoEstatal=? WHERE Claveelectoral=?");
  pst.setFloat(1,voto);
  pst.setString(2,LoginController.clave);
 int res =    pst.executeUpdate();  
 if(res >0){
 Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Se ha Votado Con Éxito");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
 }
        }
        catch(Exception e){
              Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }
}
/**
 * Registra el voto al candidato que el ciudadano eligio dentro de las elecciones Federales
 */
public void RegistrarVotoFederal(){
 Conexion con = new Conexion();
        Connection st = con.conectate();
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "INSERT INTO registrovotos(idRegistroVoto,idCandidato,idTipoVoto) VALUES(?,?,?)");
    pst.setInt(1, idRegistroVoto);
    pst.setInt(2, idCandidatoFederal);
    pst.setInt(3, tipoVotoFederal);
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
/**
 * Registra el voto al candidato que el ciudadano eligio dentro de las elecciones Estatales
 */
public void RegistrarVotoEstatal(){
 Conexion con = new Conexion();
        Connection st = con.conectate();
       
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "INSERT INTO registrovotos(idRegistroVoto,idCandidato,idTipoVoto) VALUES(?,?,?)");
    pst.setInt(1, idRegistroVoto);
    pst.setInt(2, idCandidatoEstatal);
    pst.setInt(3, tipoVotoEstatal);
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
/**
 * Metodo para guardar la contraseña que se genero aleatoriamente
 */
public void RegistrarPasswordAleatoria(){
Conexion con = new Conexion();
        Connection st = con.conectate();
        PasswordGenerador generador = new PasswordGenerador();
     String  password = generador.generatePassword();
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "UPDATE ciudadanos SET password=? WHERE Claveelectoral=?");
  pst.setString(1,password);
  pst.setString(2,LoginController.clave);
 int res =    pst.executeUpdate();  
 if(res >0){
this.password = password;
 }
        }
        catch(Exception e){
              Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }
}
public void RegistrarPasswordEstatalAleatoria(){
Conexion con = new Conexion();
        Connection st = con.conectate();
        PasswordGenerador generador = new PasswordGenerador();
     String  passwordEstatal = generador.generatePassword();
        try{
        Statement execute = st.createStatement();
        
      PreparedStatement pst =st.prepareStatement(
    "UPDATE ciudadanos SET passwordEstatal=? WHERE Claveelectoral=?");
  pst.setString(1,passwordEstatal);
  pst.setString(2,LoginController.clave);
 int res =    pst.executeUpdate();  
 if(res >0){
this.passwordEstatal = passwordEstatal;
 }
        }
        catch(Exception e){
              Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
        }
}
}
