#include <AutoItConstants.au3>
$MalwareBytes = "Printclose.exe"
$hwnd=WinWait("[CLASS:Chrome_WidgetWin_1]","",10)
Sleep(2000)
WinGetHandle("[CLASS:Chrome_WidgetWin_1]")
Local $sTitle= WinGetTitle("[ACTIVE]")
Local $sClass= WinGetClassList("[ACTIVE]")
ConsoleWrite($sTitle & @CRLF)
ConsoleWrite($sClass & @CRLF)
MouseClick($MOUSE_CLICK_LEFT, 1146, 664)
Sleep(3000)
ProcessClose($MalwareBytes)