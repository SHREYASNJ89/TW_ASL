#include <AutoItConstants.au3>
$MalwareBytes = "HtmlSign.exe"
WinWait("[CLASS:SunAwtFrame]","",10)
Sleep(2000)
WinGetHandle("[CLASS:SunAwtFrame]")
MouseClick($MOUSE_CLICK_LEFT, 716, 377)
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 948, 379)
Sleep(2000)
ProcessClose($MalwareBytes)