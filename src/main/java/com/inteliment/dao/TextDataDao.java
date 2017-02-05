package com.inteliment.dao;

import com.inteliment.bean.TextData;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by marklin on 5/02/17.
 * DAO Layer to abstract the data. It could be data stored in DB in future implementation
 * TODO May use Hibernate and make use of the 1st/2nd level cache. Or Singleton to hold the static TextData object
 */
@Service
public class TextDataDao {
    private String retrieve() {
        return TextData.data;
    }

    private String[] words() {
        return retrieve().split("\\W+");
    }

    public Map<String, Integer> aggregatedData() {
        String[] list = words();

        Map<String, Integer> result = new LinkedHashMap();
        for (String thisS : list) {
            String s = thisS.toUpperCase();
            if (result.get(s) == null) {
                result.put(s, 1);
            } else {
                result.put(s, result.get(s) + 1);
            }
        }
        return result;
    }
}
