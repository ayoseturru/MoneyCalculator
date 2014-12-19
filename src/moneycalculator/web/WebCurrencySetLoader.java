package moneycalculator.web;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.persistence.CurrencySetLoader;

public class WebCurrencySetLoader implements CurrencySetLoader{
    CurrencySet currencySet;

    public WebCurrencySetLoader() {
        currencySet = new CurrencySet();
    }
    
    @Override
    public CurrencySet load() {
        currencySet.add(new Currency("AUD", "Australian Dollar","$"));
        currencySet.add(new Currency("BGN","Bulgaria Lev","Лв"));
        currencySet.add(new Currency("BRL","Brazil Real","R$"));
        currencySet.add(new Currency("CAD","Canada Dollar","$"));
        currencySet.add(new Currency("CHF","Switzerland Franc","CHF"));
        currencySet.add(new Currency("CNY","China Yuan Renminbi","¥"));
        currencySet.add(new Currency("CZK","Czech Republic Koruna","Kč"));
        currencySet.add(new Currency("DKK","Denmark Krone","kr"));
        currencySet.add(new Currency("GBP","Great Britain Pound","£"));
        currencySet.add(new Currency("HKD","Hong Kong Dollar","$"));
        currencySet.add(new Currency("HRK","Croatia Kuna","kn"));
        currencySet.add(new Currency("HUF","Hungary Forint","Ft"));
        currencySet.add(new Currency("IDR","Indonesia Rupiah","Rp"));
        currencySet.add(new Currency("ILS","Israel Shekel","₪"));
        currencySet.add(new Currency("INR","India Rupee","I"));
        currencySet.add(new Currency("JPY","Japan Yen","¥"));
        currencySet.add(new Currency("KRW","Korea (South) Won","₩"));
        currencySet.add(new Currency("LTL","Lithuanian Litas","Lt"));
        currencySet.add(new Currency("MXN","Mexico Peso","L$"));
        currencySet.add(new Currency("MYR","Malaysia Ringgit","RM"));
        currencySet.add(new Currency("NOK","Norway Krone","kr"));
        currencySet.add(new Currency("NZD","New Zealand Dollar","$"));
        currencySet.add(new Currency("PHP","Philippines Peso","₱"));
        currencySet.add(new Currency("PLN","Poland Zloty","zł"));
        currencySet.add(new Currency("RON","Romania New Leu","lei"));
        currencySet.add(new Currency("RUB","Russia Ruble","py6"));
        currencySet.add(new Currency("SEK","Sweden Krona","KR"));
        currencySet.add(new Currency("SGD","Singapore Dollar","$"));
        currencySet.add(new Currency("THB","Thailand Baht","฿"));
        currencySet.add(new Currency("TRY","Turkey Lira","t"));
        currencySet.add(new Currency("USD","United States Dollar","$"));
        currencySet.add(new Currency("ZAR","South Africa Rand","R"));
        currencySet.add(new Currency("EUR","Euro Member Countries","€"));
        return currencySet;
    }
    
}
