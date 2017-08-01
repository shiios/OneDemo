package com.example.sandwind.onedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sandwind on 2017/8/1.
 */

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_title_fragment, container, false);

        RecyclerView newsTitleRecycleView = (RecyclerView)view.findViewById(R.id.news_title_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecycleView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecycleView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for (int i = 0;i <= 50;i++){
             News news = new News();
            news.setTitle("This is a title" + i);
            news.setContent(getRandomLengthContent("This is news content" + i + "."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int length = random.nextInt(30) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= length;i++){
            stringBuilder.append(content);

        }
        return stringBuilder.toString();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity().findViewById(R.id.news_content_fragment) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;

            public ViewHolder(View view) {

                super(view);

                newsTitleText = (TextView) view.findViewById(R.id.news_title);

            }
        }


        public NewsAdapter(List<News> newsList) {

            mNewsList = newsList;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(holder.getAdapterPosition());

                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                }
            });


            return holder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());

        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }


}
