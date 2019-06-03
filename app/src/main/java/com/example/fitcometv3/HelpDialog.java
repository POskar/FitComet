package com.example.fitcometv3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class HelpDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Poziomy aktywności")
                .setMessage("1 – leżący lub siedzący tryb życia, brak aktywności fizycznej\n" +
                        "\n" +
                        "2 – praca siedząca, aktywność fizyczna na niskim poziomie\n" +
                        "\n" +
                        "3 – lekka praca fizyczna, trening 2 razy w tygodniu\n" +
                        "\n" +
                        "4 – praca fizyczna, trening 3-4 razy w tygodniu\n")
                .setPositiveButton("ok" ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
