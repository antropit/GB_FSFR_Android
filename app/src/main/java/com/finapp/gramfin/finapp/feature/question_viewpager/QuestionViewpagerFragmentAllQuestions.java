package com.finapp.gramfin.finapp.feature.question_viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.feature.question_viewpager.presenter.IQuestionViewpager;
import com.finapp.gramfin.finapp.feature.question_viewpager.presenter.PresenterQuestionViewpager;
import com.finapp.gramfin.finapp.feature.question_viewpager.presenter.PresenterQuestionViewpagerAllQuestions;

import java.util.List;

public class QuestionViewpagerFragmentAllQuestions extends Fragment implements IQuestionViewpager, QuestionViewpagerAdapter.Listener {

    private PresenterQuestionViewpagerAllQuestions presenterQuestionViewpager;

    private ViewPager2 viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.answers_viewpager_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("ВСЕ ВОПРОСЫ");
        viewPager = view.findViewById(R.id.questionViewpager);
        presenterQuestionViewpager = new PresenterQuestionViewpagerAllQuestions (this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onFeedClick(int id, int choice) {
        presenterQuestionViewpager.callBack(id, choice);
    }


    @Override
    public void setQuestion(List<ModelQuestion> listQuestion) {
        QuestionViewpagerAdapter questionViewpagerAdapter = new QuestionViewpagerAdapter(this, listQuestion);
        viewPager.setAdapter(questionViewpagerAdapter);
    }

    @Override
    public void gotoNextPage() {
        int item = viewPager.getCurrentItem();
        if (++item < viewPager.getAdapter().getItemCount()) {
            viewPager.setCurrentItem(item, true);
        }
    }
}
