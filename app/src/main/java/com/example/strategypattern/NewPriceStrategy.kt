package com.example.strategypattern

class NewPriceStrategy : DiscountStrategy {
    override fun calculateDiscount(basePrice: Double, discountAmount: Double): Double {
        return discountAmount
    }
}