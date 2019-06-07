package com.example.fitcometv3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Message_Fragment extends Fragment implements View.OnClickListener {
    View myView;
    Button messageID;
    TextView messageTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.message_layout, container, false);
        messageID = (Button) myView.findViewById(R.id.messageID);
        messageTV = (TextView) myView.findViewById(R.id.messageTVs);

        messageID = (Button) myView.findViewById(R.id.messageID);
        messageID.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.messageID:
                //DOKONCZYC WYSYLANIE
                String messageText = messageTV.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:teamfitcomet@gmail.com"));
                startActivity(Intent.createChooser(emailIntent, "Send feedback"));
                break;
        }
    }
}