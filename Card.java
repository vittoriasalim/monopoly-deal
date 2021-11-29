public class Card 
{
  private int cardType;
  private int maxCard;
  private int cardValue;
  public final static int COLUMN=4;

  public Card(int cardType)
  {
    this.cardType = cardType;
    if (this.cardType== Special.DEBT_COLLECTOR||this.cardType== Special.FORCED_DEAL||this.cardType== Special.HOUSE||this.cardType== Special.SLY_DEAL||this.cardType==NormalProperty.YELLOW||this.cardType== NormalProperty.RED||this.cardType== WildcardProperty.YELLOW_RED||this.cardType== Rent.ALL_COLOUR||this.cardType== Money.THREE_M)
    {
      this.cardValue=3;
    }
    else if (this.cardType== Special.DEAL_BREAKER||this.cardType== Money.FIVE_M)
    {
      this.cardValue=5;
    }
    else if (this.cardType==Special.DOUBLE_RENT||this.cardType== Special.PASS_GO||this.cardType== NormalProperty.BROWN||this.cardType== NormalProperty.LIGHT_BLUE||this.cardType== WildcardProperty.LIGHTBLUE_BROWN||this.cardType== Rent.DARKBLUE_GREEN||this.cardType== Rent.ORANGE_PINK||this.cardType== Rent.LIGHTBLUE_BROWN||this.cardType== Rent.BLACK_LIGHTGREEN||this.cardType== Rent.RED_YELLOW||this.cardType== Money.ONE_M)
    {
      this.cardValue=1;
    }
    else if (this.cardType== Special.JUST_SAY_NO||this.cardType== Special.HOTEL||this.cardType==NormalProperty.DARK_GREEN||this.cardType== NormalProperty.DARK_BLUE||this.cardType==WildcardProperty.DARKBLUE_GREEN||this.cardType==WildcardProperty.GREEN_BLACK||this.cardType==WildcardProperty.LIGHTBLUE_BLACK||this.cardType== Money.FOUR_M)
    {
      this.cardValue=4;
    }
    else if (this.cardType== Special.BIRTHDAY||this.cardType== NormalProperty.ORANGE||this.cardType== NormalProperty.PINK||this.cardType== NormalProperty.LIGHT_GREEN||this.cardType== NormalProperty.BLACK||this.cardType== WildcardProperty.ORANGE_PINK||this.cardType== WildcardProperty.LIGHTGREEN_BLACK||this.cardType== Money.TWO_M)
    {
      this.cardValue=2;
    }
    else if (this.cardType==Money.TEN_M)
    {
      this.cardValue=10;
    }
    //for card types that can only have one maximum card.
    if (this.cardType == WildcardProperty.DARKBLUE_GREEN || this.cardType == WildcardProperty.LIGHTBLUE_BROWN || (this.cardType >= WildcardProperty.GREEN_BLACK && this.cardType <= WildcardProperty.LIGHTGREEN_BLACK) || this.cardType == Money.TEN_M)
    {
      maxCard = 1;
    }
    
    //for card types that can only have two maximum cards.
    else if (this.cardType == Special.DEAL_BREAKER || this.cardType == Special.DOUBLE_RENT || this.cardType == NormalProperty.BROWN || this.cardType == NormalProperty.DARK_BLUE || this.cardType == NormalProperty.DARK_GREEN || this.cardType == WildcardProperty.ALL_COLOUR || this.cardType == 24 || this.cardType == 28
               || (this.cardType >= Rent.DARKBLUE_GREEN && this.cardType <= Rent.RED_YELLOW) || this.cardType == 39)
    {
      maxCard = 2;
    }
    
    //For card type that can only have three maximum cards.
    else if (cardType == 2 || (cardType >= 5 && cardType <= 8)|| cardType == 10 || (cardType >= 13 && cardType <= 16) || cardType == 18 || cardType == 29
               || cardType == 37 || cardType == 38)
    {
      maxCard = 3;
    }
    
    else if (cardType == 4 || cardType == 17)
    {
      maxCard = 4;
    }
    
    else if (cardType == 36)
    {
      maxCard = 5;
    }
    
    else if (cardType == 35)
    {
      maxCard = 6;
    }
    
    else 
    {
      maxCard = 10;
    }
  }
  public int GetCardType()
  {
    return this.cardType;
  }
  public void SetCardType(int cardType)
  {
    this.cardType = cardType;
  }
  public int GetMaxCards()
  {
    return maxCard;
  }
  public int GetCardValue()
  {
    return this.cardValue;
  }
  
}