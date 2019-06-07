package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import org.w3c.dom.Text;

public class Pomiar_Fragment extends Fragment {
    View myView;
    TextView tvDodajPomiarwaga1, tvDodajPomiartalia1, tvDodajPomiarbiceps1, tvDodajPomiarSzyja1, tvDodajPomiarchest1,
            tvdodajPomiarBrzuch1, tvDodajPomiarBiodra1, tvDodajPomiarUdo1, tvDodajPomiarlydka1,
            tvDodajPomiarwaga2, tvDodajPomiartalia2, tvDodajPomiarbiceps2, tvDodajPomiarSzyja2, tvDodajPomiarchest2, tvdodajPomiarBrzuch2,
            tvDodajPomiarBiodra2, tvDodajPomiarUdo2, tvDodajPomiarlydka2, tvTkankatluszczowa2, tvTkankatluszczowa1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.pomiar_layout, container, false);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        if (Zapis.anuluj == false) {
            Zapis.anuluj=false;
          if  (Zapis.zapis == true) {
                Bundle bundle = getArguments();
                if (Zapis.zapispierwszy == false) {

                    String waga1 = bundle.getString("Waga");
                    String talia1 = bundle.getString("Talia1");
                    String biceps1 = bundle.getString("Biceps1");
                    String szyja1 = bundle.getString("szyja1");
                    String chest1 = bundle.getString("chest1");
                    String brzuch1 = bundle.getString("brzuch1");
                    String biodro1 = bundle.getString("biodro1");
                    String udo1 = bundle.getString("udo1");
                    String lydka1 = bundle.getString("lydka1");

                    double a = (4.15 * Integer.valueOf(talia1));
                    double b = a / 2.54;
                    double c = 0.082 * (Integer.valueOf(waga1)) * 2.2;
                    double d = b - c - 98.42;
                    double e = (Integer.valueOf(waga1)) * 2.2;
                    double WynikProcent = d / e * 100;


                    tvDodajPomiarwaga1 = (TextView) myView.findViewById(R.id.waga1TV);
                    tvDodajPomiartalia1 = (TextView) myView.findViewById(R.id.talia1TV);
                    tvDodajPomiarbiceps1 = (TextView) myView.findViewById(R.id.biceps1TV);
                    tvDodajPomiarchest1 = (TextView) myView.findViewById(R.id.chest1TV);
                    tvDodajPomiarBiodra1 = (TextView) myView.findViewById(R.id.biodraTV);
                    tvDodajPomiarUdo1 = (TextView) myView.findViewById(R.id.udo1TV);
                    tvDodajPomiarlydka1 = (TextView) myView.findViewById(R.id.lydka1TV);
                    tvTkankatluszczowa1 = (TextView) myView.findViewById(R.id.tkanka1);


                    tvDodajPomiarwaga1.setText(waga1);
                    tvDodajPomiartalia1.setText(talia1);
                    tvDodajPomiarbiceps1.setText(biceps1);
                    tvDodajPomiarSzyja1.setText(szyja1);
                    tvDodajPomiarchest1.setText(chest1);
                    tvdodajPomiarBrzuch1.setText(brzuch1);
                    tvDodajPomiarBiodra1.setText(biodro1);
                    tvDodajPomiarUdo1.setText(udo1);
                    tvDodajPomiarlydka1.setText(lydka1);
                    tvTkankatluszczowa1.setText(String.valueOf(decimalFormat.format(WynikProcent)));
                    Zapis.zapispierwszy = true;
                    //  Zapis.zapis=false;//check
                } else {
                    //NARAZIE NIE DZIALA nadpisuje pierwsze okno
                    String waga2 = bundle.getString("Waga");
                    String talia2 = bundle.getString("Talia1");
                    String biceps2 = bundle.getString("Biceps1");
                    String szyja2 = bundle.getString("szyja1");
                    String chest2 = bundle.getString("chest1");
                    String brzuch2 = bundle.getString("brzuch1");
                    String biodro2 = bundle.getString("biodro1");
                    String udo2 = bundle.getString("udo1");
                    String lydka2 = bundle.getString("lydka1");

                    double a = (4.15 * Integer.valueOf(talia2));
                    double b = a / 2.54;
                    double c = 0.082 * (Integer.valueOf(waga2)) * 2.2;
                    double d = b - c - 98.42;
                    double e = (Integer.valueOf(waga2)) * 2.2;
                    double WynikProcent = d / e * 100;


                    tvDodajPomiarwaga2 = (TextView) myView.findViewById(R.id.waga2TV);
                    tvDodajPomiartalia2 = (TextView) myView.findViewById(R.id.talia2TV);
                    tvDodajPomiarbiceps2 = (TextView) myView.findViewById(R.id.biceps2TV);
                    tvDodajPomiarchest2 = (TextView) myView.findViewById(R.id.chest2TV);
                    tvDodajPomiarBiodra2 = (TextView) myView.findViewById(R.id.biodra2TV);
                    tvDodajPomiarUdo2 = (TextView) myView.findViewById(R.id.udo2TV);
                    tvDodajPomiarlydka2 = (TextView) myView.findViewById(R.id.lydka2TV);
                    tvTkankatluszczowa2 = (TextView) myView.findViewById(R.id.tkanka2);


                    tvDodajPomiarwaga2.setText(waga2);
                    tvDodajPomiartalia2.setText(talia2);
                    tvDodajPomiarbiceps2.setText(biceps2);
                    tvDodajPomiarSzyja2.setText(szyja2);
                    tvDodajPomiarchest2.setText(chest2);
                    tvdodajPomiarBrzuch2.setText(brzuch2);
                    tvDodajPomiarBiodra2.setText(biodro2);
                    tvDodajPomiarUdo2.setText(udo2);
                    tvDodajPomiarlydka2.setText(lydka2);
                    tvTkankatluszczowa2.setText(String.valueOf(decimalFormat.format(WynikProcent)));
                }

            }
        }
        Zapis.anuluj=false;
        return myView;
    }
}
