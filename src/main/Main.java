/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Objects.Encriptador;
import Objects.ObjetoEncriptado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Main {
       public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\House\\Pictures\\prueba"
                + "\\village_field_poland_mountains_grass_snow_115890_3840x2400.jpg");
           try {
               ObjetoEncriptado arregloEncriptado = Encriptador.encriptaArchivo(file);
               GestionadorArchivo.guardarArchivito(arregloEncriptado, "archivoEncriptado.txt");
           } catch (IOException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
           File encriptado = new File("archivoEncriptado.txt");
           
           
           
               byte[] arregloDesencriptado = null;
           try {
               arregloDesencriptado = Encriptador.desencriptarArchivo(encriptado);
               GestionadorArchivo.guardarArchivito(arregloDesencriptado, "archivoDesencriptado.jpg");
           } catch (FileNotFoundException | ClassNotFoundException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
               
           
               
           
           
           
               byte[] b = new byte[(int) file.length()];
               
               FileInputStream in = new FileInputStream(file);
               in.read(b);
               /*for(int i=0; i< b.length; i++){
                   System.out.println("Arreglo desencriptado: "+arregloDesencriptado[i]+" | "+b[i]+" : Arreglo Prueba");
                   if(arregloDesencriptado[i] != b[i]){
                       System.out.println("Aqui es DISTINTO!!!!!");
                   }
               }*/
               File prueba = new File("prueba.jpg");
              
               FileOutputStream fos = new FileOutputStream(prueba);
               fos.write(b);
               fos.close();
               
           
    }
}
