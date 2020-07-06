package com.ziv.demo.kotlin

/**
 * 数据类
 *
 * 只包含数据的类，自动包含equals()/hashCode()，toString()，componentN()，copy()
 * 主构造函数至少包含一个参数。
 * 数据类不可以声明为 abstract, open, sealed 或者 inner
 * 数据类不能继承其他类 (但是可以实现接口)
 *
 * 密封类sealed
 * 密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。在某种意义上，他们是枚举类的扩展：枚举类型的值集合 也是受限的，但每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例。
 * sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
 */
data class DataBean(val name: String) {

    sealed class Person {
        data class Common(val name: String) : Person() {

        }

        data class Education(val school: String) : Person() {

        }

        data class Office(val level: Int) : Person() {

        }
    }

    fun eval(person: Person): String = when(person) {
        is Person.Common -> person.name
        is Person.Education -> person.school
        is Person.Office -> person.level.toString()
    }

    /**
     * 标准数据类
     */
    fun officeDataBean() {
        val pair : Pair<Int, Int>
        val triple: Triple<String, Int, Int>
    }
}