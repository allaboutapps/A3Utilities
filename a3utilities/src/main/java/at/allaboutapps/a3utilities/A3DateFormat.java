package at.allaboutapps.a3utilities;

/** Valid ISO8601 Date Format Constant */
public final class A3DateFormat {

  /**
   * Date format following ISO8601 to use with Gson for date parsing in the format
   *
   * <ul>
   *   <li>2016-10-05T07:31:32+00:00
   *   <li>2016-10-05T07:31:32Z
   * </ul>
   *
   * <p>e.g. Use like this with gson:
   *
   * <pre><code>
   * Gson gson = new GsonBuilder()
   *   .setDateFormat(DateFormat.ISO8601)
   *   .create();
   * </code></pre>
   *
   * <b>Warning:</b> While it will parse dates correctly, it will format the timezone as {@code
   * +2000} before 18, and as {@code +20:00} starting with 18.
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static final String ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";

  private A3DateFormat() {}
}
