package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.playstore

sealed class PlayStoreState{
    object InProgress:PlayStoreState()
    class Success(val names:List<String>):PlayStoreState()
    class Failed(val message:String?):PlayStoreState()
}
