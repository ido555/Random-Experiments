package com.example.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdemo.beans.User;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<User> users;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.txtUsrId.setText("id: " + currentUser.getId());
        holder.txtUsrName.setText("name: " + currentUser.getName());
        holder.txtUsrAddress.setText("address: " + currentUser.getAddress());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends  RecyclerView.ViewHolder{
        private TextView txtUsrId, txtUsrName, txtUsrAddress;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUsrId = itemView.findViewById(R.id.txtUsrId);
            txtUsrName = itemView.findViewById(R.id.txtUsrName);
            txtUsrAddress = itemView.findViewById(R.id.txtUsrAddress);
        }
    }

}
