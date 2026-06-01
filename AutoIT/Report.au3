WinWaitActive("Save As")
WinActivate("Save As")
Sleep(500)

; Optionally set the file name
; ControlSetText("Save As", "", "Edit1", "YourFileName.xlsx")
Sleep(500)

; Click the Save button (Button2)
ControlClick("Save As", "", "Button2")
Sleep(1000)

; If file exists, Confirm Save As dialog appears, click Yes to overwrite
If WinWaitActive("Confirm Save As", "", 2) Then
    ControlClick("Confirm Save As", "", "Button3") ; Usually Yes is Button2
EndIf