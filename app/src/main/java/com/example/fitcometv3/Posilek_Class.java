package com.example.fitcometv3;

public class Posilek_Class {
    private String name;
    private String description;
    private int imageResourceId;
    private String PoziomTrudnosciPrzygotownia;

    public static final Posilek_Class[] posilki = {

               new Posilek_Class("TORTILLE Z ŁOSOSIEM WĘDZONYM",
                       "pełnoziarnista tortilla – 2 szt. łosoś wędzony na zimno – 200 g awokado hass – 2 szt. szalotka – 1 szt. limonka – ½ szt. mango – 1 szt. koperek – 1 pęczek papryczka chili – ½ szt. sól pieprz.",
             R.drawable.tortillalosos,"Łatwy"),

               new Posilek_Class("WRAPY Z KURCZAKIEM I CHRUPIĄCYMI WARZYWAMI","2 tortille 4 łyżki kremowego serka twarogowego 1/4 papryki czerwonej 1/4 papryki żółtej garść mieszanki sałat 70 g mięsa pieczonego kurczaka jabłko maślanka naturalna.", R.drawable.tortillalosos,"Łatwy"),
               new Posilek_Class("NOCNA OWSIANKA Z BANANAMI","płatki owsiane górskie BIO – 0,5 szklanki mleko migdałowe – 0,5 szklanki jogurt naturalny BIO – 2 łyżki masło orzechowe – 1,5 łyżki syrop klonowy – 1-2 łyżeczki.",R.drawable.tortillalosos,"Łatwy"),
    };

    private Posilek_Class(String name, String description, int imageResourceId, String PoziomTrudnosciPrzygotownia) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.PoziomTrudnosciPrzygotownia = PoziomTrudnosciPrzygotownia;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getPoziomTrudnosciPrzygotownia() {
        return PoziomTrudnosciPrzygotownia;
    }

}
