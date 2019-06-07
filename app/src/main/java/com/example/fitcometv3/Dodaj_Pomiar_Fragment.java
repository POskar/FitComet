package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dodaj_Pomiar_Fragment extends Fragment implements View.OnClickListener {
    View myView;
    EditText waga1, talia1, biceps1, chest1e, biodro1e, udo1e, lydka1e;
    Button Sub;
    //
    // FragmentManager fragmentManager = getFragmentManager();
    // FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


    //
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Zapis.editDodaj = true;
        myView = inflater.inflate(R.layout.dodaj_pomiar_layout, container, false);
        waga1 = (EditText) myView.findViewById(R.id.wagaET);
        talia1 = (EditText) myView.findViewById(R.id.taliET);
        biceps1 = (EditText) myView.findViewById(R.id.bicepsET);
        chest1e = (EditText) myView.findViewById(R.id.chestET);
        biodro1e = (EditText) myView.findViewById(R.id.biodraET);
        udo1e = (EditText) myView.findViewById(R.id.udaET);
        lydka1e = (EditText) myView.findViewById(R.id.lydkET);

        Sub = (Button) myView.findViewById(R.id.ButtonDodajPomiar);
        Sub.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ButtonDodajPomiar:
                String waga1S = waga1.getText().toString();
                String talia1S = talia1.getText().toString();
                String Biceps1 = biceps1.getText().toString();
                String chest1 = chest1e.getText().toString();
                String biodro1 = biodro1e.getText().toString();
                String udo1 = udo1e.getText().toString();
                String lydka1 = lydka1e.getText().toString();
                if(!waga1S.isEmpty()&&!talia1S.isEmpty()&&!Biceps1.isEmpty()&&!chest1.isEmpty()&&!biodro1.isEmpty()&&!udo1.isEmpty()&&!lydka1.isEmpty()) {
                   if(Integer.valueOf(waga1S)<=30&&Integer.valueOf(waga1S)>=250&&Integer.valueOf(talia1S)>30&&Integer.valueOf(talia1S)<=150&&Integer.valueOf(Biceps1)>10&&Integer.valueOf(Biceps1)<=60&&Integer.valueOf(chest1)>50&&Integer.valueOf(chest1)<=200&&Integer.valueOf(biodro1)>50&&Integer.valueOf(biodro1)<=200&&Integer.valueOf(udo1)>30&&Integer.valueOf(udo1)<=120&&Integer.valueOf(lydka1)>20&&Integer.valueOf(lydka1)<=70){
                    Bundle bundle = new Bundle();
                    bundle.putString("Waga", waga1S);
                    bundle.putString("Talia1", talia1S);
                    bundle.putString("Biceps1", Biceps1);
                    bundle.putString("chest1", chest1);
                    bundle.putString("biodro1", biodro1);
                    bundle.putString("udo1", udo1);
                    bundle.putString("lydka1", lydka1);


                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    Pomiar_Fragment pomiar_fragment = new Pomiar_Fragment();
                    pomiar_fragment.setArguments(bundle);


                    Zapis.zapis = true;


                    fragmentTransaction.replace(R.id.content_frame, pomiar_fragment);
                    fragmentTransaction.commit();
                    break;}else{Toast.makeText(getContext(), "Podane Wartosci sa nie zgodne z prawidlowego przedzialu sprawdz poprawnosc danych", Toast.LENGTH_LONG).show();}

                }else {
                    Toast.makeText(getContext(), "Uzupelnij Wszystkie Pola", Toast.LENGTH_LONG).show();}

            default:
                break;
        }
    }
}
