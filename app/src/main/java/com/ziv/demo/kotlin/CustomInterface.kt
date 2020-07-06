package com.ziv.demo.kotlin

/**
 * 接口
 *
 * 接口定义
 */
interface CustomInterface {
    /**
     * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
     */
    var name: String

    fun onItemClick()
    fun onItemDoubleClick() {
        // 默认实现
        print("Double click.")
    }

    /**
     * 同一个方法的多继承需要使用 super<实现接口>.接口方法 实现函数重写
     */
}