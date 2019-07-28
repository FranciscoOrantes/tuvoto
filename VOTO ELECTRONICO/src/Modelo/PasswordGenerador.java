/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Francisco
 */
import java.util.UUID;
public class PasswordGenerador  {
  
   /**
    * Genera una password aleatoria
    * @return password
    */
    public String generatePassword() {
    String password = UUID.randomUUID().toString();
        return  password;
    }
}
