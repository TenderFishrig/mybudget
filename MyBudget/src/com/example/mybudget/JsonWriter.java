package com.example.mybudget;

import android.content.Context;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class JsonWriter
{
    private ArrayList<Budget> dataOut;

    public JsonWriter(ArrayList<Budget> budgetList)
    {
        dataOut = budgetList;
    }
    public JsonWriter() {};

    public void saveData(Context context)
    {
        JSONArray budgets = new JSONArray();

        for (Budget budget : dataOut)
        {
            if(budget.getName() != "Example Budget")
            {
                JSONObject budgetObj = new JSONObject();
                budgetObj.put("name", budget.getName());
                budgetObj.put("initialAmount", budget.getInitialAmount());
                budgetObj.put("currentRemaining", budget.getCurrentRemaining());

                ArrayList<Expense> expensesOut = budget.getExpenses();
                if(expensesOut != null)
                {
                    JSONArray expenses = new JSONArray();

                    for (Expense expense : expensesOut)
                    {
                        JSONObject expenseObj = new JSONObject();

                        expenseObj.put("name", expense.getName());
                        expenseObj.put("category", expense.getCategory());
                        expenseObj.put("recurring", expense.isRecurring());
                        expenseObj.put("lengthtype", expense.getLengthType());
                        expenseObj.put("length", expense.getLengthRecurring());
                        expenseObj.put("cost", expense.getCost());

                        expenses.add(expenseObj);
                    }

                    budgetObj.put("expense", expenses);
                }

                ArrayList<Income> incomesOut = budget.getIncomes();
                if(incomesOut != null)
                {
                    JSONArray incomes = new JSONArray();

                    for (Income income : incomesOut)
                    {
                        JSONObject incomeObj = new JSONObject();

                        incomeObj.put("name", income.getName());
                        incomeObj.put("category", income.getCategory());
                        incomeObj.put("recurring", income.isRecurring());
                        incomeObj.put("lengthtype", income.getLengthType());
                        incomeObj.put("length", income.getLengthRecurring());
                        incomeObj.put("cost", income.getCost());

                        incomes.add(incomeObj);
                    }

                    budgetObj.put("income", incomes);
                }

                budgets.add(budgetObj);
            }
        }

        String filename = "my_budget";
        String jsonString = budgets.toJSONString();
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
            outputStream.write(jsonString.getBytes());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void clearData(Context context)
    {
        String filename = "my_budget";
        String jsonString = "";
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
            outputStream.write(jsonString.getBytes());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
