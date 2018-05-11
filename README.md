# Ohjelmistotuotannon menetelmät-harjoitustyö
_Lisää **ristinollaa** ohjaajien iloksi._

## Yet-another-ristinolla
3x3 ja 10x10 perinteinen ristinolla sekä Ultimate ristinolla graafisella käyttöliittymällä.

[Käyttöohje](/documentation/kayttoohje.md)

[Alustava määrittelydokumentti](/documentation/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](/documentation/arkkitehtuuri.md)

[Tuntikirjanpito](/documentation/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/xneme/yet-another-ristinolla/releases/tag/viikko5)

[Viikko 6](https://github.com/xneme/yet-another-ristinolla/releases/tag/viikko6)

[Loppupalautus](https://github.com/xneme/yet-another-ristinolla/releases/tag/loppupalautus)

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

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/xneme/yet-another-ristinolla/blob/master/yet-another-ristinolla/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
