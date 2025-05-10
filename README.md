# CoralinesDelight 模组物品创建指南

本教程将指导你如何在自己的模板Mod中添加新物品，包含从代码到资源的完整流程（基于Minecraft 1.20.1  Forge环境）

---

## 📌 物品创建指南

### 第一步：创建物品类
1. 在 `src/main/java/io/github/poisonsheep/coralinesdelight/item` 文件夹中

2. 右键新建Java类文件（例：`GoldenStrawberryItem.java`）

3. 复制以下模板代码并修改属性：

```java
public class GoldenStrawberryItem extends Item {
    public GoldenStrawberryItem() {
        super(new Item.Properties()
            .stacksTo(16) // 修改堆叠数量
            .food(new FoodProperties.Builder() // 删除整个food块禁用食用功能
                .nutrition(4)
                .saturationMod(0.8F)
                .build())
        );
    }
}
```

### 第二步：注册物品

1. 打开
   `src/main/java/io/github/poisonsheep/coralinesdelight/registry/ItemRegistry.java`

2. 在类末尾添加注册条目（注意保持代码风格）：
```java
public static final RegistryObject<Item> GOLDEN_STRAWBERRY = 
    ITEMS.register("golden_strawberry", GoldenStrawberryItem::new);
```

### 第三步：添加至创造模式物品栏

1. 找到 `src/main/java/io/github/poisonsheep/coralinesdelight/registry/TabRegistry.java`

2. 在物品栏构建器中添加引用：
```java
event.accept(ItemRegistry.GOLDEN_STRAWBERRY.get());
```

### 第四步：添加本地化翻译

1. **英文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/en_us.json`
```json
    {
      "item.coralines_delight.golden_strawberry": "Golden Strawberry"
    }
```

2. **中文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/zh_cn.json`
```json
    {
      "item.coralines_delight.golden_strawberry": "黄金草莓"
    }
```


### 第五步：创建物品模型

#### 常规物品模型（2D贴图）

1. **创建模型文件**  
   在 `src/main/resources/assets/coralinesdelight/models/item` 中新建 `golden_strawberry.json`

2. **使用基础模型模板**：
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "coralines_delight:item/golden_strawberry"
  }
}
```
3. **关键配置说明**：

   - `parent`: 使用标准物品模板

   - `layer0`: 贴图路径对应 `textures/item` 中的PNG文件

   - 文件名必须与注册ID **完全一致**（如 `golden_strawberry.json`）

#### 3D物品模型

4. **准备模型文件**：

   - 将使用 Blockbench 制作的模型文件（如 `cotton_candy.json`）放入同一目录

   - 确保文件名与注册ID匹配（例：`cotton_candy.json`）

5. **典型3D模型结构**：
```json
{  
    "credit": "Made with Blockbench",  
    "texture_size": [32, 32],  
    "textures": {  
       "0": "coralines_delight:item/cotton_item",  
       "particle": "coralines_delight:item/cotton_item"  
    },  
    "elements": [  
       {  
          "from": [8, 0, 7],  
          "to": [9, 11, 8],  
          "rotation": {"angle": 0, "axis": "y", "origin": [7, 0, 7]},  
          "faces": {  
             "north": {"uv": [0, 9, 0.5, 14.5], "texture": "#0"},  
             "east": {"uv": [0.5, 9, 1, 14.5], "texture": "#0"},  
             "south": {"uv": [1, 9, 1.5, 14.5], "texture": "#0"},  
             "west": {"uv": [1.5, 9, 2, 14.5], "texture": "#0"},  
             "up": {"uv": [6.5, 6, 6, 5.5], "texture": "#0"},  
             "down": {"uv": [7, 5.5, 6.5, 6], "texture": "#0"}  
          }  
       },  
       {  
          "from": [6, 6, 5],  
          "to": [11, 9, 10],  
          "rotation": {"angle": 0, "axis": "y", "origin": [6, 6, 6]},  
          "faces": {  
             "north": {"uv": [8, 8, 10.5, 9.5], "texture": "#0"},  
             "east": {"uv": [3, 8.5, 5.5, 10], "texture": "#0"},  
             "south": {"uv": [8.5, 3, 11, 4.5], "texture": "#0"},  
             "west": {"uv": [5.5, 8.5, 8, 10], "texture": "#0"},  
             "up": {"uv": [5.5, 8.5, 3, 6], "texture": "#0"},  
             "down": {"uv": [8.5, 3, 6, 5.5], "texture": "#0"}  
          }  
       },  
       {  
          "from": [6, 15, 5],  
          "to": [11, 17, 10],  
          "rotation": {"angle": 0, "axis": "y", "origin": [6, 15, 6]},  
          "faces": {  
             "north": {"uv": [8.5, 4.5, 11, 5.5], "texture": "#0"},  
             "east": {"uv": [9, 0, 11.5, 1], "texture": "#0"},  
             "south": {"uv": [9, 1, 11.5, 2], "texture": "#0"},  
             "west": {"uv": [9, 2, 11.5, 3], "texture": "#0"},  
             "up": {"uv": [8, 8.5, 5.5, 6], "texture": "#0"},  
             "down": {"uv": [10.5, 5.5, 8, 8], "texture": "#0"}  
          }  
       },  
       {  
          "from": [5.4, 9.1, 4.3],  
          "to": [11.4, 15.1, 10.3],  
          "rotation": {"angle": 0, "axis": "y", "origin": [6.4, 9.1, 5.3]},  
          "faces": {  
             "north": {"uv": [0, 0, 3, 3], "texture": "#0"},  
             "east": {"uv": [0, 3, 3, 6], "texture": "#0"},  
             "south": {"uv": [3, 0, 6, 3], "texture": "#0"},  
             "west": {"uv": [3, 3, 6, 6], "texture": "#0"},  
             "up": {"uv": [3, 9, 0, 6], "texture": "#0"},  
             "down": {"uv": [9, 0, 6, 3], "texture": "#0"}  
          }  
       }  
    ],  
    "display": {  
       "thirdperson_righthand": {  
          "translation": [0, 2.75, 1.25]  
       }  
    }  
}
```

3. **关键配置说明**：

   - `0`以及`"particle"`贴图路径对应 `textures/item` 中的PNG文件

   - 模型在玩家物品栏中的方向大小以及第三人称下模型处于玩家身体哪个部位都可以在blockbench中调整

#### ⚠️ 注意事项

1. **文件命名规范**：

   - JSON文件名必须与注册ID **全小写** 一致

   - 例：注册为 `golden_strawberry` → 模型文件 `golden_strawberry.json`

---

## 方块创建指南
开始本篇前我们需要明确什么是方块，**方块（Block)** 是Minecraft世界里最基本的组成单位，只存在于世界中，需同玩家手中的方块物品区分开来。玩家手中的方块是一种拥有方块模型的物品，只是具有特殊右键的功能，从代码上讲该功能就是每一次右键使目会在标位置放置一个方块，然后物品栏中该物品堆的数量减一(如果是创造模式则不减)。这样看来我们创建方块需要进行两步，创建方块以及创建相应的方块物品(如果说只创建方块不创建物品也是可以的，不过只能通过指令`setblock`放置)

###  创建方块

#### 第一步：创建方块类

1. 在 `src/main/java/io/github/poisonsheep/coralinesdelight/block` 文件夹中

2. 右键新建Java类文件（例：`ExampleBlock.java`）

3. 方块可自定义的部分较多，详见`ExampleBlock.java`

#### 第二步：注册方块

1. 打开
   `src/main/java/io/github/poisonsheep/coralinesdelight/registry/BlockRegistry.java`

2. 在类末尾添加注册条目（注意保持代码风格）：
```java
public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", ExampleBlock::new);
```

#### 第三步：添加本地化翻译

1. **英文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/en_us.json`
```json
    {
      "block.coralines_delight.example_block": "Example Block"
    }
```

2. **中文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/zh_cn.json`
```json
    {
      "block.coralines_delight.example_block": "示范方块"
    }
```

#### 第五步：创建方块状态

Minecraft有的方块只有一种状态，有的不止一种，举个例子，活板门方块就有打开和关上的状态。有的时候模型一致朝向不同也是不同的状态，比如熔炉，摆放的时候它总是朝向你，事实上，东南西北四个朝向都各自为一个状态。

**创建方块状态文件**  
在 `src/main/resources/assets/coralinesdelight/blockstates` 中新建 `example_block.json`

对于没有状态变化的方块：
```json
{  
  "variants": {  
    "": {  
      "model": "coralines_delight:block/example_block"  
    }  
  }  
}
```

**说明**
- `coralines_delight:block/example_block`: 这是对应的这种状态下的模型文件路径

#### 第六步：创建方块模型

**创建方块模型文件**  
在 `src/main/resources/assets/coralinesdelight/models/block` 中新建 `example_block.json`

#####  常规正方体方块

```json
{  
  "parent": "minecraft:block/cube_all",  
  "textures": {  
    "all": "coralines_delight:block/example_block"  
  }  
}
```

**说明**
- `parent`: 使用标准方块模板
- `textures`: 方块每个面贴图路径对应 `textures/block` 中的PNG文件

##### 3D模型方块
这方面方块模型和物品模型并没有什么不同，都是支持json格式的文件，请查看棉花糖模型示范，注意更改以下这部分对应贴图路径的代码
```json
{  
       "0": "coralines_delight:block/example_block",  
       "particle": "coralines_delight:block/example_block"  
}
```