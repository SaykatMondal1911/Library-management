package com.example.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class homeFragment extends Fragment {

    private ListView listView;
    private AutoCompleteTextView autoCompleteTextView;

    List<String> listDataHeader;
    HashMap<String,List<String >> listDataChild;

//--------------------------------------------------------------Unknown-------------------------

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


//--------------------------------------------------------------Unknown------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        listView = (ListView) view.findViewById(R.id.listViewId);
        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewId);

        String[] bookNames = getResources().getStringArray(R.array.book_names);
        String[] bookDescriptions = getResources().getStringArray(R.array.book_descriptions);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i=0;i<bookNames.length;i++){

            listDataHeader.add(bookNames[i]);
            List<String> child = new ArrayList<>();
            child.add(bookDescriptions[i]);

            listDataChild.put(listDataHeader.get(i),child);
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),R.layout.sample_view,R.id.textViewId,bookNames);
        ArrayAdapter adapterAutoCompleteTextView = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,bookNames);


        listView.setAdapter(adapter);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapterAutoCompleteTextView);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String bookName = bookNames[i];

                Intent intent = new Intent(getActivity(),detailsBook.class);
                intent.putExtra("tag",bookName);
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String bookName = bookNames[i];

                Intent intent = new Intent(getActivity(),detailsBook.class);
                intent.putExtra("tag",bookName);
                startActivity(intent);

            }
        });

        return view;

    }

}