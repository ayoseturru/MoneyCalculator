package money.calculator.swing;

import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import money.calculator.model.Currency;
import money.calculator.model.CurrencySet;
import money.calculator.model.Exchange;
import money.calculator.model.Money;
import money.calculator.ui.ExchangeDialog;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog { 
    private final CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
        setLayout(new FlowLayout(LEFT));
        createWidgets();
    }
    
    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(getAmount(), getFromCurrency()), getToCurrency());
    }

    private void createWidgets() {
        this.add(createAmountWidget());
        this.add(createFromCurrencyWidget());
        this.add(createToCurrencyWidget());
    }

    private JTextField createAmountWidget() {
        JTextField amount = new JTextField();
        amount.setColumns(20);
        this.amount = amount;
        return amount;
    }

    private JComboBox createFromCurrencyWidget() {
        Currency[] currencies = currencySet.getItems();
        Arrays.sort(currencies);
        JComboBox<Currency> combo = new JComboBox<Currency>(currencies);
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.DESELECTED) return;
                addCurrenciesToTargetCombobox();
            }

        });
        this.fromCurrency = combo;
        return combo;
    }

    private JComboBox createToCurrencyWidget() {
        JComboBox<Currency> combo = new JComboBox<Currency>();
        this.toCurrency = combo;
        addCurrenciesToTargetCombobox();
        return combo;
    }

    private double getAmount() {
        return Double.parseDouble(amount.getText());
    }
    
    private Currency getFromCurrency() {
        return fromCurrency.getItemAt(fromCurrency.getSelectedIndex());
    }
    
    private Currency getToCurrency() {
        return toCurrency.getItemAt(toCurrency.getSelectedIndex());
    }

    private void addCurrenciesToTargetCombobox() {
        toCurrency.removeAllItems();
        for (Currency currency : currencySet) {
            if (currency == getFromCurrency()) continue;
            toCurrency.addItem(currency);
        }
    }

    
}