import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;

import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by michal.hornak on 12/29/2016.
 */
@RunWith(AndroidJUnit4.class)
public class FetchingJokesTest extends ActivityUnitTestCase<MainActivity> {

    public FetchingJokesTest() {
        super(MainActivity.class);
    }

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void FetchSingleJoke() {
        mActivityRule.getActivity();

        MainActivity mActivity = ((MainActivity) mActivityRule.getActivity());
        mActivity.tellJoke(null);

        //wait for volley to fetch response.
        while (mActivity.fetchingJoke);
        System.out.println("Testing!");

        assert (mActivity.jokeText != null);
    }
}
