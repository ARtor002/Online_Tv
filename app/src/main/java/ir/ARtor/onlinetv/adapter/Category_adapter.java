package ir.ARtor.onlinetv.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import ir.ARtor.onlinetv.R;
import ir.ARtor.onlinetv.models.Category_model;

public class Category_adapter extends RecyclerView.Adapter<Category_adapter.MyViewHolder> {

    List<Category_model> list;
    Context context;

    public Category_adapter(List<Category_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category_model cModel = list.get(position);
        Glide.with(context).load(cModel.getImg_add()).into(holder.imageView);
//        list.get(position).setImg_add();
        holder.textView.setText(cModel.getName_en());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item);
            imageView = itemView.findViewById(R.id.imageView_item);
            textView = itemView.findViewById(R.id.textView_item);

        }
    }
}
