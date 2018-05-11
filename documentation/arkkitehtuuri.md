# Arkkitehtuurikuvaus

## Rakenne

Koodin kolmikerroksinen pakkausrakenne on seuraava:

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/pakkausrakenne.png">

## Käyttöliittymä

Käyttöliittymä sisältää neljä eri näkymää:
- Menu
- 3x3 ristinolla
- 10x10 ristinolla
- Ultimate ristinolla

Jokainen on toteutettu omana scene-olionaan ja näistä on kerrallaan näkyvissa yksi sovelluksen stagessa.

Käyttöliittymä on eristetty sovelluslogiikasta GameLogic-rajapinnan kautta, jonka metodeita käyttäen logiikkaa ohjataa.

## Sovelluslogiikka

Yksittäisen pelin logiikka suoritetaan FreeSizeGame- tai UltimateGame-luokassa, jotka toteuttavat GameLogic-rajapinnan. Luokat käyttävät BoardChecker-luokkaa sisäisen array-mallisen pelilautansa tarkistamiseen ja pitävät muuttujissa tallessa esimerkiksi tietoa vuorosta ja mahdollisesta pelin voittajasta.

Luokka/pakkauskaavio:

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/luokkakaavio.png">

## Päätoiminnallisuudet

### Siirto tyhjään ruutuun

Tyhjää ruutua klikatessa etenee sovelluksen kontrolli seuraavasti:

<img src="https://raw.githubusercontent.com/xneme/yet-another-ristinolla/master/documentation/sekvenssi_siirto.png">

## Ohjelman rakenteeseen jääneet heikkoudet

### logiikka

Logiikkaluokat säilyttävät tiedot pelilaudan tilanteesta int arrayssa, joka annetaan BoardChecker-luokalle tutkittavaksi, joka on hieman liian C-tyylinen lähestymistapa. Parempi olisi luoda Board-luokka, jonka metodeita käyttämällä saataisiin suoraan pelilaudan tila. Erityisesti tämä hyödyttäisi Ultimate-pelimoodia, jossa pelilauta koostuu yhdeksästä pienemmästä pelilaudasta.
