package com.skapps.android.gamepod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int playerCount = 3;
    private String time = "no"; //if yes visibility of Room Credentials section is set to GONE
    private String real = "yes"; //if yes room id and pass is visible

    private RecyclerView recyclerView;
    private Boolean mTeamMembersOpen = false;
    private Boolean mRulesOpen = false;
    private Boolean mRoomOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setValues("erangel", "squad", "15", "TPP", "16th June", "8:00 PM", "200", "100", "50");

        String []members = new String[playerCount];
        members[0] = "Strontium84";
        members[1] = "Titanium81";
        members[2] = "Kalium84";
         recyclerView = findViewById(R.id.teamMembersRecyclerView);
        TeamMembersAdapter teamMembersAdapter = new TeamMembersAdapter(members);
        recyclerView.setAdapter(teamMembersAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setVisibilityRoom();
        showRoomCredentials();



    }


    public void toggleTeamMembers(View view) {
        TextView membersTV = (TextView)view;
        if(!mTeamMembersOpen){
            membersTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up_24, 0);
            recyclerView.setVisibility(View.VISIBLE);
            mTeamMembersOpen = true;
        }else{
            membersTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
            recyclerView.setVisibility(View.GONE);
            mTeamMembersOpen = false;
        }

    }

    public void toggleRules(View view) {
        TextView rulesTitle = findViewById(R.id.rulesToggle);
        TextView rulesTextView = findViewById(R.id.rules);

        if(!mRulesOpen){
            rulesTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up_24, 0);
            rulesTextView.setVisibility(View.VISIBLE);
            Spanned formatedText = Html.fromHtml( getString(R.string.rules));
            rulesTextView.setText(formatedText);
            mRulesOpen = true;
        }else{
            rulesTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
            rulesTextView.setVisibility(View.GONE);
            mRulesOpen = false;
        }

    }

    public void toggleRoomCredential(View view){
        RelativeLayout roomCredentialRL = findViewById(R.id.roomToggleRL);
        ImageView arrow = findViewById(R.id.show_arrow_room);

        if(!mRoomOpen){
            roomCredentialRL.setVisibility(View.VISIBLE);
            arrow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_arrow_up_24));
            mRoomOpen = true;
        }else{
            roomCredentialRL.setVisibility(View.GONE);
            arrow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_arrow_down));
            mRoomOpen = false;
        }

    }


    private void setVisibilityRoom(){
        RelativeLayout rv = findViewById(R.id.relLayout6);
        if(time.equals("yes")){
            rv.setVisibility(View.GONE);
        }else{
            rv.setVisibility(View.VISIBLE);
        }
    }

    private void showRoomCredentials(){
        RelativeLayout toggle = findViewById(R.id.relLayout6);
        ImageView arrow = findViewById(R.id.show_arrow_room);
        RelativeLayout roomCredentialRL = findViewById(R.id.roomToggleRL);
        roomCredentialRL.setVisibility(View.GONE);
        if(toggle.getVisibility() == View.VISIBLE){
            TextView availabilityTv = findViewById(R.id.availabilityTV);
            if(real.equals("yes")){             // rooms credentials now visible
                availabilityTv.setVisibility(View.GONE);
                arrow.setVisibility(View.VISIBLE);
                toggle.setClickable(true);
            }else{
                availabilityTv.setVisibility(View.VISIBLE);
                roomCredentialRL.setVisibility(View.GONE);
                toggle.setClickable(false);
            }
        }

    }



    private void setValues(String ... args){
        TextView mapName = findViewById(R.id.mapName); //0
        TextView team = findViewById(R.id.team);    //1
        TextView fee = findViewById(R.id.entryFee);   //2
        TextView mode = findViewById(R.id.mode);    //3
        TextView date = findViewById(R.id.date);    //4
        TextView time = findViewById(R.id.time);    //5
        TextView prizeFirst = findViewById(R.id.firstPrize);    //6
        TextView prizeSecond = findViewById(R.id.secondPrize);  //7
        TextView prizeThird = findViewById(R.id.thirdPrize);    //8

        mapName.setText(args[0]);
        team.setText(args[1]);
        fee.setText(args[2]);
        mode.setText(args[3]);
        date.setText(args[4]);
        time.setText(args[5]);
        prizeFirst.setText(args[6]);
        prizeSecond.setText(args[7]);
        prizeThird.setText(args[8]);


    }
}