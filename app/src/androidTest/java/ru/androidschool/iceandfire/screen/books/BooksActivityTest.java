package ru.androidschool.iceandfire.screen.books;

import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.InputType;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import ru.androidschool.iceandfire.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isFocusable;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author Azat Galiullin
 */
@RunWith(AndroidJUnit4.class)
public class BooksActivityTest {

    @Rule
    public final ActivityTestRule<BooksActivity> mActivityRule = new ActivityTestRule<>(BooksActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();
    }



    @Test
    public void testShowFirst() throws Exception {
        //Realm.getDefaultInstance().deleteAll();
        onView(withText("A Game of Thrones")).check(matches(isDisplayed()));
    }



    /*@Test
    public void testLogInButtonShown() throws Exception {
        onView(withId(R.id.logInButton)).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isClickable(),
                withText(R.string.log_in)
        )));
    }

    @Test
    public void testInputDisplayed() throws Exception {
        onView(withId(R.id.loginEdit)).perform(typeText("TestLogin"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordEdit)).perform(typeText("TestPassword"));
        closeSoftKeyboard();

        onView(withId(R.id.loginEdit)).check(matches(withText("TestLogin")));
        onView(withId(R.id.passwordEdit)).check(matches(withText("TestPassword")));
    }

    @Test
    public void testLoginErrorDisplayed() throws Exception {
        onView(withId(R.id.loginEdit)).perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.logInButton)).perform(click());
    }

    @Test
    public void testPasswordErrorDisplayed() throws Exception {
        onView(withId(R.id.loginEdit)).perform(typeText("root"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordEdit)).perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.logInButton)).perform(click());

        onView(withId(R.id.passwordInputLayout)).check(matches(withInputError(R.string.error)));
    }

    @Test
    public void testSuccessAuth() throws Exception {
        onView(withId(R.id.loginEdit)).perform(typeText("login"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordEdit)).perform(typeText("pass"));
        closeSoftKeyboard();
        onView(withId(R.id.logInButton)).perform(click());

        Intents.intended(hasComponent(RepositoriesActivity.class.getName()));
    }

    @Test
    public void testErrorAuth() throws Exception {
        RepositoryProvider.provideKeyValueStorage().saveToken(ERROR);

        onView(withId(R.id.loginEdit)).perform(typeText("login"));
        closeSoftKeyboard();
        onView(withId(R.id.passwordEdit)).perform(typeText("pass"));
        closeSoftKeyboard();
        onView(withId(R.id.logInButton)).perform(click());

        onView(withId(R.id.loginInputLayout)).check(matches(withInputError(R.string.error)));
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
        RepositoryProvider.provideKeyValueStorage().clear();
    }*/

}
