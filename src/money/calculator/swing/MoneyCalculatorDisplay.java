package money.calculator.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import money.calculator.model.Money;

public class MoneyCalculatorDisplay extends JFrame{
    Money money;

    public MoneyCalculatorDisplay(Money money) {
        super();
        setDetails();
        createWidgets(money);
    }

    private void createWidgets(Money money) {
        MoneyCalculatorDisplay.this.add(new JLabel(writeMoney(money)),BorderLayout.WEST);
    }

    private void setDetails() {
        MoneyCalculatorDisplay.this.setDefaultCloseOperation(MoneyCalculatorDisplay.DISPOSE_ON_CLOSE);
        MoneyCalculatorDisplay.this.setSize(300,150);
        MoneyCalculatorDisplay.this.setTitle("Money Calcutar Display");
        MoneyCalculatorDisplay.this.setVisible(true);
    }
    
    private String writeMoney(Money money) {
       if(String.valueOf(money.getAmount()).indexOf(".") > 1) {
            return(String.valueOf(money.getAmount()).substring(0, String.valueOf(money.getAmount()).indexOf(".") + 3)
            + " " + money.getCurrency().getCode());
        } else {
            return (String.valueOf(money.getAmount()) + " " + money.getCurrency().getCode());
        }
    }
}
