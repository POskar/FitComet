package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DietPor_Fragment extends Fragment implements View.OnClickListener {
    View myView;
    Button LosujButton;
    TextView dietporText;
    final String[] naszporady = {"odwodnienie może prowadzić do niepotrzebnego podjadania? Zawsze miej przy sobie butelkę wody. Będziesz zaskoczony jak łatwo możesz poradzić sobie z głodem, gdy jesteś nawodniony.",
            " korzyści wynikające z aktywnego trybu życia to nie tylko spalanie kalorii podczas ćwiczeń, ale również budowanie tkanki mięśniowej, która jest aktywna metabolicznie. Dlatego możesz spalać więcej kalorii nawet gdy odpoczywasz.",
            "  należy unikać tłuszczy trans znajdujących się w przekąskach, takich jak ciastka, chipsy, pączki? Badania wykazały, że tłuszcze trans mają negatywny wpływ na zdrowie: zwiększają ryzyko chorób serca, cukrzycy i prowadzą do osłabienia systemu odpornościowego.",
            "możesz wzbogacić swoją dietę o dodatkowe kalorie w zdrowy sposób? Jedz produkty wielozbożowe i tłuste ryby. Zamiast słodyczy na deser zjadaj pożywne orzechy, migdały i suszone owoce.",
            "błonnik nierozpuszczalny, znajdujący się w warzywach i produktach wielozbożowych powoduje iż są one dłużej trawione, uwalniając stopniowo energię.",
            "niska zawartość cukru to, gdy ilość cuku nie przekracza 5 gram na 100 g produktu. Wysoka zawartość cukru to 15 g cukru lub więcej na 100 g produktu. Pomiędzy 5 a 15 gram to produkty o średniej zawartości cukru. Wyjątkiem są cukry znajdujące się w produktach mlecznych, owocach i warzywach (laktoza i fruktoza).",
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.dietpor_layout, container, false);
        dietporText = (TextView) myView.findViewById(R.id.dietporText);
        int random = (int)(Math.random()*6);
        dietporText.setText(naszporady[random]);
        LosujButton = (Button) myView.findViewById(R.id.LosujButton);
        LosujButton.setOnClickListener(this);



        return myView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LosujButton:
                int random = (int)(Math.random()*6);
                dietporText.setText(naszporady[random]);
                break;
        }
    }
}
