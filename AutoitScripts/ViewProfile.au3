#include <AutoItConstants.au3>
$MalwareBytes = "ViewProfile.exe"

AutoItSetOption("WinTitleMatchMode", 4)
WinWaitActive("E135 - Google Chrome")
Sleep(2000)
WinActivate("E135 - Google Chrome")
Sleep(2000)

WinWaitActive("E135 - Google Chrome")
MouseClick($MOUSE_CLICK_LEFT, 1167, 410)
Sleep(2000)

 ProcessClose($MalwareBytes)


HotKeySet("{ESC}", "Terminate")

Func Terminate()
    Exit
EndFunc
