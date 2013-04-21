/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.networkscan;

import de.juehvtech.easi.actions.listener.ScanResultListener;
import de.juehvtech.easi.properties.Options;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class ScanManager implements Runnable{

    private String baseIp;
    private ScanResultListener listener;
    private List<Thread> threadList = new ArrayList<>();
    
    public ScanManager(String baseIp, ScanResultListener listener){
        this.baseIp = baseIp;
        this.listener = listener;
    }
    
    @Override
    public void run() {
        ScanResult.resetInstance();
        ScanResult.getInstance().setBaseIp(baseIp);
        for (short i = 1; i<255; i+=Options.SCAN_WORKER_RANGE){
            int endIp = (i+Options.SCAN_WORKER_RANGE-1);
            if (endIp >=255){
                endIp = 254;
            }
            Thread thread = new Thread(new ScanRunner(baseIp, i, (short)endIp ));
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread :threadList){
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ScanManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        listener.updateResult(ScanResult.getInstance());
    }
    
}
