package com.example.customcolor.screens.model

data class Offer(
    val id: Int,
    val highlight: String,
    val title: String,
    val description: String,
)

val offerList = listOf(
    Offer(1,"Summer Sale", "Up to 50% off on selected items", "https://example.com/image1.jpg"),
    Offer(2,"New Arrivals", "Check out our latest collection", "https://example.com/image2.jpg"),
    Offer(3,"Weekend Offer", "Special discounts for this weekend only", "https://example.com/image3.jpg")
)
