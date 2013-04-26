/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.properties;

/**
 *
 * @author Jens
 */
public final class Options {
    private Options(){}
    
    public static String RDP_SCRIPT_PATH=System.getProperty("java.io.tmpdir")+
            "remote.bat";
    public static String DATABASE_FILE_PATH = "./hosts.db";
    public static int SCAN_PING_DELAY = 2000;
    public static int HOST_PING_DELAY = 2000;
    public static int AUTO_PING_SEQUENCE=60000;
    public static byte SCAN_WORKER_RANGE = 5;
}
