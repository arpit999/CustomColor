package com.example.customcolor.screens.model

data class Offer(
    val id: Int,
    val highlight: String,
    val title: String,
    val description: String,
)

val offerList = listOf(
    Offer(1, "Limited Time!", "Summer Sale Extravaganza", "Enjoy scorching hot deals ona wide range of summer essentials, from <b>swimwear</b> and <i>sunglasses</i> to sandals and sun hats.<br><br> Don't miss out on this <font color='red'>limited-time</font> offer! Get a <del>10%</del> <ins>15%</ins> discount on your first purchase! <br><br>Shop now and <a href='https://www.example.com/summer-sale'>dive into summer savings!</a>"),
    Offer(2, "New Arrivals", "Fresh Collection Unveiled", "Step into the new season with our latest collection featuring trendy apparel, stylish footwear, and must-have accessories. <br><br><b>Discover</b> the freshest looks for a refreshed you. Check out our new <sup>premium</sup> line for an elevated style. <br><br><q>Fashion is about expressing yourself.</q> - <cite>Ralph Lauren</cite>"),Offer(3, "Weekend Offer", "Weekend Special Discounts", "Treat yourself this weekend with exclusive discounts on selected items. <br><br>It's the perfect opportunity to <i>indulge</i> in something special or stock up on your favorites. <u>Limited quantities available.</u> <br><br>Don't forget to check our <abbr title='Frequently Asked Questions'>FAQ</abbr> for more details."),
    Offer(4, "Member Exclusive", "VIP Member Exclusive Perks", "Unlock a world of exclusive benefits as a valued member. <br><br>Enjoy personalized offers, early access to sales, and <font color='blue'>special events</font> tailored just for you. <small>Terms and conditions apply.</small> <br><br><dfn>Loyalty</dfn> is always rewarded."),
    Offer(5, "Clearance Sale", "Massive Clearance Sale Event", "Shop till you drop with unbeatable prices on clearance items. <br><br>Find incredible deals on a variety of products, but hurry, these offers <b>won't last long!</b> <mark>Up to 70% off!</mark> <br><br><var>Prices</var> are subject to change.")
)