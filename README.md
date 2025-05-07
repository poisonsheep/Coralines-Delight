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
```
public static final RegistryObject<Item> GOLDEN_STRAWBERRY = 
    ITEMS.register("golden_strawberry", GoldenStrawberryItem::new);
```

### 第三步：添加至创造模式物品栏

1. 找到 `src/main/java/io/github/poisonsheep/coralinesdelight/registry/TabRegistry.java`

2. 在物品栏构建器中添加引用：
```
output.accept(ItemRegistry.GOLDEN_STRAWBERRY.get());
```

### 第四步：添加本地化翻译

1. **英文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/en_us.json`
```
    {
      "item.coralinesdelight.golden_strawberry": "Golden Strawberry"
    }
```

2. **中文翻译**：  
   `src/main/resources/assets/coralinesdelight/lang/zh_cn.json`
```
    {
      "item.coralinesdelight.golden_strawberry": "黄金草莓"
    }
```


### 第五步：创建物品模型

1. 在 `src/main/resources/assets/coralinesdelight/models/item` 文件夹

2. 复制 `example_item.json` 并重命名为 `golden_strawberry.json`

3. 修改贴图路径：
```
{
  "parent": "item/generated",
  "textures": {
    "layer0": "coralinesdelight:item/golden_strawberry"
  }
}
```

### 第六步：制作物品贴图

1. 使用像素画工具（推荐 Aseprite 或 Photoshop）

2. 创建 16x16 像素的PNG文件

3. 保存到 `src/main/resources/assets/coralinesdelight/textures/item`

4. 命名为 `golden_strawberry.png`（必须与模型文件中的名称一致）


---