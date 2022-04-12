package ru.otus.okb.first

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class VehicleWrapper {
    private val vehicles = mutableMapOf<String, Vehicle>()

    fun add(vehicle: Vehicle) {
        vehicles.put(vehicle.model, vehicle)
    }

    fun get(model: String): Vehicle? {
        return vehicles.get(model)
    }

    fun size(): Int {
        return vehicles.size
    }

    fun addOnlyBest(vehicle: Sequence<Vehicle>) {
        val bestVehicle =
            vehicle.filter { it.mileage > 50 && it.price > 500000 }
                .sortedBy { it.price }
                .take(3)
        bestVehicle.forEach {
            vehicles.put(it.model, it)
        }
    }

    suspend fun addExceptBrands(flow: Flow<Vehicle>) {
        flow.onEach { vehicle ->
            Thread.sleep(300)
            if (!vehicle.brand.equals("Toyota")) {
                vehicles.put(vehicle.model, vehicle)
            }
        }
            .flowOn(Dispatchers.IO)
            .collect()
    }
}