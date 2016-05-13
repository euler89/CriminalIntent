package android.bignerdranch.com.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Francisco R.
 */
public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new Fragment();
    }
}
