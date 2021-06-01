package com.mamakancha.irctc.dao;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.*;
import java.util.List;


public class CSVReaderUtility {

    public static <T> List<T> getAllObjects(String filePath, Class<T> type){
        try {
            CsvToBeanBuilder<T> beanBuilder =
                    new CsvToBeanBuilder<>(new InputStreamReader(new FileInputStream(filePath)));

            beanBuilder.withType(type);

            // build methods returns a list of Beans
            return beanBuilder.build().parse();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getMaxValueFromCSV(int columnIndex, String filePath) throws IOException {
        String[] nextRecord;
        CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build();
        //CSVReader reader = new CSVReader(new FileReader(filePath));
        int maxValue = 0;
        while ((nextRecord = reader.readNext()) != null) {
            int currentValue = Integer.parseInt(nextRecord[columnIndex]);
            if(currentValue> maxValue) {
                maxValue = currentValue;
            }
        }
        return maxValue;
    }
}
