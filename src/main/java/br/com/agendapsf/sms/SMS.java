/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorenoleal
 */
package br.com.agendapsf.sms;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;




public class SMS {

    public void enviar(String mensagem, String numero) {

        try {
            String credential = URLEncoder.encode("6598AF17882FE4B8EAA317C532BF390B6AAA320F", "UTF-8");
            String token = URLEncoder.encode("144D65", "UTF-8");
            String mainUser = URLEncoder.encode("Leal", "UTF-8"); //projeto principal
            String auxUser = URLEncoder.encode("Leal", "UTF-8"); //...secundário
            
            //* Numero do telefone  FORMATO: PAÍS+DDD(DOIS DÍGITOS)+NÚMERO
            String mobile = URLEncoder.encode("55" + numero, "UTF-8"); 
            //* S = Envia o SenderId antes da mensagem , N = Não envia o SenderId
            String sendProject = URLEncoder.encode("S", "UTF-8"); 
            String msg = mensagem;
            msg = URLEncoder.encode(msg, "UTF-8");
            
            String connection
                    = "https://www.mpgateway.com/v_3_00/sms/smspush/enviasms.aspx?CREDENCIAL="
                    + credential + "&TOKEN=" + token + "&PRINCIPAL_USER=" + mainUser + "&AUX_USER=" + auxUser + "&MOBILE=" + mobile
                    + "&SEND_PROJECT=" + sendProject + "&MESSAGE=" + msg;

            URL url = new URL(connection);
            InputStream input = url.openStream();
            byte[] b = new byte[4];

            input.read(b, 0, b.length);
            String RetornoMPG = new String(b);
      
            JOptionPane.showMessageDialog(null, "Ok: " + RetornoMPG);
           

        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
     
    }
}
