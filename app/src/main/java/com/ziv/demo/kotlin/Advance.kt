package com.ziv.demo.kotlin

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Advance {
    // 委托给lazy实现，第一次执行，后面只返回第一次的结果
    val lazyValue: String by lazy {
        print("computed.")
        "Hello"
    }

    // Delegates.observable可观察属性
    var name: String by Delegates.observable("初始值") { property, oldValue, newValue ->
        print("Prop: $property, Old: $oldValue -> New: $newValue")
    }

    // 映射属性
    class Site(var map: Map<String, Any?>) {
        val url: String by map
    }

    class Site2(var map: MutableMap<String, Any?>) {
        var url: String by map
    }

    fun test() {
        val site = Site(mapOf(
            "url" to "www.ziv.com"
        ))

        print(site.url)

        var site2 = Site2(mutableMapOf(
            "url" to "www.ziv.com"
        ))

        print(site2.url)
    }

    // NotNull无法在初始化时确定属性值的场景
    class Foo {
        var notNullBar: String by Delegates.notNull<String>()
    }

    fun test2() {
        var foo = Foo()
        foo.notNullBar = "Bar"
        print(foo.notNullBar)
    }

    /**
     * 提供委托不是很明白
     */
//    class ResourceID<T> {
//        var image_id:Int = 0
//        var text_id:Int = 0
//    }
//
//    class ResourceLoader<T>(id: ResourceID<T>) {
//        operator fun provideDelegate(
//            thisRef: MyUI,
//            prop: KProperty<*>
//        ) : ReadOnlyProperty<MyUI, T> {
//            checkProperty(thisRef, prop.name)
//            // 创建委托
//        }
//
//        private fun checkProperty(thisRef: MyUI, name: String) {
//
//        }
//    }
//
//    class MyUI {
//        val image by bindResource(ResourceID.image_id)
//        val text by bindResource(ResourceID.text_id)
//
//        fun <T> bindResource(id: ResourceID<T>) : ResourceLoader<T> {
//
//        }
//    }
}
