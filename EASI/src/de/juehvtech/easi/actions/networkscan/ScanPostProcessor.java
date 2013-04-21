/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.networkscan;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class ScanPostProcessor {

    public static String requestHostname(String ip) {
        try {
            InetAddress host = InetAddress.getByName(ip);
            return host.getCanonicalHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ScanPostProcessor.class.getName()).log(Level.SEVERE, null, ex);
            return ip;
        }
    }

    public static String requestMac(String ip) {
        try {
            InetAddress mac = InetAddress.getByName(ip);
            /*
             * Get NetworkInterfaces for the current host and then read the
             * hardware addresses.
             */
            byte[] address =NetworkInterface.getByInetAddress(mac).getHardwareAddress();
            String ad = "";
            for (byte b :address){
                ad+=String.format("%02X", b)+"-";
            }
            System.out.println(ad);
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "";
    }
}
