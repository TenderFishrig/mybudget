package com.example.mybudget;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Liam Grant on 24/02/2015.
 */
public class BudgetControl
{
    private ArrayList<Budget> budgets;
    private Context context;

    public BudgetControl (Context context)
    {
        this.context = context;
    }

    public void readData()
    {
    	try
    	{
    		JsonReader jRead = new JsonReader(context);
            budgets = jRead.loadData();
    	}
    	catch(VerifyError v)
    	{
    		v.getCause();
    		v.printStackTrace();
    	}
        
    }

    public void writeData()
    {
        JsonWriter jWrite = new JsonWriter(budgets);
        jWrite.saveData(context);
    }

    public void deleteData()
    {
        JsonWriter jWrite = new JsonWriter();
        jWrite.clearData(context);
    }

    public String getBudgetName(int index)
    {
        String budgetName = budgets.get(index).getName();

        return budgetName;
    }

    public String getBudgetAmount(int index)
    {
        String budgetAmount = Double.toString(budgets.get(index).getCurrentRemaining());

        return budgetAmount;
    }

    public ArrayList<String> getBudgetListName()
    {
        ArrayList<String> budgetNames = new ArrayList<String>();
        for (Budget budget : budgets)
        {
            budgetNames.add(budget.getName());
        }

        return budgetNames;
    }

    public void addNewBudget(String budgetName, Double budgetAmount)
    {
        Budget budget = new Budget(budgetName, budgetAmount);
        budgets.add(budget);
    }
}
