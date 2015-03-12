package com.example.mybudget;

import java.util.ArrayList;

/*************************************************************************
 * Budget class to store information on budgets.
 * @author Liam Grant U1470723
 * @version 1.0.0 - 27/11/2014
 *************************************************************************/

public class Budget
{
    //Fields
    private String name;
    private double initialAmount, currentRemaining;
    private ArrayList<Expense> expenses;
    private ArrayList<Income> incomes;

    //Constructor
    public Budget(String nameBudget, double initialAmountBudget)
    {
        name = nameBudget;
        initialAmount = initialAmountBudget;
        currentRemaining = initialAmountBudget;

        incomes = new ArrayList<Income>();
        expenses = new ArrayList<Expense>();

    }

    public Budget(String nameBudget, double initialAmountBudget, double currentRemainingAmount)
    {
        name = nameBudget;
        initialAmount = initialAmountBudget;
        currentRemaining = currentRemainingAmount;

        incomes = new ArrayList<Income>();
        expenses = new ArrayList<Expense>();

    }

    /**
     * @return budget name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the expenses
     */
    public ArrayList<Expense> getExpenses()
    {
        return expenses;
    }

    /**
     * @param Adds expensesBudget to expenses
     */
    public void addExpenses(Expense expensesBudget)
    {
        expenses.add(expensesBudget);
    }

    /**
     * @return the incomes
     */
    public ArrayList<Income> getIncomes()
    {
        return incomes;
    }

    /**
     * @param incomesBudget the incomes to set
     */
    public void addIncomes(Income incomesBudget)
    {
        incomes.add(incomesBudget);
    }

    /**
     * @return getInitialAmount
     */
    public double getInitialAmount()
    {
        return initialAmount;
    }

    /**
     * @return currentRemaining
     */
    public double getCurrentRemaining()
    {
        return currentRemaining;
    }

    /**
     * @param currentRemainingBudget sets current remaining budget
     */
    public void setCurrentRemaining(double currentRemainingBudget)
    {
        currentRemaining = currentRemainingBudget;
    }
}
