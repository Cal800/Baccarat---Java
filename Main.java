import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner UI = new Scanner(System.in);
        boolean running = true;

        while (running) {
            boolean menu = true;
            boolean play = false;
            boolean rules = false;




            while (menu) {

                System.out.println("\n\n====================");
                System.out.println("Welcome to Baccarat!!");
                System.out.println("====================");

                System.out.println("\n1) Play!");
                System.out.println("\n2) Rules");

                System.out.print("\n\t>>> ");

                String startingchoice = UI.nextLine();

                if (startingchoice.equalsIgnoreCase("Play!") || startingchoice.equalsIgnoreCase("1")) {
                    menu = false;
                    play = true;
                } else if (startingchoice.equalsIgnoreCase("Rules") || startingchoice.equalsIgnoreCase("2")) {
                    menu = false;
                    rules = true;
                } else {
                    System.out.println("\nPlease input a valid choice\n");
                }


            }

            if (play) {
                System.out.println("\n\n============================");
                System.out.println("Welcome to the casino table!");
                System.out.println("\nPick a starting amount of chips to play with!");
                System.out.println("\n1) 5,000 chips");
                System.out.println("\n2) 15,000 chips");
                System.out.println("\n3) 30,000 chips");

                int StartChips = 0;
                boolean SCpicked = false;

                while (!SCpicked) {

                    System.out.print("\n\t>>> ");
                    String SChips = UI.nextLine();

                    if (SChips.equalsIgnoreCase("5000") || SChips.equalsIgnoreCase("1")) {
                        StartChips = 5000;
                        SCpicked = true;
                    } else if (SChips.equalsIgnoreCase("15000") || SChips.equalsIgnoreCase("2")) {
                        StartChips = 15000;
                        SCpicked = true;
                    } else if (SChips.equalsIgnoreCase("30000") || SChips.equalsIgnoreCase("3")) {
                        StartChips = 30000;
                        SCpicked = true;
                    } else {
                        System.out.println("Please choose a valid option, 1,2,3 or typing chip values like 5000 (without the ,)");
                    }

                }

                if (SCpicked) {


                    String UserDecision = "";
                    int UserBet = 0;
                    boolean PlayAgain = true;

                    int Currentchips = StartChips;

                    while(PlayAgain) {

                        boolean inbetweenRound = true;


                        System.out.println("Lets Begin!\n\n\n");

                        System.out.println("\t       ______________________________________");
                        System.out.println("\t      /            * BACCARAT *              \\");
                        System.out.println("\t     /         --- PAYS 2 TO 1 ---            \\");
                        System.out.println("\t    /                                          \\");
                        System.out.println("\t   |     PLAYER                      BANKER     |");
                        System.out.println("\t   |   [    ][    ]                [    ][    ] |");
                        System.out.println("\t   |                                            |");
                        System.out.println("\t    \\            [ PLAYER ] [ TIE ]            /");
                        System.out.println("\t     \\               [ BANKER ]               /");
                        System.out.println("\t      \\______________________________________/\n");

                        System.out.println("\nWhat outcome do you want to choose?");
                        System.out.println("\n1) Player");
                        System.out.println("\n2) Banker");
                        System.out.println("\n3) Tie");

                        while (inbetweenRound) {

                            System.out.print("\n\t>>> ");
                            String UserDec = UI.nextLine();

                            if (UserDec.equalsIgnoreCase("Player") || UserDec.equalsIgnoreCase("1")) {
                                UserDecision = "Player";
                                inbetweenRound = false;
                            } else if (UserDec.equalsIgnoreCase("Banker") || UserDec.equalsIgnoreCase("2")) {
                                UserDecision = "Banker";
                                inbetweenRound = false;
                            } else if (UserDec.equalsIgnoreCase("Tie") || UserDec.equalsIgnoreCase("3")) {
                                UserDecision = "Tie";
                                inbetweenRound = false;
                            } else {
                                System.out.println("Please enter a valid choice, numbers count too (1,2,3)");
                            }

                        }

                        boolean bettingTime = true;
                        boolean ValidBet = false;


                        while (bettingTime) {

                            System.out.println("\n\nNow its time to bet!");

                            int MaxBet;
                            boolean isAllInAllowed = false;

                            if (Currentchips > 1000) {
                                MaxBet = Currentchips - 1000;

                                System.out.println("You currently have: " + Currentchips + " chips");
                                System.out.println("The Maximum Bet is: " + MaxBet);

                                while (!ValidBet) {

                                    System.out.print("\n\t>>> ");
                                    UserBet = UI.nextInt();
                                    UI.nextLine();

                                    if (UserBet > MaxBet || UserBet <= 0 || UserBet % 500 != 0) {
                                        System.out.println("Please enter a valid bet!");
                                        System.out.println("Valid Bets are more than 0 and are in ranges of 500");
                                    } else {
                                        Currentchips = Currentchips - UserBet;
                                        ValidBet = true;
                                        bettingTime = false;
                                    }
                                }
                            } else {
                                MaxBet = Currentchips;
                                isAllInAllowed = true;

                                System.out.println("You currently have: " + Currentchips + " chips");
                                System.out.println("You can go all in if needed!");

                                while (!ValidBet) {

                                    System.out.print("\n\t>>> ");
                                    UserBet = UI.nextInt();
                                    UI.nextLine();

                                    if (UserBet > MaxBet || UserBet <= 0 || UserBet % 500 != 0) {
                                        System.out.println("Please enter a valid bet!");
                                        System.out.println("Valid Bets are more than 0 and are in ranges of 500");
                                    } else {
                                        Currentchips = Currentchips - UserBet;
                                        ValidBet = true;
                                        bettingTime = false;
                                    }
                                }
                            }

                        }

                        pause(2);

                        System.out.println("\nBetting Closed!");

                        System.out.println("\n=====================");
                        System.out.println("Final Bet");
                        System.out.println("Decision: " + UserDecision);
                        System.out.println("Betting Amount: " + UserBet);
                        System.out.println("=======================");

                        pause(2);

                        //picking the cards
                        String PCard1 = ChooseCard();
                        String PCard2 = ChooseCard();

                        System.out.println("\t       ______________________________________");
                        System.out.println("\t      /            * BACCARAT *              \\");
                        System.out.println("\t     /         --- PAYS 2 TO 1 ---            \\");
                        System.out.println("\t    /                                          \\");
                        System.out.println("\t   |     PLAYER                BANKER           |");
                        System.out.println("\t   |   [ " + PCard1 + " ][ " + PCard2 + " ]          [    ][    ]       |");
                        System.out.println("\t   |                                            |");
                        System.out.println("\t    \\            [ PLAYER ] [ TIE ]            /");
                        System.out.println("\t     \\               [ BANKER ]               /");
                        System.out.println("\t      \\______________________________________/\n");

                        pause(2);

                        System.out.println();
                        System.out.println("\t          ====Choosing Bankers Cards====");
                        System.out.println();


                        String BCard1 = ChooseCard();
                        String BCard2 = ChooseCard();
                        pause(2);

                        System.out.println("\t       ______________________________________");
                        System.out.println("\t      /            * BACCARAT *              \\");
                        System.out.println("\t     /         --- PAYS 2 TO 1 ---            \\");
                        System.out.println("\t    /                                          \\");
                        System.out.println("\t   |     PLAYER                BANKER           |");
                        System.out.println("\t   |   [ " + PCard1 + " ][ " + PCard2 + " ]          [ " + BCard1 + " ][ " + BCard2 + " ]       |");
                        System.out.println("\t   |                                            |");
                        System.out.println("\t    \\            [ PLAYER ] [ TIE ]            /");
                        System.out.println("\t     \\               [ BANKER ]               /");
                        System.out.println("\t      \\______________________________________/\n");

                        pause(2);
                        System.out.println("Evaluating The Winning Outcome....");
                        String Winner = CalculateWinner(PCard1, PCard2, BCard1, BCard2);
                        int Balance = 0;
                        pause(2.5);

                        System.out.println("The Winning Outcome was " + Winner + "!");
                        pause(1.5);

                        if (Winner.equals("Tie") && Winner.equals(UserDecision)) {
                            System.out.println("\nYou win big!");
                            System.out.println("A Tie is a 3 to 1 win!");
                            System.out.println("Congratulations!\n");

                            Balance = (UserBet * 3) + UserBet;
                            System.out.println("Winnings >> " + Balance);


                            System.out.println("Chip Balance:" + Currentchips);
                            Currentchips = Currentchips + Balance;
                            System.out.println("Chip Balance:" + Currentchips + "▲");

                        } else if (UserDecision.equals(Winner)) {
                            System.out.println("\nYou Win");
                            System.out.println("A " + Winner + " is a 2 to 1 win!");
                            System.out.println("Congratulations!\n");

                            Balance = (UserBet * 2) + UserBet;
                            System.out.println("Winnings >> " + Balance);


                            System.out.println("Chip Balance:" + Currentchips);
                            Currentchips = Currentchips + Balance;
                            System.out.println("New Chip Balance:" + Currentchips + "▲");

                        } else {
                            System.out.println("\nLOSS");
                            System.out.println("Winning Outcome: " + Winner);
                            System.out.println("Your Choice: " + UserDecision);

                            int oldChipBalance = Currentchips + UserBet;
                            System.out.println("Chip Balance: " + oldChipBalance);
                            System.out.println("New Chip Balance: " + Currentchips + "▼");
                        }

                        if (Currentchips <= 0) {
                            System.out.println("\nYou went BUST!");
                            System.out.println("\nThanks for playing!");
                            inbetweenRound = true;
                            running = false;
                            PlayAgain = false;
                        } else {

                            Boolean PlayAgainQ = true;

                            while (PlayAgainQ) {

                                System.out.println("\nPlay Again?");
                                System.out.println("Press 'A' to play again & 'Q' to quit");
                                System.out.print("\t>>> ");
                                String ClosingChoice = UI.nextLine();

                                if (ClosingChoice.equalsIgnoreCase("A")) {
                                    inbetweenRound = true;
                                    PlayAgainQ = false;
                                } else if (ClosingChoice.equalsIgnoreCase("Q")) {
                                    System.out.println("\n\t\t\t  Thanks for playing!");
                                    inbetweenRound = true;
                                    PlayAgainQ = false;
                                    running = false;
                                    PlayAgain = false;
                                } else {
                                    System.out.println("Please enter 'A' or 'Q'");
                                }

                            }

                        }

                    }


                }


            } else if (rules) {
                System.out.println("\nRules");
                System.out.println("========");
                boolean returnQ = false;

                System.out.println("1) Pick Your Side and Hit Deal: \nChoose your chip value, click Player, Banker, or Tie, and hit Deal. \nYou’re simply predicting which hand gets closer to 9.");
                System.out.println();
                System.out.println("2) Know the Card Values: \nAces = 1, cards 2–9 = face value, and 10s/Face cards = 0.");
                System.out.println();
                System.out.println("3) Drop the First Digit: \nScores never go past 9. If a hand totals 10 or more, drop the tens digit \n(e.g., 8 + 7 = 15, so the score is 5).");
                System.out.println();
                System.out.println("4) Watch for a \"Natural\" 8 or 9: \nTwo cards are dealt to each side. \nIf either hand hits 8 or 9 right away, You know whose going to win!");
                System.out.println();
                System.out.println("5) Closest to 9 Wins: \nIf there's no Natural, the game automatically finishes the hand using built-in rules, \ncompares the final totals, and credits your winnings instantly.");


                while (!returnQ) {
                    System.out.println("\n\nPress 'Q' to quit");
                    System.out.print("\t>>> ");

                    String returnQS = UI.nextLine();

                    if (returnQS.equalsIgnoreCase("Q")) {
                        returnQ = true;
                        rules = false;
                        menu = true;
                    } else {
                        System.out.println("\nPlease type a valid response\n");
                    }

                }


            }

        }


        System.out.println("\n\n\t\t\t  ==== Cal Flood 2026 ====");
        UI.close();






    }

    public static String ChooseCard() {

        Random rand = new Random();
        String PlayerCardF = "";
        boolean hasFace = false;

        String FinalPlayerCard = "";

        int PlayerCard = rand.nextInt(1, 14);


        if(PlayerCard == 1) {
            PlayerCardF = "A";
            hasFace = true;
        }

        else if(PlayerCard == 10) {
            PlayerCardF = "T";
            hasFace = true;
        }

        else if(PlayerCard == 11) {
            PlayerCardF = "J";
            hasFace = true;
        }

        else if(PlayerCard == 12) {
            PlayerCardF = "Q";
            hasFace = true;
        }

        else if(PlayerCard == 13) {
            PlayerCardF = "K";
            hasFace = true;
        }

        String[] suits = {"♠", "♣", "♥", "♦"};

        String Suit = suits[rand.nextInt(suits.length)];

        if(!hasFace) {

            FinalPlayerCard = PlayerCard + Suit;
            return FinalPlayerCard;
        } else {
            FinalPlayerCard = PlayerCardF + Suit;
            return FinalPlayerCard;
        }


    }

    public static void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static String CalculateWinner(String PCard1, String PCard2, String BCard1, String BCard2) {

        String Winner = "";

        int PNum1 = getCardValue(PCard1);
        int PNum2 = getCardValue(PCard2);
        int BNum1 = getCardValue(BCard1);
        int BNum2 = getCardValue(BCard2);

        int Ptotal = PNum1 + PNum2;
        int Btotal = BNum1 + BNum2;

        int PlayerScore = Ptotal % 10;
        int BankerScore = Btotal %10;

        if(PlayerScore > BankerScore) {
            Winner = "Player";
        } else if (PlayerScore < BankerScore) {
            Winner = "Banker";
        } else if (PlayerScore == BankerScore) {
            Winner = "Tie";
        }

        return Winner;


    }

    public static int getCardValue(String card) {
        String rank = card.substring(0, 1);

        switch (rank) {
            case "A":
                return 1;
            case "T":
            case "J":
            case "Q":
            case "K":
                return 0;
            default:
                return Integer.parseInt(rank);
        }
    }

}