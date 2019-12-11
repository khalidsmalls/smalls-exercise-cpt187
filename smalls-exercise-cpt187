package edu.cpt187.smalls.participation;

public class SodOrder 
{
	private static final String ITEM_NAME_PREMIUM = "Premium Sod";
	private static final String ITEM_NAME_SPECIAL = "Special Sod";
	private static final String ITEM_NAME_BASIC = "Basic Sod";
	private static final double ITEM_PRICE_PREMIUM = 9.95;
	private static final double ITEM_PRICE_SPECIAL = 5.95;
	private static final double ITEM_PRICE_BASIC = 1.95;
	private static final String DISCOUNT_NAME_MEMBER = "Member";
	private static final String DISCOUNT_NAME_SENIOR = "Senior";
	private static final String DISCOUNT_NAME_NONE = "No Discount";
	private static final double DISCOUNT_RATE_MEMBER = 0.25;
	private static final double DISCOUNT_RATE_SENIOR = 0.15;
	private static final double DISCOUNT_RATE_NONE = 0.0;
	private static final double TAX_RATE = .075;
	
	private String itemName = ""; 
	private double itemPrice = 0.0;
	private double discountRate = 0.0;
	private int howMany = 0; 
	
	//sod order constructor
	public SodOrder () 
	{
	}//end of sod order constructor
	
	//set item name
	public void setItemName(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			itemName = ITEM_NAME_PREMIUM; 
		}
		else if(borrowedMenuSelection == 'B') 
		{
			itemName = ITEM_NAME_SPECIAL; 
		}
		else 
		{
			itemName = ITEM_NAME_BASIC;
		}
	}//END of setItemName
	
	//set item price
	public void setItemPrice(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			itemPrice = ITEM_PRICE_PREMIUM;
		}
		else if(borrowedMenuSelection == 'B') 
		{
			itemPrice = ITEM_PRICE_SPECIAL; 
		}
		else 
		{
			itemPrice = ITEM_PRICE_BASIC;
		}
	}//END of setItemPrice
	
	
	public void setHowMany(int borrowedHowMany) 
	{
		howMany = borrowedHowMany; 
	}//END of setHowMany
	
	
	public void setDiscountRate(char borrowedMenuSelection) 
	{
		if(borrowedMenuSelection == 'A') 
		{
			discountRate = DISCOUNT_RATE_MEMBER; 
		}
		else if(borrowedMenuSelection == 'B') 
		{
			discountRate = DISCOUNT_RATE_SENIOR;
		}
		else 
		{
			discountRate = DISCOUNT_RATE_NONE;
		}
	}
	public String getItemName() 
	{
		return itemName;
	}
	public double getItemPrice() 
	{
		return itemPrice;
	}
	public int getHowMany() 
	{
		return howMany;
	}
	public double getDiscountRate() 
	{
		return discountRate;
	}
	public double getDiscountAmt() 
	{
		return discountRate * itemPrice;
	}
	public double getDiscountPrice() 
	{
		return  itemPrice - getDiscountAmt();
	}
	public double getSubTotal() 
	{
		return howMany * getDiscountPrice();
	}
	public double getTaxRate() 
	{
		return TAX_RATE;
	}
	public double getTaxAmt() 
	{
		return getSubTotal() * TAX_RATE;
	}
	public double getTotalCost() 
	{
		return getSubTotal() + getTaxAmt();
	}
	public String getItemNamePremium() 
	{
		return ITEM_NAME_PREMIUM;
	}
	public String getItemNameSpecial() 
	{
		return ITEM_NAME_SPECIAL;
	}
	public String getItemNameBasic() 
	{
		return ITEM_NAME_BASIC;
	}
	public double getItemPricePremium() 
	{
		return ITEM_PRICE_PREMIUM; 
	}
	public double getItemPriceSpecial() 
	{
		return ITEM_PRICE_SPECIAL; 
	}
	public double getItemPriceBasic() 
	{
		return ITEM_PRICE_BASIC;
	}
	public String getDiscountNameMember() 
	{
		return DISCOUNT_NAME_MEMBER;
	}
	public String getDiscountNameSenior() 
	{
		return DISCOUNT_NAME_SENIOR;
	}
	public String getDiscountNameNone() 
	{
		return DISCOUNT_NAME_NONE;
	}
	public double getDiscountRateMember() 
	{
		return DISCOUNT_RATE_MEMBER;
	}
	public double getDiscountRateSenior() 
	{
		return DISCOUNT_RATE_SENIOR;
	}
	public double getDiscountRateNone() 
	{
		return DISCOUNT_RATE_NONE;
	}
}//END of class














