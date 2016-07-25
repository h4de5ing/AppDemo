package com.code19.drawer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.code19.drawer.R;
import com.code19.drawer.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gh0st on 2016/7/11.
 * 23:46
 */
public class BlogFragment extends Fragment {
    private List<String> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, null);
        mList = new ArrayList<String>();
        ListView bloglistview = (ListView) view.findViewById(R.id.blog_listview);
        final BlogAdapter adapter = new BlogAdapter(getActivity(), R.layout.item_blog);
        try {
            String[] blogs = getResources().getAssets().list("blog");
            for (String str : blogs) {
                if (str.contains(".html") || str.contains(".htm")) {
                    adapter.add(str);
                    mList.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bloglistview.setAdapter(adapter);
        bloglistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utils.openAssetsDoc(getActivity(), mList.get(i));
            }
        });
        return view;
    }

    private class BlogAdapter extends ArrayAdapter<String> {
        private int mResourceId;

        public BlogAdapter(Context context, int resource) {
            super(context, resource);
            mResourceId = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(mResourceId, null);
            TextView tv_name = (TextView) view.findViewById(R.id.name);
            String s = getItem(position);
            tv_name.setText(s.substring(0, s.lastIndexOf(".")));
            return view;
        }
    }
}
