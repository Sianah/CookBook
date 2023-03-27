public class Recipe extends Ingredients
{//private member variables
    private String mRName;
//    private String mIName;
//    private String mDescription;

    //constructor
    public Recipe(String RName, String IName, String Description,String Unit, String Amount)//ask why professor put "(none)" and if I can still do this
    {
        mRName = RName;
        mIName = IName;
        mDescription = Description;
        mUnit = Unit;
        mAmount = Amount;
    }
    //accessor methods
    public String getRName()
    {
        return mRName;
    }
    public void setRName(String r)//ask to explain setters and getters(ask what primitive type means)
                                    //null only works with strings and objects; null = nothing
                                    //ask how to call setRName, and getRName()
    {
        while (r == null) {
            System.out.println("YOU MUST INPUT A NAME. PLEASE TRY AGAIN.");

        }
        mRName = r;
    }
    public String getAmount()//look over
    {
        return mAmount;
    }
    public void setAmount(String a){
        while(a == null) {
            System.out.println("YOU MUST INPUT A AMOUNT. PLEASE TRY AGAIN.");
        }
        mAmount = a;
    }
    public String getUnit()//look over
    {
        return mUnit;
    }
    public void setUnit(String u){
        while(u == null) {
            System.out.println("YOU MUST INPUT A UNIT. PLEASE TRY AGAIN.");
        }
        mUnit = u;
    }
    public String getIName()//look over
    {
        return mIName;
    }
    public void setIName(String i)
    {
        while (i == null) {
            System.out.println("YOU MUST INPUT A NAME. PLEASE TRY AGAIN.");
        }
        mIName = i;
    }
    public String getDescription(){
        return mDescription;
    }
    public void setDescription(String d)
    {
        while (d == null)
        {
            System.out.println("YOU MUST INPUT A RESPONSE. PLEASE TRY AGAIN");
        }
        mDescription = d;
    }
//overriding whole number, numerator, and denominator

public String toString()
{
    return "Recipe name: " + mRName + "/nIngredient : " + mIName + " Description: " + mDescription;
}
}
