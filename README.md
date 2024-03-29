# Kanji Trainer

This is a simple Java application that helps users learn Kanji, the logographic characters used in the Japanese writing system. The project is built with Maven and uses JavaFX for the graphical user interface.

## Source files

- [MainApp.java](src/main/java/kanjitrainer/MainApp.java): This is the main entry point of the application. It launches the GUI.

- [Dictionary.java](src/main/java/kanjitrainer/Dictionary.java): This class represents a dictionary of Kanji characters. It reads from a file and stores Kanji characters along with their translations and readings.

- [GUI.java](src/main/java/kanjitrainer/GUI.java): This class represents the graphical user interface of the application. It displays a random Kanji character and asks the user to choose the correct translation.

- [kanji.txt](src/main/resources/kanji.txt): This file contains the dictionary of Kanji characters. Each line contains a Kanji character, its translation and its reading, separated by a semicolon. You may add more characters to this file to expand the dictionary.

## Quick start guide (non-developers)

See the releases on the right or click [here](https://github.com/MJKagone/Kanji-trainer/releases/latest).

## Screenshots

Start screen:

![Main screen](screenshots/kanjitrainer1.png)

Click "capital":

![Incorrect answer](screenshots/kanjitrainer2.png)

Click "to go":

![Correct answer](screenshots/kanjitrainer3.png)

Wait a few seconds:

![Next question](screenshots/kanjitrainer4.png)


