/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.juehvtech.easi.database;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import de.juehvtech.easi.container.Host;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class DatabaseDAO {

    private String filepath;

    public DatabaseDAO(String filepath) {
        this.filepath = filepath;
    }

    public static String getTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss ");
        Date currentTime = new Date();
        return formatter.format(currentTime);
    }

    public boolean createEmptyHostFile() {
        try {
            CsvWriter writer = new CsvWriter(filepath);
            writer.writeComment("Auto created hostfile " + DatabaseDAO.getTimeStamp());
            writer.writeRecord(new String[]{"Name", "IP", "Mac", "Description"});
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Host> loadHosts() {
        File csvFile = new File(filepath);
        if (!csvFile.exists()) {
            // try to create db file
            createEmptyHostFile();
            return null;
        }
        List<Host> hosts = new ArrayList<>();
        try {
            CsvReader reader = new CsvReader(filepath);
            reader.setUseComments(true);//ignore comments
            reader.readHeaders();
            while (reader.readRecord()) {
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
