package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencySetLoader {
    private final CurrencySet currencySet;
    
    public CurrencySetLoader() {
        currencySet = new CurrencySet();
    }
    
    public CurrencySet load() {
        currencySet.add(new Currency("EUR","Euro","€"));
        currencySet.add(new Currency("USD", "United States Dollar", "$"));
        currencySet.add(new Currency("AUS", "Australian Dollar", "$"));
        currencySet.add(new Currency("BZD", "Belice Dollar", "BZ$"));
        currencySet.add(new Currency("GBP", "Great Britain Pound", "£"));
        currencySet.add(new Currency("ARS", "Argentine Peso", "$"));
        currencySet.add(new Currency("BRL", "Brazilian Real", "R$"));
        currencySet.add(new Currency("CAD", "Canadian Dollar", "C$"));
        currencySet.add(new Currency("CNY", "Chinese Yuan", "¥"));
        currencySet.add(new Currency("JPY", "Japanese Yen", "¥"));
        currencySet.add(new Currency("CHF", "Swiss Franc", "CHF"));
        currencySet.add(new Currency("ZAR", "Southadrican Rand", "ZAR"));
        return currencySet;
    }
}
