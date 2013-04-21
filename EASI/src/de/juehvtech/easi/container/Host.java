/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.container;


/**
 *
 * @author Jens
 */
public class Host {

    private String ipAddress;
    private String name;
    private String mac;
    private boolean active =false;

    public Host(String name, String ipAddress, String mac, boolean active) {
        this(name,ipAddress,mac);
        this.active = active;
    }
    
    public Host(String name, String ipAddress, String mac) {
        this.ipAddress = ipAddress;
        this.name = name;
        this.mac = mac;
    }

    public Host() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public static Host fromCsvLine(String[] line) {
        if (line.length >= 3) {
            return new Host(line[0], line[1], line[2]);
        } else {
            return new Host();
        }
    }
}
