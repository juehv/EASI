/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions;

import de.juehvtech.easi.container.Host;

/**
 *
 * @author Jens
 */
public class ShutdownRunner implements Runnable {
    
    public ShutdownRunner(Host host){
        
    }

    @Override
    public void run() {
        //TODO add app on client for shutting down pc (RMI ?)
        // execution server
        // führt script aus parst ergebnisse und schickt sie an
        // den server.
        // auf diese weise können auch prozesse oder andere
        // laufzeitereignisse beobachtet werden
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
