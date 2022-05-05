package ui.smartpro.myapplication.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ui.smartpro.myapplication.databinding.ItemBinding;

public class PermissionAdapter extends RecyclerView.Adapter<PermissionAdapter.ViewHolder> {

    private ItemBinding binding;
    private List<String> permissions;

    public PermissionAdapter(List<String> permissions) {
        this.permissions = permissions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionAdapter.ViewHolder holder, int position) {
        holder.binding.permissions.setText(permissions.get(position));
    }

    @Override
    public int getItemCount() {
        return permissions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemBinding binding;

        public ViewHolder(ItemBinding view) {
            super(view.getRoot());
            binding = view;
        }
    }
}
