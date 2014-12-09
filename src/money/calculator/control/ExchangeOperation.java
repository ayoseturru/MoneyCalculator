package money.calculator.control;

import money.calculator.persistence.ExchangeRateLoader;
import money.calculator.model.Currency;
import money.calculator.model.Exchange;
import money.calculator.model.ExchangeRate;
import money.calculator.model.Money;
import money.calculator.process.Exchanger;
import money.calculator.swing.MoneyCalculatorDisplay;
import money.calculator.ui.ExchangeDialog;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute() {
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = readExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money = exchangeMoney(exchange.getMoney(),exchangeRate);
        displayMoney(money);
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

    private void displayMoney(Money money) {
        new MoneyCalculatorDisplay(money);
        showMoney(money);
    }

    private void showMoney(Money money) {
       if(String.valueOf(money.getAmount()).indexOf(".") > 1) {
            System.out.println(String.valueOf(money.getAmount()).substring(0, String.valueOf(money.getAmount()).indexOf(".") + 3)
            + " " + money.getCurrency().getCode());
        } else {
            System.out.println(String.valueOf(money.getAmount()) + " " + money.getCurrency().getCode());
        }
    }
}
