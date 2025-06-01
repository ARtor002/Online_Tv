package ir.ARtor.onlinetv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.ARtor.onlinetv.R;
import ir.ARtor.onlinetv.adapter.Category_adapter;
import ir.ARtor.onlinetv.app.app;
import ir.ARtor.onlinetv.models.Category_model;
import ir.ARtor.onlinetv.retrofit.Retrofit_client;
import ir.ARtor.onlinetv.retrofit.Retrofit_interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tv_fragment extends Fragment {
    Retrofit_interface retrofitInterface;

    RecyclerView recyclerView;
    List<Category_model> list;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        retrofitInterface = Retrofit_client.getRetrofit(app.BASEURL).create(Retrofit_interface.class);
        getData();
        recyclerView = view.findViewById(R.id.recyclerview_cat);
        recyclerView.setAdapter(new Category_adapter(list,getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setHasFixedSize(true);
        return view;
    }

    private void getData(){
        list = new ArrayList<>();
        retrofitInterface.GetCategory("tv").enqueue(new Callback<List<Category_model>>() {
            @Override
            public void onResponse(Call<List<Category_model>> call, Response<List<Category_model>> response) {
                list.addAll(response.body());

            }

            @Override
            public void onFailure(Call<List<Category_model>> call, Throwable t) {
                app.toast(getString(R.string.failed_load));
            }
        });
    }
}
