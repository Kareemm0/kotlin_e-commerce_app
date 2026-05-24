package com.example.kotline_commerceapplication.Data

import com.example.kotline_commerceapplication.R


sealed class OnBoardingModel(
  val  image: Int,
val    title: String,
   val description: String
) {
  object  OnboardingOne : OnBoardingModel(
     R.drawable.onboarding_one ,
     title ="Fast & Reliable Delivery" ,
     description = "Get your orders delivered straight to your door — quickly, safely, and tracked every step of the way"
 )
     object OnboardingTwo : OnBoardingModel(
        R.drawable.onboarding_two ,
        "Shop Anytime, Anywhere" ,
        "Browse thousands of products right from your phone and enjoy exclusive deals and discounts at your fingertips."
    )
     object OnboardingThree: OnBoardingModel(
        R.drawable.onboarding_three ,
        "Multiple Payment Options" ,
        "Pay your way — we support all major cards and payment methods for a fast, secure checkout experience."
    )

    companion object {
        fun  pages() : List<OnBoardingModel> = listOf(
            OnboardingOne ,
            OnboardingTwo ,
            OnboardingThree
        )
    }


}