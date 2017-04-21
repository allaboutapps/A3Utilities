package at.allaboutapps.a3utilities;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Hides unnecessary methods if one is just interested in the text.
 */
public abstract class A3TextChangedListener implements TextWatcher {

    @Override
    public final void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // do nothing
    }

    @Override
    public final void onTextChanged(CharSequence s, int start, int before, int count) {
        // do nothing
    }

    @Override
    public final void afterTextChanged(Editable s) {
        onTextChanged(s.toString());
    }

    /**
     * The new text of the input field from {@code afterTextChanged}.
     *
     * @param text the current text value
     */
    public abstract void onTextChanged(String text);
}
