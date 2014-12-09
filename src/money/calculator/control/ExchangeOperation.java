package money.calculator.control;

import money.calculator.loader.ExchangeRateLoader;
import money.calculator.model.ExchangeRate;
import money.calculator.process.Exchanger;
import money.calculator.ui.ExchangeDialog;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute() {
        System.out.println(dialog.getExchange().getMoney().getAmount());
        System.out.println(dialog.getExchange().getMoney().getCurrency().getCode());
        System.out.println(dialog.getExchange().getCurrency().getCode());
        ExchangeRate exchangeRate = new ExchangeRateLoader().load(dialog.getExchange().getMoney().getCurrency(), dialog.getExchange().getCurrency());
        Exchanger exchanger = new Exchanger(dialog.getExchange().getMoney(),exchangeRate);
        System.out.println(exchanger.calculate().getAmount() + exchanger.calculate().getCurrency().getCode());
    }
    
}
