import java.util.Scanner;
public class MonopolyMain
{
  public static void main (String[]args)
  {
    Scanner input = new Scanner(System.in);
    Displayer disp = new Displayer();
    MonoDeal deal = new MonoDeal();
    /*Indicating each data type*/
    char player; 
    int action ;
    
    int turnA=0;
    int turnB=0;
    int allowableAction=0;
    int discard=0;
    int allColour=0;    
    char numberOfAction='Y';
    char bankrupt='S';
    
    /*Do while loop to loop the program and exit when either one of  the player is bankrup
     * or when one of the player has three full set property*/    
    
    do
    {
      //Header of the game
      disp.DisplayMainMenu();
      //Player's input
      player = input.next().toUpperCase().charAt(0);
      
      /*Setting Players Type */    
      /*Only when player is A or B and shows warning when the character is invalid*/
      if (player == PlayerA.PLAYER_A ||player==PlayerB.PLAYER_B)
      {
        
        if (player ==PlayerA.PLAYER_A)
        {
          deal.SetCurrPlayer(player);
        }
        else if(player==PlayerB.PLAYER_B)
        {
          deal.SetCurrPlayer(player);
        }
        /*Loop the game*/
        while(true)
        {
          /*Looping Player A action*/
          if(deal.GetCurrPlayer()==PlayerA.PLAYER_A)
          {           
            
            /*Turn is variable to keep track of the number of action played by the player
             * on the first round players get to draw 5 cards and 3 cards for the following action*/            
            turnA++;
            if(turnA==1)
            {
              System.out.println("PLAYER A : Draw 5 Cards (enter) to continue");
            }
            else
            {
              System.out.println("PLAYER A  : Draw 3 Cards (enter) to continue");
            }
            /*Enter to continue following action*/
            try{
              System.in.read();
            }
            catch(Exception e){
            }
            
            //Display player cards or holding by the player
            deal.AddPlayerCardA(turnA);
            System.out.println("PLAYER A CARDS");
            disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
            
            /*while loop to discard cards when player holds more than 7 cards*/ 
            while(deal.DiscardPlayerACard()!=false)
            {
              System.out.print("\n A Player can have no more than seven cards.Choose Cards to discard :");
              discard= input.nextInt();
              //Delete method to delete the chosen card//
              deal.DeleteCard(discard-1);
              
              if (deal.DiscardPlayerACard()==false)
              {
                //when car is less than 7
                System.out.println("Successfully discard card");
                disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
              }  
              
            }
            
            /*Let Player to use an action card
             -Rent Card Function -Adding the property choosen by the player from player's property value to be paid by the opponent
             -Birthday           - player's pay 2M to the other player
             -AllColourRent      -Player's can choose any property for the opponent player's to pay the rent
             -DealBreaker        -Steal any full set property
             -Pass Go            -Draw 2 more cards to the player's hand
             -House              -Increase the rent by 3M in any full set property
             -Hotel              -Increase the rent (only can be played with House card)
             -Forced Deal        -Swap any non utility(not full set) property
             -Double The Rent    -Double the rent of any property chosen
             -Just Say No        -Just Say No to prohibit the opponent to steal any property
             -Money              -Use to pay the rent
             -Sly DEAL           -Steal Any Property from the opponent*/
            System.out.println("\nChoose action to enhance your property.Minimum action to choose is 3");
            /*Y and N is to let the player chose number of action they want to attempt
             *while allowable action is to keep track the number of action taken by the player 
             should not exceed 3*/
            while(numberOfAction =='Y')
            {
              /*Asking player to take their action*/
              System.out.print("Click (Y) to choose action and (N) to continue  :");
              numberOfAction= input.next().toUpperCase().charAt(0);;
              if(numberOfAction=='Y')
              {
                System.out.print("Pick card numbers:");
                action = input.nextInt();
                /*Showing warning when the card picked by the user is null or empty*/
                if(deal.Card(action-1)==MonoDeal.CARD_EMPTY)
                {
                  
                  System.out.println("Card is not availlable.Try Again");
                }
                /*Adding money to the bank when it is a Money card*/
                else if(deal.Money (action-1)==true)
                {
                  //delete card from the player's hand
                  deal.DeleteCard(action-1);
                  allowableAction++;
                }              
                //rent function
                else if (deal.Card(action-1)==MonoDeal.RENT_CARD)
                {
                  //players can choose property to be rented 
                  //the property must base on wildcard rent
                  System.out.println("\nPlayer A Property :");
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("Pick property to rent (column/set): ");
                  allColour=input.nextInt();                
                  
                  //if rent is success
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    System.out.println("Successfully paid rent from player B account");
                    if(allowableAction!=3)
                    {                   
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                      
                    }
                    deal.DeleteCard(action-1);
                  }
                  //if rent card does not the property set in the rent card
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.NOT_RENT_CARD)
                  {
                    //warning if rent card does not match
                    System.out.println("Rent card does not match property set.Try Again");
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                  }
                  /*else if rent field is empty 
                   * userss can choose other card to be rented*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    System.out.println("Field is empty.Choose Again");
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                  }
                  /*if the opponent does not have enough money in the bank to be paid*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*the opponent can choose to bankrupt or sell their property*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player B (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      if (bankrupt == 'B')
                      {
                        //it will break the entire loop and player A WIN
                        System.out.println("PlayerB Bankrupt : Player A wins");
                        bankrupt='B';
                        
                        break;
                      }
                      
                      /*checking if there is any property to be sold if no player A wins*/
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        
                        bankrupt='B';
                        break;
                      }
                      /*when the opponent chooses to sell their property*/
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          /*PLAYER B get to choose their property to be sold*/
                          disp.DisplayPropertyB(deal.GetPropertyCardB());
                          System.out.println("Choose Property to sell (choose your coordinate ) (x,y):");
                          System.out.println("col :");
                           int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();  
                          
                          //break the loop when there is no more property to sell
                          if (deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            bankrupt='B';
                            break;
                          }
                          //when the opponent has enough balance to pay their rent
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            
                            allowableAction++;
                            System.out.println("\nSuccessfully sold property");
                            bankrupt='X';
                            
                            deal.DeleteCard(action-1);
                            //display player cards for player to choose next action
                            if(allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                              
                            }
                            break;
                            
                          }
                          //When the opponent needs to pay more to pay their rent
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                          
                            System.out.println("not enough balance.Pick More property to sold");
                            
                          } 
                        }
                        //break the second loop when player has paid the rent
                        break;                     
                      }
                      
                    }
                    //if player chooses to go bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                  }
                  
                }
                /*Player can choose any property to rent and it will check 
                 * whether the opponent has enough balance in their bank to pay the rent 
                 else it will break the loop*/
                else if (deal.Card(action-1 )==MonoDeal.RENT_ALL_COLOUR)
                {
                  
                  System.out.println("\nPlayer A Property :");
                  //display the property set for player to choose which set to rent
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.println("Pick property set to rent (column): ");
                  allColour=input.nextInt();
                  //when the opponent has enought balance to pay their rent
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    System.out.println("Successfully paid rent");
                     deal.DeleteCard(action-1);
                   
                    
                    if(allowableAction!=3)
                    {
                      //let player choose the following action
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                    //delete the player card once it successful
                   
                    
                  }
                  //if the set property is unavaillable or the set property is empty
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER A CARDS");
                    //let player choose the following action
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());                 

                  }
                  //if opponent doesnt have enough balance in their bank account
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*Let the opponent to choose to bankrupt or pay their rent*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player B (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      /*if they choose to bankrupt it will break the loop
                       * and if there is no property to sell it will also break the loop
                       and player a wins*/
                      if (bankrupt == 'B')
                      {
                        
                        System.out.println("PlayerB Bankrupt : Player A wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        bankrupt='B';
                        break;
                      }
                      
                      /*if player choose to sell their property*/
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          /*let player choose which coordinate to sell*/
                          disp.DisplayPropertyB(deal.GetPropertyCardB());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                         /*if player pay enough rent from their property
                          * else it will break the loop*/

                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                             deal.DeleteCard(action-1);
                            if(allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                              
                            }
                           
                            bankrupt='X';
                            
                            allowableAction++;
                            
                            break;
                            
                          }
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            System.out.println("not enough balance.Pick More property to sold");
                            
                          }
                          /*when there is no more property to sold 
                           * player A wins*/
                           if (deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            /*set banrupt to break the whole loop
                             * or end the game*/
                            bankrupt='B';
                            break;
                          }
                        }
                        //break the 2nd while loop once player finish paying their rent*/

                        break;
                        
                      }

                    }
                    //if player is bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                  }
                }
                /*Rent from the property chosen will be doubled 
                 * player can choose any filled property for the opponent 
                 to pay the doubled rent*/
                else if (deal.Card(action-1 )==MonoDeal.RENT_DOUBLE_RENT)
                {
                  /*display property to be chosen*/
                  System.out.println("\nPlayer A Property :");
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.println("Pick property to rent : ");
                  allColour=input.nextInt();
                  /*if opponen has enough rent to pay to the player*/
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    System.out.println("Successfully paid rent");
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                  }
                  /*if the property chosen is empty 
                   * player can choose make 2nd attempt for following action*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER A CARDS");
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                  }
                  /*when the opponent does not have enough money to pay the rent*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*let opponent to choose to bankrupt or sell their property*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                     
                      System.out.println("Player B (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      /*if player B choose to bankrupt and end the game
                       * else if there is no property to be sold it will also end the game*/
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerB Bankrupt : Player A wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        bankrupt='B';
                        break;
                      }
                      /*if palyer choose to sell their property*/
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          /*Let player B choose property to sell*/
                          disp.DisplayPropertyB(deal.GetPropertyCardB());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          /*when player chooses to bankrupt*/
                          if(deal.Bankrupt()==true)
                          {
                            //when there is no property to sell it will break the loop and player a wins
                            System.out.print("There is no property to sell.Player A wins");
                            
                            bankrupt='B';
                            break;
                            
                          }
                          //when player pay enough rent from their property
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            allowableAction++;
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            if (allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                            }
                            bankrupt='X';
                            break;
                          }
                          //Giving warning when player needs to pay more
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            System.out.println("not enough balance.Pick More property to sold");
                            
                          }
                        }
                        break;
                      }
                    }
                    //player goes bankrupt 
                    if (bankrupt=='B')
                    {
                      break;
                    }                    
                  }                 
                  
                }
                //when player choose to increse the rent by choosing special card
                //HOUSE
                else if(deal.Card(action-1)==MonoDeal.SPECIAL_HOUSE)
                {
                  //display property to choose which set to increase
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("Choose Property to set House  :");
                  allColour=input.nextInt();
                  //when house is added
                  //only eligible when there is a full set property
                  if(deal.House(action-1,allColour-1)==true)
                  {
                    allowableAction++;
                     deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                    System.out.println("\nSuccessfully added House to Property set  :"+allColour);
                   
                    
                  }
                  else
                  {
                    //giviing warning if property is not full set
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                //when player choose birthday card the opponent must pay 2M to the player
                else if (deal.Card(action-1)==MonoDeal.SPECIAL_BIRTHDAY)
                {
                  //when  has enough balance to pay player from the bank
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    System.out.println("Succesfully paid rent from Player B account");
                    allowableAction++;
                    
                  }
                  
                  /*when player doesnt has enough balance to pay to the opponent*/
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*opponent can choose to bankrupt or sell their property to pay their rent*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      
                      System.out.println("Player B (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player choose to bankrupt it will break the entire loop and player a wins
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerB Bankrupt : Player A wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //when the opponent has property to pay to the player
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        bankrupt='B';
                        break;
                      }
                      //when the opponent choose to sell their property
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          //opponent get to choose which property by coordinate to sell
                          disp.DisplayPropertyB(deal.GetPropertyCardB());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          if(deal.Bankrupt()==true)
                          {
                            /*when there is not enough property to sell to the opponent*/
                            System.out.print("There is no property to sell.Player A wins");
                            
                            bankrupt='B';
                            break;
                          }
                          
                          /*if player succesfully pay the rent*/
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            if(allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                            }
                            
                            allowableAction++;
                            
                            break;
                            
                          }
                          /*when opponent need to pay more to pay their rent*/
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");
                          }
                          
                        }
                        //break the loop once player successfully pay their rent
                        break;
                        
                      }
                      
                    }
                    //break the whole loop when player choose to go bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }

                  }
                }
                /*player can choose any full seet property to steal*/
                else if(deal.Card(action-1)==MonoDeal.DEAL_BREAKER)
                {
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("Choose Property Set to steal (column):");
                  allColour=input.nextInt();
                  //check if property is full set
                  if(deal.DealBreaker(allColour-1)==true)
                  {
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    
                  }
                  //if it is not full set player get to choose more property
                  else
                  {
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                //check if it is hotel 
                else if(deal.Card(action-1)==MonoDeal.HOTEL)
                {
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("\nChoose Property to set Hotel  :");
                  allColour=input.nextInt();
                  //if hotel has house and is full set it will be added and rent will increase
                
                  if(deal.Hotel(action-1,allColour-1)==true)
                  {
                    allowableAction++;
                      deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                    
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    
                  
                    
                  }
                  //if hotel does not has house it cant be added and player 
                  //get to choose following action
                  else if (deal.Hotel(action-1,allColour-1)==false)
                  {                    
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("\nColumn does not have full set //Need a house to set Hotel.Choose Again");
                  }
                }
                //forced deal is used to swap the property 
                else if(deal.Card(action-1)==MonoDeal.FORCED_DEAL)
                {
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  /*choosin coordinate from player property and opponent property to be swap*/
                  System.out.print("\nChoose your Property coordinate to swap  :");
                  System.out.print("col =");
                  int colA= input.nextInt();
                  System.out.print("row =");
                  int rowA=input.nextInt();
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose your opponent Property coordinate to swap  :");
                  System.out.print("col =");
                  int colB= input.nextInt();
                  System.out.print("row =");
                  int rowB=input.nextInt();
                  //check if property stolen is not a part of full set property and if it is not 
                  //it will be swapped
                  if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.SWAP_SUCCESS)
                  {
                    deal.DeleteCard(action-1);
                    System.out.println("\nSuccessfully SWAP Property   ");
                    allowableAction++;
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                  }
                  /*if property choosen is a part of full set*/
                  else if (deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.FULL_SET)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCan't swap full set property");
                  }
                  /*if coordinate chosen is empty*/
                  else if (deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.EMPTY_COORDINATE)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCoordinate is empty");
                  }
                }
                /*debt collector is when opponent needs to pay 3M to the player*/
                else if (deal.Card(action-1)==MonoDeal.DEBT_COLLECT)
                {
                  //if opponent has enough money from the bank to pay the player
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    System.out.println("Successfully paid rent from Player B account");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                    
                  }
                  //if opponent doesnt have enough money to pay the player
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    //when opponent choose to go bankrupt
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      
                      System.out.println("Player B (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player choose to go bamkrupt 
                      if (bankrupt == 'B')
                      {
                        //when player b choose to bankrupt player a wins
                        System.out.println("PlayerB Bankrupt : Player A wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //else if opponent choose to sell the property but no more property left 
                      //player a wins
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        bankrupt='B';
                        break;
                      }
                      //when player has enough property to sell
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          //opponent choose coordinate to sell 
                          disp.DisplayPropertyB(deal.GetPropertyCardB());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          
                          int row=input.nextInt();
                          //when player has no property left to be sold
                          if(deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            bankrupt='B';
                            break;
                          }
                          //when player successfully sold property
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            
                            allowableAction++;
                            if(allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                            }
                            
                            break;
                            
                          }
                          //when player need to sell more property to sell
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            System.out.println("not enough balance.Pick More property to sold");
                          }
                          
                        }
                        break;
                        
                      }
                      
                    }
                    //break the entire loop when player choose to bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                }
                //add normal property to player property
                else if (deal.AddPropertyA(action-1)==true)
                {
                  deal.DeleteCard(action-1);
                  allowableAction++;
                }
                //add wild card property 
                else if (deal.Card(action-1)==MonoDeal.WILDCARD)
                {
                  
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("Pick Column to set Property :");
                  allColour=input.nextInt();
                  //only eligible base on the colout given
                  if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.ADD_SUCCESS)
                  {
                    deal.DeleteCard(action-1);
                    
                    allowableAction++;
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    }
                  }
                  //giving warning when it is not wildcard
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NOT_WILDCARD)
                  {
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("\nIt is not in the Wildcard property");
                  }
                  //giving warning when it needs base property
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NEED_BASE_PROPERTY)
                  {
                    disp.DisplayPlayerCardsA(deal.GetPlayerCardA());
                    System.out.println("\nWildCard Need Base Property");
                  }
                  //set action back to 'Y'
                  numberOfAction='Y';
                }
                
                
              }
              //break the loop when player choose N
              else if (numberOfAction=='N')
              {
                numberOfAction='N';
              }
              //if it is different character
              else if (numberOfAction != 'N' || numberOfAction != 'Y')
              {
                System.out.println("Wrong input.Try Again!");
                numberOfAction='Y';
              }
              //when allowable action reaches theree it will break the loop
              if (allowableAction ==3)
              {
                numberOfAction='N';
              }  
            }
            //set allowable action back to default 0 and Y
            allowableAction=0;
            numberOfAction='Y';
            //break the third loop
            if (bankrupt=='B')
            {
              break;
            }
            //display player final property
            System.out.println("\nPlayer A Property :");
            disp.DisplayPropertyA(deal.GetPropertyCardA());
            //update on players balance
            System.out.println("\nSEE AN UPDATE ON BALANCE (Enter) to continue :");
            disp.DisplayMoney();
            System.out.println(deal.PlayerABank());
            //enter to procedd
            try{
              System.in.read();
            }
            catch(Exception e){
            }
            
            deal.SwitchPlayer();
            
          }
          //when player is B 
          else if (deal.GetCurrPlayer()==PlayerB.PLAYER_B)
          {
            //keep track of the action taken
            turnB++;
            if(turnB==1)
            {
              //drawing 5 cards when the action taken is 1
              System.out.println("PLAYER B :Draw 5 Cards (enter) to continue");
            }
            else
            {
              //following will be 3
              System.out.println("PLAYER B :Draw 3 Cards (enter) to continue");
            }
            //enter to draw cards
            try
            {
              System.in.read();
            }
            catch(Exception e){
            }
            //adding player cards
            deal.AddPlayerCardB(turnB);
            //display player cards
            System.out.println("Player B cards");
            
            disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
            //if player card exceeded 7 it will make player choose card to be discarded
            while(deal.DiscardPlayerBCard()!=false)
            {
              //let player choose card to be discarded
              System.out.print("\n A Player can have no more than seven cards.Choose Cards to discard :");
              discard= input.nextInt();
              //delete discarded card from the player hand
              deal.DeleteCard(discard-1);
              
              if (deal.DiscardPlayerBCard()==false)
              {
                System.out.println("Successfully discard card");
                disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
              }
              
            }
             /*Let Player to use an action card
             -Rent Card Function -Adding the property choosen by the player from player's property value to be paid by the opponent
             -Birthday           - player's pay 2M to the other player
             -AllColourRent      -Player's can choose any property for the opponent player's to pay the rent
             -DealBreaker        -Steal any full set property
             -Pass Go            -Draw 2 more cards to the player's hand
             -House              -Increase the rent by 3M in any full set property
             -Hotel              -Increase the rent (only can be played with House card)
             -Forced Deal        -Swap any non utility(not full set) property
             -Double The Rent    -Double the rent of any property chosen
             -Just Say No        -Just Say No to prohibit the opponent to steal any property
             -Money              -Use to pay the rent
             -Sly DEAL           -Steal Any Property from the opponent
             -Debt Collect       -Opponent pay 3M to player*/
            System.out.println("\nChoose action to enhance your property.Minimum action to choose is 3");
            while(numberOfAction =='Y')
            {
              //if player choses y to pick action 
              //if N player break the loop and proceed the game
              System.out.print("Click (Y) to choose action and (N) to continue  :");
              numberOfAction= input.next().toUpperCase().charAt(0);;
              if(numberOfAction=='Y')
              {
                //pick player cards
                System.out.print("Pick card numbers:");
                action = input.nextInt();
                //adding money action to player banks
                if(deal.Money (action-1)==true)
                {
                  //delete card once action is accompished
                  deal.DeleteCard(action-1);
                  allowableAction++;
                }
                /*rent card is used to rent any property set  */
                else if (deal.Card(action-1)==MonoDeal.RENT_CARD)
                {
                  System.out.println("\nPlayer B Property :");
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("Pick property to rent (column/set): ");
                  allColour=input.nextInt();
                   /*when opponent has enough money to pay rent*/
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    
                    System.out.println("Successfully paid rent from player A account");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                  }
                  /*when the card choosen is not the colou*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.NOT_RENT_CARD)
                  {
                    System.out.println("Rent card does not match property set.Try Again");
                    System.out.println("PLAYER B CARDS :");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                  }
                  /*when property chosen is empty*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    System.out.println("Field is empty.Choose Again");
                    System.out.println("PLAYER B CARDS :");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                  }
                  /*when player doesnt have enough balance to pay the opponent*/
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*player get to choose to bankrupt or proceed*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //if player choose to bankrupt it will break the entire loop
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //when player doesnt have enough property to sell 
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player A wins");
                        
                        bankrupt='B';
                        break;
                      }
                      //when player choose to sell their property
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          //choosing which coordinate to sell
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate ) (x,y):");
                          System.out.println("col :");
                          
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          
                          //when player successfully sold their property
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            allowableAction++;
                            System.out.println("Successfully sold property");
                            bankrupt='X';
                            deal.DeleteCard(action-1);
                            if(allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            break;
                            
                          }
                          //when player needs to pay more property to pay rent
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            System.out.println("not enough balance.Pick More property to sold");
                          }
                          //if there is no more property to sell
                          if (deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            bankrupt='B';
                            
                            break;
                          }
                          
                          
                          
                        }
                        //break the loop once player succeding in paying the rent
                        break;
                        
                        
                        
                        
                        
                      }
                      
                    }
                    //if player choose to bankrupt if will break the whole loop
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                  }
                  
                }
                //if player choose all colour rent card 
                //they get to choose any property to sell
                else if (deal.Card(action-1 )==MonoDeal.RENT_ALL_COLOUR)
                {
                  
                  System.out.println("\nPlayer B Property :");
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.println("Pick property to rent : ");
                  allColour=input.nextInt();
                  //if opponet has enough money to pay the rent
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    System.out.println("\nSuccessfully paid rent");
                    
                    
                    
                    break;
                  }
                  
                  //if property chosen is empty
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER B CARDS");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    
                  }
                  //when the opponent doesnt has enough money to pay the player
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    //when opponent choose to go bankrupt
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                     
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player choose to bankrupt player b wins
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //when playr choose to sell the property but there is no more property to be sell
                      //player b wins
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                        
                      }
                      //when payer choose to sell their existing proeprty
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          
                          
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            //when player succesfully pay the rent
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            
                            bankrupt='X';
                            
                            allowableAction++;
                            if (allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            break;
                            
                          }
                          //when player need to choose more property to pay their rent
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");
 
                          }
                          //when there is no more property to sell and player A wins
                          if (deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            bankrupt='B';
                            break;
                          }

                          
                        }
                        
                        //break the loop when player finish paying their rent
                        break;
 
                      }
                      
                    }
                    //when player choose to bankrupt
                    if (bankrupt=='B')
                    {
                      //break the whole loop
                      break;
                    }
                    
                    
                  }
                  
                }
                /*Special house can be used only to any full set property 
                 * it is used to increment the rent by 3M 
                 it will show a warning if it is not a full set property*/
                 else if(deal.Card(action-1)==MonoDeal.SPECIAL_HOUSE)
                {
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose Property to set House  :");
                  allColour=input.nextInt();
                  if(deal.House(action-1,allColour-1)==true)
                  {
                    
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                   
                    
                  }
                  else
                  {
                    //will show a warning when property is not a full set
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                 /*used to double any proeprty set*/
                else if (deal.Card(action-1 )==MonoDeal.RENT_DOUBLE_RENT)
                {
                  
                  System.out.println("\nPlayer B Property :");
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.println("Pick property to rent : ");
                  allColour=input.nextInt();
                  //when rent is success
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    System.out.println("Successfully paid rent");
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    //break the loop when player is succeding in paying their rent
                    break;
                  }
                  //show warning if field is empty
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER B CARDS");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());

                  }
                  //when opponent doesnt have enough money to pay their rent
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player chooses to bankrupt 
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if(deal.Bankrupt()==true)
                      {
                        bankrupt='B';
                        break;
                      }
                      //when player choose to sell their property 
                      else if (bankrupt=='S')
                      {
                        
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          
                          //when opponent succesfully sold their property
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            
                            allowableAction++;
                            if(allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            break;
                            
                          }
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            
                            
                            
                            System.out.println("not enough balance.Pick More property to sold");

                          }
                          //break the loop when there is no property to sell
                          if(deal.Bankrupt()==true)
                          {
                            
                            System.out.println("There is no property to sell.Player B wins");
                            bankrupt='B';
                            break;
                          }
                          
                          
                          
                          
                          
                        }
                        //break the second loop to procced following action
                        break;
                        
                        
                      }
                      
                    }
                    //if player choose to end the game
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                  
                  
                }
               /*opponent need to pay 2M to player */
                
                else if (deal.Card(action-1)==MonoDeal.SPECIAL_BIRTHDAY)
                {
                  //if player successfully paid the rent
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    System.out.println("Succfully paid rent from Player A account");
                    allowableAction++;
                    
                  }
                  //if there is no enought balance in the opponent bank account
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*while loop to loop whether player has enough property to sell 
                     * if no it will break the loop
                     to ask if player want to end the game or sell their existing property*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                      }
                      
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          /*oppent get to choose which property to sell*/
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                         
                          
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            allowableAction++;
                            if (allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            
                            
                            break;
                            
                          }
                          //when player doesnt has enough money to pay the rent 
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");

                          }
                          //if there is no more property to sell
                          if(deal.Bankrupt()==true)
                          {
                            
                            System.out.print("There is no property to sell.Player B wins");
                            
                            bankrupt='B';
                            break;
                          }
                          
                          
                          
                        }
                        break;
                        
                      }
                      
                    }
                    //when player choose to bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                }
                /*Hotel to increase the rent or the value of the property set */
                else if(deal.Card(action-1)==MonoDeal.HOTEL)
                {
                  /*displaye property B */
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose Property to set Hotel  :");
                  allColour=input.nextInt();
                  //can only be placed with house
                  if(deal.Hotel(action-1,allColour-1)==true)
                  {
                    
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                    
                  }
                  //when it not full set property (give warning)
                  else
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nColumn does not have full set property//need a house to set Hotel.Choose Again");
                  }
                }
                
                //to swap any non utility property
                else if(deal.Card(action-1)==MonoDeal.FORCED_DEAL)
                {
                  //choose coodinate from each player
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose your Property coordinate to swap  :");
                  System.out.print("col =");
                  int colA= input.nextInt();
                  System.out.print("row =");
                  int rowA=input.nextInt();
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose your opponent Property coordinate to swap  :");
                  System.out.print("col =");
                  int colB= input.nextInt();
                  System.out.print("row =");
                  int rowB=input.nextInt();
                  //check if it is success
                  if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.SWAP_SUCCESS)
                  {
                    
                    System.out.println("\nSuccessfully added Swap Property");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                    
                  }
                  //when it is not fullset 
                  else if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.FULL_SET)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCan't swap full set property");
                  }
                  //when coodinate chosen is empty
                  else if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.EMPTY_COORDINATE)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCoordinate is empty");
                  }
                }
                //deal breaker is to steal any full set property from the opposing player
                else if(deal.Card(action-1)==MonoDeal.DEAL_BREAKER)
                {
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("Choose Property Set to steal :");
                  allColour=input.nextInt();
                  //if deal breaker is success
                  if(deal.DealBreaker(allColour-1)==true)
                  {
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                  
                    
                  }
                  else
                  {
                    //warning if it is not full set
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                //player needs to pay 3M to the oppposing player
                else if (deal.Card(action-1)==MonoDeal.DEBT_COLLECT)
                {
                  //if rent is succes will be added to the player account
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    
                    System.out.println("\nSuccessfully paid rent from Player A account");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                    
                  }
                  //if player doesnt have enought money to pay 
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    //if player choose to bankrupt or sell
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //break the loop if it is bankrupt
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //if there is no property to sell player b wins
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                      }
                      //if player chooses to sell their property
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col : ");
                            int col= input.nextInt();
                          System.out.println ("row :");
                            int row=input.nextInt();
                          if(deal.Bankrupt()==true)
                          {
                            //if there is no property to sell
                            System.out.print("There is no property to sell.Player B wins");
                            
                            bankrupt='B';
                            break;
                          }
                          
                          //if property succesfully been sold
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            
                            allowableAction++;
                            
                            break;
                            
                          }
                          //when it needs more property to sell
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");

                            
                          }
                          
                          
                          
                        }
                        
                        break;
                      }
                      
                    }
                    //when user choose to bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                }
                
                //add normal property
                else if (deal.AddPropertyB(action-1)==true)
                {
                  deal.DeleteCard(action-1);
                  allowableAction++;
                }
                //if it is property wildcard
                else if (deal.Card(action-1)==MonoDeal.WILDCARD)
                {                
                  //player gets to choose column to display their property
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("Pick Column to set Property :");
                  allColour=input.nextInt();
                  //if it is success
                  if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.ADD_SUCCESS)
                  {
                    deal.DeleteCard(action-1);
                    allowableAction++;
                  }
                  //if it needs base property
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NEED_BASE_PROPERTY)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nWildCard Need Base Property");
                  }
                 //if it is not the colour of the wild card property
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NOT_WILDCARD)
                    
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nIt is not in the Wildcard property");
                  }              
                  
                  
                  //set action to default
                  
                  numberOfAction='Y';
                }
                
                
              }
              //indicating the action
              else if (numberOfAction=='N')
              {
                numberOfAction='N';
              }
              //give warning when it is another character
              else if (numberOfAction != 'N' || numberOfAction != 'Y')
              {
                System.out.println("Wrong input.Try Again!");
                numberOfAction='Y';
              }
              //break loop when aloowable action is 3
              if (allowableAction ==3)
              {
                numberOfAction='N';
              }
              
              
            }
            //set variab;e to default
            allowableAction=0;
            numberOfAction='Y';
            //break the loop when it is bankrupt
            if (bankrupt=='B')
            {
              break;
            }
            
            
            
            
            System.out.println("Player B Property :");
            disp.DisplayPropertyB(deal.GetPropertyCardB());
            System.out.println("\nSEE AN UPDATE ON BALANCE (Enter) to continue :");
            //let users see an update on the bank
            disp.DisplayMoney();
            System.out.print(deal.PlayerBBank());
            
            try{
              System.in.read();
            }
            catch(Exception e){
            }
            
            deal.SwitchPlayer();
            
          }
        }
      }
      //warning on invalid player character
      else
      {
        System.out.println("Invalid Player character.Try Again");
      }
    }
    while (bankrupt!='B');
    
    
  }
}
                          }
                          
                          
                          
                        }
                        //break the loop once player succeding in paying the rent
                        break;
                        
                        
                        
                        
                        
                      }
                      
                    }
                    //if player choose to bankrupt if will break the whole loop
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                  }
                  
                }
                //if player choose all colour rent card 
                //they get to choose any property to sell
                else if (deal.Card(action-1 )==MonoDeal.RENT_ALL_COLOUR)
                {
                  
                  System.out.println("\nPlayer B Property :");
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.println("Pick property to rent : ");
                  allColour=input.nextInt();
                  //if opponet has enough money to pay the rent
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    System.out.println("\nSuccessfully paid rent");
                    
                    
                    
                    break;
                  }
                  
                  //if property chosen is empty
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER B CARDS");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    
                  }
                  //when the opponent doesnt has enough money to pay the player
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    //when opponent choose to go bankrupt
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                     
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player choose to bankrupt player b wins
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //when playr choose to sell the property but there is no more property to be sell
                      //player b wins
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                        
                      }
                      //when payer choose to sell their existing proeprty
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          
                          
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            //when player succesfully pay the rent
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            
                            bankrupt='X';
                            
                            allowableAction++;
                            if (allowableAction!=3)
                            {
                              disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            break;
                            
                          }
                          //when player need to choose more property to pay their rent
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");
 
                          }
                          //when there is no more property to sell and player A wins
                          if (deal.Bankrupt()==true)
                          {
                            System.out.print("There is no property to sell.Player A wins");
                            bankrupt='B';
                            break;
                          }

                          
                        }
                        
                        //break the loop when player finish paying their rent
                        break;
 
                      }
                      
                    }
                    //when player choose to bankrupt
                    if (bankrupt=='B')
                    {
                      //break the whole loop
                      break;
                    }
                    
                    
                  }
                  
                }
                /*Special house can be used only to any full set property 
                 * it is used to increment the rent by 3M 
                 it will show a warning if it is not a full set property*/
                 else if(deal.Card(action-1)==MonoDeal.SPECIAL_HOUSE)
                {
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose Property to set House  :");
                  allColour=input.nextInt();
                  if(deal.House(action-1,allColour-1)==true)
                  {
                    
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                   
                    
                  }
                  else
                  {
                    //will show a warning when property is not a full set
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                 /*used to double any proeprty set*/
                else if (deal.Card(action-1 )==MonoDeal.RENT_DOUBLE_RENT)
                {
                  
                  System.out.println("\nPlayer B Property :");
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.println("Pick property to rent : ");
                  allColour=input.nextInt();
                  //when rent is success
                  if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_SUCCESS)
                  {
                    allowableAction++;
                    System.out.println("Successfully paid rent");
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    //break the loop when player is succeding in paying their rent
                    break;
                  }
                  //show warning if field is empty
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_FIELD_EMPTY)
                  {
                    
                    System.out.println("Field is empty card can not be rented.Choose Again");
                    System.out.println("PLAYER B CARDS");
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());

                  }
                  //when opponent doesnt have enough money to pay their rent
                  else if (deal.Rent(action-1,allColour-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //when player chooses to bankrupt 
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if(deal.Bankrupt()==true)
                      {
                        bankrupt='B';
                        break;
                      }
                      //when player choose to sell their property 
                      else if (bankrupt=='S')
                      {
                        
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                          
                          //when opponent succesfully sold their property
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            
                            allowableAction++;
                            if(allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            break;
                            
                          }
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {
                            
                            
                            
                            System.out.println("not enough balance.Pick More property to sold");

                          }
                          //break the loop when there is no property to sell
                          if(deal.Bankrupt()==true)
                          {
                            
                            System.out.println("There is no property to sell.Player B wins");
                            bankrupt='B';
                            break;
                          }
                          
                          
                          
                          
                          
                        }
                        //break the second loop to procced following action
                        break;
                        
                        
                      }
                      
                    }
                    //if player choose to end the game
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                  
                  
                }
               /*opponent need to pay 2M to player */
                
                else if (deal.Card(action-1)==MonoDeal.SPECIAL_BIRTHDAY)
                {
                  //if player successfully paid the rent
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    System.out.println("Succfully paid rent from Player A account");
                    allowableAction++;
                    
                  }
                  //if there is no enought balance in the opponent bank account
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    /*while loop to loop whether player has enough property to sell 
                     * if no it will break the loop
                     to ask if player want to end the game or sell their existing property*/
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                      }
                      
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          /*oppent get to choose which property to sell*/
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col :");
                          int col= input.nextInt();
                          System.out.println("row :");
                          int row=input.nextInt();
                         
                          
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            allowableAction++;
                            if (allowableAction!=3)
                            {
                               disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                            }
                            
                            
                            
                            break;
                            
                          }
                          //when player doesnt has enough money to pay the rent 
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");

                          }
                          //if there is no more property to sell
                          if(deal.Bankrupt()==true)
                          {
                            
                            System.out.print("There is no property to sell.Player B wins");
                            
                            bankrupt='B';
                            break;
                          }
                          
                          
                          
                        }
                        break;
                        
                      }
                      
                    }
                    //when player choose to bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                }
                /*Hotel to increase the rent or the value of the property set */
                else if(deal.Card(action-1)==MonoDeal.HOTEL)
                {
                  /*displaye property B */
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose Property to set Hotel  :");
                  allColour=input.nextInt();
                  //can only be placed with house
                  if(deal.Hotel(action-1,allColour-1)==true)
                  {
                    
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                    
                  }
                  //when it not full set property (give warning)
                  else
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nColumn does not have full set property//need a house to set Hotel.Choose Again");
                  }
                }
                
                //to swap any non utility property
                else if(deal.Card(action-1)==MonoDeal.FORCED_DEAL)
                {
                  //choose coodinate from each player
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose your Property coordinate to swap  :");
                  System.out.print("col =");
                  int colA= input.nextInt();
                  System.out.print("row =");
                  int rowA=input.nextInt();
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("\nChoose your opponent Property coordinate to swap  :");
                  System.out.print("col =");
                  int colB= input.nextInt();
                  System.out.print("row =");
                  int rowB=input.nextInt();
                  //check if it is success
                  if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.SWAP_SUCCESS)
                  {
                    
                    System.out.println("\nSuccessfully added Swap Property");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                    
                  }
                  //when it is not fullset 
                  else if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.FULL_SET)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCan't swap full set property");
                  }
                  //when coodinate chosen is empty
                  else if(deal.ForcedDeal(colA-1,rowA-1,action-1,colB-1,rowB-1)==MonoDeal.EMPTY_COORDINATE)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nCoordinate is empty");
                  }
                }
                //deal breaker is to steal any full set property from the opposing player
                else if(deal.Card(action-1)==MonoDeal.DEAL_BREAKER)
                {
                  disp.DisplayPropertyA(deal.GetPropertyCardA());
                  System.out.print("Choose Property Set to steal :");
                  allColour=input.nextInt();
                  //if deal breaker is success
                  if(deal.DealBreaker(allColour-1)==true)
                  {
                    allowableAction++;
                    deal.DeleteCard(action-1);
                    System.out.println("\nSuccessfully added Property set  :"+allColour);
                    if(allowableAction!=3)
                    {
                      disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    }
                    
                  
                    
                  }
                  else
                  {
                    //warning if it is not full set
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    
                    System.out.println("\nColumn does not have full set property.Choose Again");
                  }
                }
                //player needs to pay 3M to the oppposing player
                else if (deal.Card(action-1)==MonoDeal.DEBT_COLLECT)
                {
                  //if rent is succes will be added to the player account
                  if(deal.SpecialRent(action-1)==MonoDeal.RENT_SUCCESS)
                  {
                    
                    System.out.println("\nSuccessfully paid rent from Player A account");
                    deal.DeleteCard(action-1);
                    allowableAction++;
                    
                  }
                  //if player doesnt have enought money to pay 
                  else if (deal.SpecialRent(action-1)==MonoDeal.RENT_NOT_ENOUGH_BALANCE)
                  {
                    //if player choose to bankrupt or sell
                    while (bankrupt!='B'||bankrupt!='X')
                    {
                      
                      System.out.println("Player A (not enough balance):Go bankrupt(B)or choose property to sell(S)");
                      bankrupt=input.next().toUpperCase().charAt(0);
                      //break the loop if it is bankrupt
                      if (bankrupt == 'B')
                      {
                        System.out.println("PlayerA Bankrupt : Player B wins");
                        bankrupt='B';
                        
                        break;
                      }
                      //if there is no property to sell player b wins
                      else if (deal.Bankrupt()==true)
                      {
                        System.out.print("There is no property to sell.Player B wins");
                        bankrupt='B';
                        break;
                      }
                      //if player chooses to sell their property
                      else if (bankrupt=='S')
                      {
                        while (true)
                        {
                          
                          
                          disp.DisplayPropertyA(deal.GetPropertyCardA());
                          System.out.println("Choose Property to sell (choose your coordinate (x,y)) :");
                          System.out.println("col : ");
                            int col= input.nextInt();
                          System.out.println ("row :");
                            int row=input.nextInt();
                          if(deal.Bankrupt()==true)
                          {
                            //if there is no property to sell
                            System.out.print("There is no property to sell.Player B wins");
                            
                            bankrupt='B';
                            break;
                          }
                          
                          //if property succesfully been sold
                          if (deal.SoldPropertyRent((col-1),(row-1))==true)
                          {
                            System.out.println("Successfully sold property");
                            deal.DeleteCard(action-1);
                            bankrupt='X';
                            
                            allowableAction++;
                            
                            break;
                            
                          }
                          //when it needs more property to sell
                          else if ( deal.SoldPropertyRent((col-1),(row-1))==false)
                          {

                            System.out.println("not enough balance.Pick More property to sold");

                            
                          }
                          
                          
                          
                        }
                        
                        break;
                      }
                      
                    }
                    //when user choose to bankrupt
                    if (bankrupt=='B')
                    {
                      break;
                    }
                    
                    
                  }
                }
                
                //add normal property
                else if (deal.AddPropertyB(action-1)==true)
                {
                  deal.DeleteCard(action-1);
                  allowableAction++;
                }
                //if it is property wildcard
                else if (deal.Card(action-1)==MonoDeal.WILDCARD)
                {                
                  //player gets to choose column to display their property
                  disp.DisplayPropertyB(deal.GetPropertyCardB());
                  System.out.print("Pick Column to set Property :");
                  allColour=input.nextInt();
                  //if it is success
                  if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.ADD_SUCCESS)
                  {
                    deal.DeleteCard(action-1);
                    allowableAction++;
                  }
                  //if it needs base property
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NEED_BASE_PROPERTY)
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nWildCard Need Base Property");
                  }
                 //if it is not the colour of the wild card property
                  else if(deal.AddWildCard(allColour-1,action-1)==MonoDeal.NOT_WILDCARD)
                    
                  {
                    disp.DisplayPlayerCardsB(deal.GetPlayerCardB());
                    System.out.println("\nIt is not in the Wildcard property");
                  }              
                  
                  
                  //set action to default
                  
                  numberOfAction='Y';
                }
                
                
              }
              //indicating the action
              else if (numberOfAction=='N')
              {
                numberOfAction='N';
              }
              //give warning when it is another character
              else if (numberOfAction != 'N' || numberOfAction != 'Y')
              {
                System.out.println("Wrong input.Try Again!");
                numberOfAction='Y';
              }
              //break loop when aloowable action is 3
              if (allowableAction ==3)
              {
                numberOfAction='N';
              }
              
              
            }
            //set variab;e to default
            allowableAction=0;
            numberOfAction='Y';
            //break the loop when it is bankrupt
            if (bankrupt=='B')
            {
              break;
            }
            
            
            
            
            System.out.println("Player B Property :");
            disp.DisplayPropertyB(deal.GetPropertyCardB());
            System.out.println("\nSEE AN UPDATE ON BALANCE (Enter) to continue :");
            //let users see an update on the bank
            disp.DisplayMoney();
            System.out.print(deal.PlayerBBank());
            
            try{
              System.in.read();
            }
            catch(Exception e){
            }
            
            deal.SwitchPlayer();
            
          }
        }
      }
      //warning on invalid player character
      else
      {
        System.out.println("Invalid Player character.Try Again");
      }
    }
    while (bankrupt!='B');
    
    
  }
}