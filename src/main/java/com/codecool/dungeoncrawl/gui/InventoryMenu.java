package com.codecool.dungeoncrawl.gui;

import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.map.Tiles;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class InventoryMenu {
    GraphicsContext context;
    double width;
    double height;

    public InventoryMenu(GraphicsContext context, double width, double height) {
        this.context = context;
        this.width = width;
        this.height = height;
    }

    public void show(List<Item> inventory) {
        context.setFill(Color.BLUE);
        context.fillRect(width - 2, height - 2, 204, 204);
        context.setFill(Color.GRAY);
        context.fillRect(width, height, 200, 200);
        context.strokeText("Inventory", 460, 282);
        int y = 300;
        for (int i = 0; i < inventory.size(); i++, y+=15) {
            context.strokeText(inventory.get(i).getName(), 410, y);
        }

    }

    private void writeText(String inv, int x, int y) {
        for (int i = 0; i < inv.length(); i++) {
            Tiles.drawTile(context, String.valueOf(inv.charAt(i)), x+i , y);

        }
    }


}
