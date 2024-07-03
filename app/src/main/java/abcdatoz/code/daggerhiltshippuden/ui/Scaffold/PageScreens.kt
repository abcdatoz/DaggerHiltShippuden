package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

sealed class PageScreens (val route: String){
    object PageA: PageScreens("pageA")
    object PageB: PageScreens("pageB")
    object PageC: PageScreens("pageC")
    object PageD: PageScreens("pageD")
}