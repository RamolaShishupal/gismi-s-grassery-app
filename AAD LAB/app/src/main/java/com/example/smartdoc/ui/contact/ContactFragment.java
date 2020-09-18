package com.example.smartdoc.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.smartdoc.R;

public class ContactFragment extends Fragment {

    View view;
    ImageButton click_map;
    ImageButton click_mail;
    ImageButton call;
    ImageButton sms;
    private RatingBar ratingBar;
    private TextView tvRateCount, tvRateMessage;
    private float ratedValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);

        click_map = view.findViewById(R.id.map_icon_button);
        click_map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View click_map) {
                //TODO: your code here
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=19.2288178,72.8481223(Star Galaxy)");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });

        click_mail = view.findViewById(R.id.mail_icon_button);
        click_mail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View click_mail) {
                //TODO: your code here
                String recipient = "example1@gmail.com";

                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
                mailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(mailIntent,"Choose an Email Client : "));
            }
        });

        call = view.findViewById(R.id.call_icon_button);
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View call) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + 12345678));//change the number
                startActivity(callIntent);
            }
        });

        sms = view.findViewById(R.id.sms_pic);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , new String ("12345678"));
                startActivity(Intent.createChooser(smsIntent, "Send sms via:"));
            }
        });

        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        tvRateCount = (TextView) view.findViewById(R.id.tvRateCount);
        tvRateMessage = (TextView) view.findViewById(R.id.tvRateMessage);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratedValue = ratingBar.getRating();
                tvRateCount.setText("Your Rating : " + ratedValue + "/5.");
                if(ratedValue<1) {
                    tvRateMessage.setText("ohh ho...");
                }
                else if(ratedValue<2) {
                    tvRateMessage.setText("Ok.");
                }
                else if(ratedValue<3) {
                    tvRateMessage.setText("Not bad.");
                }
                else if(ratedValue<4) {
                    tvRateMessage.setText("Nice");
                }
                else if(ratedValue<5) {
                    tvRateMessage.setText("Very Nice");
                }
                else if(ratedValue==5) {
                    tvRateMessage.setText("Thank you..!!!");
                }
            }
        });

        return view;
    }

}
