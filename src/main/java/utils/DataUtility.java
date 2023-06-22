package utils;

import java.io.File;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtility {
//    static String env = System.getProperty("env").length() > 0 ? System.getProperty("env") : "stage";
//    static String dataFile = env.equalsIgnoreCase("prod") ? "TestDataProd.xlsx" : "TestDataStag.xlsx";
//    static String dataFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
//            + dataFile;
    static String dataFilePath = System.getProperty("user.dir") + File.separator + "data" + File.separator
            + "TestData.xlsx";

    public static String getDataFromExcel(String sheetName, String ID) {
        String result = "";
        Connection connection;
        try {
            Fillo fillo = new Fillo();
            connection = (Connection) fillo.getConnection(dataFilePath);
            String strQuery = "Select * from " + sheetName + " where ID='" + ID + "'";
            Recordset recordset = ((com.codoid.products.fillo.Connection) connection).executeQuery(strQuery);
            while (recordset.next()) {
                result = recordset.getField("Value");
            }
            recordset.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }
}
