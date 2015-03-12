package com.example.mybudget;


public class Income
{
    private String name, category, lengthType;
    private Boolean isRecurring;
    private double lengthRecurring;
    private double cost;

    public Income(String nameIncome, String categoryIncome, String lengthTypeIncome, Boolean isRecurringIncome, double lengthRecurringIncome, double costIncome)
    {
        name = nameIncome;
        category = nameIncome;
        lengthType = lengthTypeIncome;
        isRecurring = isRecurringIncome;
        lengthRecurring = lengthRecurringIncome;
        cost = costIncome;
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
    public void setName(String nameIncome)
    {
        name = nameIncome;
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
    public void setCategory(String categoryIncome)
    {
        category = categoryIncome;
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
    public void setLengthType(String lengthTypeIncome)
    {
        lengthType = lengthTypeIncome;
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
    public void setIsRecurring(Boolean isRecurringIncome)
    {
        isRecurring = isRecurringIncome;
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
    public void setLengthRecurring(long lengthRecurringIncome)
    {
        lengthRecurring = lengthRecurringIncome;
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
    public void setCost(double costIncome)
    {
        cost = costIncome;
    }


}
