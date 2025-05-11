package io.github.poisonsheep.coralinesdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

/* 这种方块跟普通方块代码区别:
 * 1.继承的类从Block变成了HorizontalDirectionalBlock
 * 2.多了两个方法createBlockStateDefinition和getStateForPlacement
*/
public class ExampleHorizontalDirectionalBlock extends HorizontalDirectionalBlock {

    public ExampleHorizontalDirectionalBlock() {
        super(BlockBehaviour.Properties.of()
                // ------------------------- 面渲染 -------------------------
                // 如果没有这个参数，那么方块只会渲染玩家看到它的三个面，非完整方块必加，不然会直接透视,你可能会问，那我不管啥方块都加上不就完了，还真是，这个方法存在是为了优化性能的
                .noOcclusion()
                // ------------------------- 声音 -------------------------
                // SoundType类是MC原版方块的音效库，偷懒的话直接从这调用就行，比如这里用的羊毛声音模板，把.WOOL删了重新打.符号，会提示你有哪些选择
                // 自定义音效以后再讲
                .sound(SoundType.WOOL));
    }

    // 这个方法就是给方块添加了一个方块状态FACING
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    // 这个方法是让玩家放置该方块的时候设定状态为FACING，FACING有东南西北四个值，context.getHorizontalDirection()这个参数就是玩家面朝方向，.getOpposite()把前面的方向取反，这样方块就能面朝玩家了
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
