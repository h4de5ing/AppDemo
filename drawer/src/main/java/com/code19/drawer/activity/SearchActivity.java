package com.code19.drawer.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.inputmethod.InputMethodManager;

import com.code19.drawer.R;

import java.util.Collections;
import java.util.List;

/**
 * https://github.com/naman14/Timber/blob/5937bb390d334dce334df458ba4db1d1ae2cc1f2/app/src/main/java/com/naman14/timber/activities/SearchActivity.java
 */
public class SearchActivity extends BaseActivity {
    private SearchView mSearchView;
    private InputMethodManager mImm;
    private String queryString;

    //private SearchAdapter adapter;
    private RecyclerView recyclerView;

    private List searchResults = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
