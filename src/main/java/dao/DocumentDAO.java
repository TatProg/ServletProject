package dao;

import java.io.*;
import java.sql.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class DocumentDAO {
    public void saveDocument(StringBuilder data) {
        //enter here your db table
        String sqlString = "INSERT INTO text (id, text) VALUES(?, ?)";
        String mainString = null;
        String secString = null;

        try {
            Connection connection = ConnectionDB.getDBConnection();

            String nameString = data.toString().replaceAll("\\.", "|");
            //trying to find .doc
            if (nameString.split("\\|")[1].equals("doc")){
                FileInputStream fis = new FileInputStream(nameString);
                HWPFDocument document = new HWPFDocument(fis);
                WordExtractor extractor = new WordExtractor(document);
                String[] fileData = extractor.getParagraphText();
                for (int i = 0; i < fileData.length; i++) {
                    if (fileData[i] != null)
                        mainString+= fileData[i] +" ";
                }
            } else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameString)));
                while ((secString = bufferedReader.readLine()) != null) {
                    mainString += secString + " ";
                }
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, mainString);
            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
