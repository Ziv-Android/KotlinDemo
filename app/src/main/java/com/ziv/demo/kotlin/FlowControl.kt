package com.ziv.demo.kotlin

class FlowControl {
    // 分支
    // if
    val max: (Int, Int) -> Int = {a, b -> if (a > b) a else b}
    private val validNumbers = arrayOf(1, 2, 3, 4, 5)

    fun inArray() {
        val a = 5
        if (a in 1..8) {
            print("$a 在区间内")
        }
    }

    // when
    fun choose(x: Int) {
        when(x) {
            0, 1 -> print("0 or 1")
            in 0..10 -> print("$x in the range [0, 10]")
            in validNumbers -> print("valid number")
            else -> {
                print("otherwise")
            }
        }
    }

    lateinit var x: Custom
    fun choose() {
        when {
            x.isOdd() -> print("$x is odd")
            x.isEven() -> print("$x is even")
        }
    }

    class Custom {
        public fun isOdd() : Boolean {
            return true
        }

        public fun isEven() : Boolean {
            return true
        }
    }

    // 循环
    lateinit var ints: List<Int>
    // for
    fun loop() {
        for (item: Int in ints) {
            print(item)
        }

        for (index in ints.indices) {
            print(ints[index])
        }

        for ((index, value) in ints.withIndex()) {
            print("the element at $index is $value")
        }
    }

    // while和java的一样

    // 结束循环：return, break, continue
    fun foo() {
        ints.forEach lit@{
            if (it == 0) return@lit
            print(it)
        }
    }

    fun foo2() {
        ints.forEach {
            if (it == 0) return@forEach
            print(it)
        }
    }

    fun foo3() {
        ints.forEach {
            if (it == 0) return
            print(it)
        }
    }
}