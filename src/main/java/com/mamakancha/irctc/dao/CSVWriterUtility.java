package com.mamakancha.irctc.dao;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CSVWriterUtility {

    public static <T> void appendToCSV(String filePath, String[] record) throws IOException{

        FileWriter writer = new FileWriter(filePath, true);
        //writer.append("\n");
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(record);
        csvWriter.close();

//        ColumnPositionMappingStrategy mappingStrategy= new ColumnPositionMappingStrategy();
//
//        String[] columns = new String[]
//                { "bookingID", "bookingDate", "totalPrice", "trainJourneyID", "userID" };
//
//        mappingStrategy.setColumnMapping(columns);
//
//        StatefulBeanToCsvBuilder<T> builder= new StatefulBeanToCsvBuilder(writer);
//        StatefulBeanToCsv beanWriter =
//                builder.withMappingStrategy(mappingStrategy).build();
//
//        beanWriter.write(objectList);
//        writer.close();

//        mappingStrategy.setType(Employee.class);
//        CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));
//        for(String[] record : records){
//            writer.writeNext(record);
//        }
//        writer.close();

    }
}
