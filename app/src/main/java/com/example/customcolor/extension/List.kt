package com.example.customcolor.extension

fun <T> List<T>.updateItem(item: T, condition: (T) -> Boolean): List<T>{
    val items = this.toMutableList()
    val index = items.indexOfFirst { condition(it) }
    if (index != -1) {
        items[index] = item
    }
    return items.toList()
}