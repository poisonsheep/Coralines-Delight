package io.github.poisonsheep.coralinesdelight.registry;

import io.github.poisonsheep.coralinesdelight.CoralinesDelight;
import io.github.poisonsheep.coralinesdelight.block.CottonBlock;
import io.github.poisonsheep.coralinesdelight.block.ExampleBlock;
import io.github.poisonsheep.coralinesdelight.block.ShinobuBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CoralinesDelight.MODID);

    public static final RegistryObject<Block> COTTON_BLOCK = BLOCKS.register("cotton_block", CottonBlock::new);

    /* ------------------------- 物品注册模板 -------------------------
     * 注册新物品的三要素：
     * 1. RegistryObject变量名：全大写+下划线命名，对应游戏内注册名
     * 2. 注册名称字符串：全小写+下划线命名，对应方块ID
     * 3. 方块类构造器：指向方块类的构造函数（需提前创建）
     *
     * 格式示例：
     * public static final RegistryObject<Block> 变量名 =
     *     BLOCKS.register("注册名称", 方块类::new);
     */

    // 示例方块注册（可删除）
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", ExampleBlock::new);

    // ▶▶▶ 新方块注册位置 ▶▶▶
    public static final RegistryObject<Block> SHINOBU_BLOCK = BLOCKS.register("shinobu_block", ShinobuBlock::new);
    // 在此处添加新的注册条目，格式如下：
    // public static final RegistryObject<Block> 大写方块名 =
    //     BLOCKS.register("小写方块", 自定义方块类::new);

    // ▼▼▼ 示例：注册一个名为 "brick_block" 的物品 ▼▼▼
    // public static final RegistryObject<Block> BRICK_BLOCK =
    //     BLOCKS.register("brick_block", BrickBlock::new);
}
