# Setup

Run these commands in the parent directory to start the program.

## Linux and Mac

```bash
javac -d bin $(find src -name '*.java')
java -cp bin main.Main
```

## Windows

```bash
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
java -cp bin main.Main
```

# OVERVIEW

**Tagu-taguan** is intended to be a multiplayer game. You can join a game with devices connected to the same local network, or host a game.

The players are trapped in a dark room.
One player plays as the tagged player, while other players have to stay away from the IT.
The objective of players is to escape from the IT by finding the exit door.
Players can hold and use knives to eliminate other players.
Players can hold and use keys to unlock doors.
Players can hide in closets.
Players can chat with each other.

# CONTROLS

`W,A,S,D` - move up, left, down, right, respectively
`E` - hide or unhide from closet
`Q` - drop an item, players can only hold one item at a time

# ABOUT
- Game Creators:
  - Victor Farrel Angelo Beso
  - Reinalyn Madrid
  - Riel Jefferson Morales
- A final project for the course CMSC 137 - Data Communications and Networking
- We only had to complete the project for one and a half month.


# TODO:

- Test if the program works in multiplayer
- What does the program look like from other people's perspective?
- What happens if two people host a game?
- What happens if no one has hosted the game, but one player pressed 'join game'?
  - Players are forced in single player mode, although there's no message in the GUI that they have to play alone.

# LIMITATIONS
- Only one instance of the program can run per device.
- No specifically assigned roles.

