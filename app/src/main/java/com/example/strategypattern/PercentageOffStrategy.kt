package com.example.strategypattern

class PercentageOffStrategy : DiscountStrategy {
    override fun calculateDiscount(basePrice: Double, discountAmount: Double): Double {
        return basePrice - (basePrice * (discountAmount / 100.0))
    }
}