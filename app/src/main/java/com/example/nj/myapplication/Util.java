package com.example.nj.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by NJ on 2015-11-24.
 */
public class Util {
    public static void setGlobalFont(Context context,View view)
    {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int len = vg.getChildCount();
                for (int i = 0; i < len; i++) {
                    View v = vg.getChildAt(i);
                    if (v instanceof TextView) {
                        try
                        {
                            ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "nanum.ttf"));
                        }
                        catch (Exception e)
                        {
                            Log.d("Error", e.getMessage());
                        }

                    }
                    if(v instanceof RadioButton)
                    {
                        try {
                            ((RadioButton) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "nanum.ttf"));
                        }
                        catch (Exception e)
                        {
                            Log.d("Error", e.getMessage());
                        }
                    }
                    setGlobalFont(context, v);
                }
            }
        } else {
            //L.m("This is null);
        }
    }

}