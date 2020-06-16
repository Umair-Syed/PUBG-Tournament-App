package com.skapps.android.gamepod;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Syed Umair on 16/06/2020.
 */
class TeamMembersAdapter extends RecyclerView.Adapter<TeamMembersAdapter.MemberViewHolder> {

    private String[] membersList;

    public TeamMembersAdapter(String[] membersList) {
        this.membersList = membersList;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_member_list_item, parent, false);
       return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return membersList.length;
    }

    class MemberViewHolder extends RecyclerView.ViewHolder {
        private TextView listItem;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            listItem = itemView.findViewById(R.id.list_item_text_view);
        }

        void bind(int listIndex){
            listItem.setText(membersList[listIndex]);
        }


    }

}
