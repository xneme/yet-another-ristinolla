# Käyttöohje

Lataa tiedosto [yet-another-ristinolla_loppupalautus.jar](https://github.com/xneme/yet-another-ristinolla/releases/tag/loppupalautus)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar yet-another-ristinolla_loppupalautus.jar
```

## Pelin aloittaminen

Sovellus käynnistyy valikkoon:

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/valikko.png" width="640">

Valitse valikosta haluamasi pelimuoto, jolloin peli alkaa.

## Peliohjeet

### Perinteinen 3x3 tai 10x10

Peliä pelataan 3x3 tai 10x10 ruudukolla, johon pelaajat pelaavat vuorotellen merkkejä. Toinen pelaaja pelaa risteillä "X" ja toinen ympyröillä "O". Ikkunan yläosassa kerrotaan kumman vuoro on, "X" aloittaa aina. Merkkejä pelataan klikkaamalla hiirellä tyhjää ruutua.

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/peli.png" width="640">

#### Voittaminen

Pelin tavoite on saada pelitavasta riippuen kolme tai neljä omaa merkkiä peräkkäin vaaka-, pysty- tai diagonaalisuuntaan. Ensimmäisenä tavoitteen saavuttanut voittaa ja peli loppuu.

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/voitto.png" width="640">

### Ultimate ristinolla

[Säännöt englanninkielisessä wikipediassa](https://en.wikipedia.org/wiki/Ultimate_tic-tac-toe)

Peliä pelataan yhdeksällä 3x3 muotoon järjestetyllä 3x3 ruudukolla. Jokaisessa ruudukossa pelataan omaa ristinollaansa ja näiden voitoista yritetään kerätä suureen ruudukkoon voittosuora.
Peli alkaa keskimmäisestä ruudukosta ja seuraava pelattava ruudukko määräytyy sen mukaan, mihin pikkuruudukon ruutuun merkki pelattiin. Esimerkiksi vasempaan alakulmaan missä tahansa pikkuruudukossa pelattu merkki siirtää seuraavan vuoron pelattavaksi vasemman alakulman ruudukkoon. 

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/ultimate1.png" width="640">

Jos tämä ruudukko on täynnä tai voitettu, saa seuraavan siirron pelata mihin tahansa ei-täyteen, ei-voitettuun ruudukkoon.

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/ultimate2.png" width="640">

Mahdolliset siirrot on pelissä merkattu vihreällä ja loppuun pelatut ruudukot punaisella taustalla.

#### Voittaminen

Pelin voittaa se pelaaja, joka ensin saa muodostettua vaaka, pysty tai vinosuoran omista pikkuruudukkovoitoistaan suureen ruudukkoon.

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/ultimate3.png" width="640">


### Pelin lopettaminen

Pelin voi lopettaa milloin tahansa sulkemalla ikkuna tai palaamalla alkuvalikkoon vasemman alakulman painikkeesta.


