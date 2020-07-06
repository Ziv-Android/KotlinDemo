package com.ziv.demo.kotlin

/**
 * 范型
 */
class ParameterizedTypes<T>(t: T) {
    val box: ParameterizedTypes<Int> = ParameterizedTypes(1)
    // 编译器自动进行类型推断
    val box2 = ParameterizedTypes(1)

    var boxString = ParameterizedTypes<String>("Name")

    fun <T> doPrint(content: T) {
        when(content) {
            is Int -> println("数字：$content")
            is String -> println("字符串：${content.toUpperCase()}")
            else -> println("啥也不是")
        }
    }

    // 声明处型变
    // 消费者 in, 生产者 out
    // out参数协变，协变类型参数只能用作输出，子类泛型对象可以赋值给父类泛型对象，用 out
    // in参数逆变，逆变类型参数只能用作输入，父类泛型对象可以赋值给子类泛型对象，用 in

    // （*）星号投射
    // Function<in Nothing, out Any?>
}