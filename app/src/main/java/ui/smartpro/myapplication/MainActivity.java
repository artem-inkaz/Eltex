package ui.smartpro.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import ui.smartpro.myapplication.databinding.ActivityMainBinding;
import ui.smartpro.myapplication.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    NavController navController;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        prefs = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        checkSignIn();
    }

    private void checkSignIn() {
      Boolean signIn = prefs.getBoolean("oauth.loggedin",false);

      if (signIn) {
          navController.navigate(R.id.mainFragment);
      } else navController.navigate(R.id.loginFragment);
    }
}