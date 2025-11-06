# 🎯 Shake to Get a Quote

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

**Shake your phone, change your mindset! 💪**

*A motivational quote app that responds to your device's shake gesture.*

[Features](#-features) • [Demo](#-demo) • [Installation](#-installation) • [How It Works](#-how-it-works) • [Tech Stack](#-tech-stack)

</div>

---

## 🌟 Overview

**Shake to Get a Quote** is a native Android application that delivers instant motivation through an intuitive shake gesture. Built with modern Android development practices, it combines sensor technology with beautiful Material Design 3 UI to create an engaging user experience.

> *"The best motivation comes when you least expect it... like when you shake your phone!"* 🎉

---

## ✨ Features

### 🔔 Core Functionality
- **Shake Detection** - Advanced accelerometer-based shake recognition
- **20+ Motivational Quotes** - Handpicked collection of inspiring messages
- **Smooth Animations** - Beautiful scale and fade transitions using Jetpack Compose
- **Toast Notifications** - Visual feedback confirming quote changes
- **Battery Efficient** - Smart sensor lifecycle management

### 🎨 Design
- **Material Design 3** - Modern, clean purple-themed UI
- **Responsive Layout** - Adapts to different screen sizes
- **Animated Transitions** - Spring-based physics animations
- **Dark Mode Ready** - Prepared for theme switching

### 🏗️ Architecture
- **MVVM Pattern** - Clean separation of concerns
- **Repository Pattern** - Single source of truth for data
- **Jetpack Compose** - Declarative UI framework
- **Lifecycle-Aware** - Proper sensor management

---

## 📱 Demo

### App Preview

```
┌─────────────────────────┐
│  Shake to Get a Quote   │  ← Purple Header
├─────────────────────────┤
│                         │
│    Focus on progress,   │  ← Quote Display
│    not perfection 🎯    │     (Animated)
│                         │
│                         │
│ Shake your phone to get │
│   motivated! 💡         │  ← Instruction
└─────────────────────────┘
```

### How to Use
1. **Launch** the app 📲
2. **Shake** your phone (moderate movement) 📳
3. **Enjoy** your new motivational quote! ✨
4. **Repeat** whenever you need inspiration 🔄

---

## 🚀 Installation

### Prerequisites
- **Android Studio** Hedgehog | 2023.1.1 or newer
- **Android SDK** 34 or higher
- **Physical Device** or Emulator with accelerometer support
- **Minimum SDK**: Android 14 (API 34)

### Setup Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/shake-to-quote.git
   cd shake-to-quote
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Sync Gradle**
   - Click "Sync Project with Gradle Files" 🐘
   - Wait for dependencies to download

4. **Run the App**
   - Connect your Android device (enable USB debugging)
   - Or start an Android emulator
   - Click the **Run** button ▶️ or press `Shift + F10`

---

## 🧠 How It Works

### Shake Detection Algorithm

```kotlin
// 1. Read accelerometer values (x, y, z)
val acceleration = √(x² + y² + z²)

// 2. Remove gravity component
val force = acceleration - 9.8 m/s²

// 3. Check if force exceeds threshold
if (force > 15.0) {
    // SHAKE DETECTED! 🎉
    showNewQuote()
}
```

### Architecture Flow

```
User Shakes Phone
       ↓
Accelerometer Detects Movement
       ↓
ShakeDetector Processes Data
       ↓
Callback Triggered
       ↓
ViewModel Updates State
       ↓
Compose UI Recomposes
       ↓
New Quote Displayed with Animation
```

---

## 🛠️ Tech Stack

### Core Technologies
| Technology | Purpose |
|------------|---------|
| **Kotlin** | Primary programming language |
| **Jetpack Compose** | Modern declarative UI toolkit |
| **Material Design 3** | Design system and components |
| **Android Sensors API** | Accelerometer access |

### Architecture Components
- **ViewModel** - UI state management, survives configuration changes
- **Repository Pattern** - Data abstraction layer
- **LiveData/State** - Reactive data observation
- **Lifecycle Components** - Activity/Fragment lifecycle handling

### Key Libraries
```kotlin
// Compose BOM
implementation("androidx.compose:compose-bom:2024.02.00")

// Compose UI
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.activity:activity-compose:1.8.2")

// Lifecycle
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

// Navigation (for future expansion)
implementation("androidx.navigation:navigation-compose:2.9.5")
```

---

## 📁 Project Structure

```
com.example.week7_assingment/
│
├── MainActivity.kt           # Entry point, sensor lifecycle
├── QuoteViewModel.kt         # State management & business logic
├── QuoteScreen.kt           # Main UI composables
├── ShakeDetector.kt         # Accelerometer sensor handling
├── QuoteRepository.kt       # Quote data source
│
└── ui/theme/
    ├── Theme.kt             # App theming (colors, dark mode)
    ├── Type.kt              # Typography definitions
    └── Color.kt             # Color palette
```

---

## 🎨 Customization

### Adding New Quotes

Edit `QuoteRepository.kt`:
```kotlin
private val quotes = listOf(
    "Your new quote here 🚀",
    "Another inspiring message ✨",
    // Add more...
)
```

### Adjusting Shake Sensitivity

Edit `ShakeDetector.kt`:
```kotlin
// Lower = more sensitive (8-12)
// Higher = less sensitive (16-20)
private val shakeThreshold = 15.0f
```

### Changing Colors

Edit `ui/theme/Theme.kt`:
```kotlin
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFYourColor),      // Header color
    background = Color(0xFFYourColor),   // Background color
    // Customize more...
)
```

---

## 🔧 Configuration

### Gradle Configuration
- **Compile SDK**: 36
- **Target SDK**: 35
- **Min SDK**: 34
- **Java Version**: 11
- **Kotlin Compiler**: 1.5.3

### Permissions Required
✅ **None!** Accelerometer access doesn't require runtime permissions.

---

## 🐛 Troubleshooting

### Shake Not Detected?

**Problem**: Phone doesn't respond to shaking

**Solutions**:
1. ✅ Ensure you're using a physical device (emulators have limited sensor support)
2. ✅ Shake moderately - not too gentle, not too aggressive
3. ✅ Lower the threshold in `ShakeDetector.kt` (try `12.0f`)
4. ✅ Check if accelerometer is available:
   ```kotlin
   val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
   val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
   if (accelerometer == null) {
       // Device doesn't have accelerometer
   }
   ```

### Build Errors?

**Problem**: Gradle sync fails or build errors

**Solutions**:
1. ✅ Click **File → Invalidate Caches / Restart**
2. ✅ Delete `.gradle` folder and sync again
3. ✅ Update Android Studio to latest version
4. ✅ Check internet connection (Gradle downloads dependencies)

### App Crashes on Launch?

**Problem**: App crashes immediately

**Solutions**:
1. ✅ Check **Logcat** for error messages
2. ✅ Verify minimum SDK version (API 34+)
3. ✅ Clean and rebuild: **Build → Clean Project** then **Build → Rebuild Project**

---

## 🚀 Future Enhancements

### Planned Features
- [ ] 📌 **Favorite Quotes** - Save your favorite motivational quotes
- [ ] 🔔 **Daily Notifications** - Get a quote notification every morning
- [ ] 🎨 **Theme Customization** - Choose from multiple color schemes
- [ ] 📱 **Widget Support** - Display quotes on home screen
- [ ] 🌐 **Quote Categories** - Filter by motivation, wisdom, fitness, etc.
- [ ] 📤 **Share Functionality** - Share quotes on social media
- [ ] 🗣️ **Text-to-Speech** - Hear quotes read aloud
- [ ] 🌙 **Dark Mode** - Automatic theme switching
- [ ] 🔄 **Custom Quote API** - Fetch quotes from online sources
- [ ] 📊 **Usage Statistics** - Track your motivation journey

---

## 📝 License

```
MIT License

Copyright (c) 2025 [Your Name]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

---

## 👨‍💻 Author

**[Your Name]**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your Profile](https://linkedin.com/in/yourprofile)
- Email: your.email@example.com

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 🌟 Show Your Support

Give a ⭐️ if this project helped you!

---

## 📚 Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Android Sensors Overview](https://developer.android.com/guide/topics/sensors/sensors_overview)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

---

<div align="center">

**Made with ❤️ and lots of ☕**

*Shake it till you make it!* 🎯

</div>
