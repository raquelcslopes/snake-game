# Snake Game Skeleton

This project is a basic skeleton for a Snake game implemented in Java. It uses the Lanterna library for terminal-based graphics.

## Features
- Terminal-based interface using Lanterna
- Snake movement and growth
- Fruit spawning and collection
- Game over and pause functionality
- Obstacles (optional, depending on implementation)

## Requirements
- Java 8 or higher
- Lanterna library (already included in the project dependencies)

## How to Run
1. Clone this repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Build the project.
4. Run the `Main.java` file located at `src/academy/mindswap/Main.java`.

## Controls
- Use the arrow keys to control the snake's direction.
- Press `P` to pause or resume the game.
- The game ends if the snake collides with itself, the border, or an obstacle.

## Project Structure
- `academy.mindswap.field` - Field and obstacle logic
- `academy.mindswap.gameobjects.snake` - Snake logic and direction
- `academy.mindswap.gameobjects.fruit` - Fruit logic
- `academy.mindswap` - Main game loop and entry point

## License
This project is provided as-is for educational purposes.

