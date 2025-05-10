package io.github.poisonsheep.coralinesdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

// 这是一个简单的方块
public class ShinobuBlock extends HorizontalDirectionalBlock {

    public ShinobuBlock() {
        super(Properties.of()
                // ------------------------- 面渲染 -------------------------
                // 如果没有这个参数，那么方块只会渲染玩家看到它的三个面，非完整方块必加，不然会直接透视,你可能会问，那我不管啥方块都加上不就完了，还真是，这个方法存在是为了优化性能的
                .noOcclusion()
                // ------------------------- 声音 -------------------------
                // SoundType类是MC原版方块的音效库，偷懒的话直接从这调用就行，比如这里用的羊毛声音模板，把.WOOL删了重新打.符号，会提示你有哪些选择
                // 自定义音效以后再讲
                .sound(SoundType.WOOL));
    }

    /* ------------------------- 方块碰撞体积 -------------------------
     * 没有接下来的代码，方块的碰撞体积就是一个默认的16x16x16的正方体(16指的是mc的最小渲染面尺寸为1个像素点)，不要把碰撞体积和模型搞混了
     *
     *
     */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }


}
