package com.ziv.demo.kotlin

class DataType {
    lateinit var name: String

    // Byte位宽：8
    var b: Byte = 0

    // Short位宽：16
    var s: Short = 0

    // Float位宽：32
    var height: Float = 0.0F

    // Int位宽：32
    var age: Int = 0
    val bytes = 0b1101_1000
    val oneMillion: Int = 1_000_000
    var hexByte: Int = 0xFF_EC_5E

    // Double位宽：64
    var weight: Double = 0.0

    /**
     * ===比较对象地址
     * == 比较值的大小
     */
    fun equal() {
        var a: Int = 1000
        // true
        print(a === a)

        var b = a
        // true
        print(a == b)
        // false
        print(a === b)
    }

    /**
     * Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来
     * 转义字符 \t、 \b、\n、\r、\'、\"、\\ 和 \$
     * 编码其他字符要用 Unicode 转义序列语法：'\uFF00'
     */
    fun check(c: Char) :Int {
        if (c == '1') {
            print(c)
        }
        return c.toInt()
    }

    /**
     * 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）
     */
    fun array(args: Array<String>) {
        val text = """
            朝辞白帝彩云间，
            千里江陵一日还。
            两岸猿声啼不住，
            轻舟已过万重山。
        """.trimIndent()
        // trimMargin删除多余空白
        val title = """
            ｜Android
            ｜iOS
            ｜Web
        """.trimMargin()
        var a = arrayOf(1, 2, 3)
        var b = Array(3) { i -> (i * 2) }
    }
}