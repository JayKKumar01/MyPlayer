package com.github.jaykkumar01.myplayerlib;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.github.jaykkumar01.myplayerlib.playerutils.MyHandler;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class OnControlsTouch implements View.OnTouchListener {
    private StyledPlayerView playerView;

    public OnControlsTouch(ConstraintLayout rootLayout, StyledPlayerView playerView) {
        this.playerView = playerView;
        setTouchAll(rootLayout);
    }

    @SuppressLint("UnsafeOptInUsageError")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            MyHandler.hideControls(playerView);
        }
        return false;
    }

    void setTouchAll(ViewGroup viewGroup){
        int count = viewGroup.getChildCount();
        for(int i=0; i<count; i++){
            View view = viewGroup.getChildAt(i);
            if(view instanceof ViewGroup){
                setTouchAll((ViewGroup) view);
            }
            else{
                view.setOnTouchListener(this);
            }
        }
    }
}
