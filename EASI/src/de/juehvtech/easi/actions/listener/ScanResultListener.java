/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.actions.listener;

import de.juehvtech.easi.actions.networkscan.ScanResult;
import java.util.EventListener;

/**
 *
 * @author Jens
 */
public interface ScanResultListener extends EventListener {
    void updateResult(ScanResult result);
}
