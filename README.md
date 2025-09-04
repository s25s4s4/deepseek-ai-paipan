# 🤖 DeepSeek AI排盘大师

[![Android](https://img.shields.io/badge/Android-API%2024+-green.svg)](https://developer.android.com/about/versions/android-7.0)
[![DeepSeek](https://img.shields.io/badge/AI-DeepSeek-blue.svg)](https://deepseek.com)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> 专业的AI排盘应用，集成DeepSeek AI进行智能命理分析

## ✨ 功能特点

### 🎯 核心排盘功能
- **奇门遁甲排盘** - 专业的奇门遁甲算法，包含值符、值使、九星、八门、八神
- **大六壬排盘** - 传统大六壬系统，包含日干、时干、四课、三传、贵人、神煞
- **梅花易数排盘** - 梅花易数方法，包含本卦、变卦、互卦、变爻、卦辞

### 🤖 AI智能分析
- **DeepSeek集成** - 使用最新的DeepSeek Chat模型
- **智能问答** - 根据排盘结果回答用户问题
- **专业解读** - AI具备命理知识，提供专业分析
- **个性化建议** - 针对具体问题给出实用建议

## 🚀 快速开始

### 环境要求
- Android Studio 4.0+
- Android SDK API 24+
- DeepSeek API密钥

### 安装步骤
1. 克隆仓库
```bash
git clone https://github.com/你的用户名/deepseek-ai-paipan.git
cd deepseek-ai-paipan
```

2. 配置API密钥
在 `app/src/main/java/com/example/deepseekai/` 目录下的Activity文件中，替换：
```java
String apiKey = "your_deepseek_api_key_here";
```

3. 导入Android Studio
- 打开Android Studio
- 选择 "Open an existing Android Studio project"
- 选择项目目录

4. 构建运行
- 同步Gradle文件
- 连接Android设备或启动模拟器
- 点击运行按钮

## 📱 使用说明

### 操作流程
1. **选择排盘方式** → 奇门遁甲/大六壬/梅花易数
2. **生成排盘** → 点击"生成排盘"按钮
3. **输入问题** → 描述您的具体问题
4. **AI分析** → 点击"询问AI"按钮
5. **获取结果** → AI根据排盘结果分析并回答

### 示例问题
- "我的事业发展如何？"
- "这次投资是否有利？"
- "感情运势怎么样？"
- "适合搬家吗？"

## 🏗️ 技术架构

### 后端集成
- **DeepSeek API** - 使用DeepSeek Chat模型
- **异步处理** - 非阻塞式API调用
- **错误处理** - 完善的异常处理机制
- **JSON解析** - 标准化的数据交换

### 前端界面
- **Material Design** - 现代化UI设计
- **响应式布局** - 适配各种屏幕尺寸
- **用户友好** - 直观的操作流程
- **实时反馈** - 即时显示处理状态

## 📁 项目结构

```
deepseek-ai-paipan/
├── app/
│   ├── build.gradle                    # 项目依赖配置
│   └── src/main/
│       ├── AndroidManifest.xml        # 应用配置文件
│       ├── java/com/example/deepseekai/
│       │   ├── MainActivity.java      # 主界面
│       │   ├── QimenDunjiaActivity.java    # 奇门遁甲
│       │   ├── DaLiuRenActivity.java       # 大六壬
│       │   └── MeiHuaYiShuActivity.java   # 梅花易数
│       └── res/
│           └── layout/                # 界面布局文件
├── README.md                          # 项目说明
├── LICENSE                            # 开源协议
└── .gitignore                        # Git忽略文件
```

## 🔧 配置说明

### API配置
1. 注册[DeepSeek账户](https://deepseek.com)
2. 获取API密钥
3. 在代码中配置密钥
4. 注意API使用限制和费用

### 权限配置
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## 💡 扩展功能

### 计划中的功能
- [ ] 支持更多排盘方式（紫微斗数、六爻等）
- [ ] 历史记录保存
- [ ] 用户偏好设置
- [ ] 离线排盘功能
- [ ] 语音输入支持
- [ ] 多语言支持

### 贡献指南
欢迎提交Issue和Pull Request！

1. Fork本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建Pull Request

## 📄 开源协议

本项目采用 [MIT License](LICENSE) 开源协议。

## 🙏 致谢

- [DeepSeek](https://deepseek.com) - 提供强大的AI能力
- [Android](https://developer.android.com) - 移动开发平台
- 所有贡献者和用户

## 📞 联系方式

- 项目主页: [GitHub](https://github.com/你的用户名/deepseek-ai-paipan)
- 问题反馈: [Issues](https://github.com/你的用户名/deepseek-ai-paipan/issues)
- 邮箱: your.email@example.com

---

⭐ 如果这个项目对你有帮助，请给它一个星标！

**让传统命理智慧与现代AI技术完美结合！** 🎯✨
