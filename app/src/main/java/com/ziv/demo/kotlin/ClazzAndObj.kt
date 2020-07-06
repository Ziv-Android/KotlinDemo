package com.ziv.demo.kotlin

import java.util.*

/**
 * 类和对象
 */
// 与class同行的主构造器constructor
// 所有的class都隐式继承自Any（Any不等于java.lang.Object）
// 如果子类有主构造函数，则必须在构造函数中进行初始化
// 如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
class ClazzAndObj constructor(a: String) {
    // val没有set函数，因为它是只读的
    val name: String = a
    var city: String = ""
    var url: String = ""
        // field后端变量
        get() = field.toLowerCase(Locale.ROOT)
    internal var time: String = ""
        private set
    var num: Int = 0
        set(value) {
            field = if (value < 10) value else -1
        }

    // 主构造器中不能包含任何代码，初始化代码在init代码块中
    init {
        print("Main constructor init a: $a")
    }

    // 次构造器
    constructor(name: String, age: Int) : this(name) {
       num = age
    }

    // 抽象类（此处为嵌套类，内部类需要使用inner修饰）
    open class Base {
        open fun baseFoo() {}
    }

    abstract class Clazz : Base() {
        abstract override fun baseFoo()
    }

    // 内部类，可直接访问外部类成员
    inner class Inner {
        fun foo() = name
        fun test() {
            print(this@ClazzAndObj.name)
        }
    }

    // 接口
    interface TestInterface {
        fun test()
    }

    fun setTestInterface(listener: TestInterface) {
        /**
         * 采用对象表达式来创建接口对象，即匿名内部类的实例。
         */
        this.setTestInterface(object : TestInterface{
            // override重写方法，只有open的fun才允许被重写
            override fun test() {
                TODO("Not yet implemented")
            }
        })
    }

    /**
     * 伴生对象Companion
     */
    companion object Companion {

    }

    /**
     * 类的修饰符包括类 属性修饰符 和 访问权限修饰符
     * 属性修饰符：
     * abstract 抽象类
     * final 不可继承（默认）
     * enum 枚举类
     * open 可继承
     * annotation 注解类
     *
     * 访问权限修饰符
     * private 仅在同一个文件中可见
     * protected 同一文件或其子类可见
     * public 所有调用都可见
     * internal 同一个模块中可见
     */
}