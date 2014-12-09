package money.calculator.persistence;

import money.calculator.model.Currency;

public interface ExchangeRateLoader {
    public double calculateRate(Currency from,Currency to);
}
