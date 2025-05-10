package io.github.poisonsheep.coralinesdelight.item;

import net.minecraft.world.item.Item;

public class ButtonItem extends Item {
    public ButtonItem() {
        super(new Item.Properties()
                .stacksTo(64) // 修改堆叠数量
        );
    }
}