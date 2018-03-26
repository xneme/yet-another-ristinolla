package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate kassa;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
        kassa = new Kassapaate();
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa != null);
    }

    @Test
    public void konstruktoriAsettaaKortinSaldonOikein() {
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void konstruktoriAsettaaKassanSaldonOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void myytyjaEdullisiaAlussaNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjaMaukkaitaAlussaNolla() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortinToStringToimiiOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(2500);
        assertEquals(3500, kortti.saldo());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(20000);
        assertEquals(15000, kortti.saldo());
    }

    @Test
    public void negatiivinenLatausEiMuutaKortinSaldoa() {
        kortti.lataaRahaa(-500);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void otaRahaaVahentaaSaldoaOikein() {
        kortti.otaRahaa(500);
        assertEquals(500, kortti.saldo());
    }

    @Test
    public void otaRahaaPalauttaaOikeanArvon() {
        assertEquals(true, kortti.otaRahaa(500));
    }

    @Test
    public void otaRahaaToimiiMinimilla() {
        kortti.otaRahaa(1000);
        assertEquals(0, kortti.saldo());
    }

    @Test
    public void otaRahaaEiVieSaldoaNegatiiviseksi() {
        kortti.otaRahaa(2000);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kassa.syoEdullisesti(kortti);

        assertEquals(760, kortti.saldo());
    }

    @Test
    public void syoEdullisestiPalauttaaOikeanArvon() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void syoEdullisestiKirjautuuMyytyihin() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);

        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void liianVahallaSaldollaEiVoiSyodaEdullisesti() {
        kortti = new Maksukortti(100);
        assertEquals(false, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void kortillaMyymatonEdullinenEiKasvataMyytyja() {
        kortti = new Maksukortti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
     @Test
    public void kortillaMyymatonMaukasEiKasvataMyytyja() {
        kortti = new Maksukortti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);

        assertEquals(100, kortti.saldo());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kassa.syoMaukkaasti(kortti);

        assertEquals(600, kortti.saldo());
    }

    @Test
    public void syoMaukkaastiPalauttaaOikeanArvon() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void syoMaukaastiKirjautuuMyytyihin() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void liianVahallaSaldollaEiVoiSyodaMaukkaasti() {
        kortti = new Maksukortti(100);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void syoMaukkastiEiVieSaldoaNegatiiviseksi() {
        kortti = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti);

        assertEquals(100, kortti.saldo());
    }

    @Test
    public void minimiSaldollaVoiSyodaEdullisesti() {
        kortti = new Maksukortti(250);

        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void minimiSaldollaVoiSyodaMaukkaasti() {
        kortti = new Maksukortti(400);

        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void edullisenVoiMaksaaKateisella() {
        kassa.syoEdullisesti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void edullisenKateisMaksuPalauttaaOikein() {
        kassa.syoEdullisesti(500);
        assertEquals(260, kassa.syoEdullisesti(500));
    }

    @Test
    public void edullisenKateismaksuKasvattaaKassaaOikein() {
        kassa.syoEdullisesti(500);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void edullisenVoiMaksaaTasarahalla() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanVoiMaksaaKateisella() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void maukkaanKateisMaksuPalauttaaOikein() {
        kassa.syoMaukkaasti(500);
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void maukkaanKateismaksuKasvattaaKassaaOikein() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void maukkaanVoiMaksaaTasarahalla() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinLataaminenKasvattaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void kortinLataaminenKasvattaaKassaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLataaminenEiOnnistuNegatiivisella() {
        kassa.lataaRahaaKortille(kortti, -1000);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void edullisenKateismaksuPalauttaaLiianPienenMaksun() {
        assertEquals(100, kassa.syoEdullisesti(100));
    }
    
    @Test
    public void edullistaEiVoiOstaaLiianVahallaRahalla() {
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myymatonEdullinenEiKasvataKassanArvoa() {
        kassa.syoEdullisesti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaanKateismaksuPalauttaaLiianPienenMaksun() {
        assertEquals(100, kassa.syoMaukkaasti(100));
    }
    
    @Test
    public void maukastaEiVoiOstaaLiianVahallaRahalla() {
        kassa.syoMaukkaasti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
     @Test
    public void myymatonMaukasEiKasvataKassanArvoa() {
        kassa.syoMaukkaasti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
}
