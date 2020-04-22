package android.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;

        //Add a Toasts message
        if( quantity>100 )
        {
            quantity = 100;
            Toast.makeText(this, "You can to order max 100 Coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;

        //Add a Toasts message
        if( quantity<1 )
        {
            quantity = 1;
            Toast.makeText(this, "You have to order atleast 1 Coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //Edit the user's name
        EditText textName = (EditText) findViewById(R.id.name_field);
        String name = textName.getText().toString();

        //Edit the user's address
        EditText textAddress = (EditText) findViewById(R.id.address_field);
        String address = textAddress.getText().toString();

        //Figure out if user wants whipped cream toppings
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if user wants chocolate toppings
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, address, price, hasWhippedCream, hasChocolate) ;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email app should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    /**
     *  Calculate the price of the order.
     *
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 0;

        // Add $1 if user wants to add Whipped cream
        if(addWhippedCream)
            basePrice += 1;

        // Add $1 if user wants to add Chocolate
        if(addChocolate)
            basePrice += 2;

        return quantity * 5 + basePrice;

    }

    /**
     *  Create summary of the order.
     *
     *
     */
    private String createOrderSummary(String name, String address, int price,
                                      boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n";
        priceMessage += getString(R.string.order_summary_address, address);
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate Cream? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\n"+ getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method displays the quantity on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


}
