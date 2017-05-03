package at.allaboutapps.a3utilities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/** Show or hide the keyboard. */
public class A3SoftInput {

  public static void hide(@NonNull Activity act) {
    InputMethodManager imm =
        (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(act.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }

  public static void hide(@NonNull View v) {
    InputMethodManager imm =
        (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
  }

  public static void show(@NonNull View v) {
    InputMethodManager imm =
        (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
  }
}
