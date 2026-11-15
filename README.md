# Baccarat (Java)

A command-line version of the casino card game Baccarat, built in Java as a one-day weekend project.

```
       ______________________________________
      /            * BACCARAT *              \
     /         --- PAYS 2 TO 1 ---            \
    /                                          \
   |     PLAYER                BANKER           |
   |   [ K♠ ][ 8♣ ]          [ 5♦ ][ 8♣ ]       |
   |                                            |
    \            [ PLAYER ] [ TIE ]            /
     \               [ BANKER ]               /
      \______________________________________/
```

---

## 🎲 About the Project

Pick a starting stack of chips, predict whether the **Player**, the **Banker** or a **Tie** will win each hand, place your bet, and watch the cards get dealt. Keep playing until you cash out or go bust.

**Features**

- Replayable game loop, so you can play hand after hand without restarting
- Live chip balance that tracks every win and loss
- Menu and bet input validation
- Timed pauses and card reveals to give each round a bit of suspense

**Simplified rules:** this version was built to fit a tight timeframe, so some parts of real Baccarat are simplified:

- Each side is dealt exactly two cards, with no third-card drawing rule
- Payouts are simplified (see below) and do not match a real casino table

---

## 🃏 How to Play

1. **Main menu:** choose `1` to play or `2` to read the in-game rules.
2. **Starting chips:** choose `1` (5,000), `2` (15,000) or `3` (30,000).
3. **Pick an outcome:** choose `1` for Player, `2` for Banker or `3` for Tie.
4. **Place your bet:**
   - Bets must be a multiple of 500
   - The maximum bet is your balance minus 1,000, so you always keep a reserve
   - Once you are down to 1,000 chips or fewer, you can go all in
5. **Watch the deal:** the Player's cards are dealt first, then the Banker's, and the winner is announced.
6. **Collect or lose:** your balance updates, then choose `A` to play again or `Q` to quit.

**Card values**

| Card | Value |
| --- | --- |
| Ace | 1 |
| 2 to 9 | Face value |
| 10, Jack, Queen, King | 0 |

A hand's score is its total with the tens digit dropped (for example, 8 + 7 = 15, so the score is 5). The hand closest to 9 wins, and equal scores are a Tie.

**Payouts**

| Bet | Result | Winnings |
| --- | --- | --- |
| Player or Banker | Correct | 2 to 1 |
| Tie | Correct | 3 to 1 |
| Any | Incorrect | Bet is lost |

If your balance reaches 0, you go bust and the game ends.

---

## 🛠️ Setup

**Requirements**

- Java Development Kit (JDK) **17 or newer** (check with `java -version`)
- A terminal that supports UTF-8, so the card suits (♠ ♣ ♥ ♦) display correctly

**Run it**

```bash
# 1. Clone the repository
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>

# 2. Compile
javac Main.java

# 3. Run
java Main
```

**Troubleshooting**

- If the suits show up as `?` or odd symbols on Windows, run `chcp 65001` in the terminal before starting the game, or run it with `java -Dfile.encoding=UTF-8 Main`.
- You can also open the project in an IDE such as IntelliJ IDEA or VS Code and run `Main.java` directly.

---

Made by Cal Flood, 2026
