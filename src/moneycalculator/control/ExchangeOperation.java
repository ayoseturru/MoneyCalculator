package moneycalculator.control;

import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.model.Currency;
import moneycalculator.model.Exchange;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.process.Exchanger;
import moneycalculator.ui.ExchangeDialog;
import moneycalculator.ui.MoneyDisplay;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;
    private final MoneyDisplay money;

    public ExchangeOperation(ExchangeDialog dialog, MoneyDisplay money) {
        this.dialog = dialog;
        this.money = money;
    }
    
    public void execute() {
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = readExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money = exchangeMoney(exchange.getMoney(),exchangeRate);
        this.money.showMoney(money);
    }

    private Exchange readExchange() {
        return dialog.getExchange();
    }
    
     private ExchangeRate readExchangeRate(Currency from, Currency to) {
        return new ExchangeRateLoader().load(from,to);
    }
    
    private Money exchangeMoney(Money money, ExchangeRate exchangeRate) {
        return new Exchanger(money,exchangeRate).calculate();
    }

}
