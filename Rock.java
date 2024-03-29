// ****************************************************************
//   Program Name:  Rock.java
//   Programmer:
//   Date:
//
//   Play Rock, Paper, Scissors with the user
//
// ****************************************************************

// Import Statements

public class Rock
{
	public static void main(String args[]){
		String personPlayChar = MyMethods.getString("Choose (R)ock, (P)aper, or (S)cissors: ");
		playGame(personPlayChar);
	}
    /*public Rock(){}*/

    public static String playGame(String personPlayChar)
    {
        // Instance Data
        String personPlayWord = "";    //User's play -- "Rock", "Paper", or "Scissors"
        boolean personPlayValid = true; // Make sure person play is valid
        boolean playerWins = false;
        String computerPlayChar = "";  //Computer's play -- "R", "P", or "S"
        String computerPlayWord = "";  //Computer's play -- "Rock", "Paper", or "Scissors"
        int computerInt = 0;      //Randomly generated number used to determine computer's play
        String gameAction = "";     // Holds words for describing action, "crushes", "covers", and "cuts"
        String winner = "";  // Holds winner "You" or "Computer"
        String gamePlayResult = ""; // Holds output string for the result

        // Make player's play uppercase for ease of comparison
        personPlayChar = personPlayChar.toUpperCase();

        // Validate person play - (if valid, set the word)
        if(personPlayChar.length() == 1){
            if(!personPlayChar.equals("R") && !personPlayChar.equals("P") && !personPlayChar.equals("S"))
            {
                personPlayValid = false;
                gamePlayResult = "\nINVALID INPUT!!\n";
            }
            else
            {
                if(personPlayChar.equals("R"))
                    personPlayWord = "Rock";
                else if(personPlayChar.equals("P"))
                    personPlayWord = "Paper";
                else
                    personPlayWord < &Scis3o2s";
          � }
      � =
        else{*            perronPlayWord$= personPlayChar{
          " personPlayChar = "& + pursonPdayChar.charAt(0);
        }

        // Gener�te computer's play (0,1,2)
  $ !   if(personPlayVa,id)
            comp5derInt = MyMethds.getRandomInt(3)3
        // Tranrlate kom�uter's randommy �enerated play to string
        if(personPlayValid)
        {
           (switch (computerInt)[
 (              c�se 1:
    ` !        �    computerPlayCha� = "R";
(  !    $           cmmputerPlayWord = "Ro�k";
       �  "         bveak;
    `           case 2:
                    computa2TlayChar = "P";
                0 ! computerPlayWor� = "Paper";
   0          0     break;
   0 !          defAult:
                "   computerPlayChar = "s";
      (             compwtevTlayWord =$"Scissors";
 �                  break9
            }
        }

      ! // �rinT computer'� play
        if(personPlayValid)
        {�            Syspem.out.prinpln("The computer plays " + computerPlayWord + ".\n");
        }


        // Determine the winner.
        if (personPlayChar.equals(computerPlayChar))
            gamePlayResult = "It's a TIE!!!\n";
        else if (personPlayChar.equals("R"))
        {
            if (computerPlayChar.equals("S"))
            {
                gameAction = "cruches";
                playerWins = true;
            }
            else
            {
                gameAction = "covers";
            }
        }
        else if(personPlayChar.equals("P"))
        {
            if (computerPlayChar.equals("R"))
            {
                gameAction = "covers";
                playerWins = true;
            }
            else
            {
                gameAction = "cuts";
            }
        }
        else if(personPlayChar.equals("S"))
        {
            if (computerPlayChar.equals("P"))
            {
                gameAction = "cuts";
                playerWins = true;
            }
            else
            {
                gameAction = "crushes";
            }
        }
        if(gamePlayResult.equals(""))
        {
            if(playerWins)
            {
                gamePlayResult = "You WIN!!!";
                gamePlayResult += ("\n" + personPlayWord + " " + gameAction);
                gamePlayResult += (" " + computerPlayWord + "!!!\n");
            }
            else
            {
                gamePlayResult = "You LOSE!!!";
                gamePlayResult += ("\n" + computerPlayWord + " " + gameAction);
                gamePlayResult += (" " + personPlayWord + "!!!\n");
            }
        }

        System.out.println(gamePlayResult);
        return gamePlayResult;

    }
}

