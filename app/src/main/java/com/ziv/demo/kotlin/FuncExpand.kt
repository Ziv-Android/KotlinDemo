package com.ziv.demo.kotlin

/**
 * 扩展
 *
 * 扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
 * 同名函数扩展接收者优先，若要调用分发接收者的成员需要使用限定的this语法， this@className.funName
 * open修饰的分发接收者是虚拟的, 但针对扩展接受者仍然是静态的。（谁重写，谁变化）
 */
class FuncExpand {
    // 属性扩展，扩展属性只能声明为val，且不允许在函数中使用，不允许被初始化，只能显示提供getter/setter定义
    val <T> List<T>.lastIndex: Int
        get() = size - 1

    /**
     * 扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。
     * 因此扩展函数也是静态解析的，即调用时就已经确定是谁在调用，而不能动态变化
     */
    fun ClazzAndObj.printFromExpand() {
        print("printFromExpand")
    }

    fun MutableList<Int>?.swap(index1: Int, index2: Int) {
        // 使用this表示接收者，可进行非空判断
        if (this == null) return
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    fun start() {
        var clazz = ClazzAndObj("init")
        clazz.printFromExpand()

        val l = mutableListOf(1, 2, 3)
        l.swap(0, 2)
        print(l.toString())
    }

    /**
     * 扩展伴生对象
     */
    fun ClazzAndObj.Companion.foo() {
        print("伴随对象的扩展函数")
    }

    val ClazzAndObj.Companion.no: Int
        get() = 10


    /**
     * 伴生对象内的成员相当于 Java 中的静态成员，其生命周期伴随类始终，在伴生对象内部可以定义变量和函数，这些变量和函数可以直接用类名引用。
    对于伴生对象扩展函数，有两种形式，一种是在类内扩展，一种是在类外扩展，这两种形式扩展后的函数互不影响（甚至名称都可以相同），即使名称相同，它们也完全是两个不同的函数，并且有以下特点：
    （1）类内扩展的伴随对象函数和类外扩展的伴随对象可以同名，它们是两个独立的函数，互不影响；
    （2）当类内扩展的伴随对象函数和类外扩展的伴随对象同名时，类内的其它函数优先引用类内扩展的伴随对象函数，即对于类内其它成员函数来说，类内扩展屏蔽类外扩展；
    （3）类内扩展的伴随对象函数只能被类内的函数引用，不能被类外的函数和伴随对象内的函数引用；
    （4）类外扩展的伴随对象函数可以被伴随对象内的函数引用
     */
}