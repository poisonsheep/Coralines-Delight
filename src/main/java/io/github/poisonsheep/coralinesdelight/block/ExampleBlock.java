package io.github.poisonsheep.coralinesdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

// 这是一个简单的方块
public class ExampleBlock extends Block {

    public ExampleBlock() {
        super(BlockBehaviour.Properties.of()
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

    // 这里是新建了一个碰撞体积的对象，直接用的棉花糖的碰撞体积作为示范
    public static final VoxelShape SHAPE = Stream.of(
            // 这里每一个Block.box(8, 0, 7, 9, 11, 8)都是一个bb模型的cube，有多少个cube就得写多少行
            // 前面三个数字和后面三个数字是这个正方体对角线两个点的坐标
            // 如果想要碰撞体积贴合模型，直接从模型json文件里面把每个方块元素copy过来
            /*
            浏览一下模型json，里面那个elements后面每一个大括号是一个cube，from三个数字抄前面，to后面三个数字抄后面
			"from": [8, 0, 7],
			"to": [9, 11, 8],
            */
            // 这个数字最大不能超过16，超过16就改为16
            Block.box(8, 0, 7, 9, 11, 8),
            Block.box(6, 6, 5, 11, 9, 10),
            Block.box(6, 15, 5, 11, 16, 10),
            Block.box(5.4, 9.1, 4.3, 11.4, 15.1, 10.3)
    )
            //后面这一坨直接复制就完了
            .reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    // 这个方法直接复制就完了，用来把创建好的SHAPE给组装上
    @Override
    public VoxelShape getShape(BlockState State, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

}
