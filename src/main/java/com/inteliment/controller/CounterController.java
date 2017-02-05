package com.inteliment.controller;

import com.inteliment.bean.RequestSearchText;
import com.inteliment.service.TextDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by marklin on 5/02/17.
 */
@Controller
@RequestMapping("/counter-api")
public class CounterController {
    @Autowired
    TextDataService textDataService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> getCount(@RequestBody RequestSearchText requestSearchText) {
//        requestSearchText.getSearchText().stream()
//                .forEach(s -> System.out.println(s.toString()));

        return textDataService.getCountMap(requestSearchText);
    }

    @RequestMapping(value = "/top/{topCount}", method = RequestMethod.GET)
    @ResponseBody
    public String getTopInCSV(@PathVariable(value = "topCount") int topCount) {
        System.out.println("topCount: " + topCount);
        Map<String, Integer> map = textDataService.getTopCountMap(topCount);

        String out = "";
        for (String key : map.keySet()) {
//            System.out.println("key: " + key + " value: " + map.get(key));
            out += key + "\t" + map.get(key) + "\n";
        }
        return out;
    }

}
