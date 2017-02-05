package com.inteliment.service;

import com.inteliment.bean.RequestSearchText;
import com.inteliment.dao.TextDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by marklin on 5/02/17.
 */
@Service
public class TextDataService extends AbstractBase {

    @Autowired
    TextDataDao textDataDao;

    public Map<String, Integer> getCountMap(RequestSearchText rst) {

        Map<String, Integer> rawMap = textDataDao.aggregatedData();

        Map<String, Integer> result = new LinkedHashMap();
        for (String key : rst.getSearchText()) {
            if (rawMap.get(key.toUpperCase()) == null) {
                result.put(key, 0);
            } else {
                result.put(key, rawMap.get(key.toUpperCase()));
            }
        }
        return result;
    }

    public Map<String, Integer> getTopCountMap(int topCount) {
        Map<String, Integer> rawMap = textDataDao.aggregatedData();
        Map<String, Integer> sorted =
                rawMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topCount)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (u, v) -> {
                                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                                },
                                LinkedHashMap::new));
        return sorted;
    }

}
