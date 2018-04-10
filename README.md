# Ohjelmistotuotannon menetelmät-harjoitustyö
_Lisää **ristinollaa** ohjaajien iloksi._

## Yet-another-ristinolla
3x3 perinteinen ristinolla tekstikäyttöliittymällä.

[Alustava määrittelydokumentti](/documentation/vaatimusmaarittely.md)
[Tuntikirjanpito](/documentation/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _yet-another-ristinolla-1.0-SNAPSHOT.jar_
