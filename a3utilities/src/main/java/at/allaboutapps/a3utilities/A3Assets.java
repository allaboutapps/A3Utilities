package at.allaboutapps.a3utilities;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/** Util to read file contents from the assets folder. */
public class A3Assets {

  private static final String TAG = A3Assets.class.getName();

  /**
   * Read a file from assets into a {@code String}.
   *
   * @param ctx the context
   * @param fileName the filename
   * @return the file contents as {@code String}
   * @see #readString(Context, String, String)
   */
  @Nullable
  public static String readString(@NonNull Context ctx, @NonNull String fileName) {
    return readString(ctx, fileName, "UTF-8");
  }

  /**
   * Read a file from assets into a {@code String}.
   *
   * @param ctx the context
   * @param fileName the filename
   * @param encoding the encoding
   * @return the file contents as {@code String}
   * @see #readString(Context, String)
   */
  @Nullable
  public static String readString(
      @NonNull Context ctx, @NonNull String fileName, @NonNull String encoding) {
    String content = null;
    try {
      fileName = fileName.replace("assets/", "");
      InputStream is = ctx.getAssets().open(fileName);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      content = new String(buffer, encoding);
    } catch (IOException ex) {
      Log.e(TAG, ex.getMessage());
      return null;
    }
    return content;
  }

  /**
   * This will return the sample size needed to still be slightly bigger than WxH.
   *
   * <p>This is used for loading bigger images from assets or Web to reduce memory usage and load
   * time as seen in many examples. e.g.
   *
   * <pre>
   * {@code BitmapFactory.Options options = new BitmapFactory.Options();
   * AssetFileDescriptor fileDescriptor = null;
   * fileDescriptor = cr.openAssetFileDescriptor(imgUri, "r");
   * options.inJustDecodeBounds = true;
   * BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, options);
   * options.inJustDecodeBounds = false;
   * options.inSampleSize = calculateInSampleSize(options, 1200, 1600);
   * Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(),
   *      null, options);
   * }
   * </pre>
   *
   * @param options The options with the image data.
   * @param reqWidth the minimum width.
   * @param reqHeight the minimum height.
   * @return the largest inSampleSize value that is a power of 2 and keeps both height and width
   *     larger than the requested height and width.
   */
  public static int calculateInSampleSize(
      @NonNull BitmapFactory.Options options,
      @IntRange(from = 0) int reqWidth,
      @IntRange(from = 0) int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

      final int halfHeight = height / 2;
      final int halfWidth = width / 2;
      // Calculate the largest inSampleSize value that is a power of 2 and keeps both
      // height and width larger than the requested height and width.
      while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {

        inSampleSize *= 2;
      }
    }
    return inSampleSize;
  }
}
