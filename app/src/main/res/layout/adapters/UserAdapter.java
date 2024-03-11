package com.example.babycare.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.babycare.databinding.ItemContainerUserBinding;
import com.example.babycare.listeners.UserListeners;
import com.example.babycare.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>  {


    private final List<User> userList;
    private final UserListeners userListeners;

    public UserAdapter(List<User> userList, UserListeners userListeners) {
        this.userList = userList;
        this.userListeners = userListeners;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerUserBinding itemContainerUserBinding = ItemContainerUserBinding.inflate(LayoutInflater.from(parent.getContext())
        ,parent,false
        );
        return new UserViewHolder(itemContainerUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        ItemContainerUserBinding binding;
        UserViewHolder(ItemContainerUserBinding itemContainerUserBinding){
            super(itemContainerUserBinding.getRoot()) ;
            binding = itemContainerUserBinding;
        }
        void setUserData(User userData)
        {
            binding.userName.setText(userData.name);
            binding.userEmail.setText(userData.email);
            binding.imageProfile.setImageBitmap(getUserImage(userData.image));
            binding.getRoot().setOnClickListener(v -> userListeners.onUserClicked(userData));

        }
    }


    private Bitmap getUserImage(String encodedImage)
    {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
