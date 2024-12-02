#include <AutoItConstants.au3>
$MalwareBytes = "SignAndUpload_Nege.exe"


WinWaitActive("Message")
Sleep(2000)
MouseClick($MOUSE_CLICK_LEFT, 932, 426, 1)


ProcessClose($MalwareBytes)