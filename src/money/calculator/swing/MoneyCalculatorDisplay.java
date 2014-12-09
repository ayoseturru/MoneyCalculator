package money.calculator.swing;

import javax.swing.JFrame;
import money.calculator.model.Money;

public class MoneyCalculatorDisplay extends JFrame{
    Money money;

    public MoneyCalculatorDisplay(Money money) {
        super();
        this.setDefaultCloseOperation(MoneyCalculatorDisplay.this.EXIT_ON_CLOSE);
        this.setSize(550,500);
        this.setTitle("Money Calcutar Display");
        this.setVisible(true);
    }
}
