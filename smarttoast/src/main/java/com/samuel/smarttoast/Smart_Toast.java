package com.samuel.smarttoast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class Smart_Toast extends Toast {
    private Context context;
    private Activity activity;
    private TextView toastTextView;
    private ImageView toastImageView, appicon;
    private View layout;
    private String message;
    private int duration;
    private Toast toast;
    private CardView ll;
    private boolean defaultcolor = false;
    public static final int ERROR = 0;
    public static final int INFO = 1;
    public static final int SUCCESS = 2;
    public static final int SQUARE = 1;
    public static final int DEFAULT = 2;

    public static final int SHORT = 0;
    public static final int LONG = 1;
    public static final int MUCH_LONGER = 2;

    public static final int BOLD = 0;
    public static final int ITALLIC = 1;

    public Smart_Toast(Activity activity, String message) {
        super(activity);
        this.activity = activity;
        this.message = message;

        LayoutInflater inflater = (activity).getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.toast_layout_root));
        toastTextView = layout.findViewById(R.id.toastTextView);
        appicon = layout.findViewById(R.id.appicon);
        toastImageView = layout.findViewById(R.id.toastImageView);
        ll = layout.findViewById(R.id.toast_layout_root);
        toast = Toast.makeText(activity, this.message, Toast.LENGTH_LONG);
        toastTextView.setText(this.message);
    }

    public void setbackgroundColor(int color) {
        if (!defaultcolor)
            ll.setCardBackgroundColor(color);

    }

    public void setToastDuration(int duration_type) {
        switch (duration_type) {
            case SHORT:
                toast.setDuration(Toast.LENGTH_SHORT);
                break;
            case LONG:
                toast.setDuration(Toast.LENGTH_LONG);
                break;
            case MUCH_LONGER:
                toast.setDuration(Toast.LENGTH_LONG);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.show();
                    }
                }, 3500);


                break;
        }

    }

    public void setappIcon(Bitmap bm) {
        appicon.setVisibility(View.VISIBLE);
        appicon.setImageBitmap(bm);
    }

    public void setappIcon(Drawable dr) {
        appicon.setVisibility(View.VISIBLE);
        appicon.setImageDrawable(dr);
    }


    public void setappIcon(int id) {
        appicon.setVisibility(View.VISIBLE);
        appicon.setImageResource(id);
    }

    public void setToastType(int i) {
        defaultcolor = true;
        switch (i) {
            case ERROR:
                ll.setCardBackgroundColor(Color.RED);
                toastImageView.setImageResource(R.drawable.error);
                break;
            case INFO:
                ll.setCardBackgroundColor(Color.BLUE);
                toastImageView.setImageResource(R.drawable.info);
                break;
            case SUCCESS:
                ll.setCardBackgroundColor(Color.GREEN);
                toastImageView.setImageResource(R.drawable.success);
                break;
        }
    }

    public void setToastStyle(int toastStyle) {
        switch (toastStyle) {
            case SQUARE:
                ll.setRadius(0);
                break;
            default:
                ll.setRadius(20);
                break;

        }

    }

    public void setFontFamily(Typeface typeface) {
        toastTextView.setTypeface(typeface);
    }

    public void setTextColor(int color) {
        toastTextView.setTextColor(color);
    }

       public void setTextStyle(int style) {
        switch (style) {
            case BOLD:
                toastTextView.setTypeface(null, BOLD);
                break;
            case ITALLIC:
                toastTextView.setTypeface(null, ITALIC);
                break;
        }
    }


    public void setTextSize(int textSize) {
        toastTextView.setTextSize(textSize);
    }

    public void show() {
        toast.setView(layout);
        toast.show();
    }

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */


}
