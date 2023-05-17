package com.example.strategypattern

interface DiscountStrategy {
    fun calculateDiscount(basePrice: Double, discountAmount: Double): Double
}