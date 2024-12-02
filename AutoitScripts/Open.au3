#include <AutoItConstants.au3>
$MalwareBytes = "Open.exe"

AutoItSetOption("WinTitleMatchMode", 4)
WinWaitActive("Select Certificate")
Sleep(2000)
WinActivate("Select Certificate")
Sleep(2000)

WinWaitActive("Select Certificate")
MouseClick($MOUSE_CLICK_LEFT, 629, 373)
Sleep(2000)



MouseClick($MOUSE_CLICK_LEFT, 961, 414)
Sleep(2000)


If WinExists("Log on: eToken") Then
    WinActivate("Log on: eToken")
	MouseClick($MOUSE_CLICK_LEFT, 601, 443)
    Sleep(2000)
    Send('Kavana@123')
    Sleep(2000)
    Send('{TAB}')
    Sleep(2000)
    Send('{ENTER}')
EndIf









 ProcessClose($MalwareBytes)


HotKeySet("{ESC}", "Terminate")

Func Terminate()
    Exit
EndFunc
