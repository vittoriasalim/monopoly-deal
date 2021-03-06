public class Displayer
{
  private final static int LIMIT =10;
  public Displayer()
  {
    //default constructor
  }
  public void DisplayMainMenu()
  {
    System.out.println("------------------------------------");
    System.out.println("|          MONOPOLY DEALS          |");
    System.out.println("------------------------------------");
    System.out.println("Choose Player A or B ? ");
  }
  
  
  //if player has the same properties it will be allign at the same row
  //if it is different type of property it will be allign at different row
  //if it is special property it will be allign at any eligible row
  
  public void DisplayPlayerCardsA(PlayerA[] cardType)
  {
    
    for (int j =0 ;j<1;j++)
    {
      for(int a = 0 ; a<LIMIT;a++)
      {
        System.out.print("---------------"+" ");
      }
      System.out.println("");
      
      for(int b =0 ;b<LIMIT;b++)
      {
        if(cardType[b]==null||cardType[b].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");//cardtype
        }
        
        else
        {
          if (cardType[b].GetCardType()== Special.DEAL_BREAKER)
          {
            System.out.print("|DEAL.BREAKER |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.DEBT_COLLECTOR)
          {
            System.out.print("|DEBT.COLLECT |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.DOUBLE_RENT)
          {
            System.out.print("| DOUBLE.RENT |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.FORCED_DEAL)
          {
            System.out.print("| FORCED.DEAL |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.HOTEL)
          {
            System.out.print("|    HOTEL    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.HOUSE)
          {
            System.out.print("|    HOUSE    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.BIRTHDAY)
          {
            System.out.print("|  BIRTHDAY   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.JUST_SAY_NO)
          {
            System.out.print("| JUST.SAY.NO |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.PASS_GO)
          {
            System.out.print("|   PASS.GO   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.SLY_DEAL)
          {
            System.out.print("|  SLY.DEAL   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.BROWN)
          {
            System.out.print("|   BROWN     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.DARK_BLUE)
          {
            System.out.print("|  DARK.BLUE  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.DARK_GREEN)
          {
            System.out.print("|    GREEN    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.LIGHT_BLUE)
          {
            System.out.print("| LIGHT.BLUE  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.ORANGE)
          {
            System.out.print("|    ORANGE   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.PINK)
          {
            System.out.print("|    PINK     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.BLACK)
          {
            System.out.print("|    BLACK    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.RED)
          {
            System.out.print("|     RED     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.LIGHT_GREEN)
          {
            System.out.print("|   L.GREEN   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.YELLOW)
          {
            System.out.print("|    YELLOW   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.ALL_COLOUR)
          {
            System.out.print("|  ALL.COLOUR |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.DARKBLUE_GREEN)
          {
            System.out.print("| D.BLUE_GREEN|"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN)
          {
            System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK)
          {
            System.out.print("|L.GREEN_BLACK|"+" ");//cardtype
          }
          
          else if (cardType[b].GetCardType()== WildcardProperty.YELLOW_RED)
          {
            System.out.print("| YELLOW_RED  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()==WildcardProperty.GREEN_BLACK)
          {
            System.out.print("| GREEN_BLACK |"+" ");//cardType
          }
          else if(cardType[b].GetCardType()==WildcardProperty.ORANGE_PINK)
          {
            System.out.print("| ORANGE_PINK |"+" ");//cardType
          }
          else if (cardType[b].GetCardType()==WildcardProperty.LIGHTBLUE_BLACK)
          {
            System.out.print("|L.BLUE_BLACK |"+" ");//cardType
          }
          else if (cardType[b].GetCardType()== Rent.ALL_COLOUR)
          {
            System.out.print("| ALL_COLOUR  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.DARKBLUE_GREEN)
          {
            System.out.print("|D.BLUE_GREEN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.LIGHTBLUE_BROWN)
          {
            System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.ORANGE_PINK)
          {
            System.out.print("| ORANGE_PINK |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.BLACK_LIGHTGREEN)
          {
            System.out.print("|BLACK_L.GREEN|"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.RED_YELLOW)
          {
            System.out.print("| RED_YELLOW  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.ONE_M)
          {
            System.out.print("|    ONE_M    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.TWO_M)
          {
            System.out.print("|    TWO_M    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.THREE_M)
          {
            System.out.print("|   THREE_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.FOUR_M)
          {
            System.out.print("|    FOUR_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.FIVE_M)
          {
            System.out.print("|    FIVE_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.TEN_M)
          {
            System.out.print("|    TEN_M    |"+" ");//cardtype
          }
        }
        
        
        
        
        
      }
      System.out.println("");
      for(int c=0;c<LIMIT;c++)
      {
        System.out.print("|-------------|"+" ");
      }
      System.out.println("");
      for(int e=0;e<LIMIT;e++)
      {
        if (cardType[e]==null||cardType[e].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");
        }
        
        else 
        {
          System.out.print("|");
          System.out.printf("%12dM| ",cardType[e].GetCardValue());
        }
        
      }
      System.out.println("");
      
      for(int d=0;d<LIMIT;d++)
      {
        if (cardType[d]==null||cardType[d].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");
        }
        else
        {
          if (cardType[d].GetCardType()== Rent.ALL_COLOUR
                ||cardType[d].GetCardType()== Rent.DARKBLUE_GREEN
                ||cardType[d].GetCardType()== Rent.LIGHTBLUE_BROWN
                ||cardType[d].GetCardType()== Rent.ORANGE_PINK
                
                ||cardType[d].GetCardType()== Rent.BLACK_LIGHTGREEN
                
                ||cardType[d].GetCardType()== Rent.RED_YELLOW)
          {
            
            System.out.print("|         RENT|"+" "); 
          }
          else if(cardType[d].GetCardType()== NormalProperty.BROWN
                    ||cardType[d].GetCardType()== NormalProperty.DARK_BLUE
                    
                    ||cardType[d].GetCardType()== NormalProperty.DARK_GREEN
                    
                    ||cardType[d].GetCardType()== NormalProperty.LIGHT_BLUE
                    
                    || cardType[d].GetCardType()== NormalProperty.ORANGE
                    
                    ||cardType[d].GetCardType()== NormalProperty.PINK
                    
                    ||cardType[d].GetCardType()== NormalProperty.BLACK
                    
                    ||cardType[d].GetCardType()== NormalProperty.RED
                    
                    ||cardType[d].GetCardType()== NormalProperty.LIGHT_GREEN
                    ||cardType[d].GetCardType()== NormalProperty.YELLOW)
          {
            System.out.print("|     PROPERTY|"+" "); 
          }
          else if(cardType[d].GetCardType()== WildcardProperty.ALL_COLOUR
                    
                    ||cardType[d].GetCardType()== WildcardProperty.DARKBLUE_GREEN
                    
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN
                    ||cardType[d].GetCardType()==WildcardProperty.ORANGE_PINK
                    ||cardType[d].GetCardType()==WildcardProperty.GREEN_BLACK
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK
                    
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK
                    
                    
                    
                    ||cardType[d].GetCardType()== WildcardProperty.YELLOW_RED
                    
                 )
          {
            System.out.print("|     WILDCARD|"+" ");
          }
          
          
          
          else
          {
            
            System.out.print("|             |"+" "); 
          }
        }
        
        
        
      }
      
      
      System.out.println("");
      for(int f=0; f<LIMIT;f++)
      {
        
        System.out.print("|");
        System.out.printf("%13d| ",(f+1));
      }
      System.out.println("");
      
      
      for(int g=0;g<LIMIT;g++)
      {
        
        System.out.print("---------------"+" ");
      }
      
      
    }
    //card players choose to have throw to have an action
    //it will be placed at either display property or display money once players takes an action
  }
  public void DisplayPlayerCardsB(PlayerB[] cardType)
  {
    
   for (int j =0 ;j<1;j++)
    {
      for(int a = 0 ; a<LIMIT;a++)
      {
        System.out.print("---------------"+" ");
      }
      System.out.println("");
      
      for(int b =0 ;b<LIMIT;b++)
      {
        if(cardType[b]==null||cardType[b].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");//cardtype
        }
        
        else
        {
          if (cardType[b].GetCardType()== Special.DEAL_BREAKER)
          {
            System.out.print("|DEAL.BREAKER |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.DEBT_COLLECTOR)
          {
            System.out.print("|DEBT.COLLECT |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.DOUBLE_RENT)
          {
            System.out.print("| DOUBLE.RENT |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.FORCED_DEAL)
          {
            System.out.print("| FORCED.DEAL |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.HOTEL)
          {
            System.out.print("|    HOTEL    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.HOUSE)
          {
            System.out.print("|    HOUSE    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.BIRTHDAY)
          {
            System.out.print("|  BIRTHDAY   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.JUST_SAY_NO)
          {
            System.out.print("| JUST.SAY.NO |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.PASS_GO)
          {
            System.out.print("|   PASS.GO   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Special.SLY_DEAL)
          {
            System.out.print("|  SLY.DEAL   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.BROWN)
          {
            System.out.print("|   BROWN     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.DARK_BLUE)
          {
            System.out.print("|  DARK.BLUE  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.DARK_GREEN)
          {
            System.out.print("|    GREEN    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.LIGHT_BLUE)
          {
            System.out.print("| LIGHT.BLUE  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.ORANGE)
          {
            System.out.print("|    ORANGE   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.PINK)
          {
            System.out.print("|    PINK     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.BLACK)
          {
            System.out.print("|    BLACK    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.RED)
          {
            System.out.print("|     RED     |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.LIGHT_GREEN)
          {
            System.out.print("|   L.GREEN   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== NormalProperty.YELLOW)
          {
            System.out.print("|    YELLOW   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.ALL_COLOUR)
          {
            System.out.print("|  ALL.COLOUR |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.DARKBLUE_GREEN)
          {
            System.out.print("| D.BLUE_GREEN|"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN)
          {
            System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK)
          {
            System.out.print("|L.GREEN_BLACK|"+" ");//cardtype
          }
          
          else if (cardType[b].GetCardType()== WildcardProperty.YELLOW_RED)
          {
            System.out.print("| YELLOW_RED  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()==WildcardProperty.GREEN_BLACK)
          {
            System.out.print("| GREEN_BLACK |"+" ");//cardType
          }
          else if(cardType[b].GetCardType()==WildcardProperty.ORANGE_PINK)
          {
            System.out.print("| ORANGE_PINK |"+" ");//cardType
          }
          else if (cardType[b].GetCardType()==WildcardProperty.LIGHTBLUE_BLACK)
          {
            System.out.print("|L.BLUE_BLACK |"+" ");//cardType
          }
          else if (cardType[b].GetCardType()== Rent.ALL_COLOUR)
          {
            System.out.print("| ALL_COLOUR  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.DARKBLUE_GREEN)
          {
            System.out.print("|D.BLUE_GREEN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.LIGHTBLUE_BROWN)
          {
            System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.ORANGE_PINK)
          {
            System.out.print("| ORANGE_PINK |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.BLACK_LIGHTGREEN)
          {
            System.out.print("|BLACK_L.GREEN|"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Rent.RED_YELLOW)
          {
            System.out.print("| RED_YELLOW  |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.ONE_M)
          {
            System.out.print("|    ONE_M    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.TWO_M)
          {
            System.out.print("|    TWO_M    |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.THREE_M)
          {
            System.out.print("|   THREE_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.FOUR_M)
          {
            System.out.print("|    FOUR_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.FIVE_M)
          {
            System.out.print("|    FIVE_M   |"+" ");//cardtype
          }
          else if (cardType[b].GetCardType()== Money.TEN_M)
          {
            System.out.print("|    TEN_M    |"+" ");//cardtype
          }
        }
        
        
        
        
        
      }
      System.out.println("");
      for(int c=0;c<LIMIT;c++)
      {
        System.out.print("|-------------|"+" ");
      }
      System.out.println("");
      for(int e=0;e<LIMIT;e++)
      {
        if (cardType[e]==null||cardType[e].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");
        }
        
        else 
        {
          System.out.print("|");
          System.out.printf("%12dM| ",cardType[e].GetCardValue());
        }
        
      }
      System.out.println("");
      
      for(int d=0;d<LIMIT;d++)
      {
        if (cardType[d]==null||cardType[d].GetCardType()==PlayerB.EMPTY)
        {
          System.out.print("|             |"+" ");
        }
        else
        {
          if (cardType[d].GetCardType()== Rent.ALL_COLOUR
                ||cardType[d].GetCardType()== Rent.DARKBLUE_GREEN
                ||cardType[d].GetCardType()== Rent.LIGHTBLUE_BROWN
                ||cardType[d].GetCardType()== Rent.ORANGE_PINK
                
                ||cardType[d].GetCardType()== Rent.BLACK_LIGHTGREEN
                
                ||cardType[d].GetCardType()== Rent.RED_YELLOW)
          {
            
            System.out.print("|         RENT|"+" "); 
          }
          else if(cardType[d].GetCardType()== NormalProperty.BROWN
                    ||cardType[d].GetCardType()== NormalProperty.DARK_BLUE
                    
                    ||cardType[d].GetCardType()== NormalProperty.DARK_GREEN
                    
                    ||cardType[d].GetCardType()== NormalProperty.LIGHT_BLUE
                    
                    || cardType[d].GetCardType()== NormalProperty.ORANGE
                    
                    ||cardType[d].GetCardType()== NormalProperty.PINK
                    
                    ||cardType[d].GetCardType()== NormalProperty.BLACK
                    
                    ||cardType[d].GetCardType()== NormalProperty.RED
                    
                    ||cardType[d].GetCardType()== NormalProperty.LIGHT_GREEN
                    ||cardType[d].GetCardType()== NormalProperty.YELLOW)
          {
            System.out.print("|     PROPERTY|"+" "); 
          }
          else if(cardType[d].GetCardType()== WildcardProperty.ALL_COLOUR
                    
                    ||cardType[d].GetCardType()== WildcardProperty.DARKBLUE_GREEN
                    
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN
                    ||cardType[d].GetCardType()==WildcardProperty.ORANGE_PINK
                    ||cardType[d].GetCardType()==WildcardProperty.GREEN_BLACK
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK
                    
                    ||cardType[d].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK
                    
                    
                    
                    ||cardType[d].GetCardType()== WildcardProperty.YELLOW_RED
                    
                 )
          {
            System.out.print("|     WILDCARD|"+" ");
          }
          
          
          
          else
          {
            
            System.out.print("|             |"+" "); 
          }
        }
        
        
        
      }
      
      
      System.out.println("");
      for(int f=0; f<LIMIT;f++)
      {
        
        System.out.print("|");
        System.out.printf("%13d| ",(f+1));
      }
      System.out.println("");
      
      
      for(int g=0;g<LIMIT;g++)
      {
        
        System.out.print("---------------"+" ");
      }
      
      
    }
    //card players choose to have throw to have an action
    //it will be placed at either display property or display money once players takes an action
  }
  public void DisplayMoney()
  {
    System.out.print("Balance : $M  ");
    //money each player has at the bank
  }
  public void DisplayPropertyA(PropertyA[][] cardType)
  {
    
    for (int i = 0 ; i < MonoDeal.MAX_PROPERTY_ROW;i++)
    {
      for (int j =0 ;j<1;j++)
      {
        for(int a = 0 ; a<MonoDeal.MAX_PROPERTY_COLUMN;a++)
        {
          System.out.print("---------------"+" ");
        }
        System.out.println("");
        
        for(int b =0 ;b<MonoDeal.MAX_PROPERTY_COLUMN;b++)
        {
          if(cardType[i][b]!=null)
          {
            
            if (cardType[i][b].GetCardType()== NormalProperty.BROWN)
            {
              System.out.print("|   BROWN     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.DARK_BLUE)
            {
              System.out.print("|  DARK.BLUE  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.DARK_GREEN)
            {
              System.out.print("|    GREEN    |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.LIGHT_BLUE)
            {
              System.out.print("| LIGHT.BLUE  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.ORANGE)
            {
              System.out.print("|    ORANGE   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.PINK)
            {
              System.out.print("|    PINK     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.BLACK)
            {
              System.out.print("|    BLACK    |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.RED)
            {
              System.out.print("|     RED     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.LIGHT_GREEN)
            {
              System.out.print("|   L.GREEN   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.YELLOW)
            {
              System.out.print("|    YELLOW   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.ALL_COLOUR)
            {
              System.out.print("|  ALL.COLOUR |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.DARKBLUE_GREEN)
            {
              System.out.print("| D.BLUE_GREEN|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN)
            {
              System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK)
            {
              System.out.print("|L.GREEN_BLACK|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK)
            {
              System.out.print("| L.BLUE_BLACK|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.YELLOW_RED)
            {
              System.out.print("| YELLOW_RED  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()==WildcardProperty.GREEN_BLACK)
            {
              System.out.print("| GREEN_BLACK |"+" ");//cardType
            }
            else if(cardType[i][b].GetCardType()==WildcardProperty.ORANGE_PINK)
            {
              System.out.print("| ORANGE_PINK |"+" ");//cardType
            }
            else
            {
              System.out.print("|             |"+" ");
          }
            
          }
          else
          {
            System.out.print("|             |"+" ");
          }
          
          
          
        }
        System.out.println("");
        for(int c=0;c<MonoDeal.MAX_PROPERTY_COLUMN;c++)
        {
          System.out.print("|-------------|"+" ");
        }
        System.out.println("");
        for(int e=0;e<MonoDeal.MAX_PROPERTY_COLUMN;e++)
        {
          
            
          
          if(cardType[i][e]!=null)
          {
            System.out.print("|");
            System.out.printf("%12dM| ",cardType[i][e].GetCardValue());
          }
          else
          {
            System.out.print("|             |"+" ");
          }
          
        }
        System.out.println("");
        
        for(int d=0;d<MonoDeal.MAX_PROPERTY_COLUMN;d++)
        {
        
          if (cardType[i][d]!=null)
           
          {
            if(cardType[i][d].GetCardType()== NormalProperty.BROWN
                 ||cardType[i][d].GetCardType()== NormalProperty.DARK_BLUE
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.DARK_GREEN
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.LIGHT_BLUE
                 
                 || cardType[i][d].GetCardType()== NormalProperty.ORANGE
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.PINK
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.BLACK
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.RED
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.LIGHT_GREEN
                 ||cardType[i][d].GetCardType()== NormalProperty.YELLOW)
            {
              System.out.print("|     PROPERTY|"+" "); 
            }
            else if(cardType[i][d].GetCardType()== WildcardProperty.ALL_COLOUR
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.DARKBLUE_GREEN
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.YELLOW_RED
                      ||cardType[i][d].GetCardType()==WildcardProperty.ORANGE_PINK
                      ||cardType[i][d].GetCardType()==WildcardProperty.GREEN_BLACK)
            {
              System.out.print("|     WILDCARD|"+" ");
            }
            
            
            
            else
            {
              
              System.out.print("|             |"+" "); 
            }
          }
           else
          {
            System.out.print("|             |"+" ");
          }
          
          
          
        }
        
        
        System.out.println("");
        for(int f=0; f<MonoDeal.MAX_PROPERTY_COLUMN;f++)
        {
          System.out.print("|             |"+" ");
        }
        System.out.println("");
        
        
        for(int g=0;g<MonoDeal.MAX_PROPERTY_COLUMN;g++)
        {
          
          System.out.print("---------------"+" ");
        }
        
        
      }
      System.out.println("ROW : "+(i+1));
    }
    System.out.println("|    BROWN    | |    D.BLUE    | |   D.GREEN   | |   L.BLUE    | |   ORANGE    | |    PINK     | |    BLACK    | |     RED     | |   L.GREEN   | |    YELLOW   |  :SET");
    System.out.println("|      1      | |       2      | |     3       | |      4      | |     5       | |     6       | |      7      | |      8      | |       9     | |      10     |  ");
    
    
    
  }
  public void DisplayPropertyB(PropertyB[][] cardType)
  {
    
    for (int i = 0 ; i < MonoDeal.MAX_PROPERTY_ROW;i++)
    {
      for (int j =0 ;j<1;j++)
      {
        for(int a = 0 ; a<MonoDeal.MAX_PROPERTY_COLUMN;a++)
        {
          System.out.print("---------------"+" ");
        }
        System.out.println("");
        
        for(int b =0 ;b<MonoDeal.MAX_PROPERTY_COLUMN;b++)
        {
         
          
          if (cardType[i][b]!=null)
          {
            if (cardType[i][b].GetCardType()== NormalProperty.BROWN)
            {
              System.out.print("|   BROWN     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.DARK_BLUE)
            {
              System.out.print("|  DARK.BLUE  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.DARK_GREEN)
            {
              System.out.print("|    GREEN    |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.LIGHT_BLUE)
            {
              System.out.print("| LIGHT.BLUE  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.ORANGE)
            {
              System.out.print("|    ORANGE   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.PINK)
            {
              System.out.print("|    PINK     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.BLACK)
            {
              System.out.print("|    BLACK    |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.RED)
            {
              System.out.print("|     RED     |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.LIGHT_GREEN)
            {
              System.out.print("|   L.GREEN   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== NormalProperty.YELLOW)
            {
              System.out.print("|    YELLOW   |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.ALL_COLOUR)
            {
              System.out.print("|  ALL.COLOUR |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.DARKBLUE_GREEN)
            {
              System.out.print("| D.BLUE_GREEN|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN)
            {
              System.out.print("|L.BLUE_BROWN |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK)
            {
              System.out.print("|L.GREEN_BLACK|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK)
            {
              System.out.print("| L.BLUE_BLACK|"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()== WildcardProperty.YELLOW_RED)
            {
              System.out.print("| YELLOW_RED  |"+" ");//cardtype
            }
            else if (cardType[i][b].GetCardType()==WildcardProperty.GREEN_BLACK)
            {
              System.out.print("| GREEN_BLACK |"+" ");//cardType
            }
            else if(cardType[i][b].GetCardType()==WildcardProperty.ORANGE_PINK)
            {
              System.out.print("| ORANGE_PINK |"+" ");//cardType
            }
            else
            {
              System.out.print("|             |"+" "); 
            }
            
          }
          else
            {
              System.out.print("|             |"+" "); 
            }
          
          
          
          
          
          
        }
        System.out.println("");
        for(int c=0;c<MonoDeal.MAX_PROPERTY_COLUMN;c++)
        {
          System.out.print("|-------------|"+" ");
        }
        System.out.println("");
        for(int e=0;e<MonoDeal.MAX_PROPERTY_COLUMN;e++)
        {
          if (cardType[i][e]==null||cardType[i][e].GetCardType()==PlayerB.EMPTY)
          {
            System.out.print("|             |"+" ");
          }
          
          else 
          {
            System.out.print("|");
            System.out.printf("%12dM| ",cardType[i][e].GetCardValue());
          }
          
        }
        System.out.println("");
        for(int d=0;d<MonoDeal.MAX_PROPERTY_COLUMN;d++)
        {
          if (cardType[i][d]!=null)
          {
           
            if(cardType[i][d].GetCardType()== NormalProperty.BROWN
                 ||cardType[i][d].GetCardType()== NormalProperty.DARK_BLUE
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.DARK_GREEN
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.LIGHT_BLUE
                 
                 || cardType[i][d].GetCardType()== NormalProperty.ORANGE
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.PINK
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.BLACK
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.RED
                 
                 ||cardType[i][d].GetCardType()== NormalProperty.LIGHT_GREEN
                 ||cardType[i][d].GetCardType()== NormalProperty.YELLOW)
            {
              System.out.print("|     PROPERTY|"+" "); 
            }
            else if(cardType[i][d].GetCardType()== WildcardProperty.ALL_COLOUR
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.DARKBLUE_GREEN
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTBLUE_BROWN
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTGREEN_BLACK
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.LIGHTBLUE_BLACK
                      
                      ||cardType[i][d].GetCardType()== WildcardProperty.YELLOW_RED
                      ||cardType[i][d].GetCardType()==WildcardProperty.ORANGE_PINK
                      ||cardType[i][d].GetCardType()==WildcardProperty.GREEN_BLACK)
            {
              System.out.print("|     WILDCARD|"+" ");
            }
            
            
            
            else
            {
              
              System.out.print("|             |"+" "); 
            }
          }
          else
          {
            System.out.print("|             |"+" "); 
            
          }
          
          
          
        }
        
        System.out.println("");
        for(int e=0;e<MonoDeal.MAX_PROPERTY_COLUMN;e++)
        {
          System.out.print("|             |"+" ");
        }
        System.out.println("");
        for(int f=0; f<MonoDeal.MAX_PROPERTY_COLUMN;f++)
        {
          System.out.print("|             |"+" ");
        }
        System.out.println("");
        
        
        for(int g=0;g<MonoDeal.MAX_PROPERTY_COLUMN;g++)
        {
          
          System.out.print("---------------"+" ");
        }
        
        
      }
      System.out.println("ROW : "+(i+1));
    }
    System.out.println("|    BROWN    | |    D.BLUE    | |   D.GREEN   | |   L.BLUE    | |   ORANGE    | |    PINK     | |    BLACK    | |     RED     | |   L.GREEN   | |    YELLOW   |  :SET");
    System.out.println("|      1      | |       2      | |     3       | |      4      | |     5       | |     6       | |      7      | |      8      | |       9     | |      10     |  ");
    
  }
  
  
}

