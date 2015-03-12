package com.example.mybudget;


import android.content.Context;
import android.util.Log;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Reads a JSON file for data
 * Version 1.0.0 - 27/11/14 - Liam Grant
 */


public class JsonReader
{
    private ArrayList<Budget> budgetList;
    private Context context;

    public JsonReader(Context context)
    {
        this.context = context;
        budgetList = new ArrayList<Budget>();
    }

    public ArrayList<Budget> loadData()
    {
        try
        {
            JSONParser parser = new JSONParser();
            String filename = "my_budget";
            String read;
            StringBuilder builder = new StringBuilder("");
            
            try
            {
            	FileInputStream fis = context.openFileInput(filename);
                Log.d("asd", fis.toString());
                InputStreamReader isr = new InputStreamReader(fis);

                BufferedReader bufferedReader = new BufferedReader(isr);
                

                while((read = bufferedReader.readLine()) != null) {
                    builder.append(read);
                }
                bufferedReader.close();
            }
            catch(FileNotFoundException e)
            {
            	Log.d("NO FILE", "No my_budget file");
            }

            if(builder.toString() != "")
            {
                JSONArray budgets = (JSONArray) parser.parse(builder.toString());

                for (Object budgetObject : budgets)
                {
                    JSONObject budget = (JSONObject) budgetObject;

                    String budgetName = (String) budget.get("name");
                    double budgetInitial = Double.parseDouble(budget.get("initialAmount").toString());
                    double budgetCurrent = Double.parseDouble(budget.get("currentRemaining").toString());

                    Budget budgetObj = new Budget(budgetName, budgetInitial, budgetCurrent);

                    JSONArray expenses = (JSONArray) budget.get("expense");
                    JSONArray incomes = (JSONArray) budget.get("income");

                    for (Object expenseObject : expenses)
                    {
                        JSONObject expense = (JSONObject) expenseObject;

                        String expenseName = (String) expense.get("name");
                        if(expenseName == null || expenseName == "")
                        {
                            break;
                        }
                        String expenseCategory = (String) expense.get("category");
                        String expenseLengthType = (String) expense.get("lengthtype");
                        Boolean isRecurringExpense = (Boolean) expense.get("recurring");
                        double lengthExpense = Double.parseDouble(expense.get("length").toString());
                        double costExpense = Double.parseDouble(expense.get("cost").toString());

                        Expense expenseObj = new Expense(expenseName, expenseCategory, expenseLengthType, isRecurringExpense, lengthExpense, costExpense);

                        budgetObj.addExpenses(expenseObj);
                    }

                    for (Object incomeObject : incomes)
                    {
                        JSONObject income = (JSONObject) incomeObject;

                        String incomeName = (String) income.get("name");
                        if(incomeName == null || incomeName == "")
                        {
                            break;
                        }
                        String incomeCategory = (String) income.get("category");
                        String incomeLengthType = (String) income.get("lengthtype");
                        Boolean isRecurringIncome = (Boolean) income.get("recurring");
                        double lengthIncome = Double.parseDouble(income.get("length").toString());
                        double costIncome = Double.parseDouble(income.get("cost").toString());

                        Income incomeObj = new Income(incomeName, incomeCategory, incomeLengthType, isRecurringIncome, lengthIncome, costIncome);

                        budgetObj.addIncomes(incomeObj);
                    }

                    budgetList.add(budgetObj);
                }
            }
            else
            {
                Budget b = new Budget("Example Budget", 999.99, 899.99);
                Expense e = new Expense("Example Bill", "Bills", "", false, 0, 12.99);
                Income i = new Income("Example Income", "Pay", "", false, 0, 199.99);
                b.addExpenses(e);
                b.addIncomes(i);

                budgetList.add(b);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return budgetList;
    }

}