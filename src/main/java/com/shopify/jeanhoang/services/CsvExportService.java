package com.shopify.jeanhoang.services;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import com.shopify.jeanhoang.beans.Item;
import com.shopify.jeanhoang.repository.ItemRepository;

@Service
public class CsvExportService {

    private static final Logger log = Logger.getLogger(CsvExportService.class);

    private final ItemRepository itemRepo;

    public CsvExportService(ItemRepository itemRepo) {
    	
        this.itemRepo = itemRepo;
        
    }

    public void writeEmployeesToCsv(Writer writer) {

        List<Item> items = itemRepo.findAll();
        
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
        	
            for (Item i : items) {
                csvPrinter.printRecord(i.getId(), i.getName());
            }
            
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}


