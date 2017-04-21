package at.allaboutapps.a3utilitiesproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import at.allaboutapps.a3utilities.A3Device;
import at.allaboutapps.a3utilitiesproject.vh.ExampleActivityViewHolder;

public class ExampleActivity extends AppCompatActivity {

  public static final int ANDROID_O = 26;
  private ExampleActivityViewHolder mViewHolder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_example);

    mViewHolder = new ExampleActivityViewHolder(this);
    setup();
  }

  private void setup() {
    mViewHolder.cbKitkat.setChecked(A3Device.isKitKatOrAbove());
    mViewHolder.cbO.setChecked(A3Device.isApiLevelSupported(ANDROID_O));
    mViewHolder.cbLollipop.setChecked(A3Device.isLollipopOrAbove());
    mViewHolder.cbMarshmallow.setChecked(A3Device.isMarshmallowOrAbove());
    mViewHolder.cbNougat.setChecked(A3Device.isNougatOrAbove());
  }
}
