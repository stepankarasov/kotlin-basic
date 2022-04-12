import org.junit.Test
import ru.otus.okb.first.Vehicles
import kotlin.test.assertEquals

class VehiclesTest {
    @Test
    fun carTest() {
        val car: Vehicles.Car<Int> = Vehicles.Car(9, "Toyota", "Hiace")
        car.makeSound()
        assertEquals(9, car.getRouteNumber())
    }

    @Test
    fun truckTest() {
        val truck: Vehicles.Truck<String> = Vehicles.Truck("A-B", "Isuzu", "Forward")
        assert(truck.getDateProduce(false) > 2015)
        assertEquals("A-B", truck.getRouteNumber())
    }

    @Test
    fun tramTest() {
        val tram: Vehicles.Tram<String> = Vehicles.Tram("7A", "ПКТС", "Корсар")
        assertEquals("7A", tram.getRouteNumber())
    }
}