/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions;

import de.juehvtech.easi.actions.wol.WakeOnLanRunner;
import de.juehvtech.easi.container.Host;
import java.util.EventListener;

/**
 *
 * @author Jens
 */
public class ActionLauncher {

    public static void LaunchAction(Action action, Host host, EventListener listener) {
        Thread runner = null;
        switch (action) {
            case PING:
                runner = new Thread(new PingRunner(host, listener));
                break;
            case WOL:
                runner = new Thread(new WakeOnLanRunner(host));
                break;
            case SHUTDOWN:
                runner = new Thread(new ShutdownRunner(host));
                break;
            case RDP:
                runner = new Thread(new RemoteRunner(host));
                break;
        }
        if (runner != null) {
            runner.start();
        }
    }
}
