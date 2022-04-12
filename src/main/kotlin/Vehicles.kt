package ru.otus.okb.first

sealed class Vehicles {
    class Car<T>(var number: T, var brand: String, var model: String) : Vehicles() {
        fun makeSound() {
            println("e-ron-don-don")
        }

        fun getRouteNumber(): T {
            return number
        }
    }

    class Truck<T>(var number: T, var brand: String, var model: String) : Vehicles() {
        fun getDateProduce(isOld: Boolean = false): Int {
            return if (isOld) 2010 else 2020
        }

        fun getRouteNumber(): T {
            return number
        }
    }

    class Tram<T>(var number: T, var brand: String, var model: String) : Vehicles() {
        fun getRouteNumber(): T {
            return number
        }
    }
}