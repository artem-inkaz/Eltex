package ui.smartpro.myapplication.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ui.smartpro.myapplication.databinding.FragmentMainBinding;
import ui.smartpro.myapplication.response.Response;
import ui.smartpro.myapplication.ui.main.adapter.PermissionAdapter;
import ui.smartpro.myapplication.utils.Constants;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    SharedPreferences prefs;
    Response user;
    Set<String> data = new LinkedHashSet<>();
    List<String> targetList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = requireContext().getSharedPreferences(
                Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUser();
    }

    public void getUser() {
            user = getArguments().getParcelable(Constants.BUNDLE_USER);
        if (getArguments() != null && user != null) {
            if (user.getRoleId() != null) {
                binding.roleIdEt.setText(user.getRoleId());
            } else binding.roleIdEt.setText(" ");
            if (user.getUsername() != null) {
                binding.usernameEt.setText(user.getUsername());
            } else binding.usernameEt.setText(" ");
            if (user.getEmail() != null)
                binding.emailEt.setText(user.getEmail().toString());
            else binding.emailEt.setText(" ");
            targetList = user.getPermissions();
            initAdapter();
        } else {
            binding.roleIdEt.setText(prefs.getString("user.roleId",""));
            binding.usernameEt.setText(prefs.getString("user.username",""));
            binding.emailEt.setText(prefs.getString("user.email",""));
            setToList(prefs.getStringSet("user.permissions",data));
            initAdapter();
        }
    }

    public void initAdapter() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.permissionsRv.setLayoutManager(layoutManager);
        binding.permissionsRv.setAdapter(new PermissionAdapter(targetList));
    }

    public void setToList(Set<String> sourceSet) {
        targetList = new ArrayList<>(sourceSet);
    }
}