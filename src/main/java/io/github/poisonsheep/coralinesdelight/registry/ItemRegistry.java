package io.github.poisonsheep.coralinesdelight.registry;

import io.github.poisonsheep.coralinesdelight.CoralinesDelight;
import io.github.poisonsheep.coralinesdelight.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    // 物品注册器（自动对接Forge系统，不要修改这个变量）
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CoralinesDelight.MODID);

    public static final RegistryObject<Item> COTTON_ITEM = ITEMS.register("cotton_item", () -> new CottonItem(BlockRegistry.COTTON_BLOCK.get()));

    /* ------------------------- 物品注册模板 -------------------------
     * 注册新物品的三要素：
     * 1. RegistryObject变量名：全大写+下划线命名，对应游戏内注册名
     * 2. 注册名称字符串：全小写+下划线命名，对应物品ID
     * 3. 物品类构造器：指向物品类的构造函数（需提前创建）
     *
     * 格式示例：
     * public static final RegistryObject<Item> 变量名 =
     *     ITEMS.register("注册名称", 物品类::new);
     */

    // 示例普通物品注册
    public static final RegistryObject<Item> EXAMPLE_ITEM =
            ITEMS.register("example_item", ExampleItem::new);

    // ▶▶▶ 新物品注册位置 ▶▶▶
    public static final RegistryObject<Item> BUTTON=
            ITEMS.register("button", ButtonItem::new);
    // 在此处添加新的注册条目，格式如下：
    // public static final RegistryObject<Item> 大写物品名 =
    //     ITEMS.register("小写物品名", 自定义物品类::new);

    // ▼▼▼ 示例：注册一个名为 "berry_juice" 的物品 ▼▼▼
    // public static final RegistryObject<Item> BERRY_JUICE =
    //     ITEMS.register("berry_juice", BerryJuiceItem::new);

    // ▼▼▼ 示例：注册一个名为 "chocolate_cake" 的物品 ▼▼▼
    // public static final RegistryObject<Item> CHOCOLATE_CAKE =
    //     ITEMS.register("chocolate_cake", ChocolateCakeItem::new);
    public static final RegistryObject<Item> Shinobu_BLOCK_ITEM =
            ITEMS.register("shinobu_block_item", () -> new ShinobuBlockItem(BlockRegistry.SHINOBU_BLOCK.get()));

    // 示例方块物品注册
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM =
            ITEMS.register("example_block_item", () -> new ExampleBlockItem(BlockRegistry.EXAMPLE_BLOCK.get()));

    public static final RegistryObject<Item> EXAMPLE_HORIZONTAL_DIRECTIONAL_BLOCK_ITEM =
            ITEMS.register("example_horizontal_directional_block_item", () -> new ExampleHorizontalDirectionalBlockItem(BlockRegistry.EXAMPLE_HORIZONTAL_DIRECTIONAL_BLOCK.get()));
}