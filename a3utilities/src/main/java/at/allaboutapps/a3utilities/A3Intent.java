package at.allaboutapps.a3utilities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;

/**
 * This class provides some methods to create standard intents for email, phone, web
 * and methods to open matching activities
 */
public final class A3Intent {

  private A3Intent() {
    //private empty constructor
  }

  /**
   * Creates an intent to send an email
   *
   * @param address Email address to send to
   * @param subject Subject of the new email
   * @param body    Body text of the new email
   * @param cc      CC address
   * @return newly created intent
   */
  public static Intent newEmailIntent(String address, String subject, String body, String cc) {
    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", address, null));
    intent.putExtra(Intent.EXTRA_EMAIL, address);
    intent.putExtra(Intent.EXTRA_TEXT, body);
    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
    intent.putExtra(Intent.EXTRA_CC, cc);
    return intent;
  }

  /**
   * Creates an intent to send an email
   *
   * @param addresses Array of email addresses to send to
   * @param subject   Subject of the new email
   * @param body      Body text of the new email
   * @param cc        CC address
   * @return newly created intent
   */
  public static Intent newEmailIntent(String[] addresses, String subject, String body, String cc) {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("message/rfc822");
    intent.putExtra(Intent.EXTRA_EMAIL, addresses);
    intent.putExtra(Intent.EXTRA_TEXT, body);
    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
    intent.putExtra(Intent.EXTRA_CC, cc);
    return intent;
  }

  /**
   * Creates an intent to open dialer with phone number
   *
   * @param phoneNumber
   * @return
   */
  public static Intent newDialIntent(String phoneNumber) {
    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
    return intent;
  }

  /**
   * Creates an intent to start a call to phone number
   * Caution: Needs permission CALL_PHONE
   *
   * @param phoneNumber
   * @return
   */
  @RequiresPermission (Manifest.permission.CALL_PHONE)
  public static Intent newCallIntent(String phoneNumber) {
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
    return intent;
  }

  /**
   * Creates an intent to open a browser activity
   *
   * @param url
   * @return
   */
  public static Intent newUrlIntent(String url) {
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    return i;
  }

  /**
   * Opens the dialer activity
   *
   * @param context
   * @param phoneNumber
   */
  public static void openDialerActivity(@NonNull Context context, String phoneNumber) {
    Intent intent = newDialIntent(phoneNumber);
    context.startActivity(Intent.createChooser(intent, ""));
  }

  /**
   * Opens the email activity
   *
   * @param context
   * @param address
   * @param subject
   * @param body
   * @param cc
   */
  public static void openEmailActivity(@NonNull Context context, String address, String subject, String body, String cc) {
    Intent intent = newEmailIntent(address, subject, body, cc);
    context.startActivity(Intent.createChooser(intent, ""));
  }

  /**
   * Opens the browser activity
   *
   * @param context
   * @param url
   */
  public static void openBrowserActivity(@NonNull Context context, String url) {
    Intent intent = newUrlIntent(url);
    context.startActivity(Intent.createChooser(intent, ""));
  }

  /**
   * Starts a phone call
   *
   * @param context     Context to start the call
   * @param phoneNumber number to call
   */
  @RequiresPermission (Manifest.permission.CALL_PHONE)
  public static void startCall(@NonNull Context context, String phoneNumber) {
    Intent intent = newCallIntent(phoneNumber);
    context.startActivity(Intent.createChooser(intent, ""));
  }

  /**
   * Creates an intent to open maps with a position preselected
   *
   * @param latitude  double latitude
   * @param longitude double longitude
   * @param caption   String caption to show at google maps for this position
   * @return Intent to open maps
   */
  public static Intent newMapsIntent(double latitude, double longitude, @Nullable String caption) {
    StringBuilder uriString = new StringBuilder();
    uriString.append("geo:0,0?q=").append(latitude).append(',').append(longitude);
    if (!TextUtils.isEmpty(caption)) {
      uriString.append('(').append(caption).append(')');
    }

    Uri gmmIntentUri = Uri.parse(uriString.toString());
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
    mapIntent.setPackage("com.google.android.apps.maps");
    return mapIntent;
  }

  /**
   * Opens google maps at specific position
   *
   * @param context   Nonnull context
   * @param latitude  double latitude
   * @param longitude double longitude
   * @param caption   String caption to show at google maps for this position
   */
  public static void openGoogleMaps(@NonNull Context context, double latitude, double longitude, @Nullable String caption) {
    Intent intent = newMapsIntent(latitude, longitude, caption);
    context.startActivity(Intent.createChooser(intent, ""));
  }

  /**
   * Creates an intent for google maps with routing from current address to given address
   *
   * @param latitude
   * @param longitude
   * @return Intent intent to start maps
   */
  public static Intent newMapsRoutingIntent(double latitude, double longitude) {
    String url = "http://maps.google.com/maps?daddr=" + latitude + "," + longitude;
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    return intent;
  }

  /**
   * Opens google maps with routing from current address to given address
   *
   * @param context
   * @param latitude
   * @param longitude
   */
  public static void openGoogleMapsRouting(@NonNull Context context, double latitude, double longitude) {
    Intent intent = newMapsRoutingIntent(latitude, longitude);
    context.startActivity(Intent.createChooser(intent, ""));
  }
}
