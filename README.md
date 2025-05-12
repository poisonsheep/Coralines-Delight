# 📖 模组物品创建指南

本教程将指导你如何在自己的模板Mod中添加新物品，包含从代码到资源的完整流程（基于Minecraft 1.20.1  Forge环境）

---

## ✒️ 新建项目指南

### 第一步：下载并打开Mdk
1. 上forge官网下载Mdk[Downloads for Minecraft Forge for Minecraft 1.20.1](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.20.1.html)

2. 解压，会得到一个文件夹，这个就是一个基础的forge开发框架。最好他改个名，方便辨认，具体叫啥没有讲究，中英文都可

3. 用idea打开

### 第二步：更改Gradle配置
1. 找到根目录下 `gradle.properties` 文件对其进行修改
```
forge_version=47.4.0 // 这一项不要随便改，这是forge版本，只有在发现有新forge版本且有必要更新的时候才改，当然也可以回退版本，更改完会弹一个大象转圈的按钮让你重载项目，点一下就能更改
mod_id=examplemod  // mod的唯一id，命名空间(资源包也会放同名文件夹里)
mod_name=Example Mod // 展示用的名称
mod_license=All Rights Reserved // License是一种法律协议，它规定了软件代码可以被如何使用、修改和分发，最宽松的开源协议是MIT
mod_version=1.0.0 // 版本号
mod_group_id=com.example.examplemod // 组ID，两个具有相同组ID的模组同时加载时只有一个能用，把example换成作者id,examplemod替换成mod_id是较主流的做法
mod_authors=YourNameHere, OtherNameHere // 作者名
mod_description=Example mod description.\nNewline characters can be used and will be replaced properly. // mod简要描述，\n这个是换行符，代码不认识回车
```
就是这个按钮
![reload](https://github.com/poisonsheep/Coralines-Delight/blob/master/src/main/resources/reload.png?raw=true)

2. 找到 `src/main/resources/META-INF/mods.toml` 文件添加下面这一行，用作mod封面
```
logoFile="mod_icon.png"
```
**说明**
- `mod_icon.png` 为放置在 `src/main/resources` 用做mod封面图片的名字

### 第三步：新建Mod主类
1. 把它示范给的 `com.example.examplemod` 目录以及底下的文件全给删了，然后新建自己的工作路径，这个路径最好是之前修改 `gradle.properties` 中的 `mod_group_id`
   ![工作路径](https://github.com/poisonsheep/Coralines-Delight/blob/master/src/main/resources/working%20directory.png?raw=true)


2. 新建mod主类，右键文件夹空白地方新建**Java Class**。这里提一嘴**java**类名字基本遵循 `Word1Word2` 这样把两个首字母大写单词拼起来的命名规则，两个单词间不加任何其他符号包括空格跟下划线。主类名字一般用 `mod_id` 改，例如许愿泉的 `mod_id` 为 `wishing_fountain`，主类名称就叫 `WishingFountain`

3. 对主类进行编写。
   来点java小课堂，讲解主类是个什么东西，假如把mod比作一个变形金刚，那么mod主类相当于它的能源火种，其他所有类都是对于这个主类进行修饰，最后mod一整个组装到Minecraft这个大力神金刚上面
   如下是个简单的主类代码示范
```java
package com.example.examplemod;  
  
import net.minecraftforge.eventbus.api.IEventBus;  
import net.minecraftforge.fml.common.Mod;  
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;  
  
// 这里所有的ExampleMod改成java主类名，包括上面这个@Mod(ExampleMod.MODID)，类名public class ExampleMod还有构造方法 public ExampleMod()@Mod(ExampleMod.MODID)  
public class ExampleMod  
{  
    // 这个值是把mod_id写进java里，就是在gradle.properties的那个mod_id，一定要一样  
    public static final String MODID = "examplemod";  
  
    /* ------------------------- minecraft小课堂 -------------------------     * 事件是Minecraft里面一个重要系统  
     * Minecraft随着时间运行，会伴随有事件发生，比如玩家右键唱片机就会触发一个事件，通过对这个事件编写，就可以指定在玩家右键唱片机时发生什么事情  
     * 不止是玩家才会触发事件，事件有相当多，包括游戏启动时也会触发很多事件  
     */    // 这个modEventBus是一个Minecraft启动时发生的事件，通过对这个事件编写才能在游戏中添加各种有趣的东西，每次启动是不是会看到有个锤子在敲铁砧，那个时候就正在处理这个事件  
    public ExampleMod() {  
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();  
    }  
}
```
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

## 🧊方块创建指南
开始本篇前我们需要明确什么是方块，**方块（Block)** 是Minecraft世界里最基本的组成单位，只存在于世界中，需同玩家手中的方块物品区分开来。玩家手中的方块是一种拥有方块模型的物品，只是具有特殊右键的功能，从代码上讲该功能就是每一次右键使用在目标位置放置一个方块，然后物品栏中该物品堆的数量减一(如果是创造模式则不减)。这样看来我们创建方块需要进行两步，创建方块以及创建相应的方块物品(如果说只创建方块不创建物品也是可以的，不过只能通过指令`setblock`放置)

###  创建方块

#### 第一步：创建方块类
这部分因为可能用到不同的方块模板，所以得学习一下java中**父类子类**以及**继承**的概念。简单来说，**子类** **继承** **父类**的功能，还可以自定义其他的功能，**父类子类**存在的目的是在有多个代码重合率高的类的时候可以把重合这部分代码放父类，缩减代码量，还可以方便续写代码的人快速调用特殊功能的类。比如Minecraft的方块类`Block`就拥有一大堆子类，包括`HorizontalDirectionalBlock`(这个类写了一个叫`facing`的方块状态，用来方便创建能面朝不同方向的方块)，`EntityBlock`(这个方块子类也会经常用到，他是一个包含实体的方块，绑定实体的类才会拥有存储信息以及高级与玩家互动的功能，诸如箱子、熔炉和工作台都是`EntityBlock`的子类)

1. 在 `src/main/java/io/github/poisonsheep/coralinesdelight/block` 文件夹中

2. 右键新建Java类文件（例：`ExampleBlock.java`）

3. 创建普通方块让这个类继承`Block`类就行，详见`ExampleBlock.java`；如果想创建一个可以方便改变朝向的方块，那么让它继承`HorizontalDirectionalBlock`会更简单，详见`ExampleHorizontalDirectionalBlock.java`

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

**对于没有状态变化的方块：**
```json
{  
  "variants": {  
    "": {  
      "model": "coralines_delight:block/example_block"  
    }  
  }  
}
```
**对于继承`HorizontalDirectionalBlock`的方块：**
```json
{  
  "variants": {  
    "facing=east": {  
      "model": "coralines_delight:block/example_horizontal_directional_block",  
      "y": 90  
    },  
    "facing=north": {  
      "model": "coralines_delight:block/example_horizontal_directional_block"  
    },  
    "facing=south": {  
      "model": "coralines_delight:block/example_horizontal_directional_block",  
      "y": 180  
    },  
    "facing=west": {  
      "model": "coralines_delight:block/example_horizontal_directional_block",  
      "y": 270  
    }  
  }  
}
```
**说明**
- `"facing=east"`这就是一个方块状态，意味着`facing`状态为`east`，这个`facing`为`HorizontalDirectionalBlock`里的参数`Facing`在json文件中的映射，普通方块类用这个状态会报错
- `coralines_delight:block/example_block`: 这是对应的这种状态下的模型文件路径

#### 第六步：创建方块模型

**创建方块模型文件**  
在 `src/main/resources/assets/coralinesdelight/models/block` 中新建 `example_block.json`

#####  常规六面贴图都一样的正方体方块

```json
{  
  "parent": "minecraft:block/cube_all",  
  "textures": {  
    "all": "coralines_delight:block/example_block"  
  }  
}
```
**说明**
- `parent`: 使用所有面贴图都一样方块模板
- `textures`: 方块每个面贴图路径对应 `textures/block` 中的PNG文件

#####  六面贴图自定义正方体方块
如下是一个工作台的模型
```json
{  
  "parent": "minecraft:block/cube",  
  "textures": {  
    "down": "minecraft:block/oak_planks",  
    "east": "minecraft:block/crafting_table_side",  
    "north": "minecraft:block/crafting_table_front",  
    "particle": "minecraft:block/crafting_table_front",  
    "south": "minecraft:block/crafting_table_side",  
    "up": "minecraft:block/crafting_table_top",  
    "west": "minecraft:block/crafting_table_front"  
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

### 创建方块物品

1. 在 `src/main/java/io/github/poisonsheep/coralinesdelight/item` 文件夹中

2. 右键新建Java类文件（例：`ExampleBlockItem.java`）

3. 和普通物品类基本一致，详见`ExampleBlockItem.java`

#### 第二步：注册物品

1. 打开
   `src/main/java/io/github/poisonsheep/coralinesdelight/registry/ItemRegistry.java`

2. 在类末尾添加注册条目，注意绑定方块和物品在这里实现`BlockRegistry.EXAMPLE_BLOCK.get()`，还记得方块注册类里面那些大写的名字吗，用你的方块大写名字去替换这个EXAMPLE_BLOCK
```java
public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM =
        ITEMS.register("example_block_item", () -> new ExampleBlockItem(BlockRegistry.EXAMPLE_BLOCK.get()));
```

#### 第三步：添加至创造模式物品栏
同普通物品

#### 第四步：添加本地化翻译
方块物品的id会映射为方块的id，所以不用额外添加翻译映射

#### 第五步：创建物品模型
同普通物品，可使用方块默认模型，在游戏里就和草方块这些建筑方块一样，会在物品栏展示方块三个面