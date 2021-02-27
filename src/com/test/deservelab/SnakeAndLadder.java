package com.test.deservelab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadder {

	final int winPoint = 100;
	int player = 0;

	Map<Integer, Integer> snake = new HashMap<>();
	Map<Integer, Integer> ladder = new HashMap<>();

	SnakeAndLadder() {
		snake.put(99, 54);
		snake.put(70, 55);
		snake.put(52, 42);
		snake.put(25, 2);
		snake.put(95, 72);

		snake.put(6, 25);
		snake.put(11, 40);
		snake.put(60, 85);
		snake.put(46, 90);
		snake.put(17, 69);
	}

	public int moveThePlayer(int dicevalue) {
		player = player + dicevalue;

		if (player > winPoint) {
			player = player - dicevalue;
			return player;
		}

		if (snake.get(player) != null) {
			System.out.println("biten by snake");
			player = snake.get(player);
		}

		if (ladder.get(player) != null) {
			System.out.println("ladder climbed");
			player = ladder.get(player);
		}
		return player;
	}

	public int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		return (n == 0 ? 1 : n);
	}

	public static int rollCrookedDice() {
		Random rand = new Random();
		int random = rand.nextInt(8);
		random = (random * 2) % 8;
		return (random == 0 ? 2 : random);
	}

	public void startGame() {
		int diceValue = 0;
		int i = 0;
		while (i < 100) {
			System.out.println(rollCrookedDice());
			i++;
		}
		System.out.println("=========================");
		while (i < 10) {
			diceValue = rollDice();
			player = moveThePlayer(diceValue);
			System.out.println("Player moved to position: " + player);
			if (winPoint == player) {
				System.out.println("winner");
				return;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
		snakeAndLadder.startGame();
	}
}
