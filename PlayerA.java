public class PlayerA 
{
  public final static char PLAYER_A ='A';
  private int cardType;
  private int cardValue;
  public PlayerA()
  {
  }
  public PlayerA(int cardType,int cardValue)
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