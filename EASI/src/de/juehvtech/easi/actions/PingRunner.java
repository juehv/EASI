/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions;

import de.juehvtech.easi.actions.listener.PingResultListener;
import de.juehvtech.easi.container.Host;
import de.juehvtech.easi.properties.Options;
import java.io.IOException;
import java.net.InetAddress;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class PingRunner implements Runnable {

    private static final Logger LOG = Logger.getLogger(PingRunner.class.getName());
    private Host host;
    private PingResultListener listener;

    public PingRunner(Host host, EventListener listener) {
        this.host = host;
        this.listener = (PingResultListener) listener;
    }

    @Override
    public void run() {
        InetAddress hostAdress;
        boolean result = false;
        try {
            hostAdress = InetAddress.getByName(host.getName());
            result = hostAdress.isReachable(Options.HOST_PING_DELAY);
            if (!host.getIpAddress().equals(hostAdress.getHostAddress())){
                host.setIpAddress(hostAdress.getHostAddress());
            }
        } catch (IOException ex) {
            // maybe wrong hostname
            StringBuilder msg = new StringBuilder();
            msg.append("Error while ping host (hostname wrong?):")
                    .append(host.getName());
            LOG.log(Level.WARNING, msg.toString(), ex);
        }
        try {
            if (!result) {
                hostAdress = InetAddress.getByName(host.getIpAddress());
                result = hostAdress.isReachable(Options.HOST_PING_DELAY);
                if (result) {
                    host.setName(hostAdress.getCanonicalHostName());
                }
            }
        } catch (IOException ex) {
            StringBuilder msg = new StringBuilder();
            msg.append("Error while ping host:").append(host.getIpAddress());
            LOG.log(Level.SEVERE, msg.toString(), ex);
        }
        host.setActive(result);
        listener.updatePingResult(host);
    }
}
