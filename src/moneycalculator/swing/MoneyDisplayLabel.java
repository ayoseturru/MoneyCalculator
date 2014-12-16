package moneycalculator.swing;

import javax.swing.JLabel;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDisplay;

class MoneyDisplayLabel extends JLabel implements MoneyDisplay {

    public MoneyDisplayLabel() {
        super();
    }

    @Override
    public void reset() {
        super.setText("");
    }

    @Override
    public void showMoney(Money money) {
        super.setText("Result: " + writeMoney(money));
    }
    
    private String writeMoney(Money money) {
       if(String.valueOf(money.getAmount()).contains(".") && money.getAmount() != 0.0) {
            return(String.valueOf(money.getAmount()).substring(0, String.valueOf(money.getAmount()).indexOf(".") + 3)
            + " " + money.getCurrency().getCode());
        } else {
            return (String.valueOf(money.getAmount()) + "0 " + money.getCurrency().getCode());
        }
    }
    
}
