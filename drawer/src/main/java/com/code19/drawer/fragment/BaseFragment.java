package com.code19.drawer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * http://www.luchenglong.com/2016/07/06/20160706/
 * 在Fragment基类中需要保存数据现场状态和数据
 * 自定义控件状态参考：https://github.com/daimajia/NumberProgressBar/blob/master/library/src/main/java/com/daimajia/numberprogressbar/NumberProgressBar.java#L443-L481
 */
public class BaseFragment extends Fragment {
    Bundle savedState;
    String BundleKey = "TAG";

    public BaseFragment() {
        super();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!restoreStateFromArguments()) {
            // First Time, Initialize something here
            onFirstTimeLaunched();
        }
    }

    protected void onFirstTimeLaunched() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save State Here
        saveStateToArguments();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Save State Here
        saveStateToArguments();
    }

    private void saveStateToArguments() {
        if (getView() != null)
            savedState = saveState();
        if (savedState != null) {
            Bundle b = getArguments();
            b.putBundle(BundleKey, savedState);
        }
    }

    private boolean restoreStateFromArguments() {
        Bundle b = getArguments();
        savedState = b.getBundle(BundleKey);
        if (savedState != null) {
            restoreState();
            return true;
        }
        return false;
    }

    /**
     * Restore Instance State Here
     */
    private void restoreState() {
        if (savedState != null) {
            // For Example
            //tv1.setText(savedState.getString(text));
            onRestoreState(savedState);
        }
    }

    protected void onRestoreState(Bundle savedInstanceState) {

    }

    /**
     * Save Instance State Here
     */
    private Bundle saveState() {
        Bundle state = new Bundle();
        // For Example
        //state.putString(text, tv1.getText().toString());
        onSaveState(state);
        return state;
    }

    protected void onSaveState(Bundle outState) {

    }
}
