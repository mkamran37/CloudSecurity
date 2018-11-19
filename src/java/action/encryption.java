/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;

public class encryption {

    public String encrypt(String text, SecretKey secretkey) {
        String plainData = null, cipherText = null;
        try {
            plainData = text;

            Cipher aesCipher = Cipher.getInstance("AES");//getting AES instance
            aesCipher.init(Cipher.ENCRYPT_MODE, secretkey);//initiating ciper encryption using secretkey

            byte[] byteDataToEncrypt = plainData.getBytes();
            byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);//encrypting data 

            cipherText = new BASE64Encoder().encode(byteCipherText);//converting encrypted data to string 

            System.out.println("\n Given text : " + plainData + " \n Cipher Data : " + cipherText);

        } catch (Exception e) {
            System.out.println(e);
        }
        return cipherText;
    }

}
