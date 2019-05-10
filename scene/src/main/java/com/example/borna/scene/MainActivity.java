package com.example.borna.scene;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ViewGroup mSceneRoot;
    private Scene mScene1;
    private Scene mScene2;
    private Scene mScene3;
    private Scene mScene4;
    private Transition transition;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSceneRoot = findViewById(R.id.scene_root);

        // Create the scenes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

            mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, this);
            mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene2, this);
            mScene3 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene3, this);
            mScene4 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene4, this);

            mScene1.enter();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                        TransitionManager.go(mScene1);

                }
            }, 1000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TransitionManager.go(mScene2, transition);
                }
            }, 2000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TransitionManager.go(mScene3, transition);
                }
            }, 3000);
//
//
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TransitionManager.go(mScene4, transition);
                }
            }, 3500);


            mScene4.setEnterAction(new Runnable() {
                @Override
                public void run() {
                    ((ConstraintLayout) mScene4.getSceneRoot().findViewById(R.id.chart4)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                            startActivity(intent);
                        }
                    });
                }


            });
        }
    }
}

