package at.allaboutapps.a3utilities;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.TypedValue;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;

/** Utilities for version checks and pixel sizes. */
public class A3Device {

  public static boolean isMarshmallow() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.M;
  }

  public static boolean isMarshmallowOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
  }

  public static boolean isLollipop() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP;
  }

  public static boolean isLollipopOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
  }

  public static boolean isKitKat() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT;
  }

  public static boolean isKitKatOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
  }

  public static boolean isJellyBean() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN;
  }

  public static boolean isJellyBeanOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
  }

  public static boolean isIceCreamSandwich() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH;
  }

  public static boolean isIceCreamSandwichOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
  }

  public static boolean isNougat() {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.N;
  }

  public static boolean isNougatOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
  }

  public static boolean isApiLevelSupported(int apiLevel) {
    return Build.VERSION.SDK_INT >= apiLevel;
  }

  /**
   * Returns whether we are connected to a network
   *
   * @param ctx the application context
   * @return the current network state, true if online, false if ctx == null or otherwise.
   */
  @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
  public static boolean isOnline(@Nullable Context ctx) {

    if (ctx == null) {
      return false;
    }

    ConnectivityManager cm =
        (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm != null
        && cm.getActiveNetworkInfo() != null
        && cm.getActiveNetworkInfo().isConnectedOrConnecting();
  }

  public static int getPixelForDp(@NonNull Context ctx, int dp) {
    return (int)
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, ctx.getResources().getDisplayMetrics());
  }

  public static int getPixelForSp(@NonNull Context ctx, int sp) {
    return (int)
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, sp, ctx.getResources().getDisplayMetrics());
  }

  public static boolean isTablet(@NonNull Context ctx) {
    return ctx.getResources().getBoolean(R.bool.isTablet);
  }

  public static Point getDisplaySize(@NonNull Context ctx) {
    WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
    Point size = new Point();
    wm.getDefaultDisplay().getSize(size);
    return size;
  }

  public static float getDisplayWidth(@NonNull Context ctx) {

    return getDisplaySize(ctx).x;
  }

  public static float getDisplayHeight(@NonNull Context ctx) {

    return getDisplaySize(ctx).y;
  }
}
