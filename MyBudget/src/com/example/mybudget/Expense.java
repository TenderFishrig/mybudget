package com.example.mybudget;


public class Expense
{
    private String name, category, lengthType;
    private Boolean isRecurring;
    private double lengthRecurring;
    private double cost;

    public Expense(String nameExpense, String categoryExpense, String lengthTypeExpense, Boolean isRecurringExpense, double lengthRecurringExpense, double costExpense)
    {
        name = nameExpense;
        category = nameExpense;
        lengthType = lengthTypeExpense;
        isRecurring = isRecurringExpense;
        lengthRecurring = lengthRecurringExpense;
        cost = costExpense;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String nameExpense)
    {
        name = nameExpense;
    }

    /**
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String categoryExpense)
    {
        category = categoryExpense;
    }

    /**
     * @return the lengthType
     */
    public String getLengthType()
    {
        return lengthType;
    }

    /**
     * @param lengthType the lengthType to set
     */
    public void setLengthType(String lengthTypeExpense)
    {
        lengthType = lengthTypeExpense;
    }

    /**
     * @return the isRecurring
     */
    public Boolean isRecurring()
    {
        return isRecurring;
    }

    /**
     * @param isRecurring the isRecurring to set
     */
    public void setIsRecurring(Boolean isRecurringExpense)
    {
        isRecurring = isRecurringExpense;
    }

    /**
     * @return the lengthRecurring
     */
    public double getLengthRecurring()
    {
        return lengthRecurring;
    }

    /**
     * @param lengthRecurring the lengthRecurring to set
     */
    public void setLengthRecurring(long lengthRecurringExpense)
    {
        lengthRecurring = lengthRecurringExpense;
    }

    /**
     * @return the cost
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double costExpense)
    {
        cost = costExpense;
    }


}
