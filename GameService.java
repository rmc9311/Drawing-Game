package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	//  Singleton function to make it so there is only one instance of a game. 
	//This helps regulate the game and not clog the memory or speed.
	private static GameService game = new GameService();
	private GameService() {
		
	}
	
	public static GameService getGame() {
		return game;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		// Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		// Going throught the Arraylist to find if the game(both ID and name) exist
		Iterator<Game> gameIteration = games.iterator();
		
		while (gameIteration.hasNext()) {
			if (name.equals(gameIteration.next().getName())) {
				return gameIteration.next() ;
			}
		}
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		
		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		//Going through the Arraylist to find if the game ID exist
		Iterator<Game> idIteration = games.iterator();
		while (idIteration.hasNext()) {
			if (idIteration.next().getId() == id) {
				game = idIteration.next();
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		//Going throught the Arraylist to find if the name exists
		Iterator<Game> nameIteration = games.iterator();
		while (nameIteration.hasNext()) {
			if (nameIteration.next().getName() == name) {
				game = nameIteration.next() ;
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
