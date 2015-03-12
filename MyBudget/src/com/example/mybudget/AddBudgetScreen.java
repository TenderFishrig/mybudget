package com.example.mybudget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddBudgetScreen extends ActionBarActivity
{

    public BudgetControl bc;
    public Budget budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget_screen);

        bc = new BudgetControl(this.getApplicationContext());
        bc.readData();
    }

    public void saveBudgetsToStorage(View view)
    {
        EditText budgetAmountText = (EditText) findViewById(R.id.budgetAmountText);
        EditText budgetNameText = (EditText) findViewById(R.id.budgetNameText);
        String budgetName = budgetNameText.getText().toString();
        String budgetAmount = budgetAmountText.getText().toString();

        if(budgetName.isEmpty() || budgetAmount.isEmpty())
        {
            Toast.makeText(AddBudgetScreen.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double budgetAmountDouble = Double.parseDouble(budgetAmount);
            bc.addNewBudget(budgetName, budgetAmountDouble);
            bc.writeData();
            this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_budget_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
