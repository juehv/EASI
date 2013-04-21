/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.networkscan;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jens
 */
public class ScanResult {

    private static ScanResult INSTANCE = null;
    private Map<Short, Boolean> availableList = new HashMap<>();
    private String baseIp="";

    private ScanResult() {
    }

    public static synchronized ScanResult getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScanResult();
        }
        return INSTANCE;
    }

    public static synchronized void resetInstance() {
        INSTANCE = null;
    }
    
    public void addStatus(short ip, boolean result){
        availableList.put(ip,result);
    }

    public Map<Short, Boolean> getAvailableList() {
        return availableList;
    }

    public String getBaseIp() {
        return baseIp;
    }

    public void setBaseIp(String baseIp) {
        this.baseIp = baseIp;
    }
    
    
}
