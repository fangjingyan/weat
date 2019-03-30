package com.example.olivia.weat;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RouletteFragment_V2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String[] mParam1;

    public boolean blnButtonRotation = true;
    String name[] ={"A1","B2","C3","D4","E5","F6","G7","H8","I9","J10"};
    public int intNumber = name.length;
    public long lngDegrees = 0;
    SharedPreferences sharedPreferences;

    ImageView selected;
    PaintView_V2 imageRoulette;
    Button b_start;
    Button b_list;


    public RouletteFragment_V2() {
        // Required empty public constructor
    }


    public static RouletteFragment_V2 newInstance(String[] param1) {
        RouletteFragment_V2 fragment = new RouletteFragment_V2();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_roulette_v2, container, false);

        String[] streets = getArguments().getStringArray(ARG_PARAM1);
        String str = String.join(",", streets);
        Log.d("activity to fragment2: ", str);

        name = streets;

        RelativeLayout relativelayout = view.findViewById(R.id.relative);
        imageRoulette = PaintView_V2.newinstance(getContext(), streets);
        relativelayout.addView(imageRoulette);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 38;
        params.topMargin = 273;
        imageRoulette.setLayoutParams(params);

//        imageRoulette = (PaintView)view.findViewById(R.id.PaintView);

        b_start = (Button)view.findViewById(R.id.buttonStart);
        b_list = (Button)view.findViewById(R.id.buttonList);
        selected = (ImageView)view.findViewById(R.id.imageSelected);

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.intNumber = this.sharedPreferences.getInt("INT_NUMBER", name.length);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        b_start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButtonRotation(view);
            }

        });

        b_list.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }


    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Restaurants List");
        final String name2[] = name.clone();
        for (int i = 0; i < name.length; i++) {
            name2[i] = String.valueOf(i+1) + ": " + name[i];
        }
        builder.setItems(name2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),name2[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }


    public void onClickButtonRotation(View view) {
        if (blnButtonRotation) {
            int ran = new Random().nextInt(360) + 3600;
            RotateAnimation rotateAnimation = new RotateAnimation((float) lngDegrees, (float) (lngDegrees + ((long) ran)), Animation.ABSOLUTE, 500, Animation.ABSOLUTE, 500);
            lngDegrees = (lngDegrees + ((long) ran)) % 360;
            rotateAnimation.setDuration((long) ran);//set time for animation
            rotateAnimation.setFillAfter(true);//when the animation stops, keep the end state
            rotateAnimation.setInterpolator(new DecelerateInterpolator());//set the animation speed(decelerate)
//            rotateAnimation.setAnimationListener((Animation.AnimationListener) this);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    blnButtonRotation = false;
                    b_start.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    TextView tv=(TextView)getActivity().findViewById(R.id.textView);
                    tv.setText(name[(int) ((((double) intNumber) - Math.floor(((double) lngDegrees) / (360.0d / ((double) intNumber))))-1)]);

                    blnButtonRotation = true;
                    b_start.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            imageRoulette.setAnimation(rotateAnimation);
            imageRoulette.startAnimation(rotateAnimation);

        }
    }

}
