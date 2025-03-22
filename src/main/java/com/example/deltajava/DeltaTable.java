package com.example.deltajava;

import com.example.deltajava.util.ParquetUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a Delta table which is a directory containing data files and transaction logs.
 * This implementation provides a simplified version of the Delta Lake protocol.
 */
public class DeltaTable {
    
    private final String tablePath;

    /**
     * Creates a new Delta table at the specified path.
     *
     * @param tablePath the path where the table will be stored
     * @throws IOException if an I/O error occurs
     */
    public DeltaTable(String tablePath) throws IOException {
        this.tablePath = tablePath;

        // Create directories if they don't exist
        Path path = Paths.get(tablePath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        
        Path dataPath = Paths.get(tablePath, "data");
        if (!Files.exists(dataPath)) {
            Files.createDirectories(dataPath);
        }

    }
    
    /**
     * Initializes a new Delta table with protocol and metadata.
     *
     * @throws IOException if an I/O error occurs
     */
    private void initialize() throws IOException {
        // Start a transaction

    }
    
    /**
     * Inserts records into the Delta table. Each record is a map of column names to values.
     *
     * @param records the records to insert
     * @return the number of records inserted
     * @throws IOException if an I/O error occurs
     */
    public int insert(List<Map<String, String>> records) throws IOException {
        if (records == null || records.isEmpty()) {
            return 0;
        }
       // Generate a unique file name
        String fileId = UUID.randomUUID().toString();
        long timestamp = Instant.now().toEpochMilli();
        String fileName = String.format("part-%s.parquet", fileId);
        
        // Create the full path to the data file
        Path dataFilePath = Paths.get(tablePath, "data", fileName);
        
        // Write the records to a Parquet file
        long fileSize = ParquetUtil.writeRecords(records, dataFilePath);
        

        return records.size();
    }
    
    /**
     * Reads all records from the Delta table.
     *
     * @return a list of records, where each record is a map of column names to values
     * @throws IOException if an I/O error occurs
     */
    public List<Map<String, String>> readAll() throws IOException {
        List<Map<String, String>> allRecords = new ArrayList<>();
        
        // Get the latest snapshot
        //TODO:READ ALL the files.
        
        return allRecords;
    }
} 