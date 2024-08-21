# SplatWordle
wordle clone with a custom word bank (splatoon themed!) and alternative game modes and rules

- two game modes: normal and blind
    - normal: standard wordle rules, 8 guesses to find the secret word
    - blind: instead of which letters are in correct positions or not, you only get to know how many! 12 guesses to find the secret word
- variable word length
    - choose between 4 to 6, or play with the mixed length rule: you may guess any word between length 4-6, and you get clued on if the guess has the correct word length
- customisable word bank
    - this current version works only locally, and grabs words randomly from its local word bank file
    - each word also comes with some flavour text, displayed at the end of each game when that word is used as the solution
    - words the word bank file included in the repository are Splatoon themed and are written by me!
    - feel free to edit the word bank, or use your own!



# How to run:
You can download this and run it yourself to play! On an IDE that can run Java:
- import wordle.GameMaster
- in App.java, run the line: GameMaster.gameMaster();



# More about the project:
This is my first personal project! I wrote all the code from scratch by myself. Admittedly Wordle is not a very complex game, so I didn't actually spend that much time writing the code. In fact, most of the developing time was compiling the word bank and writing up flavour texts for each word. (This might seem unnecessary, but it actually helped me find a lot of words that I would have missed otherwise!)

As soon as I shared this with my friends for the first time, many of them expected some form of playable version without running the code on a laptop. So that will be what I work on next! If any of them sees this, I'm sorry for causing such a hassle, I'll learn to be a better developer!
