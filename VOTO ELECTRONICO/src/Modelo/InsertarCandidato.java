package Modelo;

import Modelo.Conexion;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


public class InsertarCandidato {

    private String ApellidoP;
    private String ApellidoM;
    private String Nombres;
    private int EdadAños;
    private String Su_partido;
    private String Puesto_a_Aspirar;
    private String CiudadCity;
    private String sloganSlog;
    private String PerfilFile;
    private int idCandidato;

    public static String P_Republic = "Presidente de la Republica";
    public static String G_gobernador = "Gobernador";
    
    public static String Part1 ;
    public static String Part2;
    public static String Part3;
    public static String Part4;
    public static String Part5;
    public static String Part6;
    public static String Part7;
    public static String Part8;
    public static String Part9;
    public static String Part10;
    public static String Part11;
    public static String Part12;
    private int id;
    
  /**
   * Almacena todos los partidos de la base de datos en un arreglo
   * @throws SQLException 
   */  
  public void SacarPartido() throws SQLException{
      
    
        String[] var = new String[20];
 
        int contador = 0;
        ResultSet rs;
        String Consulta1 = "SELECT idPartido,nombre FROM partidos";
       
        ConsultaCandidatosGobierno cons = new ConsultaCandidatosGobierno(Consulta1);
        
        cons.getError();

        if (cons.getError() == null) {
            rs = cons.getResultado();
           
            while (rs.next()) {

         
                String nombrePartido = (String) rs.getObject("nombre");
                var[contador]= nombrePartido;
                
                contador++;
            }
            Part1=var[0];
            Part2=var[1];
            Part3=var[2];
            Part4=var[3];
            Part5=var[4];
            Part6=var[5];
            Part7=var[6];
            Part8=var[7];
            Part9=var[8];
            Part10=var[9];
            Part11=var[10];
            Part12=var[11];
            
            
          
            
          
      
        }  
  }
  /**
   * Saca el id del Partido en cuestion
   * @return id
   * @throws SQLException 
   */  
  public int idpartido() throws SQLException{
        
        Su_partido = Main.RegistroCandidatosController.PartidoElegido;
          String Consulta2 = "SELECT idPartido,nombre FROM partidos WHERE nombre='"+Su_partido+"'";
        ConsultaCandidatosGobierno consulta = new ConsultaCandidatosGobierno(Consulta2);
         ResultSet rs;
              if (consulta.getError() == null) {
            rs = consulta.getResultado();
           
            while (rs.next()) {
               this.id = (Integer) rs.getObject("idpartido");
         
          
            }
           
           
        } return id;
    }
    
    
  /**
   * Metodo que permite guardar los candidatos en la base de datos
   * @throws SQLException 
   */ 
  public void InsertCandidato() throws SQLException {
        
        ApellidoP = Main.RegistroCandidatosController.ApellidoPaterno;
        ApellidoM = Main.RegistroCandidatosController.ApellidoMaterno;
        Nombres = Main.RegistroCandidatosController.Nombre;
        EdadAños = Main.RegistroCandidatosController.Edad;
        Puesto_a_Aspirar = Main.RegistroCandidatosController.Cargoelegido;
        CiudadCity = Main.RegistroCandidatosController.Ciudad;
        sloganSlog = Main.RegistroCandidatosController.Slogan;
        PerfilFile = Main.RegistroCandidatosController.imageFile;
        idCandidato = Main.RegistroCandidatosController.idC;
        Conexion con = new Conexion();
        Connection st = con.conectate();

        if (Puesto_a_Aspirar.equals("Presidente de la Republica")) {
            try {
                Statement execute = st.createStatement();

                PreparedStatement pst = st.prepareStatement(
  "INSERT INTO candidato_p_republica (idCandidato,ApellidoPaterno,ApellidoMaterno,Nombres,Edad,idPartido,PuestoAspirar,Ciudad,slogan,Perfil,idEstado) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, idCandidato);
                pst.setString(2, ApellidoP);
                pst.setString(3, ApellidoM);
                pst.setString(4, Nombres);
                pst.setInt(5, EdadAños);
                pst.setInt(6,idpartido());
                pst.setString(7, Puesto_a_Aspirar);
                pst.setString(8, CiudadCity);
                pst.setString(9, sloganSlog);
                pst.setString(10, PerfilFile);
                pst.setString(11,Main.RegistroCandidatosController.Estado );

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
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
            }
        }

        if (Puesto_a_Aspirar.equals("Gobernador")) {
          
            try {
                Statement execute = st.createStatement();

                PreparedStatement pst = st.prepareStatement(
                        "INSERT INTO candidato_gobierno (idCandidatoGob,ApellidoPaterno,ApellidoMaterno,Nombres,Edad,idPartido,PuestoAspirar,Ciudad,slogan,Perfil,idEstado) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, idCandidato);
                pst.setString(2, ApellidoP);
                pst.setString(3, ApellidoM);
                pst.setString(4, Nombres);
                pst.setInt(5, EdadAños);
                 pst.setInt(6,idpartido());
                pst.setString(7, Puesto_a_Aspirar);
                pst.setString(8, CiudadCity);
                pst.setString(9, sloganSlog);
                pst.setString(10, PerfilFile);
                pst.setString(11,Main.RegistroCandidatosController.Estado );
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
    dialogoAlerta.setTitle("");
    dialogoAlerta.setHeaderText("Error con la BD");
    dialogoAlerta.initStyle(StageStyle.UTILITY);
    dialogoAlerta.showAndWait();
            }
        }

      
    }
    
    
    
    
    
    
    
}

