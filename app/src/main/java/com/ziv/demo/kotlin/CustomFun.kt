package com.ziv.demo.kotlin

import android.util.Log

/**
 * 基础语法
 *
 * 属性/变量定义
 * 函数定义
 * 接口实现
 */
class CustomFun : CustomInterface{
    private val TAG = "CustomFun"
    // 类型后面加?表示可为空, !!抛出空指针异常
    var index:Int? = 0

    lateinit var l:CustomInterface

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

    override var name: String = ""
        get() = TODO("Not yet implemented")
        set(value) {
            field = value
        }

    override fun onItemClick() {
        print("onItemClick")
    }

    fun setOnItemClick(listener: CustomInterface) {
        l = listener
    }

    fun test() {
        // 通过对象表达式实现一个匿名内部类的对象
        setOnItemClick(object : CustomInterface {
            override var name: String = ""

            override fun onItemClick() {
                TODO("Not yet implemented")
            }

            override fun onItemDoubleClick() {
                super.onItemDoubleClick()
            }
        })

        setOnItemClick(this)

        val site = object {
            var name = "ziv test"
            var url = "www.ziv.com"
        }

        print(site.name)
    }

    // 匿名对象是私有，返回类型是匿名对象类型
    // 匿名对象是公有，返回类型是Any

    // Site为单例
    object Site{

    }

    // companion伴生对象(与java静态初始化相似)，伴生后外部类就可以访问对象内部元素了，否则不可以
    // 一个类里面只能声明一个内部关联对象
    class A {
        var name = ""
        companion object {
            fun create(): A = A()
            fun showName() {
                // 不能访问外部类的方法和变量
//                print("$name")
            }
        }
    }
}