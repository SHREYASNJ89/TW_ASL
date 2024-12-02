#include <AutoItConstants.au3>
$MalwareBytes = "SignAndUpload.exe"

WinWaitActive("Select Certificate")
Sleep(2000)



MouseClick($MOUSE_CLICK_LEFT, 979, 267, 1)

Sleep(2000)

WinWaitActive("File")
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 555, 450, 1)
Sleep(2000)

Send($CmdLine[1]);
MouseClick($MOUSE_CLICK_LEFT, 817, 526)
Sleep(2000)
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 670, 438, 1)
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 926, 481)
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

