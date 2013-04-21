/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.listener;

import de.juehvtech.easi.container.Host;
import java.util.EventListener;

/**
 *
 * @author Jens
 */
public interface PingResultListener extends EventListener{

    void updatePingResult(Host host);
}
