package com.shia.practice111.fragments2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.shia.practice111.R;

public class FragmentSix extends Fragment implements View.OnClickListener {

    View view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11, view12, view13, view14, view15,
            flag1, flag2;
    ImageView imageView1, imageView2, imageView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        view1 = view.findViewById(R.id.view1);
        view2 = view.findViewById(R.id.view2);
        view3 = view.findViewById(R.id.view3);
        view4 = view.findViewById(R.id.view4);
        view5 = view.findViewById(R.id.view5);
        view6 = view.findViewById(R.id.view6);
        view7 = view.findViewById(R.id.view7);
        view8 = view.findViewById(R.id.view8);
        view9 = view.findViewById(R.id.view9);
        view10 = view.findViewById(R.id.view10);
        view11 = view.findViewById(R.id.view11);
        view12 = view.findViewById(R.id.view12);
        view13 = view.findViewById(R.id.view13);
        view14 = view.findViewById(R.id.view14);
        view15 = view.findViewById(R.id.view15);

        flag1 = view.findViewById(R.id.flag1);
        flag2 = view.findViewById(R.id.flag2);

        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);

        view1.setOnClickListener(this);
        view2.setOnClickListener(this::onClick);
        view3.setOnClickListener(this::onClick);
        view4.setOnClickListener(this::onClick);
        view5.setOnClickListener(this::onClick);
        view6.setOnClickListener(this::onClick);
        view7.setOnClickListener(this::onClick);
        view8.setOnClickListener(this::onClick);
        view9.setOnClickListener(this::onClick);
        view10.setOnClickListener(this::onClick);
        view11.setOnClickListener(this::onClick);
        view12.setOnClickListener(this::onClick);
        view13.setOnClickListener(this::onClick);
        view14.setOnClickListener(this::onClick);
        view15.setOnClickListener(this::onClick);
        imageView1.setOnClickListener(this::onClick);
        imageView2.setOnClickListener(this::onClick);
        imageView3.setOnClickListener(this::onClick);

        view4.setAlpha(0);
        view5.setAlpha(0);
        animate(view5);

        imageView2.setTranslationX(2000);
        imageView2.animate().translationXBy(-2000).setDuration(1000);
        /*imageView2.setTranslationY(2000);
        imageView2.animate().translationYBy(-2000).setDuration(1000);*/

        imageView3.setTranslationX(0);
        imageView3.setTranslationY(0);
        imageView3.setScaleX(0.2f);
        imageView3.setScaleY(0.2f);
        customAnimation();

        super.onViewCreated(view, savedInstanceState);
    }

    private void customAnimation() {
        imageView3.animate()
                .translationX(0)
                .translationY(0)
                .rotationBy(6 * 360)
                .scaleX(1)
                .scaleY(1)
                .setDuration(2000);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.view1:
                view1.animate().alpha(0.3f).setDuration(2000);
                break;
            case R.id.view2:
            case R.id.flag1:
                fade();
                break;
            case R.id.view3:
            case R.id.flag2:
                fading();
                break;
            case R.id.view4:
                view4.animate().alpha(1).setDuration(2000);
                break;
            case R.id.view5:
                animate(view);
            case R.id.imageView1:
                imageView1.animate().translationYBy(50).setDuration(1000);
                //translation means that the picture come from Y(top or bottom) or X(left or right)
                //imageView1.animate().translationY(50).setDuration(1000);
                //imageView1.animate().translationYBy(-2000).setDuration(1000);
                //imageView1.animate().translationXBy(-2000).setDuration(1000);
                //imageView1.animate().translationXBy(2000).setDuration(1000);

                //rotation means that the picture will turn
                //imageView1.animate().rotation(90).setDuration(1000);
                //imageView1.animate().rotationBy(90).setDuration(1000);
                //imageView1.animate().rotationXBy(180).setDuration(1000);
                //imageView1.animate().rotationXBy(180).rotationBy(180).setDuration(1000);

                //scale means that the picture will zoom in or zoom out
                //imageView1.animate().scaleX(0.5f).setDuration(1000);
                //imageView1.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
                //imageView1.animate().scaleXBy(0.5f).setDuration(1000);
                //imageView1.animate().scaleXBy(0.5f).scaleYBy(0.5f).setDuration(1000);
            case R.id.view6:
                view6.setBackgroundResource(R.drawable.flag_de);
                break;
            case R.id.view7:
                view7.setTranslationY(-2000);
                view7.setBackgroundResource(R.drawable.flag_dk);
                view7.animate().translationY(0).rotationBy(3 * 360).setDuration(500);
                break;
            case R.id.view8:
                view8.animate().scaleXBy(-0.5f).scaleYBy(-0.5f).setDuration(1000);
                break;
        }
    }

    private void animate(View view) {
        view5.animate().alpha(1).setDuration(3000);
    }

    private void fading() {
        view3.animate().alpha(1 - view3.getAlpha()).setDuration(2000);
        flag2.animate().alpha(1 - flag2.getAlpha()).setDuration(2000);
    }

    private void fade() {
        if (flag1.getAlpha() == 0) {
            view2.animate().alpha(0).setDuration(2000);
            flag1.animate().alpha(1).setDuration(2000);
        } else if (view2.getAlpha() == 0) {
            view2.animate().alpha(1).setDuration(2000);
            flag1.animate().alpha(0).setDuration(2000);
        }
    }
}