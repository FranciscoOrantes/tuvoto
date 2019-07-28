/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Conexion;
import Modelo.ConsultaCandidatosGobierno;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Francisco
 */
public class EstadisticasGobiernoController implements Initializable {
@FXML private ImageView imagen1;
@FXML private Label nombre1;
@FXML private Label votos1;
@FXML private ImageView imagen2;
@FXML private Label nombre2;
@FXML private Label votos2;
@FXML private ImageView imagen3;
@FXML private Label nombre3;
@FXML private Label votos3;
@FXML private ImageView imagen4;
@FXML private Label nombre4;
@FXML private Label votos4;
@FXML private ImageView imagen5;
@FXML private Label nombre5;
@FXML private Label votos5;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        consultasVotoXVoto();
    } catch (Exception ex) {
        Logger.getLogger(EstadisticasGobiernoController.class.getName()).log(Level.SEVERE, null, ex);
    }
    } 
     
   /**
    * Extrae y muestra los datos del candidato 1
    * @throws SQLException
    * @throws IOException
    * @throws Exception 
    */
    public void DatosCandidato1() throws SQLException, IOException, Exception{
       
        String nombres=null;
        String apellidoPaterno=null;
        String apellidoMaterno= null;
        String path = null;
        String name;
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM registrovotos INNER JOIN candidato_gobierno ON registrovotos.idCandidato = candidato_gobierno.idCandidatoGob WHERE registrovotos.idCandidato=1 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                // votos = rs.getString("count(distinct idRegistroVoto)");
                 nombres = (String) rs.getObject("Nombres");
                 apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                 apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                 path = (String) rs.getObject("Perfil");

            }        
        }
nombre3.setText(nombres+" "+apellidoPaterno+" "+apellidoMaterno);
//votos1.setText("Numero de votos: "+ votos);
 Image image1 = new Image(path);
 imagen3.setImage(image1);
    }
    
   /**
    * Extrae el numero de votos del candidato 1 de la base de datos
    * @throws SQLException
    * @throws IOException
    * @throws Exception 
    */
    public void EstadisticasCandidato1() throws SQLException, IOException, Exception{
       
        
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT COUNT(DISTINCT idRegistroVoto) FROM registrovotos WHERE registrovotos.idCandidato=1 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                votos = rs.getString("COUNT(DISTINCT idRegistroVoto)");
                 

            }        
        }

votos3.setText("Numero de votos: "+ votos);

    }
    
   /**
    * Extrae y muestra los datos del candidato 2
    * @throws SQLException
    * @throws IOException
    * @throws Exception 
    */ 
    public void DatosCandidato2() throws SQLException, IOException, Exception{
       
        String nombres=null;
        String apellidoPaterno=null;
        String apellidoMaterno= null;
        String path = null;
        String name;
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM registrovotos INNER JOIN candidato_gobierno ON registrovotos.idCandidato = candidato_gobierno.idCandidatoGob WHERE registrovotos.idCandidato=2 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                // votos = rs.getString("count(distinct idRegistroVoto)");
                 nombres = (String) rs.getObject("Nombres");
                 apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                 apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                 path = (String) rs.getObject("Perfil");

            }        
        }
nombre2.setText(nombres+" "+apellidoPaterno+" "+apellidoMaterno);
//votos1.setText("Numero de votos: "+ votos);
 Image image1 = new Image(path);
 imagen2.setImage(image1);
    }
    /**
     * Extrae el numero de votos del candidato 2 de la base de datos
     * @throws SQLException
     * @throws IOException
     * @throws Exception 
     */
    public void EstadisticasCandidato2() throws SQLException, IOException, Exception{
       
        
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT COUNT(DISTINCT idRegistroVoto) FROM registrovotos WHERE registrovotos.idCandidato=2 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                votos = rs.getString("COUNT(DISTINCT idRegistroVoto)");
                 

            }        
        }

votos2.setText("Numero de votos: "+ votos);

    }
    
    /**
     * Extrae y muestra los datos del candidato 3
     * @throws SQLException
     * @throws IOException
     * @throws Exception 
     */
    public void DatosCandidato3() throws SQLException, IOException, Exception{
       
        String nombres=null;
        String apellidoPaterno=null;
        String apellidoMaterno= null;
        String path = null;
        String name;
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM registrovotos INNER JOIN candidato_gobierno ON registrovotos.idCandidato = candidato_gobierno.idCandidatoGob WHERE registrovotos.idCandidato=3 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                // votos = rs.getString("count(distinct idRegistroVoto)");
                 nombres = (String) rs.getObject("Nombres");
                 apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                 apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                 path = (String) rs.getObject("Perfil");

            }        
        }
nombre4.setText(nombres+" "+apellidoPaterno+" "+apellidoMaterno);
//votos1.setText("Numero de votos: "+ votos);
 Image image1 = new Image(path);
 imagen4.setImage(image1);
    }
    /**
     * Extrae el numero de votos del candidato 3 de la base de datos
     * @throws SQLException
     * @throws IOException
     * @throws Exception 
     */
    public void EstadisticasCandidato3() throws SQLException, IOException, Exception{
       
        
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT COUNT(DISTINCT idRegistroVoto) FROM registrovotos WHERE registrovotos.idCandidato=3 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                votos = rs.getString("COUNT(DISTINCT idRegistroVoto)");
                 

            }        
        }

votos4.setText("Numero de votos: "+ votos);

    }
    /**
     * Extrae y muestra los datos del candidato 4
     * @throws SQLException
     * @throws IOException
     * @throws Exception 
     */
    public void DatosCandidato4() throws SQLException, IOException, Exception{
       
        String nombres=null;
        String apellidoPaterno=null;
        String apellidoMaterno= null;
        String path = null;
        String name;
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM registrovotos INNER JOIN candidato_gobierno ON registrovotos.idCandidato = candidato_gobierno.idCandidatoGob WHERE registrovotos.idCandidato=4 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                // votos = rs.getString("count(distinct idRegistroVoto)");
                 nombres = (String) rs.getObject("Nombres");
                 apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                 apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                 path = (String) rs.getObject("Perfil");

            }        
        }
nombre1.setText(nombres+" "+apellidoPaterno+" "+apellidoMaterno);
//votos1.setText("Numero de votos: "+ votos);
 Image image1 = new Image(path);
 imagen1.setImage(image1);
    }
    
   /**
    * Extrae el numero de votos del candidato 4 de la base de datos
    * @throws SQLException
    * @throws IOException
    * @throws Exception 
    */
    public void EstadisticasCandidato4() throws SQLException, IOException, Exception{
       
        
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT COUNT(DISTINCT idRegistroVoto) FROM registrovotos WHERE registrovotos.idCandidato=4 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                votos = rs.getString("COUNT(DISTINCT idRegistroVoto)");
                 

            }        
        }

votos1.setText("Numero de votos: "+ votos);

    }
    
    
    public void DatosCandidato5() throws SQLException, IOException, Exception{
       
        String nombres=null;
        String apellidoPaterno=null;
        String apellidoMaterno= null;
        String path = null;
        String name;
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM registrovotos INNER JOIN candidato_gobierno ON registrovotos.idCandidato = candidato_gobierno.idCandidatoGob WHERE registrovotos.idCandidato=5 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                // votos = rs.getString("count(distinct idRegistroVoto)");
                 nombres = (String) rs.getObject("Nombres");
                 apellidoPaterno =(String) rs.getObject("ApellidoPaterno");
                 apellidoMaterno =(String) rs.getObject("ApellidoMaterno");
                 path = (String) rs.getObject("Perfil");

            }        
        }
nombre5.setText(nombres+" "+apellidoPaterno+" "+apellidoMaterno);
//votos1.setText("Numero de votos: "+ votos);
 Image image1 = new Image(path);
 imagen5.setImage(image1);
    }
    public void EstadisticasCandidato5() throws SQLException, IOException, Exception{
       
        
        String votos=null;
        int porcentaje;
           
        ResultSet rs;
    String Consulta="SELECT COUNT(DISTINCT idRegistroVoto) FROM registrovotos WHERE registrovotos.idCandidato=5 AND registrovotos.idTipoVoto=2";
     //String Consulta="SELECT votos, Nombres,ApellidoPaterno,ApellidoMaterno,Perfil FROM view.fvotosuno";
              ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta);
        cons.getError();

        if (cons.getError() == null){
             rs = cons.getResultado();
             
                      while (rs.next()) {
                votos = rs.getString("COUNT(DISTINCT idRegistroVoto)");
                 

            }        
        }

votos5.setText("Numero de votos: "+ votos);

    }
    /**
     * Permite mostrar los nombres y numeros de votos de todos los candidatos
     * @throws SQLException
     * @throws Exception 
     */
    public void consultasVotoXVoto() throws SQLException, Exception{
    DatosCandidato1();
    DatosCandidato2();
    DatosCandidato3();
    DatosCandidato4();
    DatosCandidato5();
    EstadisticasCandidato1();
    EstadisticasCandidato2();
    EstadisticasCandidato3();
    EstadisticasCandidato4();
    EstadisticasCandidato5();
    }
    public void RegresarLogin(){
LoginController.escenaBoleta.show();
BoletaController.estadisticas.close();

}
}
