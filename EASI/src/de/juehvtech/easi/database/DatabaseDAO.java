/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.database;

import com.csvreader.CsvReader;
import de.juehvtech.easi.container.Host;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class DatabaseDAO {
    private String filepath;
    
    public DatabaseDAO(String filepath){
        this.filepath=filepath;
    }
    
    public List<Host> loadHosts(){
        File csvFile = new File(filepath);
        if (!csvFile.exists()){
            return null;
        }
        List<Host> hosts = new ArrayList<>();
        try {
            CsvReader reader = new CsvReader(filepath);
             reader.readHeaders();
            while (reader.readRecord()){
                String[] line = reader.getValues();
                hosts.add(Host.fromCsvLine(line));
            }
        } catch (IOException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        return hosts;
    }
}
