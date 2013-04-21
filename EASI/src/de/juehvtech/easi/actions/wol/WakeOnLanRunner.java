/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.wol;

import de.juehvtech.easi.actions.wol.JWOL;
import de.juehvtech.easi.container.Host;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class WakeOnLanRunner implements Runnable {
    private static final Logger LOG = Logger.getLogger(WakeOnLanRunner.class.getName());
    private Host host;
    
    public WakeOnLanRunner(Host host){
        this.host = host;
    }

    @Override
    public void run() {
        try {
            JWOL wol = new JWOL();
            wol.wol(host.getMac());
        } catch (IOException | IllegalArgumentException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("Error while sendig Magic Packet to host: ").append(host.getMac());
            LOG.log(Level.SEVERE, msg.toString(), ex);
        }
    }
    
}
