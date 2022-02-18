# Squid Arcade
Team  Name: Excited Explosive Compsci Students

Members of Team:
- Jason Yang(yangjas4@my.yorku.ca) Section O, Lab 02
- Sohban Elahi Malik(Sohbanm1@my.yorku.ca) Section P, Lab 01
- Aman Singh Sahni(aman1703@my.yorku.ca) Section P, Lab 01
- Angad Singh Rekhi(angarsr03@gmail.com) section P Lab 01

Project Title: Squid Arcade

# Description: 
For our project, we’ve decided to create an app with a series of mini-games inspired by the popular Netflix series “Squid Game”. The app will include 3 different games: Red Light Green Light, Marbles, Dalgona Cookies, and 2 side widgets: a weather widget and a basic 4 function calculator. 


In the game Red Light Green Light, players must reach the finish line within a set time limit without getting eliminated. To do this, players are given a button which when held will move the player forward. When the button is released, the player stops moving. While the player is making their way to the finish line, the game will constantly prompt either green light or red light in random intervals. When the prompt is green light, the player may move forward freely however if the prompt flashes red light and the player is still holding down the button, the player is eliminated. Alternatively, if the player does not move forward far enough to reach the finish line by the time limit, they are also eliminated. This game will have 3 difficulties: easy, medium and hard which will change the amount of time given to the player to complete the game. The game can either be played in single player or 2 player mode on the same device. In 2 player mode, the first player to pass the finish line causes the other player to be eliminated. Alternatively if one player is eliminated, the other player must pass the finish line in order to win. If both players are unable to pass the finish line, the game is a draw.

# Functional Requirements

**Homepage Requirements** 
- On the homepage there will be a picture of the game to the left of the screen, and a description of the rules to the right of the image. 

**Navigational Requirements**
- User will see a navigation bar at the top of every page. On the navigation bar, users will see 3 options, singleplayer, multiplayer, leaderboards.
    - If a user left clicks singleplayer, they will be directed to the singleplayer program. 
    - If a user left clicks multiplayer, they will be directed to the multiplayer program. 

**Single Player Requirements**
- User will be assigned either playerX or playerO
    - The user is assigned a player randomly at the beginning of every game. 
    - The server is assigned a the opposite configuration as the user. (If user is playerX, server is playerO. If user is playerO, server is playerX)

- User will be presented with a 3 by 3 grid in the middle of the screen. 
    - Above the 3 by 3 grid right aligned to the grid, there will be a winstreak counter in the format "Winstreak: " + winStreakNumber
    - There will be a text left aligned above the grid stating whether it's playerX or playerO's turn to play. 

- When it's the user's turn, the user will be able to make a play on the grid. 
    - When it's the user's turn, a graphic will slide across the screen saying "Your Turn". 
    - playerX will always have the first turn. playerO will always have the second turn. This is a recursive process and will loop until the game concludes. 
    - To input a move, the user will left click on a box in the grid. If the user is playerX then there will be a X in the box. If the user is playerO there will be an O in the box.
    - Squares that have either an X or O inside are recorded as filled. Filled boxes are illegal moves. 
    - During the user's move, all legal moves (unfilled boxes) will have a dot in the center of the box to indicate a legal move. After a move is input, the turn is over.
    - When the turn is over, all dots will dissapear from the grid until it becomes the user's turn again.  
    - Users can only input moves when it's their turn. When it is not the user's turn, clicks inside the grid will not trigger anything. 
    - After the user inputs a move, a graphic will show up and fade away and a sound effect will play.

- When it's the server's turn, the computer will input a random legal move. 
    - A graphic will slide across the screen saying "Computer's Turn".
    - There will be an artificial delay before the server inputs a move. This delay will be a random duration between 2-3 seconds. 
    - After the server selects a box to input a move into, the corresponding symbol is placed inside the box. If the server is playerX then there will be a X in the box. If the server is playerO there will be an O in the box. 
    - During the delay, a buffering animation will play and loop until a move is input. 
    - After the server inputs a move, the turn is over. 

- When either the server or the user connects three of their symbols in a line, they win. 
    - A win is awarded if either Xs or Os are positioned on the board in one of the following combinations: 123, 147, 159, 357, 567, 369 (see image below)
    ![Tic Tac Toe board](https://cdn.discordapp.com/attachments/302526564636164098/896158325765468202/tictactoe.png)
    - If the player wins, a graphic will appear indicating the player has won and a point has been added to their winstreak counter. 
        - The number next to "Winstreak: " is incremented by one 
        - A button will appear with "next game" written on it in the center of the grid.
        - If the player clicks the button, everything on the grid is reset and a new game of tic-tac-toe begins
        - A graphic will fade in and out saying "Game: " + winStreakNumber + 1
    - If the computer wins, a graphic will appear indicating the player has lost. 
    - An input box will appear over the grid with the text "Please enter your name" 
    - After the player has entered their name, the server should save their name with the corresponding winstreak count at the time of their loss. 
    - After the player has input their name, a menu will appear in the center of the screen with 2 buttons: play again, and leaderboards. 
        - Clicking on the leaderboards button pulls up a leaderboard graphic in the middle of the screen which will display the top 40 highest winstreak counters mapped in the database along with the corresponding names in descending order from biggest to smallest. There will be a scroll bar if all the names cannot fit in the graphic. 
        - There will be a back button at the bottom of the leaderboards which will take players back to the previous menu when clicked. 
        - Clicking on the play again button will reset the game. This means the winstreak counter is set to 0 and a new game begins.

**Player vs Player Requirements**
-  When multiplayer is selected, a menu will first pop up with 2 buttons, local and online. 

Local: 
- If local is selected a 3 by 3 grid will appear in the center of the screen with a text above left aligned to the grid that indicates whether it is playerX or playerO's turn. 
- PlayerX will always go first. PlayerX can place a move by clicking any of the boxes in the grid. Once playerX has clicked a box, an X will appear in the box and the box is now illegal for future moves (unclickable). PlayerX's turn is over and the text at the top reflects this. 
- A graphic will slide across the screen indicating playerX's turn is over. 
- PlayerO can now click a box on the grid to place an O inside. 
- The game ends if the configuration of Xs or Os lines up as 3 (see image above) or if all boxes on the board are filled and neither played has own. 
- If Xs are lined up as 3, playerX wins, if Os are lined up as 3, playerO wins. 
- A graphic will appear congratulating the winning player if a player has won, or indicating a draw if the game has been drawn. A button will appear afterwards that says play again
- If play again is pressed the game will reset to the state when the multiplayer option was first selected.

Online: 
- If online is selected, a menu with the button find match will appear in the center of the screen. There will also be an optional text input box to type in a display name
- When find match is clicked, the button will switch to cancel search, and a finding match animation will play. The player will be placed in the matching queue 
- If 2 or more players are in the queue at the same time, the server will place them into pairs to play against each other.  
- If the player clicks cancel search, the player will be removed from the queue, and will be sent back to the previous menu with the find match button.
- When 2 players are matched one will randomly be assigned playerX and the other playerO. 
- A 3x3 grid will appear in the center of the screen. At the top left corner of the grid, there will be text indicating which player's turn it is. On the top right, there will be text telling you which player's been assigned (playerX or playerO). On the left side it will display your display name, and on the right your opponent's. If either player has not entered a display name, they will be assigned anon as their display name.
- There will be a "chat feature" where players can click on 3 different buttons: glhf!, gg!, or good move!. If you select a chat option, the message will appear inside a chat bubble next to your display name. 
- When a player wins, a graphic will appear over the grid indicating whether you won or lost. There will also be a button that says play again which will put you back into the queue if clicked. 

**Leaderboards Requirements**
- When the leaderboards page is pulled up, there will be a box in the center of the page. In the box will be the full leaderboards graphic. There will be a scroll bar if the full leaderboard doesn't fit. 
- There will be an input box above the leaderboards where the user can search a specific name, and the leaderboards will filter by the name entered.

**Widgets Requirements**
- There will be a music widget on the multiplayer and singleplayer pages underneath the 3x3 grid. It will show up in a minimized form, and expand if the mouse hovers over it.  
- There will be a weather widget which will be on all the pages except for homepage. It will be located to the left of the page in a minimized form. When moused over, it will expand. 

**Wireframe**
 ![Wireframe](https://cdn.discordapp.com/attachments/902823761739386922/907382332527358002/2_TikTak2.png)
A more clear image can be found Here https://github.com/Juliand6/Tic-Tac-Toe/blob/main/2_TikTak2.pdf
