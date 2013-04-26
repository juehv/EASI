/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions;

import de.juehvtech.easi.container.Host;
import de.juehvtech.easi.properties.Options;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
            
        Files.copy(RemoteRunner.class
                .getResourceAsStream("/de/juehvtech/easi/scripts/windows/win7/remote.bat"), 
                Paths.get(Options.RDP_SCRIPT_PATH),
                StandardCopyOption.REPLACE_EXISTING);
            Process exec = Runtime.getRuntime().exec(Options.RDP_SCRIPT_PATH + " "+host.getIpAddress());
            
        } catch (IOException ex) {
            Logger.getLogger(RemoteRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
