# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on ristonolla-peli, jossa perinteisen ristinollan lisäksi voi pelata pelin muitakin variaatioita. Aluksi perinteistä erikokoisilla kentillä ja Ultimate tic-tac-toe peliä. Myöhemmin matemaattisempia versioita, kuten toruksen tai Kleinin pullon pinnalla pelattavaa versiota.

## Käyttäjät

Sovelluksessa on vain yhdenlaisia käyttäjiä, _pelaajia_.

## Käyttöliittymäluonnos

Sovelluksessa on alkuvalikko, josta valitaan haluttu pelin variaatio tai vanhojen pelien katselu. Pelin loputtua voidaan pelattu peli tallentaa tietokantaa, aloittaa uusi samantyyppinen peli, tai palata alkuvalikkoon.

## Perusversion tarjoama toiminnallisuus

Perusversiossa pelissä voi pelata perinteistä ristinollaa erikokoisilla kentillä, sekä [Ultimate tic-tac-toe](https://en.wikipedia.org/wiki/Ultimate_tic-tac-toe) ristinollaa kahdestaa.

## Jatkokehitysideoita

Perusversion sovelluslogiikka on rakennettu helposti skaalattavaksi, joten siihen olisi helppo lisätä uusia pelimuotoja hyvin pienellä määrällä lisäkoodausta. Järjestelmää voidaan laajentaa ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Pelikentän koon vapaa valinta
- Pelattujen pelien tallennus ja uudelleen katselu
- Pelaajakohtaiset tilastot
- [Ristinollaa nauhalla/toruksella/Kleinin pullolla](https://blogs.helsinki.fi/summamutikka/files/2015/09/Avaruuden-muoto.pdf)
- [Quantum tic-tac-toe](https://en.wikipedia.org/wiki/Quantum_tic-tac-toe)
