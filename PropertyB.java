public class PropertyB
{
  private int cardType;
  private int cardValue;
  
  public PropertyB(int cardType,int cardValue)
  {
    this.cardType=cardType;
    this.cardValue=cardValue;
  }
  public int GetCardType()
  {
    return this.cardType;
    
  }
  public int GetCardValue()
   {
     return this.cardValue;
   }
}