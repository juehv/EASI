/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions;

import de.juehvtech.easi.container.Host;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class RemoteRunner implements Runnable {

    private static final Logger LOG = Logger.getLogger(RemoteRunner.class.getName());
    //private sta
    private Host host;

    public RemoteRunner(Host host) {
        this.host = host;
    }

    @Override
    public void run() {
        try {
            Process exec = Runtime.getRuntime().exec(getClass()
                    .getResource("/de/juehvtech/easi/scripts/windows/win7/remote.bat")
                    .getPath() + " "+host.getIpAddress());
        } catch (IOException ex) {
            Logger.getLogger(RemoteRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
