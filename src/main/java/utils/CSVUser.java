package utils;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUser {

    private static final String USER_CSV = System.getProperty("user.dir") + "/data/TestData.csv";

    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "value")
    private String value;

    public CSVUser getAPI(){
        CSVUser csvUser = new CSVUser();
        List<CSVUser> userList = csvUser.getUserList();
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getType().equalsIgnoreCase("LoginPayload")) {
                return userList.get(i);
            }
        }
        return null;
    }

    public String getType() {
        return id;
    }

    public List<CSVUser> getUserList() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(USER_CSV));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
