package android.bignerdranch.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Francisco José on 10/03/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
