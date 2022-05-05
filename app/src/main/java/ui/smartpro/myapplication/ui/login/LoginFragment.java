package ui.smartpro.myapplication.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ui.smartpro.myapplication.R;
import ui.smartpro.myapplication.api.Api;
import ui.smartpro.myapplication.databinding.FragmentLoginBinding;
import ui.smartpro.myapplication.response.AccessToken;
import ui.smartpro.myapplication.utils.Constants;
import ui.smartpro.myapplication.utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private NavController navController;
    SharedPreferences prefs;
    Bundle bundle = new Bundle();
    ui.smartpro.myapplication.response.Response user;
    Set<String> targetSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = requireContext().getSharedPreferences(
                Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.navController = Navigation.findNavController(view);
        signIn();
    }

    private void signIn() {
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editTextLogin.getText().length() > 0 || binding.editTextPassword.getText().length() > 0) {
                    getSignIn(
                            binding.editTextLogin.getText().toString(),
                            binding.editTextLogin.getText().toString(),
                            binding.editTextPassword.getText().toString()
                    );
                } else {
                    Toast toast = Toast.makeText(requireContext(),
                            getString(R.string.empty_auth), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void getSignIn(String grant_type, String username, String password) {
        Api client = ServiceGenerator.createService(Api.class);
        Call<AccessToken> call = client.getToken(grant_type, username, password);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    AccessToken token = response.body();
                    prefs.edit().putBoolean("oauth.loggedin", true).apply();
                    prefs.edit().putString("oauth.accesstoken", token.getAccessToken()).apply();
                    prefs.edit().putString("oauth.refreshtoken", token.getRefreshToken()).apply();
                    prefs.edit().putString("oauth.tokentype", token.getTokenType()).apply();
                    getUser(token, requireContext());
                } else {
                    Toast toast = Toast.makeText(requireContext(),
                            getString(R.string.error_auth), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessToken> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(requireContext(),
                        getString(R.string.error_auth) + t.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void getUser(AccessToken accessToken, Context c) {
        Api client = ServiceGenerator.createService(Api.class,accessToken,c);
        Call<ui.smartpro.myapplication.response.Response> call = client.getUser();
        call.enqueue(new Callback<ui.smartpro.myapplication.response.Response>() {
            @Override
            public void onResponse(@NonNull Call<ui.smartpro.myapplication.response.Response> call, @NonNull Response<ui.smartpro.myapplication.response.Response> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    ui.smartpro.myapplication.response.Response token = response.body();
                    assert token != null;
                    prefs.edit().putString("user.roleId", token.getRoleId()).apply();
                    prefs.edit().putString("user.username", token.getUsername()).apply();
                    prefs.edit().putString("user.email", (String) token.getEmail()).apply();
                    listToSet(token.getPermissions());
                    prefs.edit().putStringSet("user.permissions", targetSet).apply();
                    bundle.putParcelable(Constants.BUNDLE_USER, token);
                    navController.navigate(R.id.mainFragment,bundle);
                } else {
                    Toast toast = Toast.makeText(requireContext(),
                            R.string.error_data, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ui.smartpro.myapplication.response.Response> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(requireContext(),
                        R.string.error_data + t.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void listToSet(List<String> responseList) {
        targetSet = new HashSet<>(responseList);
    }
}