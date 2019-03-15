package com.finapp.gramfin.finapp.feature.second_screen.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;

public class SecondScreenHolder extends RecyclerView.ViewHolder {
    private View root;
    private TextView nameChapter;
    private TextView numberOfQuetions;
    private TextView textIknow;
    private TextView textIdontKnow;
    private ModelChapter modelChapter;
    private int id;
    SecondScreenAdapter.Listener listener;

    private SecondScreenHolder(@NonNull View itemView) {
        super(itemView);
        nameChapter = itemView.findViewById(R.id.chapter_name);
        numberOfQuetions = itemView.findViewById(R.id.number_of_questions);
        textIknow = itemView.findViewById(R.id.i_know);
        textIdontKnow = itemView.findViewById(R.id.i_dont_know);

        root = itemView;
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onFeedClick(id);
                }
            }
        });

    }

    void bind(ModelChapter modelChapter, SecondScreenAdapter.Listener listener, int id) {
        this.listener = listener;
        this.modelChapter = modelChapter;
        this.id = id;
        nameChapter.setText(modelChapter.getChapter());
        numberOfQuetions.setText("Всего вопросов - " + modelChapter.getNumberOfQuetions());
        textIknow.setText("Я знаю - " + modelChapter.getItemIKnow());
        textIdontKnow.setText("Я не знаю - " + modelChapter.getItemIdontKnow());

    }

    static SecondScreenHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new SecondScreenHolder(inflater.inflate(R.layout.item_second_screen, parent, false));
    }
}
