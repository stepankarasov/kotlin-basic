package ru.otus.okb.first

sealed class Vehicles {
    class Car(var brand: String, var model: String) : Vehicles() {
        fun makeSound() {
            println("e-ron-don-don")
        }
    }

    class Truck(var brand: String, var model: String) : Vehicles() {
        fun getDateProduce(isOld: Boolean = false): Int {
            return if (isOld) 2010 else 2020
        }
    }

    class Tram(var brand: String, var model: String) : Vehicles() {
        fun getRouteNumber(): Int {
            return 7
        }
    }
}