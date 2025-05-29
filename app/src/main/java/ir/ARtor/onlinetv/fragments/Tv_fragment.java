package ir.ARtor.onlinetv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.ARtor.onlinetv.R;
import ir.ARtor.onlinetv.models.Category_model;

public class Tv_fragment extends Fragment {

    RecyclerView recyclerView;
    List<Category_model> list;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_cat);

        


        return view;
    }
}
