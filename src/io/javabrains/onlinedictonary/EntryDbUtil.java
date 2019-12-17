package io.javabrains.onlinedictonary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class EntryDbUtil {

    static Entry getData(String searchText) throws SQLException, ClassNotFoundException {

        Connection con = DatabaseConnection.initializeDatabase();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from entries where word='" + searchText + "'");

        List<String> wordTypeList = new ArrayList<>();
        List<String> definitionList = new ArrayList<>();
        Entry entry = null;

//        if(rs==null||rs.getFetchSize()==0){
//            wordTypeList.add("NULL");
//            definitionList.add("NULL");
//            entry = new Entry("NULL", wordTypeList, definitionList);
//        }
        boolean firstTime = true;
        while (rs.next()) {
            String word = rs.getString("word");
            String wordType = rs.getString("wordtype");
            String definition = rs.getString("definition");

            if (firstTime) {
                wordTypeList.add(wordType);
                definitionList.add(definition);
                entry = new Entry(word, wordTypeList, definitionList);
                firstTime = false;
            } else {
                entry.getDefinitionList().add(definition);
                entry.getWordTypeList().add(wordType);
            }

        }
        if (rs != null) {
            rs.close();
        }
        if (con != null) {
            con.close();
        }
        return entry;
    }
}
