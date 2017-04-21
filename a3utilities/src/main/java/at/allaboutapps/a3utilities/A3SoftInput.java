package at.allaboutapps.a3utilities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class A3SoftInput {

    public static void hide(@NonNull Activity act) {
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(act.getWindow().getDecorView().getRootView().getWindowToken(), 0);
    }
    public static void hide(@NonNull View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static void show(@NonNull View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }


    /*
    Context ctx;
    EditText editText;

    public A3SoftInput(Context ctx, EditText editText) {
        this.ctx = ctx;
        this.editText = editText;
    }

    private Runnable mShowImeRunnable = new Runnable() {
        public void run() {
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (imm != null) {
                imm.showSoftInput(editText, 0);
            }
        }
    };

    public void setImeVisibility(final boolean visible) {
        if (visible) {
            if (editText != null) {
                editText.post(mShowImeRunnable);
            }
        } else {
            if (editText != null) {
                editText.removeCallbacks(mShowImeRunnable);
            }
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (imm != null) {

                if (editText != null) {
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                } else {
                    imm.hideSoftInputFromWindow(((Activity) ctx).getWindow().getDecorView().getRootView().getWindowToken(), 0);
                }
            }
        }
    }
    */
}
