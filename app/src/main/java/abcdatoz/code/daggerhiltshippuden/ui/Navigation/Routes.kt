package abcdatoz.code.daggerhiltshippuden.ui.Navigation

sealed class Routes (val route: String){
    object Villas: Routes("VillasScreen")
    object Clanes: Routes("ClanesScreen")
    object Ninjas: Routes("NinjasScreen")
    object NinjaOne: Routes("NinjaOne")
}