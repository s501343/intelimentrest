package com.inteliment.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marklin on 5/02/17.
 */
public class RequestSearchText {
    public List<String> getSearchText() {
        return searchText;
    }

    public void setSearchText(List<String> searchText) {
        this.searchText = searchText;
    }

    private List<String> searchText = new ArrayList<>();

    public void add(String s) {
        searchText.add(s);
    }

}
