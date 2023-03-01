package sa.gov.mc.eservices.rawan.utils


data class ErrorMsg(
    val text: UiText,
    var type: NotifyType = NotifyType.Dialog,
    var cancelable: Boolean = true,
)










