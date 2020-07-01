package com.ziv.demo.kotlin

import android.util.Log

class CustomFun {
    private val TAG = "CustomFun"
    // 类型后面加?表示可为空, !!抛出空指针异常
    var index:Int? = 0

    fun print(): Unit {
        Log.d(TAG, "Kotlin print log. $index")
    }

    fun add(a:Int):Int {
        return a
    }

    fun add(a:Int, b:Int) = a + b

    public fun add(a:Int, b:Int, c:Int): Int = a + b + c

    fun add() {
        val lambdaAdd: (Int, Int) -> Int = {a, b -> a + b}
        print(lambdaAdd(1, 2))
    }

    fun add(vararg arg:Any): Int {
        for (num in arg) {
            if (num is String) {
                // is判断后num数据类型在次if条件下被转换为is后的类型
                print(num.length)
            }
        }

        var result = 0
        val iterator = arg.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next is Int) {
                result += next
            }
        }
        return result
    }

    fun range() {
        // 顺序1，3，5 步长2
        for (i in 1..5 step 2) {
            print(i)
        }
        // 倒序4，3，2，1
        for (i in 4 downTo 1) {
            print(i)
        }
        // [1, 10)
        for (i in 1 until 10) {
            print(i)
        }
    }
}