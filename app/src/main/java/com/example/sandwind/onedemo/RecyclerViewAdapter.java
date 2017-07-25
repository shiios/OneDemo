package com.example.sandwind.onedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sandwind on 2017/7/25.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    //    定义一个继承自RecyclerView.ViewHolder的一个内部类
    static class ViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        //    在ViewHolder的构造函数中传入一个view参数
        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);

        }
    }

    public RecyclerViewAdapter(List<Fruit> fruitList) {

        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        //下面添加final：java关键字，意思是不允许改变的
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "you clicked view" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"you click image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });


        return holder;
    }

    //重写下述方法的目的：对RecycleView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行，此处我们根据position参数得到当前项的Fruit实例，然后再将数据设置到viewholder对应的imageview和textview中
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    //计算recycleview的子项
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
