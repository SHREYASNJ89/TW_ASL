#include <AutoItConstants.au3>
$MalwareBytes = "VendorManagementDB.exe"

AutoItSetOption("WinTitleMatchMode", 4)
WinWaitActive("E135 - Google Chrome")
Sleep(2000)
WinActivate("E135 - Google Chrome")
Sleep(2000)

WinWaitActive("E135 - Google Chrome")
MouseClick($MOUSE_CLICK_LEFT, 259, 233)
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 299, 436)
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 363, 305)
Sleep(4000)

 ProcessClose($MalwareBytes)


HotKeySet("{ESC}", "Terminate")

Func Terminate()
    Exit
EndFunc
