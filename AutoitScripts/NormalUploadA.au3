#include <AutoItConstants.au3>
WinWaitActive("Open")
Sleep(2000)
Send($CmdLine[1]);
Sleep(5000)
Send("{ENTER}")


HotKeySet("{Esc}", "ExitScript")
Func ExitScript()
    Exit
EndFunc