public class PlayerB 
{
  public final static char PLAYER_B='B';
  public final static int EMPTY=0;
  private int cardType;
  private int cardValue;
  public PlayerB()
  {
  }
  public PlayerB(int cardType,int cardValue)
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