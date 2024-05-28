# PacmanProject

## Overview
This repository contains two versions of the PacMan game developed for CPSC 233: a text-based version and a GUI version. Both versions track scores and highscores and require JavaFX to be installed on your system.

## Features
- Two versions: Text and GUI
- Score and highscore tracking
- Collision detection
- Simple and intuitive controls

## Prerequisites
Before running the game, ensure you have the following installed:
- Java Development Kit (JDK)
- JavaFX

## Installation

### JavaFX Setup
1. Download JavaFX from the official [JavaFX website](https://openjfx.io/).
2. Follow the installation instructions specific to your operating system.
3. Ensure your IDE (Eclipse) is configured to use JavaFX.

### Importing the Project
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/sami-abd/PacmanProject.git
2. Open Eclipse and import the project:
   - File > Import > General > Existing Projects into Workspace > Select the cloned directory.

## Running the GUI Version
1. Ensure all `.gif` and `.jpg` files are in the same package.
2. In Eclipse, navigate to `src/com/pacmanproject/main/FXGame.java`.
3. Right-click `FXGame.java` and select `Run As > Java Application`.
4. Use the arrow keys to move PacMan around and avoid the ghosts. Restart if caught.

## Running the Text Version
1. In Eclipse, navigate to `src/com/pacmanproject/main/TextGame.java`.
2. Right-click `TextGame.java` and select `Run As > Java Application`.
3. Follow the on-screen instructions to play the game.

## Running JUnit Tests
1. Ensure JUnit 4 is included in your build path:
   - Right-click the project > Build Path > Add Libraries... > JUnit > JUnit 4.
2. Navigate to the test folder:
   - `src/com/pacmanproject/test/GhostTest.java`
   - `src/com/pacmanproject/test/GridTest.java`
3. Right-click each test file and select `Run As > JUnit Test`.

## Gameplay Instructions

### GUI Version
- **Controls:** Use the arrow keys to navigate PacMan.
- **Objective:** Eat food items to increase your score. Avoid ghosts. If caught, you can restart and try to beat your highscore.
- **Features:** Collision detection ensures PacMan cannot pass through walls, and food items disappear upon being eaten.

### Text Version
- **Controls:** Follow the printed instructions on the screen.
- **Objective:** Similar to the GUI version, navigate PacMan, eat food items, and avoid ghosts.

## Resources
- `blueGhost.gif`, `pacmanRight.gif`, `redGhost.gif`: Character sprites.
- `GameOver.jpg`: Game over screen.
- `Highscore.bin`: Highscore data file.
- `wall.png`: Wall texture.

## Documentation
- `CPSC Updated UML.docx`: Updated UML diagram.
- `FinalProjectProposal.pdf`: Project proposal document.
- `Team Contract.docx`: Team contract agreement.

## Screenshots and GIFs
### GUI Version Gameplay
![GUI Gameplay](resources/screenshots/gui_gameplay.png)

### Game Over Screen
![Game Over](resources/screenshots/game_over.png)

### Text Version Gameplay
![Text Gameplay](resources/screenshots/text_gameplay.png)

### GIF
![Gameplay GIF](resources/screenshots/gameplay.gif)


