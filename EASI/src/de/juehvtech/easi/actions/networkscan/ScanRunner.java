/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.networkscan;

import de.juehvtech.easi.actions.networkscan.ScanResult;
import de.juehvtech.easi.properties.Options;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class ScanRunner implements Runnable{
    
    private static final Logger LOG = Logger.getLogger(ScanRunner.class.getName());
    private String baseIp;
    private short startIp;
    private short endIp;

    public ScanRunner(String baseIp, short startIp, short endIp) {
        this.baseIp = baseIp;
        this.startIp = startIp;
        this.endIp = endIp;
    }

    @Override
    public void run() {
        ScanResult results = ScanResult.getInstance();
        short aktIp = startIp;
        while (aktIp <=endIp){
            try {
                InetAddress host = InetAddress.getByName(baseIp+"."+aktIp);
                LOG.log(Level.INFO, "Ping to {0}", host.getHostAddress());
                boolean result = host.isReachable(Options.SCAN_PING_DELAY);
                LOG.log(Level.INFO, "Ping Result from {0} was {1}", 
                        new Object[]{host.getHostAddress(), result});
                results.addStatus(aktIp,result);
            } catch (IOException ex) {
                Logger.getLogger(ScanRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
            aktIp++;
        }
    }
    
}
