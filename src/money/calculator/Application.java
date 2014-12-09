package money.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import money.calculator.control.ExchangeOperation;
import money.calculator.persistence.CurrencySetLoader;
import money.calculator.model.CurrencySet;
import money.calculator.swing.ApplicationFrame;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new CurrencySetLoader().load();
        final ApplicationFrame frame = new ApplicationFrame(currencySet);
        frame.register("Calcular", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ExchangeOperation(frame.getDialog()).execute();
            }
            
        });
    }
    
}