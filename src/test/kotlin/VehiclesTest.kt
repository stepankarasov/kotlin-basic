import org.junit.Test
import ru.otus.okb.first.Vehicles
import kotlin.test.assertEquals

class VehiclesTest {
    @Test
    fun carTest() {
        val car: Vehicles.Car = Vehicles.Car("Toyota", "Hiace")
        car.makeSound()
    }

    @Test
    fun truckTest() {
        val truck: Vehicles.Truck = Vehicles.Truck("Isuzu", "Forward")
        assert(truck.getDateProduce(false) > 2015)
    }

    @Test
    fun tramTest() {
        val tram: Vehicles.Tram = Vehicles.Tram("ПКТС", "Корсар")
        assertEquals(7, tram.getRouteNumber())
    }
}