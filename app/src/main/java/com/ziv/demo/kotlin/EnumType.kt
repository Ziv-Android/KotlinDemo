package com.ziv.demo.kotlin

/**
 * 枚举
 */
class EnumType {
    enum class Color {
        RED, BLUE, GREEN
    }

    enum class Color2(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
    }

    inline fun <reified T: Enum<T>> printAllValues() {
        print(enumValues<T>().joinToString { it.name })
    }
}