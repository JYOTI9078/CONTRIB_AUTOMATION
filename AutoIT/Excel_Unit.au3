; SaveAsHandler.au3
WinWaitActive("Save As")
ControlFocus("Save As", "", "Edit1")
; Optionally set a file named
; Optionally set a file named
; ControlSetText("Save As", "", "Edit1", "YourFileName.xlsx")
ControlClick("Save As", "", "Button1") ; Click Save

; Handle overwrite dialog if file exists
If WinWaitActive("Confirm Save As", "", 2) Then
    ControlClick("Confirm Save As", "", "Button2") ; Click Yes
EndIf