#include <AutoItConstants.au3>
$MalwareBytes = "SignAndUpload_Cor.exe"

AutoItSetOption("WinTitleMatchMode", 4)
WinWaitActive("Applet Signer")
Sleep(2000)
WinActivate("Applet Signer")
Sleep(2000)

WinWaitActive("Applet Signer")
MouseClick($MOUSE_CLICK_LEFT, 583, 389)
Sleep(2000)



MouseClick($MOUSE_CLICK_LEFT, 961, 414)
Sleep(2000)




 ProcessClose($MalwareBytes)

