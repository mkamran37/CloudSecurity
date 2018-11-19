/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import action.Ftpcon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author java2
 */
public class encrypt1 extends HttpServlet {

    //private static java.sql.Date getCurrentDate() //{
        //java.util.Date today = new java.util.Date();
        //return new java.sql.Date(today.getTime());
    //}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection con;
            PreparedStatement pstm = null;
            PreparedStatement pstm1 = null;
             PreparedStatement pstm2 = null;
             String filename = "";
             String owner = request.getParameter("owner");
             
            String fname1 = "";
             //String date = "";
             //String gname = "";
             //String subject = "";
           // String keyword = "";
            String cd = "";
            String str = "";
                 
           
             
             String privatekey = "";
             String policy = "";
             String role = "";
             String exp = "";
            String department = "";
            String skey="8962"  ;
         String securitylevel="";
        byte PART_SIZE = 2;   
           
            try {
                boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
                if (!isMultipartContent) {
                    return;
                }
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    List<FileItem> fields = upload.parseRequest(request);
                    Iterator<FileItem> it = fields.iterator();
                    if (!it.hasNext()) {
                        return;
                    }
                    while (it.hasNext()) {
                        FileItem fileItem = it.next();
                        
                        if (fileItem.getFieldName().equals("privatekey")) {
                            privatekey = fileItem.getString();
                            System.out.println("File Name" + privatekey);
                        
                        }
                          
                            if (fileItem.getFieldName().equals("policy")) {
                            policy = fileItem.getString();
                            System.out.println("File Name" + policy);
                        
                        }
                            
                              if (fileItem.getFieldName().equals("role")) {
                            role = fileItem.getString();
                            System.out.println("File Name" + role);
                        
                        }
                              
                                if (fileItem.getFieldName().equals("exp")) {
                            exp = fileItem.getString();
                            System.out.println("File Name" + exp);
                        
                        }
                                
                                  if (fileItem.getFieldName().equals("department")) {
                            department = fileItem.getString();
                            System.out.println("File Name" + department);
                        
                        }
                                  
                                  
                                       if (fileItem.getFieldName().equals("securitylevel")) {
                            securitylevel = fileItem.getString();
                            System.out.println("File Name" + securitylevel);
                        
                        }
                        
                       
                        if (fileItem.getFieldName().equals("filename")) {
                            filename = fileItem.getString();
                            System.out.println("File Name" + filename);
                        
                        }
                        if (fileItem.getFieldName().equals("owner")) {
                            owner = fileItem.getString();
                            System.out.println("File Keyword" + owner);
                        
                        }
                        if(fileItem.getFieldName().equals("modify")) {
                            str = getStringFromInputStream(fileItem.getInputStream());
                            System.out.println("datazzzzzzzzzzzzzzzzzzzzzzzzzzzzzz" + str);
                        }
                        
                    }
                      
                            try {
                                con = Dbconnection.getConnection();
                                pstm = con.prepareStatement("insert into upload (filename, data, owner,privatekey,skey)values(?,?,?,?,?)");
                               pstm1 = con.prepareStatement("insert into cloudadata (filename,newfilename,  owner,privatekey,dkey)values(?,?,?,?,?)");
                               pstm2 = con.prepareStatement("insert into cloudbdata (filename,newfilename,  owner,privatekey,dkey)values(?,?,?,?,?)");
                               // String str = getStringFromInputStream(fileItem.getInputStream());
                                //secretkey generating
                         //  KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                              //  keyGen.init(128);
                             //  SecretKey secretKey = keyGen.generateKey();
                             //   System.out.println("secret key:" + secretKey);
                               //converting secretkey to String
                                //byte[] be = secretKey.getEncoded();//encoding secretkey
                             //  String skey = Base64.encode(be);
                             //   System.out.println("converted secretkey to string:" + skey);
                                
                                byte[] bs = Base64.decode(privatekey);
                               SecretKey sec = new SecretKeySpec(bs, "AES");
                                
                                String cipher = new StringXORer().encode(str,privatekey);
                                
                             // String cipher = new encryption().encrypt(str, sec);
                                System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+str);
                                
                                //for get extension from given file
                                //String b = fileItem.getName().substring(fileItem.getName().lastIndexOf('.'));
                                //System.out.println("File Extension" + b);
                                String skey1="7895";
                             pstm.setString(1, filename);
                               // pstm.setString(4, date);
                               // pstm.setDate(4, getCurrentDate());
                                
                                pstm.setString(2, cipher);
                               // pstm.setString(6, name);
                                 pstm.setString(3, owner);
                                  pstm.setString(4, privatekey);
                                   pstm.setString(5, skey1);
                                  
                                /*Cloud Start*/
                           File f = new File("C:\\Users\\admin\\Desktop\\upoladfiles\\"+filename);
                          FileWriter fw = new FileWriter(f);
                        fw.write(cipher);
                             fw.close();
                         
                             Ftpcon ftpcon = new Ftpcon();
                             File inputFile = new File("C:\\Users\\admin\\Desktop\\upoladfiles\\"+filename);   
                             FileInputStream inputStream;
                             Random r = new Random();
		String newFileName;
		FileOutputStream filePart;
		int fileSize = (int) inputFile.length();
		int nChunks = 0, read = 0, readLength = fileSize/2;
		byte[] byteChunkPart;
                             inputStream = new FileInputStream(inputFile);
			while (fileSize > 0) {
				if (fileSize <= 2) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
                                
				newFileName = filename + ".part"
						+ Integer.toString(nChunks - 1);
                                
                                 File inputFile1 = new File("C:\\Users\\admin\\Desktop\\down\\"+newFileName);   
				filePart = new FileOutputStream(inputFile1);
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
                                 
                                if (nChunks==1){
                                     
                                    int i = r.nextInt(10000 - 5000) + 5000;
                                    String dkey = i+"";
                                     pstm1.setString(1, filename);
                                     pstm1.setString(2, newFileName);
                                     pstm1.setString(3, owner);
                                     pstm1.setString(4, privatekey);
                                     pstm1.setString(5, dkey);
                                     pstm1.execute();
                                ftpcon.upload(inputFile1, newFileName);
                                }
                                else if(nChunks==2){
                                    
                                    int i = r.nextInt(10000 - 4000) + 5000;
                                    String dkey = i+"";
                                     pstm2.setString(1, filename);
                                     pstm2.setString(2, newFileName);
                                     pstm2.setString(3, owner);
                                     pstm2.setString(4, privatekey);
                                     pstm2.setString(5, dkey);
                                     pstm2.execute();
                                 ftpcon.upload1(inputFile1, newFileName);
                                }
			}
			inputStream.close();
                      
                                
                                int i = pstm.executeUpdate();
                                if (i == 1) {
                                    response.sendRedirect("upload.jsp?msg=success");
                                } else {
                                    response.sendRedirect("upload.jsp?m1=failed");
                                }
                                con.close();
                            } catch (Exception e) {
                                out.println(e.toString());
                            }
                      
                    
                } catch (FileUploadException e) {
                } catch (Exception ex) {
                    Logger.getLogger(encrypt1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } finally {
                out.close();
            }
        }


    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
