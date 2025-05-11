package io.github.poisonsheep.coralinesdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ExampleHorizontalDirectionalBlockItem extends BlockItem {

    public ExampleHorizontalDirectionalBlockItem(Block block) {
        super(block, new Item.Properties()
                // ------------------------- 堆叠数量设置区域 -------------------------
                // 通过.stacksTo()方法设置最大堆叠数量（参数为整数）
                // 不设置时默认最大堆叠64个
                .stacksTo(32) // 设置该物品最大堆叠32个（按需修改数字）
                // ------------------------- 食用属性设置区域 -------------------------
                // 通过.food()方法添加食物属性表示该物品可食用
                // 若要禁用食用功能，删除整个.food()代码块即可
                .food(new FoodProperties.Builder()
                        .nutrition(2)    // 设置食用后恢复的饥饿值（鸡腿图标）
                        .saturationMod(0.6F) // 设置饱食度加成（隐藏饱和度，数值越大饱食时间越长）
                        .alwaysEat()     // 允许任何时候食用（包括满饥饿值时）
                        //.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F) // 可选：添加食用后效果
                        .build())
        );
    }
}
