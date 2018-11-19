/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author java2
 */
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
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class decryption {
//public static void main(String args[])
//{
//           Scanner s=new Scanner(System.in);
//            System.out.println("Enter encrypted Text and key");
//            String text=s.next();
//            String key=s.next();
//	new decryption().decrypt(text,key);
//}

    public String decrypt(String txt, String skey) {
        String decryptedtext = null;
        try {

            //converting string to secretkey
            byte[] bs = Base64.decode(skey);
            SecretKey sec = new SecretKeySpec(bs, "AES");
            System.out.println("converted string to seretkey:" + sec);

            System.out.println("secret key:" + sec);

            Cipher aesCipher = Cipher.getInstance("AES");//getting AES instance
            aesCipher.init(Cipher.ENCRYPT_MODE, sec);//initiating ciper encryption using secretkey

            byte[] byteCipherText = new BASE64Decoder().decodeBuffer(txt); //encrypting data 

            //  System.out.println("ciper text:"+byteCipherText);
            aesCipher.init(Cipher.DECRYPT_MODE, sec, aesCipher.getParameters());//initiating ciper decryption

            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedtext = new String(byteDecryptedText);

            System.out.println("Decrypted Text:" + decryptedtext);
        } catch (Exception e) {
            System.out.println(e);
        }
        return decryptedtext;
    }

    String decrypt(String str, SecretKey sec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
