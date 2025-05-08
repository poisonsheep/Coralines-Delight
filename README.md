# CoralinesDelight 模组物品创建指南

本教程将指导你如何在自己的模板Mod中添加新物品，包含从代码到资源的完整流程（基于Minecraft 1.20.1  Forge环境）

---

## 📌 完整创建流程

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
output.accept(ItemRegistry.GOLDEN_STRAWBERRY.get());
```

### 第四步：添加本地化翻译

1. **英文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/en_us.json`
```json
    {
      "item.coralinesdelight.golden_strawberry": "Golden Strawberry"
    }
```

2. **中文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/zh_cn.json`
```json
    {
      "item.coralinesdelight.golden_strawberry": "黄金草莓"
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
    "layer0": "coralinesdelight:item/golden_strawberry"
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

### 第六步：制作物品贴图

1. 使用像素画工具（推荐 Aseprite 或 Photoshop）

2. 创建 16x16 像素的PNG文件

3. 保存到 `src/main/resources/assets/coralinesdelight/textures/item`

4. 命名为 `golden_strawberry.png`（必须与模型文件中的名称一致）


---