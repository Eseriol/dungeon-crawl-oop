package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label itemsLabel = new Label();
    Button button = new Button();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);
        ui.add(button, 2, 2);


        button.setFocusTraversable(false);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);


        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                refresh();
                break;
            case ENTER:
                System.out.println(button);
                Cell cellOfPlayer = map.getPlayer().getCell();
                if (CellType.getItemsList().contains(cellOfPlayer.getType())) {
                    cellOfPlayer.setEmptyTile();
                }
                refresh();
                break;
            case SPACE:
                System.out.println("spc pressed");
                ArrayList<Cell> list = map.getPlayer().getCell().getNeighbors();
                ArrayList<Cell> cellsWithMonsters = new ArrayList<>();
                list.forEach(cell -> {
                    if(CellType.monsterList().contains(cell.getType())){
                        cellsWithMonsters.add(cell);
                    }
                });
                if (cellsWithMonsters.size() > 0){
                    fight(cellsWithMonsters.get(0), map.getPlayer());
                }

                refresh();
                break;
        }
    }

    private void fight(Cell enemyCell, Player playerCell) {
        if (CellType.SKELETON == enemyCell.getType()){
            System.out.println(enemyCell.toString());
            Skeleton skeleton = new Skeleton(enemyCell);
            while (skeleton.getShealth() > 0) {
                skeleton.gotHit(playerCell.getDamage());
            }
            skeleton.getCell().setEmptyTile();
            refresh();
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        button.setText("Pick up");
    }
}
